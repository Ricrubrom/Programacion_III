package Practica7.ParteA.Ejercicio8;

import Classes.Grafos.General.Arista;
import Classes.Grafos.General.Grafo;
import Classes.Grafos.General.Vertice;
import Classes.Listas.ListaGenerica.ListaGenerica;

public class Delta {
  public int maxIslasDistintas(Grafo<String> grafo) {
    int aux, max = -1;
    Vertice<String> v = grafo.listaDeVertices().elemento(0); //Muelle principal
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    marca[0] = true;
    grafo.listaDeAdyacentes(v).comenzar();
    while (!grafo.listaDeAdyacentes(v).fin()) {
      aux = maxIslasDistintas(grafo.listaDeAdyacentes(v).proximo().verticeDestino().posicion(), grafo, marca); //Le paso la primera isla de cada camino a partir del muelle
      if (aux > max)
        max = aux;
    }
    return max;
  }

  private int maxIslasDistintas(int i, Grafo<String> grafo, boolean[] marca) {
    marca[i] = true;
    int cant = 0;
    Vertice<String> v = grafo.listaDeVertices().elemento(i);
    cant++; //Sumo por cada vertice visitado
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      int j = ady.proximo().verticeDestino().posicion();
      if (!marca[j]) {
        cant += maxIslasDistintas(j, grafo, marca);
      }
    }
    return cant;
  }

  public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) {
    RutaMinima l = new RutaMinima();
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    int i = 0;
    for (i = 0; i < marca.length; i++) {
      if (grafo.listaDeVertices().elemento(i).dato().equals(islaO))
        break;
    }
    RutaMinima aux = new RutaMinima();
    if (i < marca.length)
      caminoMasCortoRecursivo(i, grafo, marca, l, aux, islaD);
    return l;
  }

  private RutaMinima caminoMasCortoRecursivo(int i, Grafo<String> grafo, boolean[] marca,
      RutaMinima result, RutaMinima aux, String islaD) {
    marca[i] = true;
    Vertice<String> v = grafo.listaDeVertices().elemento(i);
    aux.agregarFinal(v.dato());
    if (v.dato().equals(grafo.listaDeVertices().elemento(0).dato())) {
      aux.nuevoBoleto();
    }
    if (v.dato().equals(islaD)) {
      if (aux.getCamino().tamanio() < result.getCamino().tamanio() || result.getCamino().esVacia()) {
        result.copyList(aux.getCamino());
        result.setNuevoBoleto(aux.isNuevoBoleto());
      }
    }
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      int j = ady.proximo().verticeDestino().posicion();
      if (!marca[j]) {
        aux = caminoMasCortoRecursivo(j, grafo, marca, result, aux, islaD);
        marca[j] = false;
        aux.getCamino().eliminarEn(aux.getCamino().tamanio() - 1);
      }
    }
    return aux;
  }
}