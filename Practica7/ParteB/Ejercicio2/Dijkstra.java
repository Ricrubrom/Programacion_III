package Practica7.ParteB.Ejercicio2;

import Classes.Grafos.General.Arista;
import Classes.Grafos.General.Grafo;
import Classes.Grafos.General.Vertice;
import Classes.Listas.ListaGenerica.ListaGenerica;
import java.util.PriorityQueue;

public class Dijkstra<T> {
  public Costo[] dijkstraSinHeap(Grafo<T> grafo, Vertice<T> v) {
    if (!grafo.listaDeVertices().incluye(v)) {
      return null;
    }
    int length = grafo.listaDeVertices().tamanio();
    Costo costos[] = new Costo[length];
    boolean[] marca = new boolean[length];
    for (int i = 0; i < costos.length; i++) {
      costos[i] = new Costo();
    }
    ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
    costos[v.posicion()].setMin(0);
    for (int i = 0; i < length; i++) {
      int j = minimo(costos, marca);
      if (j == -1)
        break;
      Vertice<T> vertice = vertices.elemento(j);
      marca[j] = true;
      ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
      adyacentes.comenzar();
      while (!adyacentes.fin()) {
        Arista<T> arista = adyacentes.proximo();
        int posDestino = arista.verticeDestino().posicion();
        int costo = costos[j].getMin() + arista.peso();
        if (costos[posDestino].getMin() > costo) {
          costos[posDestino].setMin(costo);
          costos[posDestino].setPrevio(j);
        }
      }
    }
    return costos;
  }
  

  public Costo[] dijkstraConHeap(Grafo<T> grafo, Vertice<T> v) {
    if (!grafo.listaDeVertices().incluye(v)) {
      return null;
    }
    int length = grafo.listaDeVertices().tamanio();
    Costo costos[] = new Costo[length];
    PriorityQueue<CostoHeap> heap = new PriorityQueue<CostoHeap>();
    boolean[] marca = new boolean[length];
    for (int i = 0; i < costos.length; i++) {
      costos[i] = new Costo();
    }
    ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
    costos[v.posicion()].setMin(0);
    heap.offer(new CostoHeap(v.posicion(), 0));
    while(!heap.isEmpty()) {
      CostoHeap actual = heap.poll();
      if (actual.getPos() == -1)
        continue;
      Vertice<T> vertice = vertices.elemento(actual.getPos());
      marca[actual.getPos()] = true;
      ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
      adyacentes.comenzar();
      while (!adyacentes.fin()) {
        Arista<T> arista = adyacentes.proximo();
        int posDestino = arista.verticeDestino().posicion();
        int costo = costos[actual.getPos()].getMin() + arista.peso();
        if (costos[posDestino].getMin() > costo) {
          costos[posDestino].setMin(costo);
          costos[posDestino].setPrevio(actual.getPos());
          heap.offer(new CostoHeap(posDestino, costos[posDestino].getMin()));
        }
      }
    }
    return costos;
  }

  private int minimo(Costo[] costos, boolean[] marca) {
    int min = Integer.MAX_VALUE;
    int minPos = -1;
    for (int i = 0; i < costos.length; i++) {
      if (!marca[i] && costos[i].getMin() < min) {
        min = costos[i].getMin();
        minPos = i;
      }
    }
    return minPos;
  }
}
