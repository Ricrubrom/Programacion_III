package Practica5.ParteB.Ejercicio3;

import Practica3.Source.ListaGenerica.*;
import Practica5.Source.ArbolGeneral;

public class TRIE {
  private ArbolGeneral<Character> a;
  
  public TRIE() {
    a = new ArbolGeneral<Character>(null);

  }

  public void agregarPalabra(String palabra) {
    ArbolGeneral<Character> arbol = this.a;
    for (int i = 0; i < palabra.length(); i++) {
      char car = palabra.charAt(i);
      System.out.println(car);
      if (arbol.esVacio() || arbol.esHoja()) {
        System.out.println(car+ " es hoja");
        ArbolGeneral<Character> aux = new ArbolGeneral<Character>(car);
        arbol.agregarHijo(aux);
        arbol = aux;
        continue;
      }
      ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
      hijos.comenzar();
      int j = 0;
      while (!hijos.fin()) {
        ArbolGeneral<Character> act = hijos.proximo();
        System.out.println();
        if (act.getDato() >= car) {
          break;
        }
        j++;
      }
      if (hijos.elemento(j)!=null && hijos.elemento(j).getDato() == car) {
        System.out.println("me muevo a " + hijos.elemento(j).getDato());
        arbol = hijos.elemento(j);
      } else {
        System.out.println("agrego " + car);
        ArbolGeneral<Character> aux = new ArbolGeneral<Character>(car);
        hijos.agregarEn(aux, j);
        arbol = hijos.elemento(j);
      }
    }
    
  }

  public void ImprimirPorNiveles() {
    a.ImprimirPorNiveles();
  }
}
