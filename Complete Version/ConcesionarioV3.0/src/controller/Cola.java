package controller;

/**
 *
 * @author yonier
 * @param <T>
 */
public class Cola<T> {

    //Atributos
    private NodoCola<T> primero;
    private NodoCola<T> ultimo;
    private int tamanio;

    public Cola() {
        primero = null;
        ultimo = null;
        tamanio = 0;

    }

    /**
     * Indica si la cola esta vacia
     *
     * @return
     */
    public boolean isEmpty() {
        return primero == null;
    }

    /**
     * Indica el tamaño de la cola
     *
     * @return
     */
    public int size() {
        return tamanio;
    }

    /**
     * Devuelve el primer elemento en la cola
     *
     * @return
     */
    public T primero() {
        if (isEmpty()) {
            return null;
        }

        return primero.getElemento();
    }

    /**
     * Elimina y devuelve el primer elemento de la cola
     *
     * @return
     */
    public T dequeue() {

        if (isEmpty()) {
            return null;
        }

        T elemento = primero.getElemento();
        NodoCola<T> aux = primero.getSiguiente();
        primero = null;

        primero = aux;
        tamanio--;
        if (isEmpty()) {
            ultimo = null;
        }

        return elemento;
    }

    /**
     * Añade un nuevo elemento a la cola
     *
     * @param elemento
     * @return
     */
    public T enqueue(T elemento) {

        NodoCola<T> aux = new NodoCola(elemento, null);

        if (isEmpty()) {
            primero = aux;
            ultimo = aux;
        } else {
            if (size() == 1) {
                primero.setSiguiente(aux);
            } else {
                ultimo.setSiguiente(aux);
            }
            ultimo = aux;
        }

        tamanio++;
        return aux.getElemento();

    }

    public T remove(int index) {
        if (isEmpty()) {
            return null;
        } else if (index == 0) {
            dequeue();
        }
        return null;
    }

    /**
     * Muestra el contenido
     *
     * @return
     */
    @Override
    public String toString() {

        if (isEmpty()) {
            return "La lista esta vacia";
        } else {

            String cadena = "";

            NodoCola<T> aux = primero;
            while (aux != null) {
                cadena += aux;
                aux = aux.getSiguiente();
            }

            return cadena;

        }

    }

    public T obtener(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("index was out of bounds");
        }
        NodoCola current = primero;
        for (int i = 0; i < index; i++) {
            current = current.getSiguiente();
        }
        return (T) current.getElemento();
    }

}
