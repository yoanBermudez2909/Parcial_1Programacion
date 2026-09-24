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
