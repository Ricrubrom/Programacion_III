package Practica3.ParteA.Ejercicio1;

import Practica3.Source.ListaDeEnterosEnlazada;

public class ListaDeEnterosEnlazadaTestBasico {
  public static void main(String[] args) {
    ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
    lista.agregarFinal(1);
    lista.agregarFinal(2);
    lista.agregarFinal(13);
    lista.agregarFinal(3);
    lista.agregarFinal(38);
    lista.agregarFinal(7);
    lista.comenzar();
    ImprimirLista(lista);
    }

  public static void ImprimirLista(ListaDeEnterosEnlazada lista) {
    Integer dato = null;
    if (!lista.fin()) {
      dato = lista.proximo();
      ImprimirLista(lista);
    }
    if (dato != null)
      System.out.println(dato);
  }
}

