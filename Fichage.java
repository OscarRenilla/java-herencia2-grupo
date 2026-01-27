import java.time.LocalDateTime;

public class Fichaje {
    private int idFichaje;
    private int idEmpleado;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private String tipo; 

   
    public Fichaje(int idFichaje, int idEmpleado, LocalDateTime fechaHoraEntrada,
                   LocalDateTime fechaHoraSalida, String tipo) {
        this.idFichaje = idFichaje;
        this.idEmpleado = idEmpleado;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.tipo = tipo;
    }

   
    public Fichaje(int idFichaje, int idEmpleado, LocalDateTime fechaHoraEntrada, String tipo) {
        this(idFichaje, idEmpleado, fechaHoraEntrada, null, tipo);
    }

    
    public int getIdFichaje() {
        return idFichaje;
    }

    public void setIdFichaje(int idFichaje) {
        this.idFichaje = idFichaje;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equals("ENTRADA") || tipo.equals("SALIDA") || tipo.equals("PAUSA")) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo inválido. Debe ser 'ENTRADA', 'SALIDA' o 'PAUSA'.");
        }
    }

    @Override
    public String toString() {
        return "Fichaje{" +
                "idFichaje=" + idFichaje +
                ", idEmpleado=" + idEmpleado +
                ", fechaHoraEntrada=" + fechaHoraEntrada +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

