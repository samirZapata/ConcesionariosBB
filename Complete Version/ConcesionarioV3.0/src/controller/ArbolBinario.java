
package controller;

//import arbolgrafico.Arbol;
import controller.Nodo;
import controller.Nodo;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ploks
 */
public class ArbolBinario {

    Arbol miArbol = new Arbol();

    public ArbolBinario() {
    }

    public boolean insertar(Integer dato,String valor) {
        return (this.miArbol.agregar(dato,valor));
    }

    public String borrar(int dato,String valor) {
        Integer x = this.miArbol.borrar(dato);
        if (x == null) {
            return ("No existe el dato en el arbol");
        }
        return ("Borrado el dato: " + x.toString());
    }

    public String preOrden() {
        ArrayList it = this.miArbol.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }

    public String inOrden() {
        ArrayList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }

    public String posOrden() {
        ArrayList it = this.miArbol.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }

    public String imprimirPorNiveles() {
        ArrayList it = this.miArbol.impNiveles();
        return (recorrido(it, "Imprimir Por niveles"));
    }
   
    

    public String esta(Integer dato,String valor) {
        boolean siEsta = this.miArbol.buscar(dato);
        String r = "El dato:" + dato.toString() + "\n";
        NodoArbol n=new NodoArbol(dato,valor,null,null);
        r +="El valor:"+ n.getValor() + "\n";   
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    private String recorrido(ArrayList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "\n";
            i++;
        }
        return (r);
    }
    
    public String CantidadNodos(){
        return this.miArbol.cantidadNodos();
    }
    
    
    public String alturaArbol(){
        return this.miArbol.retornarAltura();
    }
   
    
    public String porNivel(){
        this.miArbol.alturaArbol();
        ArrayList it = this.miArbol.imprimirNivel();
        return (recorrido(it, "Imprimir Por niveles en orden!!!"));
    }     
   

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
}
