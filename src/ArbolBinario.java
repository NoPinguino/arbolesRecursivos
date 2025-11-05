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

    // Método para buscar un valor en el árbol
    public boolean buscarNodo(int value) {
        return buscarRecursivo(raiz, value);
    }
    private boolean buscarRecursivo(Nodo nodo, int value) {
        if (nodo == null) {
            return false;
        }
        if (nodo.dato == value) {
            return true;
        }
        return value < nodo.dato ? buscarRecursivo(nodo.izquierdo, value) : buscarRecursivo(nodo.derecho, value);
    }

    // Método para eliminar un nodo en el árbol
    public void delete(int value) {
        raiz = deleteRec(raiz, value);
    }
    private Nodo deleteRec(Nodo nodo, int value) {
        if (nodo == null) {
            return null;
        }
        if (value < nodo.dato) {
            nodo.izquierdo = deleteRec(nodo.izquierdo, value);
        } else if (value > nodo.dato) {
            nodo.derecho = deleteRec(nodo.derecho, value);
        } else {
            // Caso 1: nodo sin hijos
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
            // Caso 2: un solo hijo
            else if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            // Caso 3: dos hijos -> buscar el sucesor (mínimo del subárbol derecho)
            nodo.dato = minValue(nodo.derecho);
            nodo.derecho = deleteRec(nodo.derecho, nodo.dato);
        }
        return nodo;
    }
    private int minValue(Nodo nodo) {
        int minv = nodo.dato;
        while (nodo.izquierdo != null) {
            minv = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return minv;
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
