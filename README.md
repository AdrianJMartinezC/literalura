<h1 align="center"> ## LITERALURA ## </h1>


**Literalura** es una aplicación Java que interactúa con la API Gutendex para buscar libros y autores, 
almacenar datos en una base de datos PostgreSQL, y proporcionar funcionalidades de consulta y estadísticas 
sobre los libros y autores almacenados.

## Requisitos ##
* Java 17
* Maven 4
* PostgreSQL

## Configuración del Proyecto ##

**1. Clonar el Repositorio** 

git clone https://github.com/AdrianJMartinezC/literalura.git

**2. Navegar al directorio del proyecto:**
   cd literalura
   
**3. Compilar el proyecto:**
   javac -d bin src/*.java

**4. Ejecutar la aplicación**
   java -cp bin com.example.literalura.Main
   
 **5. Configurar la Base de Datos**

* Asegúrate de tener PostgreSQL instalado y configurado.
* Crea una base de datos llamada literalura (o el nombre que prefieras).
* Actualiza las credenciales de la base de datos en src/main/resources/application.properties.

**NOTA:**
Otra alternativa es descargar directamente la carpeta que contiene el proyecto literalura 
y ejecutarlo en el IDE de tu preferencia.

## Funcionalidades ##

* Buscar libro por título: Busca y guarda libros por título desde la API Gutendex.
* Mostrar todos los libros: Lista todos los libros almacenados en la base de datos.
* Mostrar libros por idioma: Filtra y muestra libros según el idioma especificado.
* Mostrar autores vivos en determinado año: Muestra los autores que estuvieron vivos en un año específico.
* Listar autores: Lista autores de los libros buscados.

## Estructura del Proyecto ##
    
El proyecto sigue una estructura típica de aplicación Spring Boot:

* src/main/java/com/aluracursos/literalura: Contiene las clases Java de la aplicación.
* src/main/resources: Contiene los archivos de configuración, como application.properties.

## Uso ##

Una vez que la aplicación esté en funcionamiento, puedes interactuar con ella a través de
un menú de consola que te guiará a través de las funcionalidades disponibles. Usa las 
opciones numéricas para navegar por el menú y proporcionar los datos requeridos.

## Tecnologías Utilizadas ##
* Spring Boot 3.3.1
* Maven 4
* Spring Data JPA
* PostgreSQL
* Jackson 2.16

## Créditos ##
Este proyecto fue creado como parte de un desafío de programación y aprendizaje de la formación
Java y Spring Boot del programa **Oracle ONE**
Propuestos por #Oracle y #AluraLatam 

## Contacto ##
Para cualquier duda o sugerencia, por favor contacta a adrianjmc9@gmail.com
