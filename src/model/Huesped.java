package model;

public class Huesped {
    //Atributos huesped
    private String nombre;
    private int cedula;
    private Habitacion habitacion;
    //Metodo constructor

    public Huesped(String nombre, int cedula, Habitacion habitacion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.habitacion = habitacion;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCedula() { return cedula; }
    public void setCedula(int cedula) { this.cedula = cedula; }

    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }

    @Override
    public String toString() {
        return "Huesped{nombre='" + nombre + "', cedula=" + cedula +
                ", habitacion=" + habitacion + "}";
    }
}

