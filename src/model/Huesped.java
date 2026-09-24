package model;

import java.util.ArrayList;
import java.util.List;

public class Huesped {

    // Atributos de la clase Huesped
    private String nombreCompleto;
    private String documentoIdentidad;
    private String telefono;
    private String correoElectronico;
    private String paisProcedencia;

    // Relaciones de la clase Huesped
    private List<Reserva> listHuespedReservas;

    // Metodo constructor
    public Huesped(String nombreCompleto, String documentoIdentidad, String telefono, String correoElectronico, String paisProcedencia) {
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.paisProcedencia = paisProcedencia;
        this.listHuespedReservas = new ArrayList<>();
    }

    public boolean esFrecuente() {
        return listHuespedReservas.size() >= 3;
    }

    public String getnombreCompleto() {
        return nombreCompleto;
    }

    public void setnombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getdocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setdocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public List<Reserva> getListHuespedReservas() {
        return listHuespedReservas;
    }

    public void setListHuespedReservas(List<Reserva> listHuespedReservas) {
        this.listHuespedReservas = listHuespedReservas;
    }

    /**
     * Metodo que permite agregar una reserva al huesped
     * @param reserva reserva que se desea agregar
     */
    public void agregarReserva(Reserva reserva) {
        listHuespedReservas.add(reserva);
    }

    /**
     * Metodo que permite buscar una reserva del huesped
     * @param codigoReserva codigo de la reserva
     * @return reserva encontrada
     */
    public Reserva buscarReserva(String codigoReserva) {
        Reserva encontrada = null;

        for (int i = 0; i < listHuespedReservas.size(); ++i) {
            Reserva reserva = listHuespedReservas.get(i);
            if (reserva.getCodigoReserva().equals(codigoReserva)) {
                encontrada = reserva;
                break;
            }
        }

        return encontrada;
    }

    /**
     * Metodo que permite eliminar una reserva del huesped
     * @param codigoReserva codigo de la reserva
     * @return true si se elimina, false si no existe
     */
    public boolean eliminarReserva(String codigoReserva) {
        Reserva reserva = buscarReserva(codigoReserva);

        if (reserva != null) {
            listHuespedReservas.remove(reserva);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", paisProcedencia='" + paisProcedencia + '\'' +
                ", listHuespedReservas=" + listHuespedReservas +
                '}';
    }
}