package Practica7.ParteA.Ejercicio7;

import Classes.Grafos.General.*;
import Classes.Listas.ListaGenerica.*;
import java.util.Arrays;

public class Algoritmos<T> {
  public boolean subgrafoCuadrado(Grafo<T> grafo) {
    int cant = grafo.listaDeVertices().tamanio();
    for (int i = 0; i < cant; i++) {
      if (this.subgrafoCuadradoRecursivo(i, grafo, grafo.listaDeVertices().elemento(i), 0))
        return true;
    }
    return false;
  }

  private boolean subgrafoCuadradoRecursivo(int i, Grafo<T> grafo, Vertice<T> origen, int paso) {
    Vertice<T> v = grafo.listaDeVertices().elemento(i);
    if (v == origen && paso == 4)
      return true;
    if (paso > 4)
      return false;
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      int j = ady.proximo().verticeDestino().posicion();
      if (this.subgrafoCuadradoRecursivo(j, grafo, origen, paso + 1))
        return true;
    }
    return false;
  }

  public boolean tieneCiclo(Grafo<T> grafo) {
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i])
        if (this.tieneCicloRecursivo(i, grafo, marca, grafo.listaDeVertices().elemento(i)))
          return true;
    }
    return false;
  }

  private boolean tieneCicloRecursivo(int i, Grafo<T> grafo, boolean[] marca, Vertice<T> origen) {
    marca[i] = true;
    Vertice<T> v = grafo.listaDeVertices().elemento(i);
    if (v == origen)
      return true;
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      int j = ady.proximo().verticeDestino().posicion();
      if (!marca[j]) {
        if (this.tieneCicloRecursivo(j, grafo, marca, origen))
          return true;
      } else
        return true;
    }
    return false;
  }

  public int getGrado(Grafo<T> grafo) {
    int[] aux = new int[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < aux.length; i++) {
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(grafo.listaDeVertices().elemento(i));
      aux[i] += ady.tamanio();
      ady.comenzar();
      while (!ady.fin()) {
        aux[ady.proximo().verticeDestino().posicion()]++;
      }
    }
    return Arrays.stream(aux).max().getAsInt();
  }
}

