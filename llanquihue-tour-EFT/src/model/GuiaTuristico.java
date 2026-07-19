package model;

/**
 * Representa un guía turístico de la agencia Llanquihue Tour.
 * Extiende Empleado e implementa Registrable.
 */
public class GuiaTuristico extends Empleado implements Registrable {

    private String idioma;
    private String especialidad;

    public GuiaTuristico(String rut, String nombre, String apellido, String telefono, String correo,
                         Direccion direccion, double salario, String fechaContrato,
                         String idioma, String especialidad) {
        super(rut, nombre, apellido, telefono, correo, direccion, "Guía Turístico", salario, fechaContrato);
        this.idioma = idioma;
        this.especialidad = especialidad;
    }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public void mostrarResumen() {
        System.out.println("[Guía Turístico] " + getNombre() + " " + getApellido() +
                " | Idioma: " + idioma + " | Especialidad: " + especialidad);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("=== DATOS GUÍA TURÍSTICO ===");
        System.out.println("RUT          : " + getRut());
        System.out.println("Nombre       : " + getNombre() + " " + getApellido());
        System.out.println("Idioma       : " + idioma);
        System.out.println("Especialidad : " + especialidad);
        System.out.println("Salario      : $" + getSalario());
        System.out.println("Contrato     : " + getFechaContrato());
        System.out.println("Teléfono     : " + getTelefono());
        System.out.println("Correo       : " + getCorreo());
        System.out.println("Dirección    : " + getDireccion());
    }

    @Override
    public String toString() {
        return "GuiaTuristico{rut='" + getRut() + "', nombre='" + getNombre() + " " + getApellido() +
                "', idioma='" + idioma + "', especialidad='" + especialidad + "'}";
    }
}
