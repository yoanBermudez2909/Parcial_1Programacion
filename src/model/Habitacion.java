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