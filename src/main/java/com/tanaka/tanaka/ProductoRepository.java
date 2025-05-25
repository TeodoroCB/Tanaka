package com.tanaka.tanaka;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Indica que esta interfaz trabaja con la base de datos, que se encarga de guardar, buscar y eliminar elementos
public interface ProductoRepository extends JpaRepository<ProductoOtaku, Long> { //Esto nos dice que gestionara ProductoOtaku y que su clave primaria es de tipo Long
    //Como la interfaz extiende de JpaRepository hereda los metodos CRUD basicos
}
