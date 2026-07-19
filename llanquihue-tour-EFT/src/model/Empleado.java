package model;

public class Empleado extends Persona {

    private String cargo;
    private double salario;
    private String fechaContrato;

    public Empleado(String rut, String nombre, String apellido, String telefono, String correo,
                    Direccion direccion, String cargo, double salario, String fechaContrato) {
        super(rut, nombre, apellido, telefono, correo, direccion);
        this.cargo = cargo;
        this.salario = salario;
        this.fechaContrato = fechaContrato;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getFechaContrato() { return fechaContrato; }
    public void setFechaContrato(String fechaContrato) { this.fechaContrato = fechaContrato; }

    @Override
    public String toString() {
        return "Empleado{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + " " + getApellido() + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", fechaContrato='" + fechaContrato + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", direccion=" + getDireccion() +
                '}';
    }
}
