package TresOrdenes;

//Clase principal del Árbol
class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Método para insertar nodos en el árbol
    public void insertarNodo(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.dato) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo;
    }

    // Método para buscar un valor en el BST
    public boolean buscarNodo(int value) {
        return buscarRecursivo(raiz, value);
    }
    private boolean buscarRecursivo(Nodo raiz, int value) {
        if (raiz == null) {
            return false;
        }
        if (raiz.dato == value) {
            return true;
        }
        return value < raiz.dato
                ? buscarRecursivo(raiz.izquierdo, value)
                : buscarRecursivo(raiz.derecho, value);
    }

    // POST ORDER
    public void recorridoPostorden() {
        System.out.print("Recorrido Post-Orden: ");
        postorden(raiz);
        System.out.println();
    }
    private void postorden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        // 1. Recorrer subárbol izquierdo
        postorden(nodo.izquierdo);
        // 2. Recorrer subárbol derecho
        postorden(nodo.derecho);
        // 3. Visitar el nodo raíz
        System.out.print(nodo.dato + " ");
    }

    //IN ORDER
    public void recorridoInOrder() {
        System.out.print("Recorrido In-Order: ");
        inorder(raiz);
        System.out.println();
    }
    private void inorder(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        // 1. Recorrer subárbol izquierdo
        inorder(nodo.izquierdo);
        // 2. Visitar el nodo raíz
        System.out.print(nodo.dato + " ");
        // 3. Recorrer subárbol derecho
        inorder(nodo.derecho);
    }

    //PRE ORDER
    public void recorridoPreorden() {
        System.out.print("Recorrido Pre-Orden: ");
        preorden(raiz);
        System.out.println();
    }
    private void preorden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        // 1. Visitar el nodo raíz
        System.out.print(nodo.dato + " ");
        // 2. Recorrer subárbol izquierdo
        preorden(nodo.izquierdo);
        // 3. Recorrer subárbol derecho
        preorden(nodo.derecho);
    }
}
