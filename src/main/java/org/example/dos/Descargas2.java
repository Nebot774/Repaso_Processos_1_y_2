package org.example.dos;

import javafx.collections.ListChangeListener;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

public class Descargas2 implements ListChangeListener<String> {
    // Este método se invoca cuando se produce un cambio en la lista de URLs
    @Override
    public void onChanged(Change<? extends String> c) {
        // Mientras haya elementos en la lista de cambios
        while (c.next()) {
            // Si se añadió una URL a la lista
            if (c.wasAdded()) {
                // Para cada URL añadida a la lista
                for (String url : c.getAddedSubList()) {
                    // Inicia una tarea asíncrona para descargar la URL
                    CompletableFuture.runAsync(() -> {
                        try {
                            descargarURL(url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
    }

    // Método para descargar una URL y guardarla en un archivo
    private void descargarURL(String url) throws IOException {
        // Abre un flujo de entrada desde la URL
        InputStream in = new URL(url).openStream();
        // Copia el contenido del flujo de entrada a un archivo
        Files.copy(in, Paths.get("downloaded.html"));
    }
}