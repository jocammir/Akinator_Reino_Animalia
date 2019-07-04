
package tdas;

import java.io.*;
import java.util.*;


public class elabArbol  {
    Scanner sc=new Scanner(System.in);
    nodoAB<String> raiz;

    public elabArbol() {
    }

    public elabArbol(nodoAB<String> raiz) {
        this.raiz = raiz;
    }
    
    public Stack<nodoAB<String>> crearPila(String Archivo) { 
        Stack<nodoAB<String>> pilaDatos=new Stack<>();
        try (Scanner sc = new Scanner(new File(Archivo))) {
            while(sc.hasNextLine()) {
                nodoAB<String> nodo= new nodoAB<>(sc.nextLine());
                pilaDatos.push(nodo);
            }
        } catch (FileNotFoundException ex) {}
    return voltearPila(pilaDatos);
    }
    private Stack<nodoAB<String>> voltearPila (Stack<nodoAB<String>> pila){
        Stack<nodoAB<String>> nueva= new Stack<>();
        while(!pila.empty()){
            nueva.push(pila.pop());
        }
        return nueva;
    }
    public void guardarArbol(nodoAB<String> ultimoNodo){
        nodoAB<String> opcDer= new nodoAB<>(ultimoNodo.getContenido());
        
        System.out.println("No he podido adivinar !! ... ayudame a mejorar mi predicción ");
        System.out.println("¿Qué animal estabas pensando? ");
        String animalCorrecto=sc.nextLine();
        String respuesta,pregunta="";

        while(true){
            System.out.println("Escribe la pregunta que me permita diferenciar entre un "+animalCorrecto+
                            " y un "+ ultimoNodo.getContenido().substring(3, ultimoNodo.getContenido().length())+": ");
            String preg=sc.nextLine();
            System.out.println("Para un "+animalCorrecto+" , la respuesta a la pregunta: "+preg+" , es si o no?");
            String resp=sc.nextLine();
            if("si".equals(resp.toLowerCase())){
                respuesta=resp;
                pregunta=preg;
                break;
            }
        }
        nodoAB<String> opcIzq=new nodoAB<>("#R "+animalCorrecto);
        ultimoNodo.setContenido("#P "+pregunta);
        if("si".equals(respuesta)){
            ultimoNodo.setDer(opcDer);
            ultimoNodo.setIzq(opcIzq);}
        else if("no".equals(respuesta)){
            ultimoNodo.setDer(opcIzq);
            ultimoNodo.setIzq(opcDer);
        }
        borrarTxT("datos.txt");
        arbolPrinter ap=new arbolPrinter();
        arbolArchivo("datos.txt",this.raiz);
        
        System.out.println("Gracias, he aprendido algo nuevo ^^");
        interactuar ayu= new interactuar(raiz);
        ayu.jugarDeNuevo();
    }
     public void arbolArchivo(String archivo, nodoAB<String> n){
        if(n==null)return;
        
        crearTxT(archivo,n.getContenido());
        arbolArchivo(archivo, n.getIzq());
        arbolArchivo(archivo, n.getDer());
    }
    
    public void borrarTxT(String nombre){
        try{
            File f =new File(nombre);
            FileWriter escritor = new FileWriter (f);
            try (BufferedWriter A = new BufferedWriter(escritor); PrintWriter salida = new PrintWriter(A)) {
                    salida.write("");
                }
        } catch (Exception e) {}
    }
    
    private void crearTxT(String archivo, String contenido){
        try{
            File f =new File(archivo);
            FileWriter escritor = new FileWriter (f,true);
            try (BufferedWriter A = new BufferedWriter(escritor); PrintWriter salida = new PrintWriter(A)) {
                    salida.write(contenido+"\r\n");
                }
        } catch (Exception e) {}
    }
}
