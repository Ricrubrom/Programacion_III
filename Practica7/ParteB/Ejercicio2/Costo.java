package Practica7.ParteB.Ejercicio2;

public class Costo implements Comparable<Costo> {
  private int min;
  private int previo;

  public Costo() {
    this.min = Integer.MAX_VALUE;
    this.previo = 0;
  }

  public int getMin() {
    return min;
  }

  public int getPrevio() {
    return previo;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public void setPrevio(int previo) {
    this.previo = previo;
  }

  @Override
  public String toString() {
    return ("Costo minimo: " + min + ".\nVertice previo: " + previo);
  }

  @Override
  public int compareTo(Costo otro) {
    return Integer.compare(min, otro.getMin());
  }
}
