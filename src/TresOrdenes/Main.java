package TresOrdenes;
//Clase de prueba con main
public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        // Insertar valores en el árbol
        //System.out.println("Insertando valores: 50, 30, 70, 20, 40, 60, 80");
        arbol.insertarNodo(5);
        arbol.insertarNodo(2);
        arbol.insertarNodo(1);
        arbol.insertarNodo(3);
        arbol.insertarNodo(12);
        arbol.insertarNodo(9);
        arbol.insertarNodo(21);
        arbol.insertarNodo(19);
        arbol.insertarNodo(25);

        System.out.println("\nRecorridos del árbol:");

        arbol.recorridoPostorden(); // Uso PostOrder() para las pruebas, usa el recorrido que más te guste :)
        System.out.println();

        if(!arbol.buscarNodo(15))
            System.out.println("El valor 15 NO se ha encontrado.");
        arbol.recorridoPostorden();
        System.out.println();

        arbol.insertarNodo(15);
        if(arbol.buscarNodo(15))
            System.out.println("El valor 15 se ha encontrado.");
        arbol.recorridoPostorden();
        System.out.println();

        arbol.delete(12);
        arbol.recorridoPostorden(); //Como puedes ver, elimina el valor 12 del árbol.
    }
}