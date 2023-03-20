package Practica2.ParteA.Ejercicio3;

public class TestTablet {
  public static void main(String[] args) {
    Tablet[] t = new Tablet[3]; 
    Tablet t1 = new Tablet("Asus", "Android", "ZenPad", 3000, 10);
    t[0]=t1;
    t1 = new Tablet("Samsung", "Android", "Galaxy Tab", 5000, 8);
    t[1]=t1;
    t1 = new Tablet("Apple", "iOS", "iPad", 10000, 12);
    t[2] = t1;
    for (Tablet tablet : t) {
      System.out.println(tablet.devolverDatos()+"\n");
    }
  }
}
