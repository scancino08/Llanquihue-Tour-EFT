package model;

/**
 * Interfaz que define el contrato común para todas las entidades
 * gestionables del sistema Llanquihue Tour.
 */
public interface Registrable {

    /**
     * Muestra un resumen breve de la entidad (una línea).
     */
    void mostrarResumen();

    /**
     * Muestra todos los datos completos de la entidad.
     */
    void mostrarDatos();

    /**
     * Registra la entidad en el sistema (confirma su incorporación).
     */
    default void registrar() {
        System.out.println("✔ Entidad registrada: " + this.getClass().getSimpleName());
    }
}
