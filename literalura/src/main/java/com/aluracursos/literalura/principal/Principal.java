package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class Principal  {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books?search=";

    @Autowired
    private LibroRepository libroRepository ;
    private AutorRepository autorRepository;

    public Principal(AutorRepository repositorio, LibroRepository repositorioo) {
        this.autorRepository = repositorio;
        this.libroRepository = repositorioo;
    }


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por título
                    2 - Mostrar todos los libros buscados
                    3 - Mostrar libros por idioma
                    4 - Mostrar autores vivos en determinado año
                    5 - Lista de autores
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:mostrarTodosLosLibros();
                break;
                case 3:
                    mostrarLibrosPorIdioma();
                    break;
                case 4:
                    mostrarAutoresVivosEnAño();
                    break;
                case 5:
                    listarAutores();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Escribe el título del libro que deseas buscar:");
        var tituloLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + tituloLibro.replace(" ", "+"));
        Libro libro = conversor.obtenerDatos(json, Libro.class);

        // Guarda el libro en la base de datos
        libroRepository.save(libro);
        System.out.println(libro);
    }

    private void mostrarTodosLosLibros() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    private void mostrarLibrosPorIdioma() {
        System.out.println("Escribe el idioma para filtrar los libros:");
        var idioma = teclado.nextLine();
        List<Libro> libros = libroRepository.findByLanguage(idioma);
        libros.forEach(System.out::println);
    }

    private void mostrarAutoresVivosEnAño() {
        System.out.println("Escribe el año para consultar autores vivos:");
        var año = teclado.nextInt();
        teclado.nextLine();
        var autores = autorRepository.findByBirthYearBeforeAndDeathYearAfter(año, año);
        autores.forEach(System.out::println);
    }
    private void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }
}