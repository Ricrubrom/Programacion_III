package Practica5.Source;

import Practica3.Source.ListaGenerica.*;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	public int altura() {
		int lvl = 0;
		int max = Integer.MIN_VALUE;
		if (!this.tieneHijos()) {
			return lvl;
		}
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		while (!hijos.fin()) {
			lvl = hijos.proximo().altura() + 1;
			if (lvl > max) {
				max = lvl;
			}
		}
		if (max > lvl)
			return max;
		else
			return lvl;
	}

	public boolean include(T dato){
		boolean flag=false;
		if (this.getDato() == dato) {
			return true;
		}
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin() && !flag) {
				flag = hijos.proximo().include(dato);
			}
		}
		return flag;
	}

	public int nivel(T dato) {
		int lvl=-1;
		if (this.getDato() == dato) {
			return lvl+1;
		}
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				lvl = hijos.proximo().nivel(dato);
				if (lvl > -1) {
					return lvl + 1;
				}
			}
		}
		return lvl;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

}