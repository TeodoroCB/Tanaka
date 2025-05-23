package com.tanaka.tanaka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository repository;

    public DataLoader(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        repository.save(new ProductoOtaku(null, "Figura de Luffy", "Figura", 25.99, 10));
        repository.save(new ProductoOtaku(null, "Manga de Naruto", "Manga", 15.50, 20));
        repository.save(new ProductoOtaku(null, "Póster de One Piece", "Póster", 9.99, 30));
    }
}
