package Practica1.Ejercicio2;

public class Multiplos {
  public static void main(String[] args) {
    int[] res = getMultiplos(10);
    for (int i : res) {
      System.out.println(i);
    }
  }
  
  public static int[] getMultiplos(int n) {
    int[] res=new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = n * (i + 1);
    }
    return res;
  }

}

