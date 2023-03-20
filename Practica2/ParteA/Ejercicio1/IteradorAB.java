package Practica2.ParteA.Ejercicio1;

public class IteradorAB {
  public static void main(String[] args) {
    iteracionConFor(3, 5);
    iteracionConWhile(2, 5);
    Recursivo(3, 5);

  }
  
  public static void iteracionConFor(int a, int b) {
    for (int i = a; i <= b; i++)
      System.out.println(i);
  }
  
  
  public static void iteracionConWhile(int a, int b) {
    while (a <= b) {
      System.out.println(a);
      a++;
    }
  }
  
  public static void Recursivo(int a, int b) {
    if (a <= b) {
      System.out.println(a);
      Recursivo(a + 1, b);
    }
    return;
  }
}
