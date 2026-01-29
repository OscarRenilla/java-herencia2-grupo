import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorFichajes {

    private Map<String, List<Fichaje>> fichajes;
    private int contadorFichaje;

    public GestorFichajes() {
        this.fichajes = new HashMap<>();
        this.contadorFichaje = 1;
    }

   
    public void registrarEntrada(String idEmpleado) {
        Fichaje fichaje = new Fichaje(contadorFichaje++, Integer.parseInt(idEmpleado),
                LocalDateTime.now(), "ENTRADA");
        fichajes.computeIfAbsent(idEmpleado, k -> new ArrayList<>()).add(fichaje);
    }

    
    public void registrarSalida(String idEmpleado) {
        Fichaje fichaje = new Fichaje(contadorFichaje++, Integer.parseInt(idEmpleado),
                LocalDateTime.now(), "SALIDA");
        fichajes.computeIfAbsent(idEmpleado, k -> new ArrayList<>()).add(fichaje);
    }

   
    public List<Fichaje> obtenerFichajesDelDia(String idEmpleado, LocalDate fecha) {
        List<Fichaje> resultado = new ArrayList<>();
        if (fichajes.containsKey(idEmpleado)) {
            for (Fichaje f : fichajes.get(idEmpleado)) {
                if (f.getFechaHoraEntrada().toLocalDate().equals(fecha) ||
                    (f.getFechaHoraSalida() != null && f.getFechaHoraSalida().toLocalDate().equals(fecha))) {
                    resultado.add(f);
                }
            }
        }
        return resultado;
    }

   
    public double calcularHorasMensuales(String idEmpleado, int mes, int anio) {
        double totalHoras = 0;
        if (fichajes.containsKey(idEmpleado)) {
            List<Fichaje> lista = fichajes.get(idEmpleado);
            for (int i = 0; i < lista.size(); i++) {
                Fichaje entrada = lista.get(i);
                if ("ENTRADA".equals(entrada.getTipo()) && i + 1 < lista.size()) {
                    Fichaje salida = lista.get(i + 1);
                    if ("SALIDA".equals(salida.getTipo()) &&
                        entrada.getFechaHoraEntrada().getMonthValue() == mes &&
                        entrada.getFechaHoraEntrada().getYear() == anio) {
                        Duration duracion = Duration.between(entrada.getFechaHoraEntrada(), salida.getFechaHoraSalida());
                        totalHoras += duracion.toMinutes() / 60.0;
                    }
                }
            }
        }
        return totalHoras;
    }

    // Generar reporte de asistencia
    public String generarReporteAsistencia(String idEmpleado) {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de asistencia para empleado ").append(idEmpleado).append(":\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        if (!fichajes.containsKey(idEmpleado) || fichajes.get(idEmpleado).isEmpty()) {
            sb.append("No hay fichajes registrados.\n");
            return sb.toString();
        }

        for (Fichaje f : fichajes.get(idEmpleado)) {
            sb.append(f.getTipo())
              .append(": ")
              .append(f.getFechaHoraEntrada().format(formatter));

            if (f.getFechaHoraSalida() != null) {
                sb.append(" - ").append(f.getFechaHoraSalida().format(formatter));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
