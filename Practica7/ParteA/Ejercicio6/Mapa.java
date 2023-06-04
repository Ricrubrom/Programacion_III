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
    int i = 0;
    for (i = 0; i < marca.length; i++) {
      if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1))
        break;
    }
    if (i < marca.length) {
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
    int i = 0;
    for (i = 0; i < marca.length; i++) {
      if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1))
        break;
    }
    if (i < marca.length)
      devolverCaminoExceptuandoRecursivo(i, mapaCiudades, marca, l, ciudad2, ciudades);
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
    int i = 0;
    for (i = 0; i < marca.length; i++) {
      if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1))
        break;
    }
    if (i < marca.length)
      caminoMasCortoRecursivo(i, mapaCiudades, marca, l, ciudad2);
    return l;
  }

  private ListaGenerica<String> caminoMasCortoRecursivo(int i, Grafo<String> grafo, boolean[] marca,
      ListaGenerica<String> l, String ciudad2) {
    marca[i] = true;
    Vertice<String> v = grafo.listaDeVertices().elemento(i);
    ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<String>();
    if (v.dato().equals(ciudad2)) {
      caminoActual.agregarInicio(v.dato());
      return caminoActual;
    }
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      int j = ady.proximo().verticeDestino().posicion();
      if (!marca[j]) {
        caminoActual = caminoMasCortoRecursivo(j, grafo, marca, l, ciudad2);
        marca[j] = false;
        if (caminoActual!=null&&(caminoActual.tamanio() < l.tamanio() || l.esVacia())) {
          copiarLista(caminoActual, l);
          l.agregarInicio(v.dato());
        }
      }
    }
    return l;
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
    ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
    boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
    int i = 0;
    for (i = 0; i < marca.length; i++) {
      if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1))
        break;
    }
    if (i < marca.length)
      caminoSinCargarCombustibleRecursivo(i, mapaCiudades, marca, l, ciudad2, tanqueAuto);
    return l;
    }

    private boolean caminoSinCargarCombustibleRecursivo(int i, Grafo<String> grafo,boolean[] marca, ListaGenerica<String> l, String ciudad2, int tanqueAuto) {
      marca[i] = true;
      if (tanqueAuto<0)
        return false;
      Vertice<String> v = grafo.listaDeVertices().elemento(i);
      if (v.dato().equals(ciudad2)) {
        l.agregarInicio(v.dato());
        return true;
      }
      ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<String> A = ady.proximo();
        int j = A.verticeDestino().posicion();
        if (!marca[j]) {
          boolean flag = caminoSinCargarCombustibleRecursivo(j, grafo, marca, l, ciudad2, tanqueAuto - A.peso());
          marca[j] = false;
          if (flag) {
            l.agregarInicio(v.dato());
            return flag;
          }
        }
      }
      return false;
  }


  public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int
  tanqueAuto) {
      Resultado<String> aux = new Resultado<String>(new ListaGenericaEnlazada<>(), 0);
      Resultado<String> result = new Resultado<String>(new ListaGenericaEnlazada<>(), 0);
      boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
      int i;
      for (i = 0; i < marca.length; i++) {
          if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
            break;
          }
      }
      if (i < marca.length) { //Si la ciudad1 se encuentra en el grafo
        result.setCant(9999999);
        caminoConMenorCargaDeCombustible(i, mapaCiudades, ciudad2, marca, aux, result, tanqueAuto, tanqueAuto);
      }
      return result.getList();
  }

  private void caminoConMenorCargaDeCombustible(int i, Grafo<String> grafo, String ciudad2, boolean[] marca, Resultado<String> aux, Resultado<String> result, int tanqueAuto, int tanqueAct) {
      Vertice<String> v = grafo.listaDeVertices().elemento(i);
      marca[i] = true;
      aux.getList().agregarFinal(v.dato());
      if (v.dato().equals(ciudad2)) {
        if (aux.getCant() < result.getCant()) {
          result.copyList(aux.getList());
          result.setCant(aux.getCant());
        }
        return;
      }
      ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<String> a = ady.proximo();         
        int j = a.verticeDestino().posicion();
        if (!marca[j]) {
          if (tanqueAct - a.peso() <= 0) {
            if (a.peso() > tanqueAuto)
              continue;
            aux.setCant(aux.getCant() + 1);
            caminoConMenorCargaDeCombustible(j, grafo, ciudad2, marca, aux, result, tanqueAuto, tanqueAuto - a.peso());
            aux.setCant(aux.getCant() - 1);
          }
          else
            caminoConMenorCargaDeCombustible(j, grafo, ciudad2, marca, aux, result, tanqueAuto, tanqueAct  - a.peso());
          marca[j] = false;
          aux.getList().eliminarEn(aux.getList().tamanio() - 1);
        }
      }
    }
}