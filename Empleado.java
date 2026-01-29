import java.time.LocalDate;
import java.time.Period;


public class Empleado extends Persona {
    protected double salarioBase;
    protected int antiguedadAnios;
    protected String idEmpleado; 
    protected LocalDate fechaContratacion;
    protected String departamento;
    protected double jornadaHoraria;
    protected boolean activo;
    
    public Empleado(String dni, String nombre, int edad, double salarioBase, int antiguedadAnios, String idEmpleado, LocalDate fechaContratacion, String departamento, double jornadaHoraria, boolean activo) {
        super(dni, nombre, edad);
        this.salarioBase = salarioBase;
        this.antiguedadAnios = antiguedadAnios;
        this.idEmpleado = idEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.departamento = departamento;
        this.jornadaHoraria = jornadaHoraria;
        this.activo = activo;
    }
    
    public Empleado(String dni, String nombre, int edad, double salarioBase, int antiguedadAnios) {
        super();
    }


    public String getIdEmpleado() {
        return idEmpleado;
    }

    public LocalDate getFechaContratacion(){
        return fechaContratacion;
    }

    public String detDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public double getJornadaHoraria(){
        return jornadaHoraria;
    }

    public void setJornadaHoraria(double jornadaHoraria){
        this.jornadaHoraria = jornadaHoraria;
    }

    public boolean isActivo(){
        return activo;
    }


    public double getSalarioBase() {
        return salarioBase;
    }
    
    
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    
    public int getAntiguedadAnios() {
        return antiguedadAnios;
    }
    
    
    public void setAntiguedadAnios(int antiguedadAnios) {
        this.antiguedadAnios = antiguedadAnios;
    }
    
    public int calcularAntiguedad(){
        if (fechaContratacion == null) return 0;
        return Period.between(fechaContratacion, LocalDate.now()).getYears();
    }
    
    public double calcularSalario() {
        int antiguedad = calcularAntiguedad();
        double plusAntiguedad = salarioBase * (0.03 * antiguedad);
        return salarioBase + plusAntiguedad;
    }

    @Override
    public String toString(){
        return "Empleado: " + nombre + ", ID: " + idEmpleado + ", DNI: " + dni + ", Edad: " + edad + ", Departamento: " + departamento + ", Activo: " + activo + ", Fecha contratación: " + fechaContratacion + ", Jornada: " + jornadaHoraria + " horas al día.";
    }
    
    
    @Override
    public String presentarse() {
        return super.presentarse() + 
               ". Soy empleado con ID" + idEmpleado + 
               " y trabajo en el departamento de " + departamento + ".";
    }
}