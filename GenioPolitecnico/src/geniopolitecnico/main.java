
package geniopolitecnico;

import java.io.FileNotFoundException;
import java.io.IOException;
import tdas.*;
import java.util.*;


public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        System.out.println("+------------------------------------------+");
        System.out.println("|   BIENVENIDO AL JUEGO POLITÉCNICO :v !!  |");
        System.out.println("+------------------------------------------+");
        
        System.out.println("Vamos a ver si se puede adividar algo >_< ");
        System.out.println("Primero: Piensa en un animal . \nOk, ¿Estás listo?\nComenzamos !!!\n");
        ABD<String> arbol =new ABD<String>(); 
        arbol.cargarArbol();
        //arbol.print();
        
        }

    
    
}
