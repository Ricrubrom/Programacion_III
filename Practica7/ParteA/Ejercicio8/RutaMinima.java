package Practica7.ParteA.Ejercicio8;

import Classes.Listas.ListaGenerica.*;

public class RutaMinima {
  private boolean nuevoBoleto;
  private ListaGenerica<String> camino;


  public RutaMinima() {
    nuevoBoleto = false;
    camino = new ListaGenericaEnlazada<String>();
  }
  
  public void nuevoBoleto() {
    nuevoBoleto = true;
  }

  public ListaGenerica<String> getCamino() {
    return camino;
  }

  public boolean isNuevoBoleto() {
    return nuevoBoleto;
  }

  public void setCamino(ListaGenerica<String> camino) {
    this.camino = camino;
  }

  public void setNuevoBoleto(boolean nuevoBoleto) {
    this.nuevoBoleto = nuevoBoleto;
  }

  public void agregarInicio(String ciudad) {
    camino.agregarInicio(ciudad);
  }

  public void agregarFinal(String ciudad) {
    camino.agregarFinal(ciudad);
  }

  public boolean esRutaMinima(ListaGenerica<String> camino) {
    return this.camino.tamanio() < camino.tamanio();
  }

  public void copyList(ListaGenerica<String> camino){
    this.camino = new ListaGenericaEnlazada<String>();
    camino.comenzar();
    while (!camino.fin()) {
      this.camino.agregarFinal(camino.proximo());
    }
  }
}
