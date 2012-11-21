package fiuba.algo3.flightcontrol;
import java.util.List;

public class Helipuerto extends Pista {
	
	public Helipuerto(List<Vector> unasEntradas) {
		
		super(unasEntradas);
	}
	
	public Vector getDireccionDeEntrada() {
		
		throw new NoTieneUnaDireccionDeEntradaException();
	}
	
	public void recibirAterrizajeDeAvionSimple(AvionSimple simple) {
		
	}
	
	public void recibirAterrizajeDeHelicoptero(Helicoptero helicoptero) {
		
		if (helicoptero.getPosicion().esIgual(getPosicionDeEntrada())) {
			
			helicoptero.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeComputarizado(AvionComputarizado avion) {
	}
	
	
}
