package ui;

import data.GestorEntidades;
import model.ColaboradorExterno;
import model.Direccion;
import model.GuiaTuristico;
import model.Registrable;
import model.Vehiculo;

import javax.swing.*;

/**
 * Interfaz gráfica del sistema Llanquihue Tour.
 * Permite ingresar y visualizar entidades usando JOptionPane y JFrame.
 */
public class VentanaPrincipal {

    private GestorEntidades gestor;

    public VentanaPrincipal(GestorEntidades gestor) {
        this.gestor = gestor;
    }

    /**
     * Inicia el menú principal de la interfaz gráfica.
     */
    public void iniciar() {
        String[] opciones = {
            "1. Registrar Guía Turístico",
            "2. Registrar Vehículo",
            "3. Registrar Colaborador Externo",
            "4. Ver todas las entidades",
            "5. Ver detalle por tipo",
            "6. Salir"
        };

        boolean salir = false;

        while (!salir) {
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "Bienvenido al Sistema Llanquihue Tour\nSeleccione una opción:",
                "Llanquihue Tour — Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (seleccion) {
                case 0:
                    registrarGuia();
                    break;
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    registrarColaborador();
                    break;
                case 3:
                    mostrarResumenEntidades();
                    break;
                case 4:
                    mostrarDetallePorTipo();
                    break;
                case 5:
                case JOptionPane.CLOSED_OPTION:
                    salir = true;
                    JOptionPane.showMessageDialog(null,
                        "Sistema cerrado. ¡Hasta pronto!",
                        "Llanquihue Tour",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    }

    private void registrarGuia() {
        try {
            String rut        = JOptionPane.showInputDialog(null, "RUT del guía:", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (rut == null) return;
            String nombre     = JOptionPane.showInputDialog(null, "Nombre:", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (nombre == null) return;
            String apellido   = JOptionPane.showInputDialog(null, "Apellido:", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (apellido == null) return;
            String telefono   = JOptionPane.showInputDialog(null, "Teléfono:", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (telefono == null) return;
            String correo     = JOptionPane.showInputDialog(null, "Correo:", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (correo == null) return;
            String ciudad     = JOptionPane.showInputDialog(null, "Ciudad:", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (ciudad == null) return;
            String idioma     = JOptionPane.showInputDialog(null, "Idiomas (ej: Español / Inglés):", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (idioma == null) return;
            String especialidad = JOptionPane.showInputDialog(null, "Especialidad:", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (especialidad == null) return;
            String salarioStr = JOptionPane.showInputDialog(null, "Salario:", "Registrar Guía", JOptionPane.PLAIN_MESSAGE);
            if (salarioStr == null) return;

            double salario = Double.parseDouble(salarioStr.trim());
            Direccion direccion = new Direccion("Sin especificar", "S/N", ciudad, "Región de Los Lagos");

            GuiaTuristico guia = new GuiaTuristico(rut, nombre, apellido, telefono, correo,
                    direccion, salario, "2024-01-01", idioma, especialidad);
            gestor.agregar(guia);

            JOptionPane.showMessageDialog(null,
                "✔ Guía registrado correctamente:\n" + guia.toString(),
                "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                "✘ Error: El salario debe ser un número válido.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarVehiculo() {
        try {
            String patente  = JOptionPane.showInputDialog(null, "Patente:", "Registrar Vehículo", JOptionPane.PLAIN_MESSAGE);
            if (patente == null) return;
            String marca    = JOptionPane.showInputDialog(null, "Marca:", "Registrar Vehículo", JOptionPane.PLAIN_MESSAGE);
            if (marca == null) return;
            String modelo   = JOptionPane.showInputDialog(null, "Modelo:", "Registrar Vehículo", JOptionPane.PLAIN_MESSAGE);
            if (modelo == null) return;
            String tipo     = JOptionPane.showInputDialog(null, "Tipo (Minibús, Van, Camioneta):", "Registrar Vehículo", JOptionPane.PLAIN_MESSAGE);
            if (tipo == null) return;
            String capStr   = JOptionPane.showInputDialog(null, "Capacidad (pasajeros):", "Registrar Vehículo", JOptionPane.PLAIN_MESSAGE);
            if (capStr == null) return;

            int capacidad = Integer.parseInt(capStr.trim());
            Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, capacidad, tipo);
            gestor.agregar(vehiculo);

            JOptionPane.showMessageDialog(null,
                "✔ Vehículo registrado correctamente:\n" + vehiculo.toString(),
                "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                "✘ Error: La capacidad debe ser un número entero.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarColaborador() {
        String rut      = JOptionPane.showInputDialog(null, "RUT:", "Registrar Colaborador Externo", JOptionPane.PLAIN_MESSAGE);
        if (rut == null) return;
        String nombre   = JOptionPane.showInputDialog(null, "Nombre:", "Registrar Colaborador Externo", JOptionPane.PLAIN_MESSAGE);
        if (nombre == null) return;
        String empresa  = JOptionPane.showInputDialog(null, "Empresa:", "Registrar Colaborador Externo", JOptionPane.PLAIN_MESSAGE);
        if (empresa == null) return;
        String servicio = JOptionPane.showInputDialog(null, "Servicio que ofrece:", "Registrar Colaborador Externo", JOptionPane.PLAIN_MESSAGE);
        if (servicio == null) return;
        String contacto = JOptionPane.showInputDialog(null, "Contacto (teléfono/correo):", "Registrar Colaborador Externo", JOptionPane.PLAIN_MESSAGE);
        if (contacto == null) return;

        ColaboradorExterno colaborador = new ColaboradorExterno(rut, nombre, empresa, servicio, contacto);
        gestor.agregar(colaborador);

        JOptionPane.showMessageDialog(null,
            "✔ Colaborador registrado correctamente:\n" + colaborador.toString(),
            "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarResumenEntidades() {
        if (gestor.cantidad() == 0) {
            JOptionPane.showMessageDialog(null,
                "No hay entidades registradas aún.",
                "Sin registros", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("ENTIDADES REGISTRADAS (").append(gestor.cantidad()).append("):\n\n");

        for (Registrable r : gestor.getEntidades()) {
            sb.append("• ").append(r.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null,
            sb.toString(),
            "Todas las entidades", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarDetallePorTipo() {
        if (gestor.cantidad() == 0) {
            JOptionPane.showMessageDialog(null,
                "No hay entidades registradas aún.",
                "Sin registros", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder guias   = new StringBuilder("GUÍAS TURÍSTICOS:\n");
        StringBuilder vehiculos = new StringBuilder("\nVEHÍCULOS:\n");
        StringBuilder colaboradores = new StringBuilder("\nCOLABORADORES EXTERNOS:\n");
        StringBuilder clientes = new StringBuilder("\nCLIENTES:\n");

        for (Registrable r : gestor.getEntidades()) {
            if (r instanceof GuiaTuristico) {
                GuiaTuristico g = (GuiaTuristico) r;
                guias.append("  • ").append(g.getNombre()).append(" ").append(g.getApellido())
                     .append(" | ").append(g.getIdioma()).append("\n");
            } else if (r instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) r;
                vehiculos.append("  • ").append(v.getMarca()).append(" ").append(v.getModelo())
                         .append(" (").append(v.getPatente()).append(")\n");
            } else if (r instanceof ColaboradorExterno) {
                ColaboradorExterno ce = (ColaboradorExterno) r;
                colaboradores.append("  • ").append(ce.getNombre())
                             .append(" — ").append(ce.getServicio()).append("\n");
            } else if (r instanceof model.Cliente) {
                model.Cliente c = (model.Cliente) r;
                clientes.append("  • ").append(c.getNombre()).append(" ").append(c.getApellido()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null,
            guias.toString() + vehiculos.toString() + colaboradores.toString() + clientes.toString(),
            "Detalle por tipo", JOptionPane.INFORMATION_MESSAGE);
    }
}
