package Practica7.ParteA.Ejercicio6;

import Classes.Listas.ListaGenerica.ListaGenerica;
import Classes.Listas.ListaGenerica.ListaGenericaEnlazada;

public class Resultado<T> {
  private ListaGenerica<T> list;
  private int cant;

  public Resultado(ListaGenerica<T> list, int cant) {
    this.list = list;
    this.cant = cant;
  }
  
  public Resultado() {
    this.list = new ListaGenericaEnlazada<>();
    this.cant = 0;
  }

  public ListaGenerica<T> getList() {
    return list;
  }

  public int getCant() {
    return cant;
  }

  public void setList(ListaGenerica<T> list) {
    this.list = list;
  }

  public void setCant(int cant) {
    this.cant = cant;
  }

  public void copyList(ListaGenerica<T> list){
    this.list = new ListaGenericaEnlazada<T>();
    list.comenzar();
    while (!list.fin()) {
      this.list.agregarFinal(list.proximo());
    }
  }
}