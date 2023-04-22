package Practica3.ParteA.Ejercicio2;

import Practica3.ParteA.Ejercicio4.UtilitariosLista;
import Classes.Listas.ListaDeEnteros.*;

public class TestOrdenamientos {
  public static void main(String[] args) {
    ListaDeEnterosEnlazada listaO = new ListaDeEnterosEnlazada();
    listaO.agregarFinal(103);
    listaO.agregarFinal(2);
    listaO.agregarFinal(13123);
    listaO.agregarFinal(1015413);
    listaO.agregarFinal(2541);
    listaO.agregarFinal(151233);
    listaO.agregarFinal(10412453);
    listaO.agregarFinal(2123);
    listaO.agregarFinal(11243);
    listaO.agregarFinal(123103);
    listaO.agregarFinal(5122);
    listaO.agregarFinal(1563243);
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
    ListaDeEnterosEnlazada lista = UtilitariosLista.mergeSort(listaO);
    lista.comenzar();
    while (!lista.fin()) {
      System.out.println(lista.proximo());
    }
  }


  

}

