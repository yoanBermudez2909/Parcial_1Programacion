package model;

import java.util.ArrayList;
import java.util.List;

    public class Hotel {

        private String nombreComercial;
        private String nit;
        private String direccion;
        private String telefono;
        private String paginaWeb;
        private List<Huesped> listHotelHuespedes;
        private List<Habitacion> listHotelHabitaciones;
        private List<Reserva> listHotelReservas;
        private List<ServicioAdicional> listHotelServicios;

        /**
         * Metodo constructor de la clase Estudiante
         * @param nombreComercial del estudiante
         * @param nit del estudiante
         * @param direccion del estudiante
         * @param telefono del estudiante
         */

        public Hotel(String nombreComercial, String nit, String direccion, String telefono, String paginaWeb) {
            this.nombreComercial = nombreComercial;
            this.nit = nit;
            this.direccion = direccion;
            this.telefono = telefono;
            this.paginaWeb = paginaWeb;
            this.listHotelHuespedes = new ArrayList<>();
            this.listHotelHabitaciones = new ArrayList<>();
            this.listHotelReservas = new ArrayList<>();
            this.listHotelServicios = new ArrayList<>();
        }




        public Huesped buscarHuesped(String documento) {
            Huesped encontrado = null;

            for (int i = 0; i < this.listHotelHuespedes.size(); ++i) {
                Huesped huesped = this.listHotelHuespedes.get(i);
                if (huesped.getDocumento().equals(documento)) {
                    encontrado = huesped;
                    break;
                }
            }

            return encontrado;
        }

        public boolean registrarHuesped(String nombreCompleto, String documento, String telefono, String correo, String pais) {
            boolean registrado = false;
            Huesped huesped = this.buscarHuesped(documento);
            if (huesped == null) {
                Huesped nuevo = new Huesped(nombreCompleto, documento, telefono, correo, pais);
                this.listHotelHuespedes.add(nuevo);
                registrado = true;
            }

            return registrado;
        }

        // Consulta un huésped por teléfono (funcionalidad del enunciado)
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

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
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

        @Override
        public String toString() {
            return "Hotel{" +
                    "nit='" + nit + '\'' +
                    ", nombreComercial='" + nombreComercial + '\'' +
                    ", direccion='" + direccion + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", paginaWeb='" + paginaWeb + '\'' +
                    ", listHotelHuespedes=" + listHotelHuespedes +
                    ", listHotelHabitaciones=" + listHotelHabitaciones +
                    ", listHotelReservas=" + listHotelReservas +
                    ", listHotelServicios=" + listHotelServicios +
                    '}';
        }


    }
