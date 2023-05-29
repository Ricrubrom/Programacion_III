package Practica7.ParteA.Ejercicio6;

import Classes.Grafos.General.Grafo;
import Classes.Grafos.General.Vertice;
import Classes.Grafos.Lista.GrafoImplListAdy;
import Classes.Grafos.Lista.VerticeImplListAdy;
import Classes.Listas.ListaGenerica.ListaGenerica;

public class MapaPrueba {
  public static void main(String[] args) {
    Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
    Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
    Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
    Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
    Vertice<String> v5 = new VerticeImplListAdy<String>("Asunsion");
    Vertice<String> v6 = new VerticeImplListAdy<String>("La Habana");
    Vertice<String> v7 = new VerticeImplListAdy<String>("Caracas");

    Grafo<String> ciudades = new GrafoImplListAdy<String>();
    ciudades.agregarVertice(v1);
    ciudades.agregarVertice(v2);
    ciudades.agregarVertice(v3);
    ciudades.agregarVertice(v4);
    ciudades.agregarVertice(v5);
    ciudades.agregarVertice(v6);
    ciudades.agregarVertice(v7);
    ciudades.conectar(v1, v2, 3);
    ciudades.conectar(v1, v3, 2);
    ciudades.conectar(v1, v4, 4);
    ciudades.conectar(v1, v5, 8);
    ciudades.conectar(v2, v5, 500);
    ciudades.conectar(v3, v5, 88);
    ciudades.conectar(v4, v5, 9);
    ciudades.conectar(v2, v6, 4);
    ciudades.conectar(v7, v5, 11);
    ciudades.conectar(v7, v6, 10);

    Mapa M = new Mapa(ciudades);
    ListaGenerica<String> l = M.devolverCamino("Buenos Aires", "Asunsion");
    System.out.println(l.toString());

    l.eliminar("Buenos Aires");
    l.eliminar("Asunsion");
    ListaGenerica<String> l2 = M.devolverCaminoExceptuando("Buenos Aires", "Asunsion", l);
    System.out.println(l2.toString());

    ListaGenerica<String> l3 = M.caminoMasCorto("Buenos Aires", "Asunsion");
    System.out.println(l3.toString());

    /*ListaGenerica<String> l4 = M.caminoSinCargarCombustible("Buenos Aires", "Asunsion", 10);
    System.out.println(l4.toString());

    ListaGenerica<String> l5 = M.caminoConMenorCargaDeCombustible("Buenos Aires", "Asunsion", 10);
    System.out.println(l5.toString());*/
  }
}
