# Inventario del señor Tanaka

Este proyecto es una aplicación web construida con Spring Boot que simula la gestión del inventario de la tienda del señor tanaka.
Desarrollada con Spring Boot y respaldada por una base de datos H2 en memoria, esta aplicación permite crear, consultar, actualizar y eliminar productos del inventario a través de una API.
Utiliza validaciones automáticas y documentación generada mediante Swagger e incluye datos precargados.

---

## Características

- **API REST CRUD**: Permite crear, leer, actualizar y eliminar productos.
- **Validación de Datos**: Se usan anotaciones de validación (como `@NotBlank`, `@Positive`) para asegurar la integridad de la información.
- **Persistencia con JPA y H2**: Utiliza Spring Data JPA para acceder a una base de datos en memoria (H2), lo que facilita el desarrollo y las pruebas iniciales.
- **Interfaz Gráfica Dinámica**: Una página web incluye formularios para la inclusión y edición de productos, así como una tabla en la que se listan los productos y se pueden realizar acciones (editar, eliminar) sin recargar la página.
- **Documentación Automática**: Se integra Swagger para documentar la API y facilitar su uso.

---

## Tecnologías Utilizadas

- **Backend**:
  - Java 
  - Spring Boot
  - Spring Data JPA
  - H2 Database 
  - Maven
  - Swagger 

- **Frontend**:
  - HTML5, CSS y JavaScript
  - Bootstrap
 
  ---

## Cómo probar la aplicación

Una vez que la aplicación está en funcionamiento, no es necesario utilizar herramientas externas para probar la API. Toda la interacción se puede realizar directamente desde la interfaz web integrada, ya que esta ya está conectada con los endpoints del backend, lo que elimina la necesidad de configuraciones manuales adicionales.
- Abre el archivo: src/main/resources/static/index.html
- Agregar productos llenando el formulario y haciendo clic en "Añadir"
- Editar un producto usando el botón "Editar" en la tabla
- Eliminar productos haciendo clic en "Eliminar"
  

 ---
