package Practica5.ParteB.Ejercicio3;

public class TestTRIE {
  public static void main(String[] args) {
    TRIE trie = new TRIE();
    trie.agregarPalabra("arbol");
    trie.agregarPalabra("araña");
    trie.agregarPalabra("arañita");
    trie.agregarPalabra("arar");
    trie.agregarPalabra("hola");
    trie.agregarPalabra("hoja");
    trie.agregarPalabra("homo");
    trie.ImprimirPorNiveles();
    System.out.println("\n");
    System.out.println(trie.palabrasQueEmpiezanCon("ara"));
  }
}
