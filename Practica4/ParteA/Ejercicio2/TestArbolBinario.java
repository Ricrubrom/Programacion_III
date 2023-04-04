package Practica4.ParteA.Ejercicio2;

import Practica4.Source.ArbolBinario;
import Practica3.Source.ListaGenerica.*;

public class TestArbolBinario {
  public static void main(String[] args) {
    ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);
    ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
    hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
    hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
    ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
    hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
    hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
    arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
    arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

    System.out.print("Preorden: ");
    arbolBinarioB.printPreorden();
    System.out.println();
    System.out.print("Inorden: ");
    arbolBinarioB.printInorden();
    System.out.println();
    System.out.print("Postorden: ");
    arbolBinarioB.printPostorden();
    System.out.println();
    System.out.println("hojas: "+arbolBinarioB.contarHojas());
    System.out.println();
    System.out.println(arbolBinarioB.frontera());
    System.out.println();
    ListaGenerica<Integer> lista = new ListaGenericaEnlazada<Integer>();
    System.out.println(arbolBinarioB.frontera(lista));
    System.out.println();
    System.out.println(arbolBinarioB.esLleno());
    System.out.println();
    System.out.println(arbolBinarioB.esCompleto());
    /*System.out.println("Por niveles: ");
    arbolBinarioB.recorridoPorNiveles();*/
  }
}