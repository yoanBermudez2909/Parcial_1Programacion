package model;

public class ServicioAdicional {
    // Atributos servicio adicional
    private String bebidas, comida, atracciones, spa;
    private int pago;

    // Metodo constructor
    public ServicioAdicional(String bebidas, String comida, String atracciones, String spa, int pago) {
        this.bebidas = bebidas;
        this.comida = comida;
        this.atracciones = atracciones;
        this.spa = spa;
        this.pago = pago;
    }

    public String getBebidas() { return bebidas; }
    public void setBebidas(String bebidas) { this.bebidas = bebidas; }

    public String getComida() { return comida; }
    public void setComida(String comida) { this.comida = comida; }

    public String getAtracciones() { return atracciones; }
    public void setAtracciones(String atracciones) { this.atracciones = atracciones; }

    public String getSpa() { return spa; }
    public void setSpa(String spa) { this.spa = spa; }

    public int getPago() { return pago; }
    public void setPago(int pago) { this.pago = pago; }



    @Override
    public String toString() {
        return "ServicioAdicional{bebidas='" + bebidas + '\'' +
                ", comida='" + comida + '\'' +
                ", atracciones='" + atracciones + '\'' +
                ", spa='" + spa + '\'' +
                ", pago=" + pago + "}";
    }
}

