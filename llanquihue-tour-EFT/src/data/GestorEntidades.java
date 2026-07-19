package data;

import model.Cliente;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.PaqueteTuristico;
import model.Registrable;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Gestiona una colección polimórfica de entidades Registrable.
 * Usa ArrayList (lista general), HashMap (búsqueda rápida por clave)
 * y Stack (historial de últimas acciones).
 */
public class GestorEntidades {

    // Lista polimórfica principal
    private ArrayList<Registrable> entidades;

    // Búsqueda rápida por RUT o código
    private HashMap<String, Registrable> indice;

    // Historial de las últimas acciones registradas
    private Stack<String> historial;

    public GestorEntidades() {
        this.entidades = new ArrayList<>();
        this.indice    = new HashMap<>();
        this.historial = new Stack<>();
    }

    /**
     * Agrega una entidad a la colección y la indexa por su clave.
     *
     * @param clave  RUT, patente o código que identifica la entidad.
     * @param entidad Objeto que implementa Registrable.
     */
    public void agregar(String clave, Registrable entidad) {
        entidades.add(entidad);
        indice.put(clave, entidad);
        historial.push("AGREGAR: " + entidad.getClass().getSimpleName() + " [" + clave + "]");
        entidad.registrar();
    }

    /**
     * Busca una entidad por su clave (RUT, patente o código).
     *
     * @param clave Clave de búsqueda.
     * @return La entidad encontrada o null si no existe.
     */
    public Registrable buscarPorClave(String clave) {
        return indice.get(clave);
    }

    /**
     * Muestra el resumen de todas las entidades registradas.
     */
    public void listarTodas() {
        if (entidades.isEmpty()) {
            System.out.println("No hay entidades registradas.");
            return;
        }
        System.out.println("\n=== ENTIDADES REGISTRADAS (" + entidades.size() + ") ===");
        for (Registrable r : entidades) {
            r.mostrarResumen();
        }
    }

    /**
     * Lista todas las entidades con sus datos completos.
     */
    public void listarConDatos() {
        System.out.println("\n=== DETALLE COMPLETO ===");
        for (Registrable r : entidades) {
            r.mostrarDatos();
            System.out.println();
        }
    }

    /**
     * Recorre la colección diferenciando por tipo con instanceof.
     */
    public void listarConDetalle() {
        System.out.println("\n=== DETALLE POR TIPO ===");
        for (Registrable r : entidades) {
            if (r instanceof GuiaTuristico) {
                GuiaTuristico g = (GuiaTuristico) r;
                System.out.println("👤 GUÍA: " + g.getNombre() + " " + g.getApellido() +
                        " — Idioma: " + g.getIdioma() + " | Especialidad: " + g.getEspecialidad());
            } else if (r instanceof Cliente) {
                Cliente c = (Cliente) r;
                System.out.println("🧳 CLIENTE: " + c.getNombre() + " " + c.getApellido() +
                        " — Nacionalidad: " + c.getNacionalidad() + " | Reservas: " + c.getCantidadReservas());
            } else if (r instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) r;
                System.out.println("🚐 VEHÍCULO: " + v.getMarca() + " " + v.getModelo() +
                        " — Patente: " + v.getPatente() + " | Capacidad: " + v.getCapacidad());
            } else if (r instanceof ColaboradorExterno) {
                ColaboradorExterno ce = (ColaboradorExterno) r;
                System.out.println("🤝 COLABORADOR: " + ce.getNombre() +
                        " — Empresa: " + ce.getEmpresa() + " | Servicio: " + ce.getServicio());
            } else if (r instanceof PaqueteTuristico) {
                PaqueteTuristico p = (PaqueteTuristico) r;
                System.out.println("🗺️  PAQUETE: " + p.getNombre() +
                        " — Destino: " + p.getDestino() + " | Precio: $" + p.getPrecio());
            }
        }
    }

    /**
     * Muestra las últimas acciones del historial (Stack).
     */
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        System.out.println("\n=== HISTORIAL DE ACCIONES ===");
        // Copia para no destruir el stack original
        Stack<String> copia = new Stack<>();
        copia.addAll(historial);
        while (!copia.isEmpty()) {
            System.out.println("  • " + copia.pop());
        }
    }

    public ArrayList<Registrable> getEntidades() { return entidades; }
    public HashMap<String, Registrable> getIndice() { return indice; }
    public int cantidad() { return entidades.size(); }
}
