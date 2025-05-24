package com.tanaka.tanaka;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Schema(description = "Representa un producto en el inventario del maestro Tanaka")
public class ProductoOtaku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del producto", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre del producto. Este campo es obligatorio", example = "Figura de Goku")
    private String nombre;
    @NotNull(message = "la categoria es obligatoria")
    @Schema(description = "Categoría a la que pertenece el producto", example = "Figura")
    private String categoria;
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser positivo")
    @Schema(description = "Precio del producto, debe ser un número positivo", example = "25.99")
    private Double precio;
    @NotNull(message = "Debes tener al menos una unidad")
    @Positive(message = "Debes tener al menos una unidad")
    @Schema(description = "Cantidad disponible en stock", example = "10")
    private Integer stock;

    // Constructor vacío (necesario para JPA)
    public ProductoOtaku() {
    }

    // Constructor con parámetros
    public ProductoOtaku(Long id, String nombre, String categoria, Double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
