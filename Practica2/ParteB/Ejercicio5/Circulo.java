package Practica2.ParteB.Ejercicio5;

public class Circulo extends Figura{
  private double radio;
  
  public Circulo(String color, boolean relleno, double radio) {
    super(color, relleno);
    this.radio = radio;
  }
  
  public double getRadio() {
    return radio;
  }
  
  public void setRadio(double radio) {
    this.radio = radio;
  }
  
  public double getArea() {
    return Math.PI * Math.pow(radio, 2);
  }
  
  public double getPerimetro() {
    return 2 * Math.PI * radio;
  }
  
  public String toString() {
    return "Circulo: " + super.toString() + " \nRadio: " + this.radio;
  }
}
