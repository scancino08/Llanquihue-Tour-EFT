package model;

/**
 * Representa un vehículo de la flota de Llanquihue Tour.
 * Implementa Registrable para ser gestionado en la colección unificada.
 */
public class Vehiculo implements Registrable {

    private String patente;
    private String marca;
    private String modelo;
    private int capacidad;
    private String tipo;

    public Vehiculo(String patente, String marca, String modelo, int capacidad, String tipo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public void mostrarResumen() {
        System.out.println("[Vehículo] " + tipo + " " + marca + " " + modelo +
                " | Patente: " + patente + " | Capacidad: " + capacidad + " pasajeros");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("=== DATOS VEHÍCULO ===");
        System.out.println("Patente    : " + patente);
        System.out.println("Marca      : " + marca);
        System.out.println("Modelo     : " + modelo);
        System.out.println("Tipo       : " + tipo);
        System.out.println("Capacidad  : " + capacidad + " pasajeros");
    }

    @Override
    public String toString() {
        return "Vehiculo{patente='" + patente + "', marca='" + marca + "', modelo='" + modelo +
                "', capacidad=" + capacidad + ", tipo='" + tipo + "'}";
    }
}
