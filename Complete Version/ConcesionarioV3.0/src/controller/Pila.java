package controller;

/**
 *
 * @author yonier
 * @param <T>
 */
public class Pila<T> {

    //Atributos
    private NodoPila<T> top; //Ultimo nodo que se ha incluido
    private int tamanio;

    private class elemento<T> {

        private T dato;
        private int indice;
        private elemento siguiente;

        /**
         *
         * @param dato
         * @param indice
         */
        //inicializo objetos
        public elemento(T dato, int indice) {
            this.dato = dato;
            this.indice = indice;
            this.siguiente = null;
        }

        /**
         *
         * @param indice
         */
        public elemento(int indice) {
            this.dato = null;
            this.indice = indice;
            this.siguiente = null;
        }

        public elemento() {
            this.dato = null;
            this.indice = 0;
            this.siguiente = null;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public int getIndice() {
            return indice;
        }

        public void setIndice(int indice) {
            this.indice = indice;
        }

        public elemento getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(elemento siguiente) {
            this.siguiente = siguiente;
        }

    }
    private elemento<T> tops;

    //Constructores
    public Pila() {
        top = null; //No hay elementos
        this.tamanio = 0;
    }

    /**
     * Indica si esta vacia o no
     *
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Indica el tamaño
     *
     * @return
     */
    public int size() {
        return tamanio;
    }

    /**
     * Devuelve el que esta más arriba en la pila
     *
     * @return
     */
    public T top() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) top.getSiguiente();
        }
    }

    /**
     * Saca y devuelve el elemento que mas arriba esta en la pila
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T elemento = top.getElemento();
            NodoPila<T> aux = top.getSiguiente();
            top = null; //marco para borrar
            top = aux; //actualizo el top
            this.tamanio--;
            return elemento;
        }
    }

    public T remove(int index) {
        if (isEmpty()) {
            return null;
        } else if (index == 0) {
            top();
        } /*else {
            //Cojo el nodo anterior al que quiero borrar
            NodoPila<T> nodo_anterior = getNode(index - 1);

            //Cojo el nodo que quiero borrar
            NodoPila<T> nodo_actual = getNode(index);

            //Cojo el elemento antes de borrar
            elemento = nodo_actual.getDato();
            System.out.println("Elemento antes de borrar " + elemento);
            //Cojo el nodo siguiente al que quiero borrar
            NodoPila<T> nodo_siguiente = nodo_actual.getSiguiente();

            //Lo marco para borrar para el recolector
            nodo_actual = null;

            //El nodo anterior apunta al nodo siguiente
            nodo_anterior.setSiguiente(nodo_siguiente);
            tamanio--;
        }*/
        return null;
    }

    /**
     * Mete un elemento a la pila
     *
     * @param elemento
     * @return
     */
    public T push(T elemento) {

        NodoPila<T> aux = new NodoPila<>(elemento, top);
        top = aux; //actualizo el top
        this.tamanio++;
        return aux.getElemento();
    }

    /**
     * Devuelve el estado de la pila
     *
     * @return
     */
    @Override
    public String toString() {

        if (isEmpty()) {
            return "La pila esta vacia";
        } else {

            String resultado = "";
            NodoPila<T> aux = top;
            //Recorro la pila
            while (aux != null) {
                resultado += aux.toString();
                aux = aux.getSiguiente();
            }

            return resultado;

        }

    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("index was out of bounds");
        }
        NodoPila current = top;
        for (int i = 0; i < index; i++) {
            current = current.getSiguiente();
        }
        return (T) current.getElemento();
    }

}
