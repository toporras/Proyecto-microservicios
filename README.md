.Proyecto de Microservicios de Torneos

.Integrantes
  - Tomas Porras
  - Natalia Rios

.Requisitos previos
- Debe contar con la version de java 21
 
.Descripcion del proyecto
- Proyecto creado en base a microservicios para la gestiion de torneos deportivos
- Se implemento una arquitectura de microservicios mediantes OpenFegn y Spriing Boot
- Cada microservicio cuenta con una base de datos propia en MySQL

.Tecnologias implementadas
- Swagger/OpenAPI: Documentación interactiva de todos los endpoints de los microservicios.
- HATEOAS: Implementación de hipermedia para guiar la navegación de la API en los microservicios.
- Eureka: Registro y descubrimiento de servicios para la orquestación del sistema.
- DataFaker: Generación de datos de prueba dinámicos y realistas.
- Pruebas Unitarias: Validación de lógica del negocio con JUnit5.

.Microservicios implementados

- ms-equipo
- ms-jugador
- ms-partido
- ms-estadio
- ms-entrenador
- ms-torneo
- ms-estadistica
- ms-posiciones
- ms-arbitro
- ms-usuario

.Funcionalidades 
cada microservicio cuenta con un
- GET , -POST , -PUT y -DELETE

.Puertos Ocupados
- ms-equipo - 8081 
- ms-jugador - 8082 
- ms-partido - 8083 
- ms-estadio - 8084 
- ms-entrenador - 8085 
- ms-estadistica - 8086 
- ms-arbitro - 8087 
- ms-posiciones - 8088 
- ms-torneo - 8089 
- ms-usuario - 8090 
 
Para ejecutar el proyecto

Abrir los microservicios en vs code en intancias separadas.
Tener Mysql Workbench corriendo y configurado 
Ejecutarlos los microservicios respetando el orden de puertos.
Para probar los endpoints utiliza Postman o bien puedes navegar por los enlaces de Hateoas.
 
