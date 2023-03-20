package Practica2.ParteB.Ejercicio1;

public abstract class Mobile {
  private String marca;
  private String OS;
  private String modelo;
  private double costo;
  
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

  
  public Mobile(String marca, String OS, String modelo, double costo) {
    this.marca = marca;
    this.OS = OS;
    this.modelo = modelo;
    this.costo = costo;
  }
  
  public String toString() {
    return "Marca: " + this.marca + " \nOS: " + this.OS + " \nModelo: " + this.modelo + " \nCosto: " + this.costo;

  }

  public abstract boolean equals(Mobile mobile);
}
