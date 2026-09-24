package model;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

    // Atributos de la clase Reserva
    private String codigoReserva;
    private String fechaRealizacion;
    private String fechaEntrada;
    private String fechaSalida;
    private String estado;
    private String metodoPago;
    private double valorTotal;

    // Relaciones de la clase Reserva
    private Huesped huesped;
    private List<Habitacion> listReservaHabitaciones;
    private List<ServicioAdicional> listReservaServicios;


    public Reserva(String codigoReserva, String fechaRealizacion, String fechaEntrada, String fechaSalida, String estado, String metodoPago, double valorTotal) {

        this.codigoReserva = codigoReserva;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;

        this.huesped = null;
        this.listReservaHabitaciones = new ArrayList<>();
        this.listReservaServicios = new ArrayList<>();
    }

    public Habitacion buscarHabitacion(int numero) {

        Habitacion encontrada = null;

        for (int i = 0; i < this.listReservaHabitaciones.size(); ++i) {
            Habitacion habitacion = this.listReservaHabitaciones.get(i);
            if (habitacion.getNumero() == numero) {
                encontrada = habitacion;
                break;
            }
        }

        return encontrada;
    }

    public boolean agregarHabitacion(Habitacion habitacion) {

        if (buscarHabitacion(habitacion.getNumero()) == null) {
            this.listReservaHabitaciones.add(habitacion);
            return true;
        }

        return false;
    }

    public boolean eliminarHabitacion(int numero) {

        Habitacion habitacion = buscarHabitacion(numero);

        if (habitacion != null) {
            this.listReservaHabitaciones.remove(habitacion);
            return true;
        }

        return false;
    }

    public ServicioAdicional buscarServicio(String codigo) {

        ServicioAdicional encontrado = null;

        for (int i = 0; i < this.listReservaServicios.size(); ++i) {
            ServicioAdicional servicio = this.listReservaServicios.get(i);
            if (servicio.getCodigo().equals(codigo)) {
                encontrado = servicio;
                break;
            }
        }

        return encontrado;
    }

    public void agregarServicio(ServicioAdicional servicio) {
        this.listReservaServicios.add(servicio);
    }

    public boolean eliminarServicio(String codigo) {

        ServicioAdicional servicio = buscarServicio(codigo);

        if (servicio != null) {
            this.listReservaServicios.remove(servicio);
            return true;
        }

        return false;
    }

    // Convierte una fecha AAAAMMDD (ej. 20260924) en un numero de dias
    private int fechaADias(String fecha) {

        int anio = Integer.parseInt(fecha.substring(0, 4));
        int mes = Integer.parseInt(fecha.substring(4, 6));
        int dia = Integer.parseInt(fecha.substring(6, 8));
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int bisiestos = (anio - 1) / 4 - (anio - 1) / 100 + (anio - 1) / 400;
        int total = anio * 365 + bisiestos + dia;

        for (int m = 0; m < mes - 1; ++m) {
            total += diasMes[m];
        }

        if (mes > 2 && ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0)) {
            total += 1;
        }

        return total;
    }

    public int calcularCantidadNoches() {
        return fechaADias(fechaSalida) - fechaADias(fechaEntrada);
    }

    public double calcularValorTotal() {

        double subtotal = 0;
        int noches = calcularCantidadNoches();

        for (int i = 0; i < this.listReservaHabitaciones.size(); ++i) {
            subtotal += this.listReservaHabitaciones.get(i).getprecioPorNoche() * noches;
        }

        for (int i = 0; i < this.listReservaServicios.size(); ++i) {
            subtotal += this.listReservaServicios.get(i).getPrecio();
        }

        if (huesped != null && huesped.esFrecuente()) {
            subtotal = subtotal * 0.9;
        }

        this.valorTotal = subtotal;

        return this.valorTotal;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
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

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public List<Habitacion> getListReservaHabitaciones() {
        return listReservaHabitaciones;
    }

    public void setListReservaHabitaciones(List<Habitacion> listReservaHabitaciones) {
        this.listReservaHabitaciones = listReservaHabitaciones;
    }

    public List<ServicioAdicional> getListReservaServicios() {
        return listReservaServicios;
    }

    public void setListReservaServicios(List<ServicioAdicional> listReservaServicios) {
        this.listReservaServicios = listReservaServicios;
    }
}

