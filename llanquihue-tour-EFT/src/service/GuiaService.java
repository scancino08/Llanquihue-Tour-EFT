package service;

import model.Direccion;
import model.GuiaTuristico;
import util.LectorCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar la colección de guías turísticos.
 * Carga los datos desde un archivo CSV y permite buscar por RUT o idioma.
 */
public class GuiaService {

    private ArrayList<GuiaTuristico> guias;

    public GuiaService() {
        this.guias = new ArrayList<>();
    }

    /**
     * Carga los guías desde un archivo CSV.
     *
     * @param rutaArchivo Ruta del archivo guias.csv
     */
    public void cargarDesdeCSV(String rutaArchivo) {
        try {
            List<String[]> filas = LectorCSV.leer(rutaArchivo);
            guias.clear();

            for (String[] campos : filas) {
                // rut,nombre,apellido,telefono,correo,calle,numero,ciudad,region,salario,fechaContrato,idioma,especialidad
                String rut           = campos[0].trim();
                String nombre        = campos[1].trim();
                String apellido      = campos[2].trim();
                String telefono      = campos[3].trim();
                String correo        = campos[4].trim();
                String calle         = campos[5].trim();
                String numero        = campos[6].trim();
                String ciudad        = campos[7].trim();
                String region        = campos[8].trim();
                double salario       = Double.parseDouble(campos[9].trim());
                String fechaContrato = campos[10].trim();
                String idioma        = campos[11].trim();
                String especialidad  = campos[12].trim();

                Direccion direccion = new Direccion(calle, numero, ciudad, region);
                GuiaTuristico guia = new GuiaTuristico(rut, nombre, apellido, telefono, correo,
                        direccion, salario, fechaContrato, idioma, especialidad);
                guias.add(guia);
            }

            System.out.println("✔ " + guias.size() + " guías turísticos cargados correctamente.");

        } catch (IOException e) {
            System.out.println("✘ Error al leer el archivo de guías: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("✘ Error en el formato de datos del CSV: " + e.getMessage());
        }
    }

    /**
     * Retorna todos los guías cargados.
     */
    public ArrayList<GuiaTuristico> obtenerTodos() {
        return guias;
    }

    /**
     * Busca un guía por su RUT.
     *
     * @param rut RUT a buscar.
     * @return El guía encontrado o null si no existe.
     */
    public GuiaTuristico buscarPorRut(String rut) {
        for (GuiaTuristico g : guias) {
            if (g.getRut().equalsIgnoreCase(rut.trim())) {
                return g;
            }
        }
        return null;
    }

    /**
     * Busca guías que manejen un idioma específico.
     *
     * @param idioma Idioma a buscar.
     * @return Lista de guías que hablan ese idioma.
     */
    public ArrayList<GuiaTuristico> buscarPorIdioma(String idioma) {
        ArrayList<GuiaTuristico> resultados = new ArrayList<>();
        String textoBusqueda = idioma.trim().toLowerCase();

        for (GuiaTuristico g : guias) {
            if (g.getIdioma().toLowerCase().contains(textoBusqueda)) {
                resultados.add(g);
            }
        }
        return resultados;
    }
}
