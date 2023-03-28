package Practica3.ParteA.Ejercicio4;

import Practica3.Source.ListaDeEnteros.ListaDeEnterosEnlazada;

public class UtilitariosLista {
  public static ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada lista) {
    if (lista.tamanio() <= 1) {
      return lista;
    }
    ListaDeEnterosEnlazada izq = new ListaDeEnterosEnlazada();
    ListaDeEnterosEnlazada der = new ListaDeEnterosEnlazada();
    int i = 0;
    lista.comenzar();
    while (!lista.fin()) {
      if (i < lista.tamanio() / 2) {
        izq.agregarFinal(lista.proximo());
      } else {
        der.agregarFinal(lista.proximo());
      }
      i++;
    }
    izq = mergeSort(izq);
    der = mergeSort(der);
    return merge(izq, der);
  }
  
    private static ListaDeEnterosEnlazada merge(ListaDeEnterosEnlazada izq, ListaDeEnterosEnlazada der) {
        der.comenzar();
        izq.comenzar();
        ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada();
        while (!izq.esVacia() && !der.esVacia()) {
          if (izq.elemento(0) < der.elemento(0)) {
            resultado.agregarFinal(izq.elemento(0));
            izq.eliminarEn(0);
          } else {
            resultado.agregarFinal(der.elemento(0));
            der.eliminarEn(0);
          }
        }
        while (!der.esVacia()) {
          resultado.agregarFinal(der.elemento(0));
          der.eliminar(der.elemento(0));
        }
        while (!izq.esVacia()) {
          resultado.agregarFinal(izq.elemento(0));
          izq.eliminar(izq.elemento(0));
        }
        return resultado;
      }
}
