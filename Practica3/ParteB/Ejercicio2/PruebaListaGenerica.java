package Practica3.ParteB.Ejercicio2;

import Practica3.Source.ListaGenerica.ListaGenericaEnlazada;

public class PruebaListaGenerica {
  public static void main(String[] args) {
    ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
    lista.agregarFinal(1);
    lista.agregarFinal(2);
    lista.agregarFinal(3);
    lista = lista.invertir();
    lista.comenzar();
    System.out.println(lista.toString());
  }
}
