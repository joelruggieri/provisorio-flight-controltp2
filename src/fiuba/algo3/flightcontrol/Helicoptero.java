package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

public class Helicoptero extends ObjetoVolador{

	public Helicoptero(int nivel,Escenario unPlano){
		
		super (nivel, unPlano);
		listaDePosiciones  = new ArrayList <Vector>();
		this.trayectoria = new Trayectoria (listaDePosiciones);
		
	}
	
	public void mover(){
		/* Mueve el helicoptero siguiendo la trayectoria, y si no hay
		 * trayectoria definida se queda en el lugar */
		/* post: cambia el valor de la posicion actual, 
		 * buscando el movimiento mas optimo posible */
		
		if (this.trayectoria.hayTrayectoria()){
			super.mover();
		}
		
	}
	
}
