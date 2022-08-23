
package controller;

import controller.GraficoArbol;
import controller.GraficoArbol;
import controller.Nodo;
import controller.Nodo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ploks
 */
public class Arbol {
    String valor;
    private NodoArbol raiz;
    int cant;
    int altura;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

   

    public NodoArbol getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NodoArbol r) {
        this.raiz = r;
    }

    public Arbol() {
        this.raiz = null;
    }

    public boolean agregar(int dato,String valor) {
        NodoArbol nuevo = new NodoArbol(dato,valor, null, null);
        System.out.println(dato);
        System.out.println(valor);
        nuevo.setValor(valor);
        insertar(nuevo,raiz);
        return true;
    }

    public void insertar(NodoArbol nuevo, NodoArbol pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }

    }
    //cantidad de nodos del arbol
    public String cantidadNodos() {
        cant = 0;
        cantidadNodos(raiz);
        return ""+cant;
    }

    private void cantidadNodos(NodoArbol reco) {
        if (reco != null) {
            cant++;
            cantidadNodos(reco.getIzq());
            cantidadNodos(reco.getDer());
        }
    }     
        
      //altura del arbol
      public String retornarAltura() {
        altura = 0;
        retornarAltura(raiz, 1);
        return ""+altura;
    }

    private void retornarAltura(NodoArbol reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getDer(), nivel + 1);
        }
    }
    
    
    
    //Balance
    int subizq = 0;
    int subder = 0;

 
    String[] niveles;

    public int alturaArbol() {
        altura = 0;
        alturaArbol(raiz, 0);
        return altura;
    }

    private void alturaArbol(NodoArbol pivote, int nivel) {
        if (pivote != null) {
            alturaArbol(pivote.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            alturaArbol(pivote.getDer(), nivel + 1);
        }
    }

    public ArrayList imprimirNivel() {
        niveles = new String[altura + 1];
        ArrayList l=new ArrayList();
        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            l.add(niveles[i] + " ");
            //System.out.println(niveles[i] + " ");
        }
        return l;
    }
      public void imprimirNivel(NodoArbol pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.getDato() + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.getDer(), nivel2 + 1);
            imprimirNivel(pivote.getIzq(), nivel2 + 1);
        }
    }
      
  
    
    
    //Borrar el que sea
    public int borrar(int x) {
        if (!this.buscar(x)) {
            return 0;
        }

        NodoArbol z = borrar(this.raiz, x);
        this.setRaiz(z);
        return x;

    }

    private NodoArbol borrar(NodoArbol r, int x) {
        if (r == null) {
            return null;//<--Dato no encontrado		
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            r.setIzq(borrar(r.getIzq(), x));
        } else if (compara < 0) {
            r.setDer(borrar(r.getDer(), x));
        } else {
            System.out.println("Encontro el dato:" + x);
            if (r.getIzq() != null && r.getDer() != null) {
                /*
                 *	Buscar el menor de los derechos y lo intercambia por el dato
                 *	que desea borrar. La idea del algoritmo es que el dato a borrar 
                 *	se coloque en una hoja o en un nodo que no tenga una de sus ramas.
                 **/
                NodoArbol cambiar = buscarMin(r.getDer());
                int aux = cambiar.getDato();
                cambiar.setDato(r.getDato());
                r.setDato(aux);
                r.setDer(borrar(r.getDer(), x));
                System.out.println("2 ramas");
            } else {
                r = (r.getIzq() != null) ? r.getIzq() : r.getDer();
                System.out.println("Entro cuando le faltan ramas ");
            }
        }
        return r;
    }

    //buscar
    public boolean buscar(int x) {
        return (buscar(this.raiz, x));


    }

    private boolean buscar(NodoArbol r, int x) {
        if (r == null) {
            return (false);
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            return (buscar(r.getIzq(), x));
        } else if (compara < 0) {
            return (buscar(r.getDer(), x));
        } else {
            return (true);
        }
    }

    //buscar min
    private NodoArbol buscarMin(NodoArbol r) {
        for (; r.getIzq() != null; r = r.getIzq());
        return (r);
    }
       //imprimir preorden
    public ArrayList preOrden() {
        ArrayList l=new ArrayList();
        preOrden(raiz,l);
        return l;
    }

    private void preOrden(NodoArbol reco, ArrayList l) {
        if (reco != null) {
            l.add(reco.getDato() + " " + reco.getValor());
            preOrden(reco.getIzq(),l);
            preOrden(reco.getDer(),l);
        }
    }
    //imprimir InOrden
    public ArrayList inOrden() {
        ArrayList l=new ArrayList();
        inOrden(raiz,l);
        return l;
    }

    private void inOrden(NodoArbol reco,ArrayList l) {
        if (reco != null) {
            inOrden(reco.getIzq(),l);
            l.add(reco.getDato() + " "+reco.getValor());
            inOrden(reco.getDer(),l);
        }
    }

//imprimir post orden
    public ArrayList postOrden() {
        ArrayList l=new ArrayList();
        postOrden(raiz,l);
        return l;
    }

    private void postOrden(NodoArbol reco, ArrayList l) {
        if (reco != null) {
            postOrden(reco.getIzq(),l);
            postOrden(reco.getDer(),l);
            l.add(reco.getDato() + " " + reco.getValor());
        }
    }
    
    //con nivel
       public ArrayList impNiveles() {
        ArrayList l=new ArrayList();
        impNiveles(raiz, 1,l);
        return l;
    }

    private void impNiveles(NodoArbol reco, int nivel,ArrayList l) {
        if (reco != null) {
            impNiveles(reco.getIzq(), nivel + 1, l);
            l.add(reco.getDato() + reco.getValor()+ " Nivel: (" + nivel + ") ");
            impNiveles(reco.getDer(), nivel + 1, l);
        }
    }
    
    //hojas
    public ArrayList getHojas() {
        ArrayList l = new ArrayList();
        getHojas(this.raiz, l);
        return (l);
    }

    private void getHojas(NodoArbol r, ArrayList l) {
        if (r != null) {
            if (this.esHoja(r)) {
                l.add(r.getDato());
            }
            getHojas(r.getIzq(), l);
            getHojas(r.getDer(), l);
        }

    }
    protected boolean esHoja(NodoArbol x) {
        return (x != null && x.getIzq() == null && x.getDer() == null);
    }
    
    
    
    
    
     
   
    
    
    
    //dibujar arbol
     public JPanel getdibujo() {
        return new GraficoArbol(this);
    }
}
