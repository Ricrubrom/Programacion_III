package Practica7.ParteA.Ejercicio9;

import Classes.Grafos.General.Arista;
import Classes.Grafos.General.Grafo;
import Classes.Grafos.General.Vertice;
import Classes.Listas.ListaGenerica.ListaGenerica;
import Classes.Listas.ListaGenerica.ListaGenericaEnlazada;

public class GuiaDeTurismo {
  public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen,
      String puntoInteresDestino) {
    ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    int i = 0;
    for (i = 0; i < marca.length; i++) {
      if (grafo.listaDeVertices().elemento(i).dato().equals(puntoInteresOrigen))
        break;
    }
    ListaGenerica<String> aux = new ListaGenericaEnlazada<String>();
    int min=9999;
    int [] max = new int[1];
    if (i < marca.length)
      caminoConMenorNrodeViajesRecursivo(i, grafo, marca, l, aux, puntoInteresDestino, min, max);
    return l;
  }
  
  private void caminoConMenorNrodeViajesRecursivo(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> result,
      ListaGenerica<String> aux, String puntoInteresDestino, int min, int[] max) {
    marca[i] = true;
    Vertice<String> v = grafo.listaDeVertices().elemento(i);
    aux.agregarFinal(v.dato());
    if (v.dato().equals(puntoInteresDestino)) {
      if (max[0] < min) {
        max[0] = min;
        copiarLista(aux, result);
      }
      return;
    }
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      Arista<String> A = ady.proximo();
      int j = A.verticeDestino().posicion();
      if (!marca[j]) {
        if (A.peso() <= min)
          min = A.peso();
        caminoConMenorNrodeViajesRecursivo(j, grafo, marca, result, aux, puntoInteresDestino, min, max);
        marca[j] = false;
        aux.eliminarEn(aux.tamanio() - 1);
      }
    }
  }

  private void copiarLista(ListaGenerica<String> caminoActual, ListaGenerica<String> camino) {
    while(!camino.esVacia()) {
      camino.eliminarEn(0);
    }
    caminoActual.comenzar();
    while (!caminoActual.fin()) {
      camino.agregarFinal(caminoActual.proximo());
    }
  }
}
