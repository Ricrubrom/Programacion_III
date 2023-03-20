package Practica2.ParteB.Ejercicio5;

public class TestDeFigurasGeometricas {
  public static void main(String[] args) {
    Figura[] figuras = new Figura[3];
    figuras[0] = new Circulo("Naranja", false, 2.0);
    figuras[1] = new Rectangulo("Amarillo",true,2.0, 3.0);
    figuras[2] = new Rectangulo("Anasheee",true,4.0, 4.0);
    for (Figura figura : figuras) {
      System.out.println("Area: " + figura.getArea());
      System.out.println("Perimetro: " + figura.getPerimetro()+"\n");
      }
    }
}
