package fiuba.algo3.flightcontrol;

import java.util.ArrayList;

public class AvionSimple extends ObjetoVolador {	
	
	
	
	public AvionSimple(int velocidadInicial, int limite, Escenario unPlano){
		/* Constructor de una avion simple */
		super (velocidadInicial, limite, unPlano);
		listaDePosiciones  = new ArrayList<Posicion>();
		this.crearTrayectoria (listaDePosiciones);
		
	}
	
	public void moverse() {
		/* Mueve el objeto volador siguiendo la trayectoria o en el sentido de la direccion si no hay trayectoria definida */
		/* post: cambia el valor de la posicion actual, buscando el movimiento mas optimo posible */
		
		if (!this.trayectoria.hayTrayectoria()){
					
			direccion = this.getDireccion();
			Posicion posicionSiguiente = direccion.sumar(this.posicionActual);
			
			listaDePosiciones = new ArrayList <Posicion> ();
			listaDePosiciones.add(posicionSiguiente);
			
			this.crearTrayectoria(listaDePosiciones);
	
		}
		
		super.moverse();
	}
		
	
}

