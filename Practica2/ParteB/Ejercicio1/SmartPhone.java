package Practica2.ParteB.Ejercicio1;

public class SmartPhone extends Mobile{
  int numero;

  public SmartPhone(String marca, String OS, String modelo, double costo, int numero) {
    super(marca, OS, modelo, costo);
    this.numero = numero;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }
  
  public boolean equals(Mobile dispositivo) {
    if ((dispositivo != null) && (dispositivo instanceof SmartPhone)) {
      SmartPhone sp = (SmartPhone) dispositivo;
      if ((sp.getModelo() == this.getModelo()) && (sp.getMarca() == this.getMarca())&&(sp.getNumero() == this.getNumero()))
        return true;
      else
        return false;
    } else
      return false;
  }
  
  
  @Override
  public String toString() {
    return super.toString() + " \nNumero: " + this.numero;
  }


}
