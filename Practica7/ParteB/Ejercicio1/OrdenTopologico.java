package Practica7.ParteB.Ejercicio1;

import Classes.Grafos.General.Arista;
import Classes.Grafos.General.Grafo;
import Classes.Grafos.General.Vertice;
import Classes.Listas.ListaGenerica.ListaGenerica;
import Classes.Listas.ListaGenerica.ListaGenericaEnlazada;

public class OrdenTopologico<T> {  //O(|V|+|E|)
  public ListaGenerica<Vertice<T>> ordenTopologico(Grafo<T> grafo) {
    ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i]) {
        ordenTopologicoRecursivo(grafo.listaDeVertices().elemento(i), grafo, marca, lista);
      }
    }
    return lista;
  }
  
  private void ordenTopologicoRecursivo(Vertice<T> v, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> lista) {
    marca[v.posicion()] = true;
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      Vertice<T> w = ady.proximo().verticeDestino();
      if (!marca[w.posicion()]) {
        ordenTopologicoRecursivo(w, grafo, marca, lista);
      }
    }
    lista.agregarInicio(v);
  }
}
