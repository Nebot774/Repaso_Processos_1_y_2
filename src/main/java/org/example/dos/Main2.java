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
            System.out.println("Introduce una URL:");
            String url = scanner.nextLine();
            // Añade la URL a la lista
            urlList.addURL(url);
        }
    }
}