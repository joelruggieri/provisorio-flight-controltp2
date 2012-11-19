package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

public class AvionSimple extends ObjetoVolador {	
		
	public AvionSimple(int nivel, Escenario unPlano) {
		
		super(nivel, unPlano);
		List<Vector> listaDePosiciones = new ArrayList<Vector>();
		this.setTrayectoria(new Trayectoria(listaDePosiciones));
		
	}
	
	public void mover() {
		/* Mueve el avion simple siguiendo la trayectoria o en el 
		 * sentido de la direccion si no hay trayectoria definida */
		/* post: cambia el valor de la posicion actual, buscando el
		 * movimiento mas optimo posible */
		
		if (!this.getTrayectoria().hayTrayectoria()) {
					
			Vector direccion = this.getDireccion();
			Vector posicionSiguiente; 
			posicionSiguiente = direccion.sumar(this.getPosicion());
			
			List<Vector> listaDePuntos = new ArrayList<Vector>();
			listaDePuntos.add(posicionSiguiente);
			
			this.setTrayectoria(new Trayectoria(listaDePuntos));
		}
		
		super.vivir();
	}
		
}
