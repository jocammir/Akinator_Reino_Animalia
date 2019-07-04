
package tdas;
import java.io.*;
import java.util.*;


public class ABD<T extends Comparable<T>> {
    private nodoAB<String> raiz;
    Scanner sc=new Scanner(System.in);
    //**************************************************************
    
    public ABD() {
        this.raiz = null;
    }
    public nodoAB<String> getRaiz() {
        return raiz;
    }
    public void setRaiz(nodoAB<String> raiz) {
        this.raiz = raiz;
    }
 
    //********************************************************* 
   public ABD<String> cargarArbol(){
        ABD arbol = new ABD ();elabArbol fun=new elabArbol();
        Stack<nodoAB<String>> datos= fun.crearPila("datos.txt");//le dare la vuelta para que crear de arriba para abajo

        raiz=cargarArbol(arbol.raiz,datos);
        
        arbol.setRaiz(raiz);
        
        interactuar ayuda= new interactuar(raiz);
        
        ayuda.jugar(raiz);
        
        return arbol;
    }
      
    //**********************************************************

     private nodoAB<String> cargarArbol(nodoAB<String> principal,Stack<nodoAB<String>> datos){
        nodoAB<String> nuevo= new nodoAB<>(datos.pop().getContenido());
        
        if((nuevo.getContenido()).contains("#P")){
            nodoAB<String> nuevoizq= new nodoAB<>("");
            nodoAB<String> nuevoder= new nodoAB<>("");
            nuevo.setIzq(cargarArbol(nuevoizq,datos));
            nuevo.setDer(cargarArbol(nuevoizq,datos));
            
        }
        if((nuevo.getContenido()).contains("#R")){
            return nuevo;
        }
        return nuevo;
    }
    
    public void print(){
        arbolPrinter.printNode(this.getRaiz());
    }

    
}
