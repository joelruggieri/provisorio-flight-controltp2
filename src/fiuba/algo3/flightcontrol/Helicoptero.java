package fiuba.algo3.flightcontrol;

import java.util.ArrayList;

public class Helicoptero extends ObjetoVolador{

	public Helicoptero(int velocidadInicial,int limite,Escenario unPlano){
		/* Constructor de una avion simple */
		super (velocidadInicial, limite, unPlano);
		listaDePosiciones  = new ArrayList<Posicion>();
		this.crearTrayectoria (listaDePosiciones);
		
		
	}
	
	public void moverse(){
		/* Mueve el objeto volador siguiendo la trayectoria, y si no hay trayectoria definida se queda en el lugar */
		/* post: cambia el valor de la posicion actual, buscando el movimiento mas optimo posible */
		if (this.trayectoria.hayTrayectoria()){
			super.moverse();
		}
		
	}
	
}
