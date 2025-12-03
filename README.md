# arbolesRecursivos

Repositorio para aprender y experimentar con árboles binarios de búsqueda (BST) y recursividad en Java.

## Qué contiene
Implementaciones y ejemplos básicos de:
- Inserción
- Búsqueda
- Eliminación (casos comunes)
- Recorridos: inorden, preorden, postorden y por niveles
- Métodos auxiliares (altura, tamaño)

## Requisitos
- JDK 8+ (recomendado 11)

## Compilar y ejecutar (rápido)
Si tu código está en `src/` y tienes una clase con `main`:
1. Compilar:
   ```
   javac -d out $(find src -name "*.java")
   ```
2. Ejecutar:
   ```
   java -cp out tu.paquete.Main
   ```

(Reemplaza `tu.paquete.Main` por la clase que tenga `main`.)

## Ejemplo de uso
```java
BinarySearchTree<Integer> tree = new BinarySearchTree<>();
tree.insert(5);
tree.insert(3);
tree.insert(7);
List<Integer> inOrder = tree.inOrder(); // [3,5,7]
```

## Estructura sugerida
- src/ (clases Java)
- README.md

## Contribuir
Es un repo personal de aprendizaje; puedes abrir issues o PRs si quieres proponer mejoras o ejemplos.
