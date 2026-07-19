package service;

import model.Vehiculo;
import util.LectorTXT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para cargar y gestionar vehículos desde archivo .txt.
 */
public class VehiculoService {

    private ArrayList<Vehiculo> vehiculos;

    public VehiculoService() {
        this.vehiculos = new ArrayList<>();
    }

    public void cargarDesdeTXT(String rutaArchivo) {
        try {
            List<String[]> filas = LectorTXT.leer(rutaArchivo);
            vehiculos.clear();
            for (String[] campos : filas) {
                // patente,marca,modelo,capacidad,tipo
                String patente = campos[0].trim();
                String marca   = campos[1].trim();
                String modelo  = campos[2].trim();
                int capacidad  = Integer.parseInt(campos[3].trim());
                String tipo    = campos[4].trim();
                vehiculos.add(new Vehiculo(patente, marca, modelo, capacidad, tipo));
            }
            System.out.println("✔ " + vehiculos.size() + " vehículos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("✘ Error al leer vehículos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("✘ Error en formato de datos de vehículos: " + e.getMessage());
        }
    }

    public ArrayList<Vehiculo> obtenerTodos() { return vehiculos; }
}
