
import model.Habitacion;
import model.Hotel;
import model.Huesped;
import model.Reserva;
import model.ServicioAdicional;

import javax.swing.JOptionPane;

    public class Main {

        public static void main(String[] args) {

            Hotel hotel = new Hotel("StayPlus", "900123456", "Calle 10 # 5-20", "6061234", "www.stayplus.com");

            int opcion = 0;

            while (opcion != 6) {

                String menu = "\n===== MENU PRINCIPAL - STAYPLUS =====\n"
                        + "1. Hotel\n"
                        + "2. Huesped\n"
                        + "3. Habitacion\n"
                        + "4. Reserva\n"
                        + "5. Servicio adicional\n"
                        + "6. Salir";

                opcion = leerEntero(menu + "\n\nOpcion: ");

                switch (opcion) {

                    case 1:
                        menuHotel(hotel);
                        break;

                    case 2:
                        menuHuesped(hotel);
                        break;

                    case 3:
                        menuHabitacion(hotel);
                        break;

                    case 4:
                        menuReserva(hotel);
                        break;

                    case 5:
                        menuServicio(hotel);
                        break;

                    case 6:
                        JOptionPane.showMessageDialog(null, "Hasta luego.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida.");
                }
            }
        }


        public static void menuHotel(Hotel hotel) {

            int opcion = 0;

            while (opcion != 3) {

                String menu = "\n--- HOTEL ---\n"
                        + "1. Ver datos del hotel\n"
                        + "2. Modificar datos del hotel\n"
                        + "3. Volver al menu principal";

                opcion = leerEntero(menu + "\n\nOpcion: ");

                switch (opcion) {

                    case 1:
                        JOptionPane.showMessageDialog(null,
                                "Nombre comercial: " + hotel.getNombreComercial()
                                        + "\nNIT: " + hotel.getNit()
                                        + "\nDireccion: " + hotel.getDireccion()
                                        + "\nTelefono: " + hotel.getTelefonoHotel()
                                        + "\nPagina web: " + hotel.getPaginaWeb());
                        break;

                    case 2:
                        hotel.setNombreComercial(leerTexto("Nuevo nombre comercial: "));
                        hotel.setNit(leerTexto("Nuevo NIT: "));
                        hotel.setDireccion(leerTexto("Nueva direccion: "));
                        hotel.setTelefonoHotel(leerTexto("Nuevo telefono: "));
                        hotel.setPaginaWeb(leerTexto("Nueva pagina web: "));

                        JOptionPane.showMessageDialog(null, "Datos del hotel actualizados.");
                        break;

                    case 3:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida.");
                }
            }
        }


        public static void menuHuesped(Hotel hotel) {

            int opcion = 0;

            while (opcion != 8) {

                String menu = "\n--- HUESPED ---\n"
                        + "1. Registrar huesped\n"
                        + "2. Buscar huesped por documento\n"
                        + "3. Actualizar huesped\n"
                        + "4. Eliminar huesped\n"
                        + "5. Listar huespedes\n"
                        + "6. Consultar huesped por telefono y verificar si es numero perfecto\n"
                        + "7. Listar huespedes con telefono perfecto\n"
                        + "8. Volver al menu principal";

                opcion = leerEntero(menu + "\n\nOpcion: ");

                switch (opcion) {

                    case 1: {
                        String nombre = leerTexto("Nombre completo: ");
                        String documento = leerTexto("Documento: ");
                        String telefono = leerTexto("Telefono: ");
                        String correo = leerTexto("Correo electronico: ");
                        String pais = leerTexto("Pais de procedencia: ");

                        if (hotel.registrarHuesped(nombre, documento, telefono, correo, pais)) {
                            JOptionPane.showMessageDialog(null, "Huesped registrado.");
                        }

                        break;
                    }

                    case 2: {
                        Huesped huesped = hotel.buscarHuesped(leerTexto("Documento: "));

                        if (huesped != null) {
                            JOptionPane.showMessageDialog(null, huesped);
                        } else {
                            JOptionPane.showMessageDialog(null, "Huesped no encontrado.");
                        }

                        break;
                    }

                    case 3: {
                        String documento = leerTexto("Documento del huesped a actualizar: ");
                        String nombre = leerTexto("Nuevo nombre completo: ");
                        String telefono = leerTexto("Nuevo telefono: ");
                        String correo = leerTexto("Nuevo correo electronico: ");
                        String pais = leerTexto("Nuevo pais de procedencia: ");

                        if (hotel.actualizarHuesped(documento, nombre, telefono, correo, pais)) {
                            JOptionPane.showMessageDialog(null, "Huesped actualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Huesped no encontrado.");
                        }

                        break;
                    }

                    case 4:
                        if (hotel.eliminarHuesped(leerTexto("Documento: "))) {
                            JOptionPane.showMessageDialog(null, "Huesped eliminado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Huesped no encontrado.");
                        }

                        break;

                    case 5: {
                        String mensaje = "";

                        for (Huesped huesped : hotel.getListHotelHuespedes()) {
                            mensaje += huesped + "\n";
                        }

                        JOptionPane.showMessageDialog(null, mensaje);
                        break;
                    }

                    case 6: {
                        String telefono = leerTexto("Telefono: ");
                        Huesped huesped = hotel.buscarHuespedPorTelefono(telefono);

                        if (huesped != null) {
                            String mensaje = huesped + "\n\n";

                            if (hotel.detectarNumerosPerfecto(telefono)) {
                                mensaje += "El telefono ES un numero perfecto.";
                            } else {
                                mensaje += "El telefono NO es un numero perfecto.";
                            }

                            JOptionPane.showMessageDialog(null, mensaje);

                        } else {
                            JOptionPane.showMessageDialog(null, "Huesped no encontrado.");
                        }

                        break;
                    }

                    case 7: {
                        String mensaje = hotel.obtenerNumerosPerfectos();

                        if (mensaje.equals("")) {
                            JOptionPane.showMessageDialog(null, "Ningun huesped tiene telefono perfecto.");
                        } else {
                            JOptionPane.showMessageDialog(null, mensaje);
                        }

                        break;
                    }

                    case 8:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida.");
                }
            }
        }


        public static void menuHabitacion(Hotel hotel) {

            int opcion = 0;

            while (opcion != 7) {

                String menu = "\n--- HABITACION ---\n"
                        + "1. Registrar habitacion\n"
                        + "2. Buscar habitacion por numero\n"
                        + "3. Actualizar habitacion\n"
                        + "4. Eliminar habitacion\n"
                        + "5. Listar habitaciones\n"
                        + "6. Consultar precio base por tipo\n"
                        + "7. Volver al menu principal";

                opcion = leerEntero(menu + "\n\nOpcion: ");

                switch (opcion) {

                    case 1: {
                        int numero = leerEntero("Numero: ");
                        String piso = leerTexto("Piso: ");
                        String tipo = leerTexto("Tipo (Individual/Doble/Suite): ");
                        int capacidad = leerEntero("Capacidad: ");
                        double precio = leerDouble("Precio por noche: ");
                        String estado = leerTexto("Estado (Disponible/Reservada/Ocupada/Mantenimiento): ");

                        if (hotel.registrarHabitacion(numero, piso, tipo, capacidad, precio, estado)) {
                            JOptionPane.showMessageDialog(null, "Habitacion registrada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe una habitacion con ese numero.");
                        }

                        break;
                    }

                    case 2: {
                        Habitacion habitacion = hotel.buscarHabitacion(leerEntero("Numero: "));

                        if (habitacion != null) {
                            JOptionPane.showMessageDialog(null, habitacion);
                        } else {
                            JOptionPane.showMessageDialog(null, "Habitacion no encontrada.");
                        }

                        break;
                    }

                    case 3: {
                        int numero = leerEntero("Numero de la habitacion a actualizar: ");
                        String piso = leerTexto("Nuevo piso: ");
                        String tipo = leerTexto("Nuevo tipo (Individual/Doble/Suite): ");
                        int capacidad = leerEntero("Nueva capacidad: ");
                        double precio = leerDouble("Nuevo precio por noche: ");
                        String estado = leerTexto("Nuevo estado (Disponible/Reservada/Ocupada/Mantenimiento): ");

                        if (hotel.actualizarHabitacion(numero, piso, tipo, capacidad, precio, estado)) {
                            JOptionPane.showMessageDialog(null, "Habitacion actualizada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Habitacion no encontrada.");
                        }

                        break;
                    }

                    case 4:
                        if (hotel.eliminarHabitacion(leerEntero("Numero: "))) {
                            JOptionPane.showMessageDialog(null, "Habitacion eliminada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Habitacion no encontrada.");
                        }

                        break;

                    case 5: {
                        String mensaje = "";

                        for (Habitacion habitacion : hotel.getListHotelHabitaciones()) {
                            mensaje += habitacion + "\n";
                        }

                        JOptionPane.showMessageDialog(null, mensaje);
                        break;
                    }

                    case 6: {
                        double precioBase = hotel.obtenerPrecioBase(leerTexto("Tipo (Individual/Doble/Suite): "));

                        if (precioBase == -1) {
                            JOptionPane.showMessageDialog(null, "Tipo de habitacion invalido.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Precio base: " + precioBase);
                        }

                        break;
                    }

                    case 7:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida.");
                }
            }
        }

        public static void menuReserva(Hotel hotel) {

            int opcion = 0;

            while (opcion != 11) {

                String menu = "\n--- RESERVA ---\n"
                        + "1. Registrar reserva\n"
                        + "2. Buscar reserva por codigo\n"
                        + "3. Actualizar reserva\n"
                        + "4. Eliminar reserva\n"
                        + "5. Listar reservas\n"
                        + "6. Asignar huesped a reserva\n"
                        + "7. Agregar habitacion a reserva\n"
                        + "8. Agregar servicio a reserva\n"
                        + "9. Confirmar reserva\n"
                        + "10. Calcular ingresos por fecha de realizacion\n"
                        + "11. Volver al menu principal";

                opcion = leerEntero(menu + "\n\nOpcion: ");

                switch (opcion) {

                    case 1: {
                        String codigo = leerTexto("Codigo de reserva: ");
                        String fechaRealizacion = leerTexto("Fecha de realizacion (AAAAMMDD): ");
                        String fechaEntrada = leerTexto("Fecha de entrada (AAAAMMDD): ");
                        String fechaSalida = leerTexto("Fecha de salida (AAAAMMDD): ");
                        String metodoPago = leerTexto("Metodo de pago (tarjeta de credito/transferencia bancaria/efectivo): ");

                        if (hotel.registrarReserva(codigo, fechaRealizacion, fechaEntrada, fechaSalida, "Pendiente", metodoPago, 0)) {
                            JOptionPane.showMessageDialog(null, "Reserva registrada en estado Pendiente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe una reserva con ese codigo.");
                        }

                        break;
                    }

                    case 2: {
                        Reserva reserva = hotel.buscarReserva(leerTexto("Codigo de reserva: "));

                        if (reserva != null) {
                            JOptionPane.showMessageDialog(null, reserva);
                        } else {
                            JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
                        }

                        break;
                    }

                    case 3: {
                        String codigo = leerTexto("Codigo de la reserva a actualizar: ");
                        String fechaRealizacion = leerTexto("Nueva fecha de realizacion (AAAAMMDD): ");
                        String fechaEntrada = leerTexto("Nueva fecha de entrada (AAAAMMDD): ");
                        String fechaSalida = leerTexto("Nueva fecha de salida (AAAAMMDD): ");
                        String estado = leerTexto("Nuevo estado (Pendiente/Confirmada/En curso/Finalizada/Cancelada): ");
                        String metodoPago = leerTexto("Nuevo metodo de pago: ");
                        double valorTotal = leerDouble("Nuevo valor total: ");

                        if (hotel.actualizarReserva(codigo, fechaRealizacion, fechaEntrada, fechaSalida, estado, metodoPago, valorTotal)) {
                            JOptionPane.showMessageDialog(null, "Reserva actualizada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
                        }

                        break;
                    }

                    case 4:
                        if (hotel.eliminarReserva(leerTexto("Codigo de reserva: "))) {
                            JOptionPane.showMessageDialog(null, "Reserva eliminada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
                        }

                        break;

                    case 5: {
                        String mensaje = "";

                        for (Reserva reserva : hotel.getListHotelReservas()) {
                            mensaje += reserva + "\n";
                        }

                        JOptionPane.showMessageDialog(null, mensaje);
                        break;
                    }

                    case 6: {
                        String codigo = leerTexto("Codigo de reserva: ");
                        String documento = leerTexto("Documento del huesped: ");

                        if (hotel.asignarHuespedAReserva(codigo, documento)) {
                            JOptionPane.showMessageDialog(null, "Huesped asignado a la reserva.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo asignar (reserva o huesped no existe).");
                        }

                        break;
                    }

                    case 7: {
                        String codigo = leerTexto("Codigo de reserva: ");
                        int numero = leerEntero("Numero de habitacion: ");

                        if (hotel.agregarHabitacionAReserva(codigo, numero)) {
                            JOptionPane.showMessageDialog(null, "Habitacion agregada a la reserva.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo agregar (no existe, ya esta en la reserva o no esta disponible en esas fechas).");
                        }

                        break;
                    }

                    case 8: {
                        String codigo = leerTexto("Codigo de reserva: ");
                        String codigoServicio = leerTexto("Codigo del servicio: ");

                        if (hotel.agregarServicioAReserva(codigo, codigoServicio)) {
                            JOptionPane.showMessageDialog(null, "Servicio agregado a la reserva.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo agregar (no existe o no esta disponible).");
                        }

                        break;
                    }

                    case 9:
                        if (hotel.confirmarReserva(leerTexto("Codigo de reserva: "))) {
                            JOptionPane.showMessageDialog(null, "Reserva confirmada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo confirmar (no existe, no esta Pendiente o hay habitaciones no disponibles).");
                        }

                        break;

                    case 10: {
                        double total = hotel.calcularIngresosPorFecha(leerTexto("Fecha de realizacion (AAAAMMDD): "));

                        JOptionPane.showMessageDialog(null, "Ingresos de esa fecha: " + total);
                        break;
                    }

                    case 11:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida.");
                }
            }
        }


        public static void menuServicio(Hotel hotel) {

            int opcion = 0;

            while (opcion != 6) {

                String menu = "\n--- SERVICIO ADICIONAL ---\n"
                        + "1. Registrar servicio\n"
                        + "2. Buscar servicio por codigo\n"
                        + "3. Actualizar servicio\n"
                        + "4. Eliminar servicio\n"
                        + "5. Listar servicios\n"
                        + "6. Volver al menu principal";

                opcion = leerEntero(menu + "\n\nOpcion: ");

                switch (opcion) {

                    case 1: {
                        String codigo = leerTexto("Codigo: ");
                        String nombre = leerTexto("Nombre: ");
                        String descripcion = leerTexto("Descripcion: ");
                        double precio = leerDouble("Precio: ");
                        boolean disponible = leerBoolean("Disponible (true/false): ");

                        if (hotel.registrarServicio(codigo, nombre, descripcion, precio, disponible)) {
                            JOptionPane.showMessageDialog(null, "Servicio registrado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe un servicio con ese codigo.");
                        }

                        break;
                    }

                    case 2: {
                        ServicioAdicional servicio = hotel.buscarServicio(leerTexto("Codigo: "));

                        if (servicio != null) {
                            JOptionPane.showMessageDialog(null, servicio);
                        } else {
                            JOptionPane.showMessageDialog(null, "Servicio no encontrado.");
                        }

                        break;
                    }

                    case 3: {
                        String codigo = leerTexto("Codigo del servicio a actualizar: ");
                        String nombre = leerTexto("Nuevo nombre: ");
                        String descripcion = leerTexto("Nueva descripcion: ");
                        double precio = leerDouble("Nuevo precio: ");
                        boolean disponible = leerBoolean("Disponible (true/false): ");

                        if (hotel.actualizarServicio(codigo, nombre, descripcion, precio, disponible)) {
                            JOptionPane.showMessageDialog(null, "Servicio actualizado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Servicio no encontrado.");
                        }

                        break;
                    }

                    case 4:
                        if (hotel.eliminarServicio(leerTexto("Codigo: "))) {
                            JOptionPane.showMessageDialog(null, "Servicio eliminado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Servicio no encontrado.");
                        }

                        break;

                    case 5: {
                        String mensaje = "";

                        for (ServicioAdicional servicio : hotel.getListHotelServicios()) {
                            mensaje += servicio + "\n";
                        }

                        JOptionPane.showMessageDialog(null, mensaje);
                        break;
                    }

                    case 6:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida.");
                }
            }
        }


        public static String leerTexto(String mensaje) {
            return JOptionPane.showInputDialog(null, mensaje);
        }

        public static int leerEntero(String mensaje) {
            return Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
        }

        public static double leerDouble(String mensaje) {
            return Double.parseDouble(JOptionPane.showInputDialog(null, mensaje));
        }

        public static boolean leerBoolean(String mensaje) {
            return Boolean.parseBoolean(JOptionPane.showInputDialog(null, mensaje));
        }
    }