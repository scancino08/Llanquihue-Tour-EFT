package model;

/**
 * Representa un cliente de la agencia Llanquihue Tour.
 * Extiende Persona e implementa Registrable.
 */
public class Cliente extends Persona implements Registrable {

    private String nacionalidad;
    private int cantidadReservas;

    public Cliente(String rut, String nombre, String apellido, String telefono, String correo,
                   Direccion direccion, String nacionalidad, int cantidadReservas) {
        super(rut, nombre, apellido, telefono, correo, direccion);
        this.nacionalidad = nacionalidad;
        this.cantidadReservas = cantidadReservas;
    }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public int getCantidadReservas() { return cantidadReservas; }
    public void setCantidadReservas(int cantidadReservas) { this.cantidadReservas = cantidadReservas; }

    @Override
    public void mostrarResumen() {
        System.out.println("[Cliente] " + getNombre() + " " + getApellido() +
                " | Nacionalidad: " + nacionalidad + " | Reservas: " + cantidadReservas);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("=== DATOS CLIENTE ===");
        System.out.println("RUT          : " + getRut());
        System.out.println("Nombre       : " + getNombre() + " " + getApellido());
        System.out.println("Nacionalidad : " + nacionalidad);
        System.out.println("Reservas     : " + cantidadReservas);
        System.out.println("Teléfono     : " + getTelefono());
        System.out.println("Correo       : " + getCorreo());
        System.out.println("Dirección    : " + getDireccion());
    }

    @Override
    public String toString() {
        return "Cliente{rut='" + getRut() + "', nombre='" + getNombre() + " " + getApellido() +
                "', nacionalidad='" + nacionalidad + "', reservas=" + cantidadReservas + "}";
    }
}
