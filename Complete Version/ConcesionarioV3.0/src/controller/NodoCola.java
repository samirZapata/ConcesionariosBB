package controller;

/**
 *
 * @author yonier
 * @param <T>
 */
public class NodoCola<T> {
    //Atributos
    private T elemento;
    private NodoCola<T> siguiente; //Apunta al siguiente nodo
     
    //Contructor
    public NodoCola(T elemento, NodoCola<T> siguiente){
        this.elemento = elemento;
        this.siguiente = siguiente;
    }
 
    //Metodos
    public T getElemento() {
        return elemento;
    }
 
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
 
    public NodoCola<T> getSiguiente() {
        return siguiente;
    }
 
    public void setSiguiente(NodoCola<T> siguiente) {
        this.siguiente = siguiente;
    }
 
    @Override
    public String toString() {
        return elemento+"\n";
    }
}
