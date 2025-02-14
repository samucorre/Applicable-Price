# Sistema de Gestión de Applicable Price con Spring Boot

##  Descripción General
Aplicación desarrollada con **Spring Boot** que permite la gestión de **precios aplicables** a productos según la marca, la fecha y la prioridad establecida.  
Implementa una **API REST** para consultar los precios vigentes en una fecha y hora determinada.  

---

### ⚡ **Pruebas y Colección Postman**
📂 **En la carpeta `test`**, la clase **`PricesEndpointTest`** desarrolla las pruebas que validan las peticiones al servicio en base a los requisitos establecidos.  
📌 **Se incluye una colección Postman** para facilitar la prueba de los endpoints.  

---

##  Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data JPA**
- **Base de datos en memoria H2**
- **Lombok**
- **Mockito y JUnit** para pruebas unitarias e integración
- **Maven** para la gestión de dependencias

---

##  Arquitectura del Proyecto
El sistema sigue el patrón **MVC (Modelo-Vista-Controlador)**:

 **Model**  
   - `Prices.java`: Representa la entidad de precios en la base de datos.  

 **Repository**  
   - `PricesRepository.java`: Interfaz para el acceso a los datos.  

 **Service**  
   - `PricesService.java`: Contiene la lógica de negocio para recuperar precios aplicables.  

 **Controller**  
   - `PricesController.java`: Expone los endpoints REST para la consulta de precios.  

### Endpoints disponibles:
| Método | Endpoint        | Descripción |
|--------|---------------|-------------|
| `GET`  | `/api/prices` | Obtiene el precio aplicable para un producto en una fecha y hora dada. |

---

##  Pruebas
Se han implementado pruebas con **JUnit y Mockito**:

- **Pruebas de contexto**: Verifica la correcta carga del contexto de la aplicación.
- **Pruebas del repositorio**: Valida la consulta de datos en la base de datos H2.
- **Pruebas del endpoint**: Comprueba que las respuestas sean correctas según los datos ingresados.

---
