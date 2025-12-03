class Nodo {
    int dato; // Dato de this nodo
    Nodo izq; // Hijo izquierdo
    Nodo der; // Hijo derecho

    public Nodo(int dato) {
        this.izq = null;
        this.der = null;
        this.dato = dato;
    }
}
