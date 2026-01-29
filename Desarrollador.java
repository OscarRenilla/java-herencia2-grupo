import java.util.ArrayList;
import java.util.List;

public class Desarrollador extends Empleado {

    private String lenguajePrincipal;
    private String nivel;
    private List<String> tecnologias;
    private double horasExtra;

    public Desarrollador(String dni, String nombre, int edad, double salarioBase, int antiguedadAnios, String lenguajePrincipal, String nivel) {
        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.lenguajePrincipal = lenguajePrincipal;
        this.nivel = nivel;
        this.tecnologias = new ArrayList<>();
        this.horasExtra = 0.0;
    }

    public Desarrollador (String id, String nombre, LocaDate fn, String email, String tel. Double sal, LocalDate now, String nivel){
        super();
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<String> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public void agregarTecnologia(String tecnologia) {
        this.tecnologias.add(tecnologia);
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    public void registrarHoraExtra(double horas) {
        this.horasExtra += horas;
    }

    
    public double calcularSalario() {
        double salarioBase = super.calcularSalario(); // Incluye plus antigüedad si Empleado.java ya lo tiene
        double plusNivel = 0.0;

        switch (nivel.toUpperCase()) {
            case "MID":
                plusNivel = salarioBase * 0.15;
                break;
            case "SENIOR":
                plusNivel = salarioBase * 0.30;
                break;
            case "JUNIOR":
            default:
                plusNivel = 0.0;
                break;
        }

        double pagoHorasExtra = this.horasExtra * 20.0;

        double bonusLenguaje = 0;
        switch (lenguajePrincipal.toLowerCase()) {
            case "java":
                bonusLenguaje = 500;
                break;
            case "python":
                bonusLenguaje = 400;
                break;
            case "javascript":
                bonusLenguaje = 300;
                break;
            default:
                bonusLenguaje = 200;
                break;
        }

        return salarioBase + plusNivel + pagoHorasExtra + bonusLenguaje;
    }

    @Override
    public String toString() {
        return "Desarrollador{" +
                "dni='" + getDni() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", nivel='" + nivel + '\'' +
                ", lenguajePrincipal='" + lenguajePrincipal + '\'' +
                ", tecnologias=" + tecnologias +
                ", horasExtra=" + horasExtra +
                '}';
    }
}