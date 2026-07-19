package service;

import model.PaqueteTuristico;
import util.LectorTXT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para cargar y gestionar paquetes turísticos desde archivo .txt.
 */
public class PaqueteService {

    private ArrayList<PaqueteTuristico> paquetes;

    public PaqueteService() {
        this.paquetes = new ArrayList<>();
    }

    public void cargarDesdeTXT(String rutaArchivo) {
        try {
            List<String[]> filas = LectorTXT.leer(rutaArchivo);
            paquetes.clear();
            for (String[] campos : filas) {
                // codigo,nombre,descripcion,precio,duracion,destino
                String codigo      = campos[0].trim();
                String nombre      = campos[1].trim();
                String descripcion = campos[2].trim();
                double precio      = Double.parseDouble(campos[3].trim());
                String duracion    = campos[4].trim();
                String destino     = campos[5].trim();
                paquetes.add(new PaqueteTuristico(codigo, nombre, descripcion, precio, duracion, destino));
            }
            System.out.println("✔ " + paquetes.size() + " paquetes turísticos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("✘ Error al leer paquetes: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("✘ Error en formato de datos de paquetes: " + e.getMessage());
        }
    }

    public ArrayList<PaqueteTuristico> obtenerTodos() { return paquetes; }
}
