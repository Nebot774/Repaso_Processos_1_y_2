package org.example.uno;

import javafx.collections.ListChangeListener;


public class Descargas  implements ListChangeListener<String> {
    // Este método se invoca cuando se produce un cambio en la lista de URLs
    @Override
    public void onChanged(Change<? extends String> c) {
        // Mientras haya elementos en la lista de cambios
        while (c.next()) {
            // Si se añadió una URL a la lista
            if (c.wasAdded()) {
                // Para cada URL añadida a la lista
                for (String url : c.getAddedSubList()) {
                    // Imprime un mensaje indicando que se ha iniciado la descarga del archivo
                    System.out.println("Se ha iniciado la descarga del archivo: " + url);
                }
            }
        }
    }
}

