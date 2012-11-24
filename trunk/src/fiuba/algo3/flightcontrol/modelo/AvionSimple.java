package fiuba.algo3.flightcontrol.modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvionSimple extends ObjetoVolador {	
		
	public AvionSimple(int velocidad, Nivel unNivel) {
		
		super(velocidad, unNivel);
		List<Vector> listaDePosiciones = new ArrayList<Vector>();
		this.setTrayectoria(new Trayectoria(listaDePosiciones));
		
	}
	
	public void vivir() {
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
	
    public void aterrizarSiHayPistaDeAterrizajeCompatible() {
    	
    	Iterator<Pista> it = this.getNivel().getPistas();
    	
    	while (it.hasNext() && !this.aterrizo()) {
    		
    		it.next().recibirAterrizajeDeObjetoVolador(this);
    	}
    	
    }
		
}
