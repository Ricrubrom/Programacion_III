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
      if (arbol.esVacio() || arbol.esHoja()) {
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
        if (act.getDato() >= car) {
          break;
        }
        j++;
      }
      if (hijos.elemento(j) != null && hijos.elemento(j).getDato() == car) {
        arbol = hijos.elemento(j);
      } else {
        ArbolGeneral<Character> aux = new ArbolGeneral<Character>(car);
        hijos.agregarEn(aux, j);
        arbol = hijos.elemento(j);
      }
    }
    
  }
  

  /*public ListaGenerica<StringBuilder> palabrasQueEmpiezanCon(String prefijo) {
    ListaGenerica<StringBuilder> lista = new ListaGenericaEnlazada<StringBuilder>();
    ArbolGeneral<Character> arbol = this.a;
    StringBuilder aux = new StringBuilder();
    aux.append(prefijo);
    for (int i = 0; i < prefijo.length(); i++) {
      char car = prefijo.charAt(i);
      ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
      hijos.comenzar();
      int j = 0;
      while (!hijos.fin()) {
        ArbolGeneral<Character> act = hijos.proximo();
        if (act.getDato() >= car) {
          break;
        }
        j++;
      }
      if (hijos.elemento(j) != null && hijos.elemento(j).getDato() == car) {
        arbol = hijos.elemento(j);
      } else {
        return null;
      }
    }
  
    Pila<ArbolGeneral<Character>> pila = new Pila<>();
    ListaGenerica<ArbolGeneral<Character>> h = arbol.getHijos();
    h.comenzar();
    while (!h.fin()) {
      pila.apilar(h.proximo());
    }
    int i = 0;
    while (!pila.esVacia()) {
      ArbolGeneral<Character> act = pila.desapilar();
      while (!act.esHoja()) {
        ListaGenerica<ArbolGeneral<Character>> hijos = act.getHijos();
        hijos.comenzar();
        if (hijos.tamanio() > 1) {
          hijos.comenzar();
          while (!hijos.fin())
            pila.apilar(hijos.proximo());
        }
        if (lista.elemento(i) == null)
          lista.agregarFinal(aux.append(act.getDato()));
        else
          lista.elemento(i).append(act.getDato());
        act = hijos.proximo();
      }
      lista.elemento(i).append(act.getDato());
      i++;
    }
  
    return lista;
  }*/

  public ListaGenerica<StringBuilder> palabrasQueEmpiezanCon(String prefijo) {
    ListaGenerica<StringBuilder> lista = new ListaGenericaEnlazada<StringBuilder>();
    ArbolGeneral<Character> arbol = this.a;
    for (int i = 0; i < prefijo.length(); i++) {
        char car = prefijo.charAt(i);
        ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
        hijos.comenzar();
        int j = 0;
        while (!hijos.fin()) {
            ArbolGeneral<Character> act = hijos.proximo();
            if (act.getDato() >= car) {
                break;
            }
            j++;
        }
        if (hijos.elemento(j) != null && hijos.elemento(j).getDato() == car) {
            arbol = hijos.elemento(j);
        } else {
            return null;
        }
    }

    StringBuilder palabra = new StringBuilder(prefijo);
    recorrerArbol(arbol, palabra, lista);
    return lista;
}

private void recorrerArbol(ArbolGeneral<Character> nodo, StringBuilder palabra, ListaGenerica<StringBuilder> lista) {
    if (nodo.esHoja()) {
        lista.agregarFinal(new StringBuilder(palabra));
        return;
    }
    ListaGenerica<ArbolGeneral<Character>> hijos = nodo.getHijos();
    hijos.comenzar();
    while (!hijos.fin()) {
        ArbolGeneral<Character> hijo = hijos.proximo();
        palabra.append(hijo.getDato());
        recorrerArbol(hijo, palabra, lista);
        palabra.deleteCharAt(palabra.length() - 1);
    }
}

  public void ImprimirPorNiveles() {
    a.ImprimirPorNiveles();
  }
}
