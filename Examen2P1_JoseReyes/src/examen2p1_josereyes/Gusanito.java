/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p1_josereyes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class Gusanito {
    private char[][] tablero;
    private int gusX, gusY, manX, manY;
    private ArrayList<String> instrucciones;

    public Gusanito(int n, int m) {
        instrucciones = new ArrayList<String>();
        tablero = new char[n][m];
        Random random = new Random();
        gusX = random.nextInt(n);
        gusY = random.nextInt(m);
        manX = random.nextInt(n);
        manY = random.nextInt(m);
        while (manX == gusX && manY == gusY) {
            manX = random.nextInt(n);
            manY = random.nextInt(m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tablero[i][j] = ' ';
            }
        }
        tablero[gusX][gusY] = 'S';
        tablero[manX][manY] = 'O';
    }

    public void addInstruccion(String instruccion) {
        instrucciones.add(instruccion);
    }

    public void mover() {
        Scanner scanner = new Scanner(System.in);
        for (String instruccion : instrucciones) {
            int longitud = Integer.parseInt(instruccion.substring(0, instruccion.length() - 2));
            String direccion = instruccion.substring(instruccion.length() - 2);
            for (int i = 1; i <= longitud; i++) {
                int newX = gusX;
                int newY = gusY;
                if (direccion.equals("UP")) {
                    newX--;
                } else if (direccion.equals("DN")) {
                    newX++;
                } else if (direccion.equals("LT")) {
                    newY--;
                } else if (direccion.equals("RT")) {
                    newY++;
                }
                if (newX < 0 || newX >= tablero.length || newY < 0 || newY >= tablero[0].length) {
                    System.out.println("Te saliste del tablero!");
                    return;
                } else if (tablero[newX][newY] != ' ') {
                    System.out.println("Te encontraste con algo!");
                    return;
                } else {
                    tablero[gusX][gusY] = ' ';
                    gusX = newX;
                    gusY = newY;
                    tablero[gusX][gusY] = 'S';
                }
                imprimirTablero();
            }
        }
        if (gusX == manX && gusY == manY) {
            System.out.println("Lograste llegar a la manzana!");
        } else {
            System.out.println("No lograste llegar a la manzana :(");
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
}
