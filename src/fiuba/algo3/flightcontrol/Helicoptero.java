package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helicoptero extends ObjetoVolador {

	public Helicoptero(int velocidad, Nivel unNivel) {
		
		super(velocidad, unNivel);
		List<Vector> listaDePosiciones = new ArrayList<Vector>();
		this.setTrayectoria(new Trayectoria(listaDePosiciones));
		
	}
	
	public void vivir() {
		/* Mueve el helicoptero siguiendo la trayectoria, y si no hay
		 * trayectoria definida se queda en el lugar */
		/* post: cambia el valor de la posicion actual, 
		 * buscando el movimiento mas optimo posible */
		
		if (this.getTrayectoria().hayTrayectoria()) {
			super.vivir();
		}
	}
	
	protected void aterrizarSiHayPistaDeAterrizajeCompatible(){
	    	
		Iterator< Pista > it = this.nivel.getPistas();
	    	
	    while (it.hasNext() && !this.aterrizo()){
	    		
	    	it.next().recibirAterrizajeDeObjetoVolador(this);
	    }
	    	
	}
}
