/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p1_josereyes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class Libreria {
     private ArrayList<String> titulos;
    private ArrayList<String> autores;

    public Libreria() {
        titulos = new ArrayList<String>();
        autores = new ArrayList<String>();
    }

    public void agregarLibro(String titulo, String autor) {
        titulos.add(titulo);
        autores.add(autor);
        System.out.println("Libro agregado al inventario.");
    }

    public void eliminarLibro(String titulo) {
        int indice = titulos.indexOf(titulo);
        if (indice == -1) {
            System.out.println("El libro no se encuentra en el inventario.");
        } else {
            titulos.remove(indice);
            autores.remove(indice);
            System.out.println("Libro eliminado del inventario.");
        }
    }

    public void buscarLibro(String titulo) {
        int indice = titulos.indexOf(titulo);
        if (indice == -1) {
            System.out.println("El libro no se encuentra en el inventario.");
        } else {
            System.out.println("Autor: " + autores.get(indice));
        }
    }

    public void listarLibros() {
        if (titulos.size() == 0) {
            System.out.println("No hay libros en el inventario.");
        } else {
            System.out.println("Libros en el inventario:");
            for (int i = 0; i < titulos.size(); i++) {
                System.out.println((i+1) + ". " + titulos.get(i) + " - " + autores.get(i));
            }
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== Menu de la Libreria =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Regresar al menu principal");
            System.out.print("Ingrese la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer la opción

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el nombre del autor: ");
                    String autor = scanner.nextLine();
                    agregarLibro(titulo, autor);
                    break;
                case 2:
                    System.out.print("Ingrese el titulo del libro a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    eliminarLibro(tituloEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el titulo del libro a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    buscarLibro(tituloBuscar);
                    break;
                case 4:
                    listarLibros();
                    break;
                case 5:
                    Menu view = new Menu();
                    salir = true;
                    view.setVisible(true);
                    break;
                default:
                    System.out.println("Opcion inválida.");
                    break;
            }
        }
    }
}
