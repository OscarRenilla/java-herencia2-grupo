public class Manager extends Empleado {
    private String titulo;
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

    public void aprobarHorasExtraÇ(desarrollador  dev, double horas){
        dev.registrarHorasExtra(horas);
        System.out.println("El manager " + nombre + " ha aprobado " + horas + " horas extra para " + dev.getNombre())
    }

    @Override 
    public double calcularAntiguedad() {
        int antiguedad = calcularAntiguedad();
        double plusAntiguedad = salarioBase * (0.03 * antiguedad);
        double plusPersonasCargo = personasACargo * 250;
        double bonusPresupuesto = presupuestoGestionado * 0.002;

        return salarioBase + plusAntiguedad + plusPersonasCargo + bonusPresupuesto;
    }

    @Override
    public super.toString("Título: " + titulo + ", Presupuesto gestionado: " + presupuestoGestionado + ", Reuniones semanales: " + reunionesSemanales);

}