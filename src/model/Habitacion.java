package model;
//Atributos de la habitacion
public class Habitacion {
  private String piso,tipo,estado;
  private int capacidad,numero;
  private double precio;
  //Metodo constructor
    public Habitacion(String piso, String tipo,int capacidad,double precio,String estado,int numero) {
      this.piso = piso;
      this.tipo = tipo;
      this.capacidad = capacidad;
      this.precio = precio;
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
public double getPrecio() {
      return precio;
}
public void setPrecio(double precio) {
      this.precio = precio;
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
    return "Habitación{numero=" + numero +
            ", piso='" + piso + '\'' +
            ", tipo='" + tipo + '\'' +
            ", capacidad='" + capacidad + '\'' +
            ", precio='" + precio + '\'' +
            ", estado='" + estado + '\'' + "}";
  }
}

