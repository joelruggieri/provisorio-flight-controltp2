package fiuba.algo3.flightcontrol.modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Helicoptero extends ObjetoVolador {

	public Helicoptero(int velocidad, Nivel unNivel) {
		
		super(velocidad, unNivel);
		List<Vector> listaDePosiciones = new ArrayList<Vector>();
		Vector destinoInicial = generarPrimerDestino(unNivel);
		listaDePosiciones.add(destinoInicial);
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
	
	public void aterrizarSiHayPistaDeAterrizajeCompatible() {
	    	
		Iterator<Pista> it = this.getNivel().getPistas();
	    	
	    while (it.hasNext() && !this.aterrizo()) {
	    		
	    	it.next().recibirAterrizajeDeObjetoVolador(this);
	    }
	    	
	}
	
	private Vector generarPrimerDestino(Nivel unNivel) {
		
		Random generadorDeRandoms = new Random();
		
		int posicionX = generadorDeRandoms.nextInt(unNivel.getLimite());
		int posicionY = generadorDeRandoms.nextInt(unNivel.getLimite());
		
		Vector posicion = new Vector(posicionX, posicionY);
		
		return posicion;
	}
}
