package Practica3.ParteB.Ejercicio3;

import Practica3.Source.ListaGenerica.Pila;

public class PilaTest {
  public static void main(String[] args) {
    Pila<Character> pila = new Pila<Character>();
    pila.apilar('a');
    pila.apilar('b');
    pila.apilar('c');
    pila.apilar('d');
    pila.apilar('e');
    while (!pila.esVacia()) {
      System.out.println(pila.desapilar());
    }
  }
}
