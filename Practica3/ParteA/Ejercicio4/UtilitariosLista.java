package Practica3.ParteA.Ejercicio4;

import Practica3.Source.ListaDeEnterosEnlazada;

public class UtilitariosLista {
  public ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada lista) {
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
  
  private ListaDeEnterosEnlazada merge(ListaDeEnterosEnlazada izq, ListaDeEnterosEnlazada der) {
    ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada();
    izq.comenzar();
    der.comenzar();
    while (!izq.fin() && !der.fin()) {
      Integer datoIzq = izq.proximo();
      Integer datoDer = der.proximo();
      if (datoIzq < datoDer) {
        resultado.agregarFinal(datoIzq);
        resultado.agregarFinal(datoDer);
      } else {
        resultado.agregarFinal(datoDer);
        resultado.agregarFinal(datoIzq);
      }
    }
    while (!izq.fin()) {
      resultado.agregarFinal(izq.proximo());
    }
    while (!der.fin()) {
      resultado.agregarFinal(der.proximo());
    }
    return resultado;
  }
}
