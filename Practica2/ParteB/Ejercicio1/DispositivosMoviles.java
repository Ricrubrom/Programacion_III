package Practica2.ParteB.Ejercicio1;

public class DispositivosMoviles {
  public static void main(String[] args) {
    SmartPhone sp1 = new SmartPhone("Samsung", "Android", "Galaxy S10", 1000, 123456789);
    SmartPhone sp2 = new SmartPhone("Samsung", "Android", "Galaxy S10", 1000, 123456789);

    if (sp1.equals(sp2))
      System.out.println("Los dispositivos son iguales");
    else
      System.out.println("Los dispositivos son diferentes");
    System.out.println(sp1);
    System.out.println("\n" + sp2);
    
  }
}
