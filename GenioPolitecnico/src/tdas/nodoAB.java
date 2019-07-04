
package tdas;

// esta es la clase que nos cedió el profesor.
public class nodoAB<T extends Comparable<?>> {
    private T contenido;
    private nodoAB<T> izq, der;
    
    
    public nodoAB(T contenido) {
        this.contenido = contenido;
        this.izq = null;
        this.der = null;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public nodoAB<T> getIzq() {
        return izq;
    }

    public void setIzq(nodoAB<T> izq) {
        this.izq = izq;
    }

    public nodoAB<T> getDer() {
        return der;
    }

    public void setDer(nodoAB<T> der) {
        this.der = der;
    }
    
    
}
