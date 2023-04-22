package Practica4.ParteB.Ejercicio3y5;

import Classes.Arboles.ArbolBinario;
import Classes.Listas.ListaGenerica.*;

public class Adivinanza {
  public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) {
    ListaGenericaEnlazada<String> izq= new ListaGenericaEnlazada<String>();
    ListaGenericaEnlazada<String> der= new ListaGenericaEnlazada<String>();
    if (abinario.esHoja()) {
      ListaGenericaEnlazada<String> res = new ListaGenericaEnlazada<String>();
      res.agregarInicio(abinario.getDato());
      return res;
    }
    if (abinario.tieneHijoIzquierdo()) {
      izq = secuenciaConMasPreguntas(abinario.getHijoIzquierdo());
    }
    if (abinario.tieneHijoDerecho()) {
      der = secuenciaConMasPreguntas(abinario.getHijoDerecho());
    }
    if (izq.tamanio() >= der.tamanio()) {
      izq.agregarInicio("Si");
      izq.agregarInicio(abinario.getDato());
      return izq;
    } else {
      der.agregarInicio("No");
      der.agregarInicio(abinario.getDato());
      return der;
    }
  }



  public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntas2(ArbolBinario<String> abinario) {
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> izq = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> der = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> res = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    if (abinario.esHoja()) {
      ListaGenericaEnlazada<String> res1 = new ListaGenericaEnlazada<String>();
      res1.agregarInicio(abinario.getDato());
      res.agregarInicio(res1);
      return res;
    }
    if (abinario.tieneHijoIzquierdo()) {
      izq = secuenciaConMasPreguntas2(abinario.getHijoIzquierdo());
    }
    if (abinario.tieneHijoDerecho()) {
      der = secuenciaConMasPreguntas2(abinario.getHijoDerecho());
    }
    izq.comenzar();
    der.comenzar();
    if ((izq.elemento(0)!=null && der.elemento(0)!=null) && (izq.elemento(0).tamanio() > der.elemento(0).tamanio())) {
      int i = 0;
      while (izq.elemento(i)!=null) {
        izq.elemento(i).agregarInicio("Si");
        izq.elemento(i).agregarInicio(abinario.getDato());
        i++;
      }
      return izq;
    } else if ((izq.elemento(0)!=null && der.elemento(0)!=null) && (izq.elemento(0).tamanio() < der.elemento(0).tamanio())){
        int i = 0;
        while (der.elemento(i)!=null) {
          der.elemento(i).agregarInicio("Si");
          der.elemento(i).agregarInicio(abinario.getDato());
          i++;
        }
        return der;
      } else {
        int i = 0;
        while (izq.elemento(i) != null) {
          izq.elemento(i).agregarInicio("Si");
          izq.elemento(i).agregarInicio(abinario.getDato());
          res.agregarFinal(izq.elemento(i));
          i++;
        }
        i = 0;
        while (der.elemento(i)!=null) {
          der.elemento(i).agregarInicio("Si");
          der.elemento(i).agregarInicio(abinario.getDato());
          res.agregarFinal(der.elemento(i));
          i++;
        }
      return res;
    }
  }
}
