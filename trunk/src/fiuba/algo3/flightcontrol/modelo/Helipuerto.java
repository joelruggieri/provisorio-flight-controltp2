package fiuba.algo3.flightcontrol.modelo;
import java.util.List;

public class Helipuerto extends Pista {
	
	public Helipuerto(List<Vector> unasEntradas) {
		
		super(unasEntradas);
	}
	
	//public Vector getDireccionDeEntrada() {
		
	//	throw new NoTieneUnaDireccionDeEntradaException();
//	}
	
	public void recibirAterrizajeDeObjetoVolador(AvionSimple simple) {
		
	}
	
	public void recibirAterrizajeDeObjetoVolador(Helicoptero helicoptero) {
		
		if (helicoptero.getPosicion().esIgual(getPosicionDeEntrada())) {
			
			helicoptero.aterrizar();
			this.setChanged();
			this.notifyObservers(helicoptero);
		}
		
	}
	
	public void recibirAterrizajeDeObjetoVolador(AvionComputarizado avion) {
	}
	
	
}
