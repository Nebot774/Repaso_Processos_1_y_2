package org.example.uno;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaURL {
    // Lista observable de URLs
    private ObservableList<String> urls;

    // Constructor de la clase ListaURL
    public ListaURL() {
        // Inicializar la lista de URLs como una lista observable
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