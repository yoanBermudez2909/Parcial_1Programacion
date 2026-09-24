package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    // Atributos de la clase Hotel
    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefonoHotel;
    private String paginaWeb;

    // Relaciones de la clase Hotel
    private List<Huesped> listHotelHuespedes;
    private List<Habitacion> listHotelHabitaciones;
    private List<Reserva> listHotelReservas;
    private List<ServicioAdicional> listHotelServicios;

    /**
     * Metodo constructor de la clase Hotel
     * @param nombreComercial nombre comercial del hotel
     * @param nit NIT del hotel
     * @param direccion direccion del hotel
     * @param telefonoHotel telefono del hotel
     * @param paginaWeb pagina web del hotel
     */
    public Hotel(String nombreComercial, String nit, String direccion,
                 String telefonoHotel, String paginaWeb) {

        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefonoHotel = telefonoHotel;
        this.paginaWeb = paginaWeb;

        this.listHotelHuespedes = new ArrayList<>();
        this.listHotelHabitaciones = new ArrayList<>();
        this.listHotelReservas = new ArrayList<>();
        this.listHotelServicios = new ArrayList<>();
    }


    // =========================================================
    // CRUD DE HUESPED
    // =========================================================

    /**
     * Metodo que permite buscar un huesped por documento.
     * @param documento documento del huesped
     * @return huesped encontrado
     */
    public Huesped buscarHuesped(String documento) {

        Huesped encontrado = null;

        for (int i = 0; i < this.listHotelHuespedes.size(); ++i) {

            Huesped huesped = this.listHotelHuespedes.get(i);

            if (huesped.getdocumentoIdentidad().equals(documento)) {
                encontrado = huesped;
                break;
            }
        }

        return encontrado;
    }

    /**
     * Metodo que permite registrar un huesped.
     * @param nombreCompleto nombre completo del huesped
     * @param documento documento del huesped
     * @param telefono telefono del huesped
     * @param correo correo electronico
     * @param pais pais de procedencia
     * @return true si se registra, false si ya existe
     */
    public boolean registrarHuesped(String nombreCompleto, String documento,
                                    String telefono, String correo, String pais) {

        boolean registrado = false;

        Huesped huesped = this.buscarHuesped(documento);

        if (huesped == null) {

            Huesped nuevo = new Huesped(
                    nombreCompleto,
                    documento,
                    telefono,
                    correo,
                    pais
            );

            this.listHotelHuespedes.add(nuevo);
            registrado = true;

        } else {
            System.out.println("Huesped ya registrado.");
        }

        return registrado;
    }

    /**
     * Metodo que permite actualizar un huesped.
     * @param documento documento del huesped
     * @param nombreCompleto nuevo nombre
     * @param telefono nuevo telefono
     * @param correo nuevo correo
     * @param pais nuevo pais
     * @return true si se actualiza, false si no existe
     */
    public boolean actualizarHuesped(String documento,
                                     String nombreCompleto,
                                     String telefono,
                                     String correo,
                                     String pais) {

        Huesped huesped = buscarHuesped(documento);

        if (huesped != null) {

            huesped.setnombreCompleto(nombreCompleto);
            huesped.setTelefono(telefono);
            huesped.setCorreoElectronico(correo);
            huesped.setPaisProcedencia(pais);

            return true;
        }

        return false;
    }

    /**
     * Metodo que permite eliminar un huesped.
     * @param documento documento del huesped
     * @return true si se elimina, false si no existe
     */
    public boolean eliminarHuesped(String documento) {

        Huesped huesped = buscarHuesped(documento);

        if (huesped != null) {
            listHotelHuespedes.remove(huesped);
            return true;
        }

        return false;
    }


    // =========================================================
    // METODOS ESPECIALES DE HUESPED
    // =========================================================

    /**
     * Metodo que permite buscar un huesped por telefono.
     * @param telefono telefono del huesped
     * @return huesped encontrado
     */
    public Huesped buscarHuespedPorTelefono(String telefono) {

        Huesped encontrado = null;

        for (int i = 0; i < this.listHotelHuespedes.size(); ++i) {

            Huesped huesped = this.listHotelHuespedes.get(i);

            if (huesped.getTelefono().equals(telefono)) {
                encontrado = huesped;
                break;
            }
        }

        return encontrado;
    }

    /**
     * Metodo que permite determinar si un numero es perfecto.
     * @param telefono numero que sera evaluado
     * @return true si es perfecto, false si no
     */
    public boolean detectarNumerosPerfecto(String telefono) {

        boolean esPerfecto = false;

        int tel = Integer.parseInt(telefono);

        if (tel > 1) {

            long suma = 0;

            for (long i = 1; i <= tel / 2; ++i) {

                if (tel % i == 0) {
                    suma += i;
                }
            }

            esPerfecto = (suma == tel);
        }

        return esPerfecto;
    }

    /**
     * Metodo que permite obtener los huespedes cuyo telefono
     * corresponde a un numero perfecto.
     * @return mensaje con los huespedes encontrados
     */
    public String obtenerNumerosPerfectos() {

        String mensaje = "";

        for (Huesped huesped : listHotelHuespedes) {

            if (detectarNumerosPerfecto(huesped.getTelefono())) {

                mensaje += huesped.toString()
                        + " ¡Este huesped tiene un numero de telefono perfecto!\n";
            }
        }

        return mensaje;
    }


    // =========================================================
    // CRUD DE HABITACION
    // =========================================================

    /**
     * Metodo que permite buscar una habitacion por numero.
     * @param numero numero de habitacion
     * @return habitacion encontrada
     */
    public Habitacion buscarHabitacion(int numero) {

        Habitacion encontrada = null;

        for (int i = 0; i < this.listHotelHabitaciones.size(); ++i) {

            Habitacion habitacion = this.listHotelHabitaciones.get(i);

            if (habitacion.getNumero() == numero) {
                encontrada = habitacion;
                break;
            }
        }

        return encontrada;
    }

    /**
     * Metodo que permite registrar una habitacion.
     * @return true si se registra, false si ya existe
     */
    public boolean registrarHabitacion(int numero, String piso, String tipo, int capacidad, double precioPorNoche, String estado) {

        boolean registrada = false;

        Habitacion habitacion = this.buscarHabitacion(numero);

        if (habitacion == null) {

            Habitacion nueva = new Habitacion(
                    piso,
                    tipo,
                    capacidad,
                    precioPorNoche,
                    estado,
                    numero
            );

            this.listHotelHabitaciones.add(nueva);
            registrada = true;
        }

        return registrada;
    }

    /**
     * Metodo que permite actualizar una habitacion.
     * @return true si se actualiza, false si no existe
     */
    public boolean actualizarHabitacion(int numero,
                                        String piso,
                                        String tipo,
                                        int capacidad,
                                        double precioPorNoche,
                                        String estado) {

        Habitacion habitacion = buscarHabitacion(numero);

        if (habitacion != null) {

            habitacion.setPiso(piso);
            habitacion.setTipo(tipo);
            habitacion.setCapacidad(capacidad);
            habitacion.setprecioPorNoche(precioPorNoche);
            habitacion.setEstado(estado);

            return true;
        }

        return false;
    }

    /**
     * Metodo que permite eliminar una habitacion.
     * @param numero numero de habitacion
     * @return true si se elimina
     */
    public boolean eliminarHabitacion(int numero) {

        Habitacion habitacion = buscarHabitacion(numero);

        if (habitacion != null) {

            listHotelHabitaciones.remove(habitacion);
            return true;
        }

        return false;
    }

    /**
     * Metodo que permite obtener un precio base
     * dependiendo del tipo de habitacion.
     * @param tipo tipo de habitacion
     * @return precio base
     */
    public double obtenerPrecioBase(String tipo) {

        double precio;

        switch (tipo) {

            case "Individual":
                precio = 100000;
                break;

            case "Doble":
                precio = 180000;
                break;

            case "Suite":
                precio = 350000;
                break;

            default:
                precio = -1;
        }

        return precio;
    }


    // =========================================================
    // CRUD DE RESERVA
    // =========================================================

    /**
     * Metodo que permite buscar una reserva por codigo.
     * @param codigoReserva codigo de la reserva
     * @return reserva encontrada
     */
    public Reserva buscarReserva(String codigoReserva) {

        Reserva encontrada = null;

        for (int i = 0; i < this.listHotelReservas.size(); ++i) {

            Reserva reserva = this.listHotelReservas.get(i);

            if (reserva.getCodigoReserva().equals(codigoReserva)) {
                encontrada = reserva;
                break;
            }
        }

        return encontrada;
    }

    /**
     * Metodo que permite registrar una reserva.
     * @return true si se registra, false si ya existe
     */
    public boolean registrarReserva(String codigoReserva,
                                    String fechaRealizacion,
                                    String fechaEntrada,
                                    String fechaSalida,
                                    String estado,
                                    String metodoPago,
                                    double valorTotal) {

        boolean registrada = false;

        Reserva reserva = buscarReserva(codigoReserva);

        if (reserva == null) {

            Reserva nueva = new Reserva(
                    codigoReserva,
                    fechaRealizacion,
                    fechaEntrada,
                    fechaSalida,
                    estado,
                    metodoPago,
                    valorTotal
            );

            listHotelReservas.add(nueva);
            registrada = true;
        }

        return registrada;
    }

    /**
     * Metodo que permite actualizar una reserva.
     * @return true si se actualiza
     */
    public boolean actualizarReserva(String codigoReserva,
                                     String fechaRealizacion,
                                     String fechaEntrada,
                                     String fechaSalida,
                                     String estado,
                                     String metodoPago,
                                     double valorTotal) {

        Reserva reserva = buscarReserva(codigoReserva);

        if (reserva != null) {

            reserva.setFechaRealizacion(fechaRealizacion);
            reserva.setFechaEntrada(fechaEntrada);
            reserva.setFechaSalida(fechaSalida);
            reserva.setEstado(estado);
            reserva.setMetodoPago(metodoPago);
            reserva.setValorTotal(valorTotal);

            return true;
        }

        return false;
    }

    /**
     * Metodo que permite eliminar una reserva.
     * @param codigoReserva codigo de la reserva
     * @return true si se elimina
     */
    public boolean eliminarReserva(String codigoReserva) {

        Reserva reserva = buscarReserva(codigoReserva);

        if (reserva != null) {

            listHotelReservas.remove(reserva);
            return true;
        }

        return false;
    }


    // =========================================================
    // INGRESOS POR FECHA
    // =========================================================

    /**
     * Metodo que permite calcular los ingresos de las reservas
     * realizadas en una fecha determinada.
     * @param fecha fecha de consulta
     * @return total de ingresos
     */
    public double calcularIngresosPorFecha(String fecha) {

        double total = 0;

        for (Reserva reserva : listHotelReservas) {

            if (reserva.getFechaRealizacion().equals(fecha)) {

                total += reserva.getValorTotal();
            }
        }

        return total;
    }


    // =========================================================
    // CRUD DE SERVICIO ADICIONAL
    // =========================================================

    /**
     * Metodo que permite buscar un servicio por codigo.
     * @param codigo codigo del servicio
     * @return servicio encontrado
     */
    public ServicioAdicional buscarServicio(String codigo) {

        ServicioAdicional encontrado = null;

        for (int i = 0; i < this.listHotelServicios.size(); ++i) {

            ServicioAdicional servicio = this.listHotelServicios.get(i);

            if (servicio.getCodigo().equals(codigo)) {
                encontrado = servicio;
                break;
            }
        }

        return encontrado;
    }

    /**
     * Metodo que permite registrar un servicio adicional.
     * @return true si se registra
     */
    public boolean registrarServicio(String codigo,
                                     String nombre,
                                     String descripcion,
                                     double precio,
                                     boolean disponibilidad) {

        boolean registrado = false;

        ServicioAdicional servicio = buscarServicio(codigo);

        if (servicio == null) {

            ServicioAdicional nuevo = new ServicioAdicional(
                    codigo,
                    nombre,
                    descripcion,
                    precio,
                    disponibilidad
            );

            listHotelServicios.add(nuevo);
            registrado = true;
        }

        return registrado;
    }

    /**
     * Metodo que permite actualizar un servicio.
     * @return true si se actualiza
     */
    public boolean actualizarServicio(String codigo,
                                      String nombre,
                                      String descripcion,
                                      double precio,
                                      boolean disponibilidad) {

        ServicioAdicional servicio = buscarServicio(codigo);

        if (servicio != null) {

            servicio.setNombre(nombre);
            servicio.setDescripcion(descripcion);
            servicio.setPrecio(precio);
            servicio.setDisponible(disponibilidad);

            return true;
        }

        return false;
    }

    /**
     * Metodo que permite eliminar un servicio.
     * @param codigo codigo del servicio
     * @return true si se elimina
     */
    public boolean eliminarServicio(String codigo) {

        ServicioAdicional servicio = buscarServicio(codigo);

        if (servicio != null) {

            listHotelServicios.remove(servicio);
            return true;
        }

        return false;
    }


    // =========================================================
    // GETTERS Y SETTERS
    // =========================================================

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoHotel() {
        return telefonoHotel;
    }

    public void setTelefonoHotel(String telefonoHotel) {
        this.telefonoHotel = telefonoHotel;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public List<Huesped> getListHotelHuespedes() {
        return listHotelHuespedes;
    }

    public void setListHotelHuespedes(List<Huesped> listHotelHuespedes) {
        this.listHotelHuespedes = listHotelHuespedes;
    }

    public List<Habitacion> getListHotelHabitaciones() {
        return listHotelHabitaciones;
    }

    public void setListHotelHabitaciones(List<Habitacion> listHotelHabitaciones) {
        this.listHotelHabitaciones = listHotelHabitaciones;
    }

    public List<Reserva> getListHotelReservas() {
        return listHotelReservas;
    }

    public void setListHotelReservas(List<Reserva> listHotelReservas) {
        this.listHotelReservas = listHotelReservas;
    }

    public List<ServicioAdicional> getListHotelServicios() {
        return listHotelServicios;
    }

    public void setListHotelServicios(List<ServicioAdicional> listHotelServicios) {
        this.listHotelServicios = listHotelServicios;
    }

    public boolean asignarHuespedAReserva(String codigoReserva, String documento) {

        Reserva reserva = buscarReserva(codigoReserva);
        Huesped huesped = buscarHuesped(documento);

        if (reserva != null && huesped != null) {
            reserva.setHuesped(huesped);
            huesped.agregarReserva(reserva);
            reserva.calcularValorTotal();
            return true;
        }

        return false;
    }

    public boolean validarDisponibilidadHabitacion(int numeroHabitacion, String fechaEntrada, String fechaSalida) {

        boolean disponible = true;
        int entrada = Integer.parseInt(fechaEntrada);
        int salida = Integer.parseInt(fechaSalida);

        for (int i = 0; i < this.listHotelReservas.size(); ++i) {

            Reserva otra = this.listHotelReservas.get(i);

            if ((otra.getEstado().equals("Confirmada") || otra.getEstado().equals("En curso")) && otra.buscarHabitacion(numeroHabitacion) != null) {

                int otraEntrada = Integer.parseInt(otra.getFechaEntrada());
                int otraSalida = Integer.parseInt(otra.getFechaSalida());

                if (entrada < otraSalida && otraEntrada < salida) {
                    disponible = false;
                    break;
                }
            }
        }

        return disponible;
    }

    public boolean agregarHabitacionAReserva(String codigoReserva, int numeroHabitacion) {

        Reserva reserva = buscarReserva(codigoReserva);
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);

        if (reserva != null && habitacion != null && validarDisponibilidadHabitacion(numeroHabitacion, reserva.getFechaEntrada(), reserva.getFechaSalida())) {
            if (reserva.agregarHabitacion(habitacion)) {
                reserva.calcularValorTotal();
                return true;
            }
        }

        return false;
    }

    public boolean agregarServicioAReserva(String codigoReserva, String codigoServicio) {

        Reserva reserva = buscarReserva(codigoReserva);
        ServicioAdicional servicio = buscarServicio(codigoServicio);

        if (reserva != null && servicio != null && servicio.isDisponible()) {
            reserva.agregarServicio(servicio);
            reserva.calcularValorTotal();
            return true;
        }

        return false;
    }

    public boolean confirmarReserva(String codigoReserva) {

        boolean confirmada = false;

        Reserva reserva = buscarReserva(codigoReserva);

        if (reserva != null && reserva.getEstado().equals("Pendiente")) {

            boolean disponibles = true;

            for (int i = 0; i < reserva.getListReservaHabitaciones().size(); ++i) {
                Habitacion habitacion = reserva.getListReservaHabitaciones().get(i);
                if (!validarDisponibilidadHabitacion(habitacion.getNumero(), reserva.getFechaEntrada(), reserva.getFechaSalida())) {
                    disponibles = false;
                }
            }

            if (disponibles) {
                reserva.setEstado("Confirmada");
                for (int i = 0; i < reserva.getListReservaHabitaciones().size(); ++i) {
                    reserva.getListReservaHabitaciones().get(i).setEstado("Reservada");
                }
                reserva.calcularValorTotal();
                confirmada = true;
            }
        }

        return confirmada;
    }

    @Override
    public String toString() {

        return "Hotel{" +
                "nit='" + nit + '\'' +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefonoHotel + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                ", listHotelHuespedes=" + listHotelHuespedes +
                ", listHotelHabitaciones=" + listHotelHabitaciones +
                ", listHotelReservas=" + listHotelReservas +
                ", listHotelServicios=" + listHotelServicios +
                '}';
    }
}