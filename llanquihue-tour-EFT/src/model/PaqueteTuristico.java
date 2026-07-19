package model;

/**
 * Representa un paquete turístico ofrecido por la agencia Llanquihue Tour.
 * Implementa Registrable para ser gestionado en la colección unificada.
 */
public class PaqueteTuristico implements Registrable {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private String duracion;
    private String destino;

    public PaqueteTuristico(String codigo, String nombre, String descripcion,
                             double precio, String duracion, String destino) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
        this.destino = destino;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    @Override
    public void mostrarResumen() {
        System.out.println("[Paquete] " + nombre + " | Destino: " + destino +
                " | Precio: $" + precio + " | Duración: " + duracion);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("=== DATOS PAQUETE TURÍSTICO ===");
        System.out.println("Código      : " + codigo);
        System.out.println("Nombre      : " + nombre);
        System.out.println("Descripción : " + descripcion);
        System.out.println("Destino     : " + destino);
        System.out.println("Duración    : " + duracion);
        System.out.println("Precio      : $" + precio);
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{codigo='" + codigo + "', nombre='" + nombre +
                "', destino='" + destino + "', precio=" + precio + "}";
    }
}
