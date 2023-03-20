package Practica2.ParteB.Ejercicio4;

public class PruebaRetorno {
  public static void main(String[] args) {
    int[] arreglo = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    System.out.println(procesarArreglo1(arreglo));
    Resultado res = procesarArreglo2(arreglo);
    System.out.println(res);
  }
  
  public static String procesarArreglo1(int[] arreglo) {
    float total = 0;
    int cant = 0, maximo = 0, minimo = 999999999;
    for (int i : arreglo) {
      total += i;
      cant++;
      if (i > maximo) {
        maximo = i;
      }
      if (i < minimo) {
        minimo = i;
      }
    }
    float prom = total / cant;
    return "El promedio es: " + prom + " El maximo es: " + maximo + " El minimo es: " + minimo;
  }
  
  public static Resultado procesarArreglo2(int[] arreglo) {
    float total = 0;
    int cant = 0, maximo = 0, minimo = 999999999;
    for (int i : arreglo) {
      total += i;
      cant++;
      if (i > maximo) {
        maximo = i;
      }
      if (i < minimo) {
        minimo = i;
      }
    }
    float prom = total / cant;
    Resultado res = new Resultado(prom, maximo, minimo);
    return res;
  }
}
