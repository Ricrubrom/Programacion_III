package Practica5.ParteB.Ejercicio3;

public class TestTRIE {
  public static void main(String[] args) {
    TRIE trie = new TRIE();
    trie.agregarPalabra("hola");
    trie.agregarPalabra("hoja");
    trie.agregarPalabra("homo");
    trie.agregarPalabra("arbol");
    trie.agregarPalabra("araña");
    System.out.println("\n\n");
    trie.ImprimirPorNiveles();
  }
}
