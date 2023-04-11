package Practica5.ParteB;

import Practica5.Source.*;
import Practica3.Source.ListaGenerica.*;

public class Empresa {
  private ArbolGeneral<Empleado> empleados;


  public Empresa(ArbolGeneral<Empleado> empleados) {
    this.empleados = empleados;
  }

  public ArbolGeneral<Empleado> getEmpleados() {
    return empleados;
  }

  public void setEmpleados(ArbolGeneral<Empleado> empleados) {
    this.empleados = empleados;
  }

  public int empleadosPorCategoria(int categoria) {
    int cant = 0;
    int categoriaActual = 1;
		ArbolGeneral<Empleado> arbol = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(this.getEmpleados());
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
      if (arbol != null) {
				cant++;
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> l = arbol.getHijos();
					l.comenzar();
					while (!l.fin()) {
						cola.encolar(l.proximo());
					}
				}
			} 
			else if (!cola.esVacia()) {
        cola.encolar(null);
        if (categoriaActual == categoria) {
          return cant;
        }
        categoriaActual++;
				cant = 0;
			}
		}
		return cant; //Solo ocurre si no hay empleados en la categoria/Categoria erronea
  }
  
  public int categoriaConMasEmpleados() {
    int cant = 0;
    int max = Integer.MIN_VALUE;
    int maxCategoria =1;
    int categoriaActual = 1;
		ArbolGeneral<Empleado> arbol = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(this.getEmpleados());
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
      if (arbol != null) {
				cant++;
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> l = arbol.getHijos();
					l.comenzar();
					while (!l.fin()) {
						cola.encolar(l.proximo());
					}
				}
			} 
			else if (!cola.esVacia()) {
        cola.encolar(null);
        if (max < cant) {
          max = cant;
          maxCategoria = categoriaActual;
        }
        categoriaActual++;
				cant = 0;
			}
		}
		return maxCategoria;
  }

  public int cantidadTotalDeEmpleados() {
    int cant = 0;
		ArbolGeneral<Empleado> arbol = null;
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(this.getEmpleados());
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
				cant++;
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Empleado>> l = arbol.getHijos();
					l.comenzar();
					while (!l.fin()) {
						cola.encolar(l.proximo());
					}
				}
		}
		return cant;
  }

  public void reemplazarPresidente() {
    ArbolGeneral<Empleado> arbol = this.empleados;
    while (arbol != null) {
      ListaGenerica<ArbolGeneral<Empleado>> l = arbol.getHijos();
      l.comenzar();
      ArbolGeneral<Empleado> e = l.proximo();
      while (!l.fin()) {
        ArbolGeneral<Empleado> e2 = l.proximo();
        if (e.getDato().getAntiguedad() < e2.getDato().getAntiguedad()) {
          e = e2;
        }
      }
      arbol.setDato(e.getDato());
      if (e.esHoja()) {
        arbol.eliminarHijo(e);;
        break;
      }
      arbol = e;
    }
  }
}
