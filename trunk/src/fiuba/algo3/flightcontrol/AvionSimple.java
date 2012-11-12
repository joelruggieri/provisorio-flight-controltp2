package fiuba.algo3.flightcontrol;

import java.util.ArrayList;

public class AvionSimple extends ObjetoVolador {	
	
	public AvionSimple(int velocidadInicial, int limite, Escenario unPlano){
		/* Constructor de una avion simle */
		super (velocidadInicial, limite, unPlano);
		
		
	}
	
	
	//public void moverse() {
		/* Mueve el objeto volador siguiendo la trayectoria o en el sentido de la direccion si no hay trayectoria definida */
		/* post: cambia el valor de la posicion actual, buscando el movimiento mas optimo posible */
		
		/*if (siguientePosicion == null){
			
			System.out.println("ACA ESTRA SI NO EXISTE TRAYECTORIA PREDEFINIDA");
			
			direccion = this.getDireccion();
			posicionLimite = direccion.multiplicar(this.plano.getDimension());
			
			trayectoriaNueva = new ArrayList <Posicion> ();
			trayectoriaNueva.add(posicionLimite);
			
			this.crearTrayectoria(trayectoriaNueva);
	
		}
		this.plano.posicionQuedaVacio(posicionActual);
		
		if (this.trayectoria.getProximaPosicion(posicionActual) == null){
			
			this.posicionActual = this.posicionActual.sumar(this.direccion);
			
		}else{
			
			this.trayectoria.getProximaPosicion(posicionActual);
			
		}
		
			this.plano.posicionOcupadaPor(posicionActual, "objetoVolador");
		}*/
	
}

