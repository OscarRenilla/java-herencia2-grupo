public class Manager extends Empleado {
    protected int personasACargo; 

    public Manager(String dni, String nombre, int edad, double salarioBase, int antiguedadAnios, int personasACargo){
        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.personasACargo = personasACargo;
    }

    public int getPersonasACargo(){
        return personasACargo;
    }

    public void setPersonasACargo(int personasACargo){
        this.personasACargo = personasACargo; 
    }

    @Override 
    public double calcularSalario() {
        double plusResponsabilidad = personasACargo * 100;
        double plusAntiguedad = antiguedadAnios * 75;
        return salarioBase + plusResponsabilidad + plusAntiguedad;      
    }

}