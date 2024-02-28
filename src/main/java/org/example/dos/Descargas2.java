package org.example.dos;

import javafx.collections.ListChangeListener;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Descargas2 implements ListChangeListener<String> {
    // Lista para mantener los futuros de las descargas
    private List<CompletableFuture<Void>> futures = new ArrayList<>();

    @Override
    public void onChanged(Change<? extends String> c) {
        while (c.next()) {
            if (c.wasAdded()) {
                for (String url : c.getAddedSubList()) {
                    // Guarda el futuro en la lista
                    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                        try {
                            descargarURL(url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    futures.add(future);
                }
            }
        }
    }

    // Método para descargar una URL y guardarla en un archivo
    private void descargarURL(String url) throws IOException {
        // Abre un flujo de entrada desde la URL
        InputStream in = new URL(url).openStream();
        // Genera un nombre de archivo único con timestamp
        String fileName = "downloaded_" + System.currentTimeMillis() + ".html";
        // Copia el contenido del flujo de entrada a un archivo único
        Files.copy(in, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
    }
    // Método para esperar a que todas las descargas,cuando el usuario salga del bucle para descargar pagians esperaremos a que se hayan descargado todas
    public void esperarDescargas() {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }


}