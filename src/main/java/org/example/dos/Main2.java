package org.example.dos;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Crea una instancia de ListaURL2
        ListaURL2 urlList = new ListaURL2();
        // Crea una instancia de Descargas2
        Descargas2 descargas = new Descargas2();
        // Añade descargas como observador de la lista de URLs
        urlList.getUrls().addListener(descargas);

        // Entra en un bucle infinito
        while (true) {
            // Solicita una URL al usuario
            System.out.println("Introduce una URL o escribe 'salir' para finalizar:");
            String input = scanner.nextLine();
            // Verifica si el usuario desea salir
            if ("salir".equalsIgnoreCase(input)) {
                break; // Sale del bucle
            }
            // Añade la URL a la lista
            urlList.addURL(input);
        }

        // Espera a que todas las descargas se completen antes de finalizar
        System.out.println("Esperando a que todas las descargas finalicen...");
        descargas.esperarDescargas();
        System.out.println("Todas las descargas han finalizado. Programa terminado.");
    }
}
