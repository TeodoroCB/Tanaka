package com.tanaka.tanaka;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    // GET /productos → Obtener todos los productos
    @Operation(
            summary = "Obtener todos los productos",
            description = "Este endpoint recupera la lista completa de productos del inventario. Cada producto incluye información como nombre, categoría, precio y stock."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de productos obtenido correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno en el servidor")
    })
    @GetMapping
    public List<ProductoOtaku> getAll() {
        return repository.findAll();
    }

    // GET /productos/{id} → Obtener un producto por ID
    @Operation(
            summary = "Obtener un producto por ID",
            description = "Este endpoint devuelve los detalles de un producto en particular identificándolo por su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoOtaku> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Crear un nuevo producto",
            description = "Crea un nuevo producto en el inventario. Se validan campos obligatorios como el nombre y se comprueba que el precio sea positivo."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error en la validación de datos")
    })
    @PostMapping
    public ProductoOtaku create(@Valid @RequestBody ProductoOtaku producto) {
        return repository.save(producto);
    }

    @Operation(
            summary = "Actualizar un producto",
            description = "Este endpoint permite actualizar la información de un producto existente identificado por su ID. Se requiere que los datos enviados cumplan con las validaciones predefinidas, como el nombre obligatorio y el precio positivo."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación en los datos enviados"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductoOtaku> update(@PathVariable Long id, @Valid @RequestBody ProductoOtaku producto) {
        return repository.findById(id).map(existing -> {
            producto.setId(id);
            return ResponseEntity.ok(repository.save(producto));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Eliminar un producto",
            description = "Este endpoint elimina un producto del inventario basado en su ID. Si el producto no existe, se devuelve un error 404 indicando que no se encontró."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
