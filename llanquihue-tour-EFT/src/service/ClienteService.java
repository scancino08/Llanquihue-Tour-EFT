package service;

import model.Cliente;
import model.Direccion;
import util.LectorCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar la colección de clientes.
 * Carga los datos desde un archivo CSV y permite buscar por RUT o nombre.
 */
public class ClienteService {

    private ArrayList<Cliente> clientes;

    public ClienteService() {
        this.clientes = new ArrayList<>();
    }

    /**
     * Carga los clientes desde un archivo CSV.
     *
     * @param rutaArchivo Ruta del archivo clientes.csv
     */
    public void cargarDesdeCSV(String rutaArchivo) {
        try {
            List<String[]> filas = LectorCSV.leer(rutaArchivo);
            clientes.clear();

            for (String[] campos : filas) {
                // rut,nombre,apellido,telefono,correo,calle,numero,ciudad,region,nacionalidad,cantidadReservas
                String rut            = campos[0].trim();
                String nombre         = campos[1].trim();
                String apellido       = campos[2].trim();
                String telefono       = campos[3].trim();
                String correo         = campos[4].trim();
                String calle          = campos[5].trim();
                String numero         = campos[6].trim();
                String ciudad         = campos[7].trim();
                String region         = campos[8].trim();
                String nacionalidad   = campos[9].trim();
                int cantidadReservas  = Integer.parseInt(campos[10].trim());

                Direccion direccion = new Direccion(calle, numero, ciudad, region);
                Cliente cliente = new Cliente(rut, nombre, apellido, telefono, correo,
                        direccion, nacionalidad, cantidadReservas);
                clientes.add(cliente);
            }

            System.out.println("✔ " + clientes.size() + " clientes cargados correctamente.");

        } catch (IOException e) {
            System.out.println("✘ Error al leer el archivo de clientes: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("✘ Error en el formato de datos del CSV: " + e.getMessage());
        }
    }

    /**
     * Retorna todos los clientes cargados.
     */
    public ArrayList<Cliente> obtenerTodos() {
        return clientes;
    }

    /**
     * Busca un cliente por su RUT.
     *
     * @param rut RUT a buscar.
     * @return El cliente encontrado o null si no existe.
     */
    public Cliente buscarPorRut(String rut) {
        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rut.trim())) {
                return c;
            }
        }
        return null;
    }

    /**
     * Busca clientes cuyo nombre o apellido contenga el texto ingresado.
     *
     * @param texto Texto a buscar (no sensible a mayúsculas).
     * @return Lista de clientes que coinciden.
     */
    public ArrayList<Cliente> buscarPorNombre(String texto) {
        ArrayList<Cliente> resultados = new ArrayList<>();
        String textoBusqueda = texto.trim().toLowerCase();

        for (Cliente c : clientes) {
            if (c.getNombre().toLowerCase().contains(textoBusqueda)
                    || c.getApellido().toLowerCase().contains(textoBusqueda)) {
                resultados.add(c);
            }
        }
        return resultados;
    }
}
