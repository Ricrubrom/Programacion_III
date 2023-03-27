package Practica3.ParteA.Ejercicio2;

import Practica3.Source.ListaDeEnterosEnlazada;
import Practica3.ParteA.Ejercicio4.UtilitariosLista;

public class TestOrdenamientos {
  public static void main(String[] args) {
    ListaDeEnterosEnlazada listaO = new ListaDeEnterosEnlazada();
    listaO.agregarFinal(103);
    listaO.agregarFinal(2);
    listaO.agregarFinal(13);
    listaO.comenzar();
    /*listaO = listaO.ordenar();
    ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
    lista.agregarFinal(12);
    lista.agregarFinal(223);
    lista.agregarFinal(15);
    lista.agregarFinal(5);
    lista.agregarFinal(328);
    lista.agregarFinal(47);
    lista.comenzar();
    lista=lista.ordenar();
    ListaDeEnterosEnlazada listaFinal = lista.combinarOrdenado(listaO);
    listaFinal.comenzar();
    while (!listaFinal.fin()) {
      System.out.println(listaFinal.proximo());
    }*/
    UtilitariosLista util = new UtilitariosLista();
    ListaDeEnterosEnlazada lista = util.mergeSort(listaO);
    lista.comenzar();
    while (!lista.fin()) {
      System.out.println(lista.proximo());
    }
  }


  

}

