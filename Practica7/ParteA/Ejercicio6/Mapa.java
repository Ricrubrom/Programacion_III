package Practica7.ParteA.Ejercicio6;

import Classes.Grafos.General.Arista;
import Classes.Grafos.General.Grafo;
import Classes.Grafos.General.Vertice;
import Classes.Listas.ListaGenerica.ListaGenerica;
import Classes.Listas.ListaGenerica.ListaGenericaEnlazada;

public class Mapa {
  private Grafo<String> mapaCiudades;
  
  public Mapa(Grafo<String> mapa) {
    mapaCiudades = mapa;
  }

  public Mapa() {
    
  }



  public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
    ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
    boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i])
        devolverCaminoRecursivo(i, mapaCiudades, marca, l, ciudad2);
    }
    return l;
  }
  
  private boolean devolverCaminoRecursivo(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> l, String ciudad2) {
    marca[i] = true;
    Vertice<String> v = grafo.listaDeVertices().elemento(i);
    if (v.dato() == ciudad2) {
      l.agregarInicio(v.dato());
      return true;
    }
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      int j = ady.proximo().verticeDestino().posicion();
      if (!marca[j]) {
        if (devolverCaminoRecursivo(j, grafo, marca, l, ciudad2)) {
          l.agregarInicio(v.dato());
          return true;
        }
      }
    }
    return false;
  }

  
  public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
    ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
    boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i])
        devolverCaminoExceptuandoRecursivo(i, mapaCiudades, marca, l, ciudad2, ciudades);
    }
    return l;
  }
  
  private Boolean devolverCaminoExceptuandoRecursivo(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> l, String ciudad2, ListaGenerica<String> ciudades) {
    marca[i] = true;
    Vertice<String> v = grafo.listaDeVertices().elemento(i);
    if (ciudades.incluye(v.dato())) {
      return false;
    }
    if (v.dato() == ciudad2) {
      l.agregarInicio(v.dato());
      return true;
    }
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      int j = ady.proximo().verticeDestino().posicion();
      if (!marca[j]) {
        if (devolverCaminoExceptuandoRecursivo(j, grafo, marca, l, ciudad2, ciudades)) {
          l.agregarInicio(v.dato());
          return true;
        }
      }
    }
    return false;
  }
  

  public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
    ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
    boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i])
        caminoMasCortoRecursivo(i, mapaCiudades, marca, l, ciudad2);
    }
    return l;
  }

  private ListaGenerica<String> caminoMasCortoRecursivo(int i, Grafo<String> grafo, boolean[] marca,
      ListaGenerica<String> l, String ciudad2) {
    marca[i] = true;
    Vertice<String> v = grafo.listaDeVertices().elemento(i);
    ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
    if (v.dato() == ciudad2) {
      caminoActual.agregarInicio(v.dato());
      return caminoActual;
    }
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      int j = ady.proximo().verticeDestino().posicion();
      if (!marca[j]) {
        caminoActual = caminoMasCortoRecursivo(j, grafo, marca, l, ciudad2);
        if (caminoActual!=null&&(caminoActual.tamanio() < l.tamanio() || l.esVacia())) {
          copiarLista(caminoActual, l);
          l.agregarInicio(v.dato());
        }
      }
    }
    return null;
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
  
  public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int
  tanqueAuto) {
    return null;
  }
  
  public ListaGenerica<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int
  tanqueAuto) {
    return null;
  }
}
