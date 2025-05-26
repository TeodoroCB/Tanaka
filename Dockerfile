# Usar una imagen oficial de OpenJDK 21
FROM openjdk:21-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/Tanaka-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Definir el comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
