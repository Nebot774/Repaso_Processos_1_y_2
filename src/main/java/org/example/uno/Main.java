package org.example.uno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Crear una nueva lista de URLs
        ListaURL urlList = new ListaURL();

        // Crear un nuevo objeto Descargas
        Descargas descargas = new Descargas();

        // Añadir un observador a la lista de URLs para que cuando se añada una nueva URL, se descargue
        urlList.getUrls().addListener(descargas);

        // Bucle infinito para seguir pidiendo URLs al usuario
        while (true) {
            System.out.println("Introduce una URL:"); // Solicitar al usuario que introduzca una URL
            String url = scanner.nextLine(); // Leer la URL introducida por el usuario
            urlList.addURL(url); // Añadir la URL a la lista
        }
    }
}
