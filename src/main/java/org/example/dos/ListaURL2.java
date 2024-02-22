package org.example.dos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaURL2 {
    // Mantiene una lista observable de URLs
    private ObservableList<String> urls;

    public ListaURL2() {
        // Inicializa la lista de URLs
        urls = FXCollections.observableArrayList();
    }

    // Método para añadir una URL a la lista
    public void addURL(String url) {
        urls.add(url);
    }

    // Método para obtener la lista de URLs
    public ObservableList<String> getUrls() {
        return urls;
    }
}