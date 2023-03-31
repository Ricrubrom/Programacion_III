package Practica3.ParteB.Ejercicio4;

import Practica3.Source.ListaGenerica.Pila;

public class TestBalanceo {
  public static void main(String[] args) {
    String cadena = "[()]";
    System.out.println(balanceo(cadena));
  }
  
  
  
  public static boolean balanceo(String cadena) {
    Pila<Character> pila = new Pila<Character>();
    for (int i = 0; i < cadena.length(); i++) {
      char car = cadena.charAt(i);
      if ((car == '(') || (car == '{') || (car == '['))
        pila.apilar(car);
      else if ((car == ')') || (car == '}') || (car == ']')) {
        if (pila.esVacia()) {
          return false;
        }
        char dato = pila.desapilar();
        if (!((car == ')' && (dato == '(')) || ((car == '}') && (dato == '{')) || ((car == ']') && (dato == '['))))
          return false;
      }
    }
    return true;
  }
}
