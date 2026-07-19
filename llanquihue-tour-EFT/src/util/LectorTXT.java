package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para leer archivos de texto (.txt).
 * Cada línea se separa por comas y se retorna como arreglo de campos.
 */
public class LectorTXT {

    /**
     * Lee un archivo .txt y retorna sus líneas (sin encabezado) como listas de campos.
     *
     * @param rutaArchivo Ruta del archivo .txt a leer.
     * @return Lista de arreglos de String, cada uno representando una fila.
     * @throws IOException Si el archivo no se puede leer.
     */
    public static List<String[]> leer(String rutaArchivo) throws IOException {
        List<String[]> filas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                if (!linea.trim().isEmpty()) {
                    filas.add(linea.split(",", -1));
                }
            }
        }

        return filas;
    }
}
