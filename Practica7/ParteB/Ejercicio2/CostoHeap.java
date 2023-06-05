package Practica7.ParteB.Ejercicio2;

public class CostoHeap implements Comparable<CostoHeap> {
  private int min;
  private int pos;

  public CostoHeap() {
    this.min = Integer.MAX_VALUE;
    this.pos = 0;
  }

  public CostoHeap(int pos, int min) {
    this.min = min;
    this.pos = pos;
  }

  public int getMin() {
    return min;
  }

  public int getPos() {
    return pos;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public void setPos(int pos) {
    this.pos = pos;
  }

  @Override
  public String toString() {
    return ("Costo minimo: " + min + ".\nVertice pos: " + pos);
  }

  @Override
  public int compareTo(CostoHeap otro) {
    return Integer.compare(min, otro.getMin());
  }
}
