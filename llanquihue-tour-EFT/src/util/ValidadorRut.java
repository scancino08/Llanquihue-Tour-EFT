package util;

import model.RutInvalidoException;

/**
 * Clase utilitaria para validar RUTs chilenos.
 * Formato aceptado: XX.XXX.XXX-X o XXXXXXXX-X
 */
public class ValidadorRut {

    /**
     * Valida que el RUT tenga un formato básico correcto.
     * Formato esperado: 12.345.678-9 o 12345678-9
     *
     * @param rut RUT a validar.
     * @throws RutInvalidoException Si el RUT no tiene un formato válido.
     */
    public static void validar(String rut) throws RutInvalidoException {
        if (rut == null || rut.trim().isEmpty()) {
            throw new RutInvalidoException("El RUT no puede estar vacío.");
        }

        // Aceptar formato con o sin puntos: 12.345.678-9 o 12345678-9
        String rutLimpio = rut.trim().replace(".", "");

        if (!rutLimpio.matches("\\d{7,8}-[\\dkK]")) {
            throw new RutInvalidoException(
                "Formato de RUT inválido: '" + rut + "'. Use el formato 12345678-9.");
        }
    }
}
