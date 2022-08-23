package controller;

import java.io.InputStream;

public class inventarioCarrosCr {

    private String placa;
    private String modelo;
    private String color;
    private String NoMotor;
    private String Ciudad;
    private String Marca;
    private String Tipoc;
    //private InputStream Imagen;

    /**
     *
     * @param placa
     * @param modelo
     * @param color
     * @param NoMotor
     * @param Ciudad
     * @param Marca
     * @param Tipoc
     *
     */
    public inventarioCarrosCr(String placa, String modelo, String color, String NoMotor, String Ciudad, String Marca, String Tipoc) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.NoMotor = NoMotor;
        this.Ciudad = Ciudad;
        this.Marca = Marca;
        this.Tipoc = Tipoc;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNoMotor() {
        return NoMotor;
    }

    public void setNoMotor(String NoMotor) {
        this.NoMotor = NoMotor;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getTipoc() {
        return Tipoc;
    }

    public void setTipoc(String Tipoc) {
        this.Tipoc = Tipoc;
    }

//    public InputStream getImagen() {
//        return Imagen;
//    }
//
//    public void setImagen(InputStream Imagen) {
//        this.Imagen = Imagen;
//    }
    public inventarioCarrosCr() {

    }

    @Override
    public String toString() {
        return "inventarioCarrosCr{" + "placa=" + placa + ", modelo=" + modelo + ", color=" + color + ", NoMotor=" + NoMotor + ", Ciudad=" + Ciudad + ", Marca=" + Marca + ", Tipoc=" + Tipoc + '}';
    }

}
