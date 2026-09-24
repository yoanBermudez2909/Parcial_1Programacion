package model;

public class Habitacion {

    // Atributos de la clase Habitacion
    private String piso;
    private String tipo;
    private String estado;
    private int capacidad;
    private int numero;
    private double precioPorNoche;

    // Metodo constructor
    public Habitacion(String piso, String tipo, int capacidad, double precioPorNoche, String estado, int numero) {
        this.piso = piso;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.estado = estado;
        this.numero = numero;
    }


    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getprecioPorNoche() {
        return precioPorNoche;
    }

    public void setprecioPorNoche(double precio) {
        this.precioPorNoche = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", piso='" + piso + '\'' +
                ", tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +
                ", precioPorNoche=" + precioPorNoche +
                ", estado='" + estado + '\'' +
                '}';
    }
}