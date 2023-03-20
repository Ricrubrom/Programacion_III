package Practica2.ParteA.Ejercicio3;

public class Tablet {
  private String marca;
  private String OS;
  private String modelo;
  private double costo;
  private float pulgadas;
  
  public String getMarca() {
    return marca;
  }
  
  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getOS() {
    return OS;
  }
  
  public void setOS(String oS) {
    OS = oS;
  }
  
  public String getModelo() {
    return modelo;
  }
  
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }
  
  public double getCosto() {
    return costo;
  }
  
  public void setCosto(double costo) {
    this.costo = costo;
  }
  
  public float getPulgadas() {
    return pulgadas;
  }
  
  public void setPulgadas(float pulgadas) {
    this.pulgadas = pulgadas;
  }
  
  public Tablet(String marca, String OS, String modelo, double costo, float pulgadas) {
    this.marca = marca;
    this.OS = OS;
    this.modelo = modelo;
    this.costo = costo;
    this.pulgadas = pulgadas;
  }
  
  public String devolverDatos() {
    return "Marca: " + this.marca + " \nOS: " + this.OS + " \nModelo: " + this.modelo + " \nCosto: " + this.costo + " \nPulgadas: " + this.pulgadas;
    
  }

}
