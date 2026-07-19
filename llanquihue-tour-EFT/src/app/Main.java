package app;

import data.GestorEntidades;
import model.*;
import service.*;
import ui.VentanaPrincipal;
import util.ValidadorRut;

/**
 * Clase principal del sistema Llanquihue Tour v4.0 (EFT).
 * Carga datos desde archivos .txt, gestiona colecciones y lanza la GUI.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("   SISTEMA LLANQUIHUE TOUR v4.0 - EFT");
        System.out.println("===========================================\n");

        // --- CARGA DE DATOS DESDE ARCHIVOS .TXT ---
        ClienteService  clienteService  = new ClienteService();
        GuiaService     guiaService     = new GuiaService();
        VehiculoService vehiculoService = new VehiculoService();
        PaqueteService  paqueteService  = new PaqueteService();

        System.out.println("Cargando datos desde archivos .txt...");
        clienteService.cargarDesdeCSV("data/clientes.txt");
        guiaService.cargarDesdeCSV("data/guias.txt");
        vehiculoService.cargarDesdeTXT("data/vehiculos.txt");
        paqueteService.cargarDesdeTXT("data/paquetes.txt");

        // --- GESTOR CON ArrayList + HashMap + Stack ---
        GestorEntidades gestor = new GestorEntidades();

        // Cargar clientes (validando RUT con excepción personalizada)
        for (Cliente c : clienteService.obtenerTodos()) {
            try {
                ValidadorRut.validar(c.getRut());
                gestor.agregar(c.getRut(), c);
            } catch (model.RutInvalidoException e) {
                System.out.println("✘ RUT inválido omitido: " + e.getMessage());
            }
        }

        // Cargar guías
        for (GuiaTuristico g : guiaService.obtenerTodos()) {
            try {
                ValidadorRut.validar(g.getRut());
                gestor.agregar(g.getRut(), g);
            } catch (model.RutInvalidoException e) {
                System.out.println("✘ RUT inválido omitido: " + e.getMessage());
            }
        }

        // Cargar vehículos (clave = patente)
        for (Vehiculo v : vehiculoService.obtenerTodos()) {
            gestor.agregar(v.getPatente(), v);
        }

        // Cargar paquetes turísticos (clave = código)
        for (PaqueteTuristico p : paqueteService.obtenerTodos()) {
            gestor.agregar(p.getCodigo(), p);
        }

        // Colaboradores externos (datos fijos)
        ColaboradorExterno c1 = new ColaboradorExterno(
                "77.777.777-7", "Carlos Vera", "Foto Patagonia", "Fotografía turística", "+56912345678");
        ColaboradorExterno c2 = new ColaboradorExterno(
                "88.888.888-8", "Ana Muñoz", "Sabores del Lago", "Catering y cocina local", "+56987654321");
        gestor.agregar(c1.getRut(), c1);
        gestor.agregar(c2.getRut(), c2);

        System.out.println("\nTotal entidades cargadas: " + gestor.cantidad());

        // Mostrar detalle por tipo en consola (instanceof)
        gestor.listarConDetalle();

        // Mostrar historial de acciones (Stack)
        gestor.mostrarHistorial();

        // --- LANZAR GUI ---
        VentanaPrincipal ventana = new VentanaPrincipal(gestor);
        ventana.iniciar();
    }
}
