package Practica3.ParteB.Ejercicio4;

import Practica3.Source.ListaGenerica.ListaGenericaEnlazada;

public class TestBalanceo {
  public static void main(String[] args) {
    ListaGenericaEnlazada<Character> lista = new ListaGenericaEnlazada<Character>();
    String cadena = "(([]({})[]))";
    for (int i = 0; i < cadena.length(); i++) {
      lista.agregarFinal(cadena.charAt(i));
    }
  }



  public static boolean balanceo(ListaGenericaEnlazada<Character> lista) {
    lista.comenzar();
    while (!lista.fin()) {
      
    }
  }
}
