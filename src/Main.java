public class Main {
    public static void main(String[] args) {
        Arbol a = new Arbol();

        // Inserciones
        a.insertarLanzadera(50);
        a.insertarLanzadera(30);
        a.insertarLanzadera(70);
        a.insertarLanzadera(20);
        a.insertarLanzadera(40);
        a.insertarLanzadera(60);
        a.insertarLanzadera(80);

        System.out.println("¿Existe 10?: " + a.buscarLanzadera(10));
        System.out.println("¿Existe 80?: " + a.buscarLanzadera(80));

        a.recorrerPreOrder();

        System.out.println("¿Es estricto el árbol?: " + a.estrictoLanzadera());
        System.out.println("Altura del árbol: " + a.alturaLanzadera());
        System.out.println("Valor máximo del árbol: " + a.maximoLanzadera());
        System.out.println("Número de nodos en árbol: " + a.numNodosLanzadera());
        System.out.println("Número de hojas en árbol: " + a.numHojasLanzadera());
        System.out.println("Sumatorio: " + a.sumatorioLanzadera());
        System.out.println("Sumatorio de nodos con valor par: " + a.sumatorioParesLanzadera());
        System.out.println("Sumatorio de nodos internos: " + a.sumatorioInternosLanzadera());

        Arbol b = new Arbol();
        // Mismas inserciones que A
        b.insertarLanzadera(50);
        b.insertarLanzadera(30);
        b.insertarLanzadera(70);
        b.insertarLanzadera(20);
        b.insertarLanzadera(40);
        b.insertarLanzadera(60);
        b.insertarLanzadera(80);

        Arbol c = new Arbol();
        // Inserciones diferentes
        c.insertarLanzadera(50);
        c.insertarLanzadera(30);
        c.insertarLanzadera(70);
        c.insertarLanzadera(20);
        c.insertarLanzadera(45);  // Diferente: 45 vs 40
        c.insertarLanzadera(60);
        c.insertarLanzadera(80);

        System.out.println("¿Son identicos A y B?: " + a.sonIdenticosLanzadera(b));
        System.out.println("¿Son identicos A y C?: " + a.sonIdenticosLanzadera(c));
    }
}
