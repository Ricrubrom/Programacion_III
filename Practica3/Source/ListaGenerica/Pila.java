package Practica3.Source.ListaGenerica;

public class Pila<T>{
  private ListaGenericaEnlazada<T> pila;

  public Pila() {
    pila = new ListaGenericaEnlazada<T>();
  }

  public void apilar(T dato) {
    pila.agregarInicio(dato);
  }

  public T desapilar() {
    T dato = pila.elemento(0);
    pila.eliminarEn(0);
    return dato;
  }

  public T tope() {
    return pila.elemento(0);
  }

  public boolean esVacia() {
    return pila.esVacia();
  }
}
