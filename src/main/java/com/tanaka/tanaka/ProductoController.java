package com.tanaka.tanaka;

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
    @GetMapping
    public List<ProductoOtaku> getAll() {
        return repository.findAll();
    }

    // GET /productos/{id} → Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoOtaku> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /productos → Agregar un nuevo producto
    @PostMapping
    public ProductoOtaku create(@Valid @RequestBody ProductoOtaku producto) {
        return repository.save(producto);
    }

    // PUT /productos/{id} → Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<ProductoOtaku> update(@PathVariable Long id, @Valid @RequestBody ProductoOtaku producto) {
        return repository.findById(id).map(existing -> {
            producto.setId(id);
            return ResponseEntity.ok(repository.save(producto));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /productos/{id} → Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
