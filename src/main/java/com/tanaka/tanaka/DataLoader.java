package com.tanaka.tanaka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner { //Esta implementacion significa que el metodo run se ejecutará automáticamente cuando la aplicación se inicie

    private final ProductoRepository repository;

    public DataLoader(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override //Para sustituir el metodo que viene con CommandLineRunner
    public void run(String... args) { //Se introduce null en el Id porque se genera uno autoincrementable con GeneratedValue
        repository.save(new ProductoOtaku(null, "Figura de Zoro", "Figura", 300.99, 25));
        repository.save(new ProductoOtaku(null, "Manga de One piece", "Manga", 200.50, 50));
        repository.save(new ProductoOtaku(null, "Poster de Luffy", "Poster", 100.00, 60));
    }
}
