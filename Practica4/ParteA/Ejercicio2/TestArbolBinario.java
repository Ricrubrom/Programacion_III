package Practica4.ParteA.Ejercicio2;

import Practica4.Source.ArbolBinario;
import Practica3.Source.ListaGenerica.*;
import Practica4.ParteB.Ejercicio1_2y4.Utiles;
import Practica4.ParteB.Ejercicio3y5.Adivinanza;

public class TestArbolBinario {
  public static void main(String[] args) {
    ArbolBinario<Integer> arbolBinario=new ArbolBinario<Integer>(1);
    ArbolBinario<Integer> hijoIzquierdo=new ArbolBinario<Integer>(2);
    hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
    hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(4));
    ArbolBinario<Integer> hijoDerecho=new ArbolBinario<Integer>(6);
    hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
    hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(8));
    arbolBinario.agregarHijoIzquierdo(hijoIzquierdo);
    arbolBinario.agregarHijoDerecho(hijoDerecho);

    System.out.print("Preorden: ");
    arbolBinario.printPreorden();
    System.out.println();
    System.out.print("Inorden: ");
    arbolBinario.printInorden();
    System.out.println();
    System.out.print("Postorden: ");
    arbolBinario.printPostorden();
    System.out.println();
    System.out.println("hojas: "+arbolBinario.contarHojas());
    System.out.println();
    System.out.println(arbolBinario.frontera());
    System.out.println();
    ListaGenerica<Integer> lista = new ListaGenericaEnlazada<Integer>();
    System.out.println(arbolBinario.frontera(lista));
    System.out.println();
    System.out.println(arbolBinario.esLleno());
    System.out.println();
    System.out.println(arbolBinario.esCompleto());
    System.out.println();
    System.out.println(Utiles.sumaMaximaVertical(arbolBinario, 0));
    System.out.println();
    System.out.println(Utiles.sumaMaximaHorizontal(arbolBinario));
    System.out.println();

    // ----- arbolBinarioB -----
    ArbolBinario<String> arbolBinarioB;
		arbolBinarioB = new ArbolBinario<String>("¿Tiene 4 patas?");
		ArbolBinario<String> hijoIzquierdoB = new ArbolBinario<String>("¿Se mueve?");
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<String>("Es una mesa"));
		ArbolBinario<String> hhijoIzquierdoB = new ArbolBinario<String>("¿Ladra?");
		hhijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<String>("Es un perro"));
		hhijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<String>("Es un gato"));
		hijoIzquierdoB.agregarHijoIzquierdo(hhijoIzquierdoB);
    arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoIzquierdoB);



    System.out.println(Adivinanza.secuenciaConMasPreguntas(arbolBinarioB));
    System.out.println();
    System.out.println(Utiles.trayectoriaPesada(arbolBinario));
    System.out.println();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> listaCaminos = new ListaGenericaEnlazada<>();
    listaCaminos = Adivinanza.secuenciaConMasPreguntas2(arbolBinarioB);
    
		for (int i = 0; i < listaCaminos.tamanio(); i++) {
			System.out.println(listaCaminos.elemento(i).toString());
		}

  }
}