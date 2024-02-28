# Gestor de Descargas de URLs en JavaFX

## Descripción
Este proyecto es una aplicación JavaFX que permite a los usuarios introducir URLs, las cuales son añadidas a una lista observable. Un observador, `Descargas2`, monitoriza esta lista y, cuando se añade una nueva URL, inicia una descarga asíncrona.

## Construcción y Ejecución
Para construir y ejecutar este proyecto, se requiere Java y un entorno que soporte JavaFX. Sigue estos pasos:

1. Clona el repositorio: `git clone [URL_DEL_REPOSITORIO]`
2. Navega al directorio del proyecto: `cd [NOMBRE_DEL_DIRECTORIO]`
3. Ejecuta el proyecto con tu entorno de desarrollo o línea de comandos.

## Clases

### `Main2`
- **Funcionalidad**: Clase principal que inicia la aplicación. Solicita URLs al usuario y las añade a la lista.
- **Métodos principales**: 
  - `main(String[] args)`: Punto de entrada de la aplicación.

### `ListaURL2`
- **Funcionalidad**: Mantiene y gestiona una lista observable de URLs.
- **Métodos principales**: 
  - `addURL(String url)`: Añade una URL a la lista.
  - `getUrls()`: Retorna la lista observable.

### `Descargas2` (Implementa `ListChangeListener<String>`)
- **Funcionalidad**: Observa los cambios en la lista de URLs y inicia la descarga de nuevas URLs.
- **Métodos principales**: 
  - `onChanged(Change<? extends String> c)`: Se invoca cuando se añade una URL a la lista.
  - `descargarURL(String url)`: Descarga el contenido de la URL.

## Dependencias
Asegúrate de incluir las dependencias de JavaFX en tu archivo `pom.xml`:

```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>11</version>
</dependency>
