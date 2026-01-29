import java.time.LocalDate;

public class Manager extends Empleado {
    private String titulo;
    private double personasACargo;
    private double presupuestoGestionado;
    private int reunionesSemanales; 

    public Manager(String dni, String nombre, int edad, 
        double salarioBase, int antiguedadAnios,
        String idEmpleado, LocalDate fechaContratacion,
        String departamento, double jornadaHoraria, boolean activo,
        String titulo, double presupuestoGestionado, int reunionesSemanales) {

        super(dni, nombre, edad, salarioBase, antiguedadAnios, idEmpleado, fechaContratacion, departamento, jornadaHoraria, activo);
        this.titulo = titulo;
        this.presupuestoGestionado = presupuestoGestionado;
        this.reunionesSemanales = reunionesSemanales; 
    }

    public Manager(String id, String nombre, LocalDate fn, String email, String tel, double sal, LocalDate now, String titulo, double pres, int i) {
    }

    public void aprobarHorasExtra(Desarrollador  dev, double horas){
        dev.registrarHoraExtra(horas);
        System.out.println("El manager " + nombre + " ha aprobado " + horas + " horas extra para " + dev.getNombre());
    }

    public int calcularAntiguedad() {
        int antiguedad = calcularAntiguedad();
        double plusAntiguedad = salarioBase * (0.03 * antiguedad);
        double plusPersonasCargo = personasACargo * 250;
        double bonusPresupuesto = presupuestoGestionado * 0.002;

        return (int) salarioBase + plusAntiguedad + plusPersonasCargo + bonusPresupuesto;
    }

    @Override
    public String toString(){
        return ("Título: " + titulo + ", Presupuesto gestionado: " + presupuestoGestionado +  ", personasACargo=" + personasACargo + ", Reuniones semanales: " + reunionesSemanales);
    }
}