package com.tanaka.tanaka;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //Hace que los metodos devuelvan datos json en la respuesta http
@RequestMapping("/productos") //Esta sera la ruta base para todos los endpoints
public class ProductoController { //Esta clase define los endpoints para interactuar con los productos

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
        //Esta dentro del constructor para que Spring cree una instancia y la inyecte en el constructor directamente sin hacer un new
    }

    // Para obtener todos los productos
    @Operation(
            summary = "Obtener todos los productos",
            description = "Este endpoint recupera la lista completa de productos del inventario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de productos obtenido correctamente"),
            @ApiResponse(responseCode = "500", description = "Error")
    })
    @GetMapping
    public List<ProductoOtaku> getAll() {
        return repository.findAll();
    }

    // Para obtener un producto por ID
    @Operation(
            summary = "Obtener un producto por ID",
            description = "Este endpoint devuelve los detalles de un producto despues de obtener su id"
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
            description = "Crea un nuevo producto en el inventario. Se validan campos obligatorios como el nombre y se comprueba que el precio sea positivo"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error en la validación de datos")
    })
    @PostMapping
    public ProductoOtaku create(@Valid @RequestBody ProductoOtaku producto) {
        return repository.save(producto);
    } //Recibe un producto en formato JSON, lo valida y lo almacena
    /**
     * Actualiza los detalles de un producto despues de buscar su id
     *
     * @param id Identificador del producto que se actualiza
     * @param producto Datos nuevos del producto
     * @return El producto actualizado o un código 404 si no lo encuentra
     */
    @Operation(
            summary = "Actualizar un producto",
            description = "Este endpoint actualiza la información de un producto identificandolo por su ID."
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
    /**
     * Elimina un producto del inventario con el id
     *
     * @param id Identificador del producto que se elimina
     * @return Un código 204 si la eliminación fue exitosa o 404 si no
     */
    @Operation(
            summary = "Eliminar un producto",
            description = "Este endpoint elimina un producto del inventario o se devuelve un error 404 si no esta en el listado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
