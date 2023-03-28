package Practica3.Source.ListaGenerica;

public class Pila<T>{
  private ListaGenericaEnlazada<T> lista;

  public Pila() {
    lista = new ListaGenericaEnlazada<T>();
  }

  public void apilar(T dato) {
    lista.agregarInicio(dato);
  }

  public T desapilar() {
    T dato = lista.elemento(0);
    lista.eliminarEn(0);
    return dato;
  }

  public T tope() {
    return lista.elemento(0);
  }

  public boolean esVacia() {
    return lista.esVacia();
  }
}
