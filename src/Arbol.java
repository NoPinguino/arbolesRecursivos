public class Arbol {
    private Nodo raiz;

    // Insertar en árbol:
    public void insertarLanzadera(int valor) {
        this.raiz = insertarRecursivo(raiz, valor);
    }
    private Nodo insertarRecursivo(Nodo n, int valor) {
        if (n == null) return new Nodo(valor);
        if (valor < n.dato) n.izq = insertarRecursivo(n.izq, valor);
        if (valor > n.dato) n.der = insertarRecursivo(n.der, valor);
        return n;
    }

    // Buscar en árbol:
    public boolean buscarLanzadera(int valor) {
        return buscarRecursivo(raiz, valor);
    }
    private boolean buscarRecursivo(Nodo n, int valor) {
        if (n == null) return false;
        if (valor < n.dato) return buscarRecursivo(n.izq, valor);
        if (valor > n.dato) return buscarRecursivo(n.der, valor);
        return true;
    }

    // Recorrido pre-order:
    public void recorrerPreOrder() {
        System.out.print("Recorreido pre-order: ");
        recorrerPreOrderRecursivo(raiz);
        System.out.println(); // Salto de linea
    }
    private void recorrerPreOrderRecursivo(Nodo n) {
        if (n == null) return;
        System.out.print(n.dato + " ");
        recorrerPreOrderRecursivo(n.izq);
        recorrerPreOrderRecursivo(n.der);
    }

    // Eliminación de un nodo [DIFÍCIL]:
    public void eliminarLanzadera(int valor) {
        this.raiz = eliminarRecursivo(raiz, valor);
    }
    private Nodo eliminarRecursivo(Nodo n, int valor) {
        // PRIMERO: Comprobar que hay contenido en el árbol.
        if (n == null) return null;
        // SEGUNDO: Encontrar el nodo que queremos eliminar.
        if (valor < n.dato) {
            n.izq = eliminarRecursivo(n.izq, valor);
            return n; // Retornar nodo actual con descendientes re-estructurados.
        } else if (valor > n.dato) {
            n.der = eliminarRecursivo(n.der, valor);
            return n; // Retornar nodo actual con descendientes re-estructurados.
        }

        // === UNA VEZ ENCONTRAMOS EL NODO A ELIMINAR ===

        // Caso 1: Sin hijos.
        if (n.izq == null && n.der == null) return null; // Eliminamos nodo sin preocuparnos de hijos.
        // Caso 2: Un solo hijo.
        if (n.izq == null) return n.der; // Solo tiene hijo derecho
        if (n.der == null) return n.izq; // Solo tiene hijo izquierdo
        // Caso 3: Dos hijos.
        n.dato = minValue(n.der); // Buscar valor mímino
        n = eliminarRecursivo(n.der, n.dato); // Re-estructurar subárbol derecho
        return n; // Devolver nodo con descendientes re-estructurados
    }
    // minValue: devuelve el dato menor de un subárbol - descendiente menor.
    private int minValue(Nodo n) {
        int min = n.dato;
        while (n.izq != null) {
            n = n.izq;
            min = n.dato;
        }
        return min;
    }

    // Ejercicios recursividad:

    // ¿Es estricto? ✅
    public boolean estrictoLanzadera() {
        return estrictoRecursivo(raiz);
    }
    private boolean estrictoRecursivo(Nodo n) {
        if (n == null) return true;
        if (n.izq == null && n.der == null) return true;
        if (n.izq != null && n.der != null) return (estrictoRecursivo(n.izq) && estrictoRecursivo(n.der));
        return false;
    }

    // Hallar la altura del árbol ✅
    public int alturaLanzadera() {
        return alturaRecursiva(raiz);
    }
    private int alturaRecursiva(Nodo n) {
        if (n == null) return 0;
        return 1 + (Math.max(alturaRecursiva(n.izq), alturaRecursiva(n.der)));
    }

    // Encontrar valor máximo ✅
    public int maximoLanzadera() {
        return maximoRecursivo(raiz);
    }
    private int maximoRecursivo(Nodo n) {
        if (n == null) return -1;
        if (n.der == null) return n.dato;
        return maximoRecursivo(n.der);
    }

    // Contar número de nodos ✅
    public int numNodosLanzadera() {
        return numNodosRecursivo(raiz);
    }
    private int numNodosRecursivo(Nodo n) {
        if (n == null) return 0;
        if (n.izq == null && n.der == null) return 1; // Caso hoja
        return 1 + (numNodosRecursivo(n.izq) + numNodosRecursivo(n.der));
    }

    // Contar número de hojas ✅
    public int numHojasLanzadera() {
        return numHojasRecursivo(raiz);
    }
    private int numHojasRecursivo(Nodo n) {
        if (n == null) return 0;
        if (n.izq == null && n.der == null) return 1;
        return (numHojasRecursivo(n.izq) + numHojasRecursivo(n.der));
    }

    // Sumatorio del valor de nodos ✅
    public int sumatorioLanzadera() {
        return sumatorioRecursivo(raiz);
    }
    private int sumatorioRecursivo(Nodo n) {
        if (n == null) return 0;
        if (n.izq == null && n.der == null) return n.dato;
        return n.dato + (sumatorioRecursivo(n.izq) + sumatorioRecursivo(n.der));
    }

    // Sumatorio del valor de nodos cuyo dato sea PAR ✅
    public int sumatorioParesLanzadera() {
        return sumatorioParesRecursivo(raiz);
    }
    private int sumatorioParesRecursivo(Nodo n) {
        if (n == null) return 0;
        if (n.izq == null && n.der == null && n.dato % 2 == 0) return n.dato;
        if (n.dato % 2 == 0) return (sumatorioParesRecursivo(n.izq) + sumatorioParesRecursivo(n.der) + n.dato);
        return (sumatorioParesRecursivo(n.izq) + sumatorioParesRecursivo(n.der));
    }

    // ¿Son dos árboles identicos? ✅
    public boolean sonIdenticosLanzadera(Arbol other) {
        return sonIdenticosRecursivo(this.raiz, other.raiz);
    }
    private boolean sonIdenticosRecursivo(Nodo nodeThis, Nodo nodeOther) {
        if (nodeThis == null && nodeOther == null) return true; // Ambos nodos null
        if ((nodeThis != null && nodeOther == null) || (nodeThis == null && nodeOther != null)) return false; // Un nodo es null y otro no

        // Ya no hay nulls aquí, ya se pueden comparar datos
        if (nodeThis.dato != nodeOther.dato) return false;
        return (sonIdenticosRecursivo(nodeThis.izq, nodeOther.izq) && sonIdenticosRecursivo(nodeThis.der, nodeOther.der));
    }

    // Suma de nodos NO hojas ✅
    public int sumatorioInternosLanzadera() {
        return sumatorioInternosRecursivo(raiz);
    }
    private int sumatorioInternosRecursivo(Nodo n) {
        if (n == null) return 0;
        if (n.izq == null && n.der == null) return 0; // Caso hoja
        return n.dato + (sumatorioInternosRecursivo(n.izq) + sumatorioInternosRecursivo(n.der));
    }
}