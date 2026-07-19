package model;

/**
 * Excepción personalizada que se lanza cuando el RUT ingresado
 * no cumple con el formato válido esperado por el sistema.
 */
public class RutInvalidoException extends Exception {

    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}
