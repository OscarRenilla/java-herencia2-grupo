public class Departamento(){

    private String nombre;
    private String jefeDepartamento
    private double presupuestoAnual;
    private List<String> empleados;

    public Departamento(String nombre, String jefeDepartamento, double presupuestoAnual){
    this.nombre = nombre;
    thos.jefeDepartamento = jefeDepartamento;
    this.presupuestoAnual = presupuestoAnual;
    this.empleados = new ArrayList<>();    
    }

    public void agregarEmpleados(String idEmpleado){
        if (!empleados.contains(idEmpleado)){
            empleados.add(idEmpleado);
        }
    }

  public List<String> listarEmpleados(){
    return new ArrayList<>(empleados);
  }

  public double calcularNominaDepartamentos(GestorEmpleados gestor){
    double total = 0;

    for (String id : empleados){
        Empleado e = gestor.buscarEmpleado(id);
        if (e !=null && e.isActivo()){
            total += e.calcularSalario();
        }
    }
    reutrn total;
  }

  public String getNombre() {
        return nombre;
    }

    public String getJefeDepartamento() {
        return jefeDepartamento;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }
}