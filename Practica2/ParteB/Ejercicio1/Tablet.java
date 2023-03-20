package Practica2.ParteB.Ejercicio1;

public class Tablet extends Mobile{
  int pulgadas;

  public Tablet(String marca, String OS, String modelo, double costo, int pulgadas) {
    super(marca, OS, modelo, costo);
    this.pulgadas = pulgadas;
  }

  public int getPulgadas() {
    return pulgadas;
  }

  public void setPulgadas(int pulgadas) {
    this.pulgadas = pulgadas;
  }

  public boolean equals(Mobile dispositivo) {
    if ((dispositivo != null) && (dispositivo instanceof Tablet)) {
      Tablet t = (Tablet) dispositivo;
      if ((t.getModelo() == this.getModelo()) && (t.getMarca() == this.getMarca())&&(t.getPulgadas() == this.getPulgadas()))
        return true;
      else
        return false;
    } else
      return false;
  }
  
  @Override
  public String toString() {
    return super.toString() + " \nPulgadas: " + this.pulgadas;
  }
}
