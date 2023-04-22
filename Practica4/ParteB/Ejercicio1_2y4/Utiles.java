package Practica4.ParteB.Ejercicio1_2y4;

import Classes.Arboles.ArbolBinario;
import Classes.Listas.ListaGenerica.*;
import Classes.Listas.Cola;

public class Utiles {
  public static int sumaMaximaVertical(ArbolBinario<Integer> a, int suma) {
    int izq = 0, der = 0;
    if (a.esHoja()) {
      return a.getDato();
    }
    if (a.tieneHijoIzquierdo()) {
      izq += sumaMaximaVertical(a.getHijoIzquierdo(), izq);
    }
    if (a.tieneHijoDerecho()) {
      der += sumaMaximaVertical(a.getHijoDerecho(), der);
    }
    suma = Math.max(izq, der) + a.getDato();
    return suma;
  }

  public static int sumaMaximaHorizontal(ArbolBinario<Integer> a) {
    ArbolBinario<Integer> arbol = null;
    int suma = 0, max = -1;
    Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
    cola.encolar(a);
    cola.encolar(null);
    while (!cola.esVacia()) {
      arbol = cola.desencolar();
      if (arbol != null) {
        suma += arbol.getDato();
        if (arbol.tieneHijoIzquierdo()) {
          cola.encolar(arbol.getHijoIzquierdo());
        }
        if (arbol.tieneHijoDerecho()) {
          cola.encolar(arbol.getHijoDerecho());
        }
      } else if (!cola.esVacia()) {
        if (suma > max) {
          max = suma;
        }
        suma = 0;
        cola.encolar(null);
      } else {
        if (suma > max) {
          max = suma;
        }
      }
    }
    return max;
  }


  public static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> a) {
    ListaGenericaEnlazada<Integer> l = trayectoriaPesadaRecorrido(a, 0);
    return l;
  }

  public static ListaGenericaEnlazada<Integer> trayectoriaPesadaRecorrido(ArbolBinario<Integer> a, int lvl) {
    if (a.esHoja()) {
      ListaGenericaEnlazada<Integer> res = new ListaGenericaEnlazada<Integer>();
      res.agregarInicio(a.getDato() * lvl);
      return res;
    }
    ListaGenericaEnlazada<Integer> res = new ListaGenericaEnlazada<Integer>();
    ListaGenericaEnlazada<Integer> izq=new ListaGenericaEnlazada<Integer>();
    ListaGenericaEnlazada<Integer> der=new ListaGenericaEnlazada<Integer>();
    if (a.tieneHijoIzquierdo()){
      izq = trayectoriaPesadaRecorrido(a.getHijoIzquierdo(), lvl+1);
    }
    if (a.tieneHijoDerecho()) {
      der = trayectoriaPesadaRecorrido(a.getHijoDerecho(), lvl+1);
    }
    izq.comenzar();
    der.comenzar();
    while (!izq.fin()) {
      res.agregarFinal(izq.proximo() + a.getDato() * lvl);
    }
    while (!der.fin()) {
      res.agregarFinal(der.proximo() + a.getDato() * lvl);
    }
    return res;
  }
}