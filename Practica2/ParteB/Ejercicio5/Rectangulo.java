package Practica2.ParteB.Ejercicio5;

public class Rectangulo extends Figura {
  private double ancho;
  private double largo;
  
  public Rectangulo(String color, boolean relleno, double ancho, double largo) {
    super(color, relleno);
    this.ancho = ancho;
    this.largo = largo;
  }
  
  public double getAncho() {
    return ancho;
  }
  
  public void setAncho(double ancho) {
    this.ancho = ancho;
  }
  
  public double getLargo() {
    return largo;
  }
  
  public void setLargo(double largo) {
    this.largo = largo;
  }
  
  public double getArea() {
    return ancho * largo;
  }
  
  public double getPerimetro() {
    return 2 * (ancho + largo);
  }
  
  public String toString() {
    return "Rectangulo: " + super.toString() + " \nAncho: " + this.ancho + " \nLargo: " + this.largo;
  }
}
