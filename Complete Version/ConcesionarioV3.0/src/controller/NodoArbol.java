package controller;

/**
 *
 * @author ploks
 */
public class NodoArbol {

    private String valor;

    private int dato;
    private NodoArbol izq, der;

    public NodoArbol(int dato, String valor, NodoArbol izq, NodoArbol der) {
        this.valor = valor;
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

}
