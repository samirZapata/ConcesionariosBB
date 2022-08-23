package controller;

import java.io.InputStream;

public class productoscreate {

    private int referencia;
    private String nombre;
    private String marca;
    private String tipoprod;
    private String aplicacion;
    private int cantidadprod;
    private double precio;
    private InputStream imagenprod;

    /**
     *
     * @param referencia
     * @param nombre
     * @param marca
     * @param tipoprod
     * @param aplicacion
     * @param cantidadprod
     * @param precio
     */
    public productoscreate(int referencia, String nombre, String marca, String tipoprod, String aplicacion, int cantidadprod, double precio) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.marca = marca;
        this.tipoprod = tipoprod;
        this.aplicacion = aplicacion;
        this.cantidadprod = cantidadprod;
        this.precio = precio;
        //this.imagenprod = imagenprod;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoprod() {
        return tipoprod;
    }

    public void setTipoprod(String tipoprod) {
        this.tipoprod = tipoprod;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public int getCantidadprod() {
        return cantidadprod;
    }

    public void setCantidadprod(int cantidadprod) {
        this.cantidadprod = cantidadprod;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

//    public InputStream getImagenprod() {
//        return imagenprod;
//    }
//
//    public void setImagenprod(InputStream imagenprod) {
//        this.imagenprod = imagenprod;
//    }
    public productoscreate() {
    }

    @Override
    public String toString() {
        return "productoscreate{" + "referencia=" + referencia + ", nombre=" + nombre + ", marca=" + marca + ", tipoprod=" + tipoprod + ", aplicacion=" + aplicacion + ", cantidadprod=" + cantidadprod + ", precio=" + precio + '}';
    }

}
