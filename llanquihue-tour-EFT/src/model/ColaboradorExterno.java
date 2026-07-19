package model;

/**
 * Representa un colaborador externo de la agencia Llanquihue Tour.
 * Implementa Registrable para ser gestionado en la colección unificada.
 */
public class ColaboradorExterno implements Registrable {

    private String rut;
    private String nombre;
    private String empresa;
    private String servicio;
    private String contacto;

    public ColaboradorExterno(String rut, String nombre, String empresa,
                               String servicio, String contacto) {
        this.rut = rut;
        this.nombre = nombre;
        this.empresa = empresa;
        this.servicio = servicio;
        this.contacto = contacto;
    }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }
    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    @Override
    public void mostrarResumen() {
        System.out.println("[Colaborador Externo] " + nombre + " | Empresa: " + empresa +
                " | Servicio: " + servicio);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("=== DATOS COLABORADOR EXTERNO ===");
        System.out.println("RUT      : " + rut);
        System.out.println("Nombre   : " + nombre);
        System.out.println("Empresa  : " + empresa);
        System.out.println("Servicio : " + servicio);
        System.out.println("Contacto : " + contacto);
    }

    @Override
    public String toString() {
        return "ColaboradorExterno{rut='" + rut + "', nombre='" + nombre +
                "', empresa='" + empresa + "', servicio='" + servicio + "'}";
    }
}
