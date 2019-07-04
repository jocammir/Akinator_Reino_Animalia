
package tdas;

import java.util.Scanner;

public class interactuar {
    Scanner sc=new Scanner(System.in);
    nodoAB<String> raiz;

    public interactuar(nodoAB<String> raiz) {
        this.raiz = raiz;
    }
    
    
    
    public nodoAB<String> jugar (nodoAB<String> principal){
        System.out.println(principal.getContenido().substring(2,principal.getContenido().length()  ));
        String decision=sc.nextLine();
        elabArbol fun = new elabArbol(raiz);
        
        if("si".equals(decision.toLowerCase())){
            if(principal.getDer()!=null){
                return jugar(principal.getIzq());
            }else{
                if(principal.getContenido().contains("#R")){
                    System.out.println("he adivinado ^^");
                    jugarDeNuevo();
                }
                else{
                    fun.guardarArbol(principal);
                    return null;
                }
            }
        }else if("no".equals(decision.toLowerCase())){
            if(principal.getIzq()!=null){
                return jugar(principal.getDer());
            }else{
                fun.guardarArbol(principal);
                return null;
            }
        }else{
            System.out.println("\nEscribe una opcion correcta");
            jugar(principal);
        }
         return null;
    }
    public void jugarDeNuevo(){
        
        System.out.println("Deseas jugar de nuevo:");
        String decision=sc.nextLine();
        if("si".equals(decision.toLowerCase())){
            jugar(raiz);
        }
        else if ("no".equals(decision.toLowerCase())){
            System.out.println("Gracias por jugar \\^^/ ");
            return;
        }
        else{
            System.out.println("Escribe una opcion correcta");
            jugarDeNuevo();
        }
    }
    
}
