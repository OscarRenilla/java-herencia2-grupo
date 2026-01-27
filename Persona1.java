import java.time.LocalDate;

public class Persona1 {

    private String dni;
    protected String nombre;
    protected LocalDate fechaNacimiento;
    protected String email;
    protected int telefono;
    

    public Persona1(String dni, String nombre, LocalDate fechaNacimiento, String email, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public int calcularEdad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    public String presentarse() {
        return "Hola, me llamo " + nombre +
                ", tengo " + calcularEdad() +
                " años y mi DNI es " + dni +
                ". Nací el " + fechaNacimiento +
                ". Mi email es " + email +
                " y mi teléfono es " + telefono + ".";
    }
}
