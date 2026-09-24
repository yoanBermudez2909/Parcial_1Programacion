package model;

public class Reserva {
    private String codigoReserva;
    private int fechaRealizacion;
    private int fechaEntrada;
    private int fechaSalida;
    private String estado;
    private String metodoPago;
    private double valorTotal;

    public Reserva(String codigoReserva, int fechaRealizacion, int fechaEntrada,
                   int fechaSalida, String estado, String metodoPago, double valorTotal) {
        this.codigoReserva = codigoReserva;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }
    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public int getFechaRealizacion() {
        return fechaRealizacion;
    }
    public void setFechaRealizacion(int fechaRealizacion) { this.fechaRealizacion = fechaRealizacion; }

    public int getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(int fechaEntrada) { this.fechaEntrada = fechaEntrada; }

    public int getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    @Override
    public String toString() {
        return "Reserva{codigoReserva='" + codigoReserva + '\'' +
                ", fechaRealizacion=" + fechaRealizacion +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", estado='" + estado + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotal=" + valorTotal + "}";
    }
}


