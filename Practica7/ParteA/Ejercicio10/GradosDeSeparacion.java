package Practica7.ParteA.Ejercicio10;

import Classes.Grafos.General.Arista;
import Classes.Grafos.General.Grafo;
import Classes.Grafos.General.Vertice;
import Classes.Listas.Cola;
import Classes.Listas.ListaGenerica.ListaGenerica;

public class GradosDeSeparacion {
  public int maximoGradoDeSeparacion(Grafo<String> grafo) {
    int cant = -1;
    int aux = 0;
    for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
      aux = this.maximoGradoDeSeparacion(i, grafo);
      if (aux > cant)
        cant = aux;
    }
    return cant;
    }
    
    private int maximoGradoDeSeparacion(int i, Grafo<String> grafo) {
      ListaGenerica<Arista<String>> ady = null;
      boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
      Cola<Vertice<String>> cola = new Cola<Vertice<String>>();
      cola.encolar(grafo.listaDeVertices().elemento(i));
      cola.encolar(null);
      marca[i] = true;
      int aux = 0;
      while (!cola.esVacia()) {
        Vertice<String> V = cola.desencolar();
        if(V==null){
          if (!cola.esVacia()) {
            aux++;
            cola.encolar(null);
          }
          continue;
        }
        System.out.println(V.dato());
        ady = grafo.listaDeAdyacentes(V);
        ady.comenzar();
        while (!ady.fin()) {
          Arista<String> arista = ady.proximo();
          int j = arista.verticeDestino().posicion();
          if (!marca[j]) {
            marca[j] = true;
            cola.encolar(arista.verticeDestino());
          }
        }
      }
      return aux;
    }
}
