package Practica2.ParteA.Ejercicio4;

import java.util.Scanner;

public class Multiplos {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      System.out.print("Ingrese el numero de multiplos que desea obtener: ");
      int n = in.nextInt();
      int[] res = getMultiplos(n);
      for (int i : res) {
        System.out.println(i);
      }
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

