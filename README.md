# simpleCRUDSpringboot
Proyecto CRUD con Spring Boot
Este es un proyecto que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) utilizando Spring Boot, una herramienta de desarrollo de aplicaciones basada en el framework Spring. El CRUD permite gestionar una entidad llamada "Usuarios", donde cada usuario tiene un nombre, un tipo de documento, un número de documento, una categoría y un estado de tarjeta.

Tecnologías utilizadas
Java 8
Spring Boot 2.x
Spring Data JPA
MYSQL 8
Gadlew
Instalación
Clonar el repositorio en tu máquina local:
bash
```
https://github.com/juandiegou/simpleCRUDSpringboot.git
```
Abrir el proyecto en tu IDE de preferencia (por ejemplo, IntelliJ IDEA o Eclipse).

Asegurarse de tener Java 11 y Maven instalados y configurados en tu sistema.

Ejecutar la aplicación. La base de datos H2 se configurará automáticamente en memoria.

Uso
La aplicación expone una API REST para realizar operaciones CRUD en la entidad "Usuarios". A continuación, se presentan los endpoints disponibles:

Obtener todos los usuarios:

Método: GET
bash 
```
URL: http://localhost:8080/usuarios/
```
Obtener un usuario por su ID:

Método: GET
bash 
```
URL: http://localhost:8080/usuarios/{id}
```
Crear un nuevo usuario:

Método: POST
bash 
```
URL: http://localhost:8080/usuarios/
```
Body (ejemplo en formato JSON):

json
bash
```
{
  "nombre": "Juan Perez",
  "tipoDocumento": "CC",
  "numeroDocumento": "12345678",
  "categoria": "Moda",
  "tarjeta": true
}

```


Actualizar todos los atributos de un usuario existente:

Método: PUT
URL: http://localhost:8080/usuarios/{id}
Body (ejemplo en formato JSON):

json
bash
```
{
  "nombre": "Maria Lopez",
  "tipoDocumento": "CE",
  "numeroDocumento": "87654321",
  "categoria": "Mercado",
  "tarjeta": false
}

```

Actualizar solo atributos no nulos de un usuario existente:

Método: PATCH
URL: http://localhost:8080/usuarios/{id}
Body (ejemplo en formato JSON):

bash 
```
{
  "nombre": "Ana Ramirez",
  "categoria": "Ahorro"
}

``` 
Eliminar un usuario por su ID:

Método: DELETE
URL: http://localhost:8080/usuarios/{id}
