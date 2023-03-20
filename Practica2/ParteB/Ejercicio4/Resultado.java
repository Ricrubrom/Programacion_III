package Practica2.ParteB.Ejercicio4;

public class Resultado {
  float prom;
  int maximo;
  int minimo;

  public Resultado(float prom, int maximo, int minimo) {
    this.prom = prom;
    this.maximo = maximo;
    this.minimo = minimo;
  }

  public float getProm() {
    return prom;
  }

  public int getMaximo() {
    return maximo;
  }

  public int getMinimo() {
    return minimo;
  }

  public void setProm(float prom) {
    this.prom = prom;
  }

  public void setMaximo(int maximo) {
    this.maximo = maximo;
  }
  
  public void setMinimo(int minimo) {
    this.minimo = minimo;
  }

  @Override
  public String toString() {
    return "Resultado [maximo=" + maximo + ", minimo=" + minimo + ", prom=" + prom + "]";
  }
}
