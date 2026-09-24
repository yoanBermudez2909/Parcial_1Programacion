package model;

public class Reserva {
    //Atributos reserva
    private String nombreCliente,estado;
    private int fechaReserva,fechaSalida;
    //Metodo constructor
    private int id;
    private Huesped huesped;
    private Habitacion habitacion;
    private String fechaInicio;
    private String fechaFin;

    public Reserva(int id, Huesped huesped, Habitacion habitacion,
                   String fechaInicio, String fechaFin) {
        this.id = id;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Huesped getHuesped() { return huesped; }
    public void setHuesped(Huesped huesped) { this.huesped = huesped; }

    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    @Override
    public String toString() {
        return "Reserva{id=" + id +
                ", huesped=" + huesped +
                ", habitacion=" + habitacion +
                ", inicio='" + fechaInicio + '\'' +
                ", fin='" + fechaFin + '\'' + "}";
    }
}

