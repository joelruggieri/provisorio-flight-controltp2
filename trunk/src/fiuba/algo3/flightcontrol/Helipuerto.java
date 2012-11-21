package fiuba.algo3.flightcontrol;
import java.util.List;

public class Helipuerto extends Pista {
	
	public Helipuerto(List<Vector> unasEntradas) {
		
		super(unasEntradas);
	}
	
	public Vector getDireccionDeEntrada() {
		
		throw new NoTieneUnaDireccionDeEntradaException();
	}
	
	public void recibirAterrizajeDeObjetoVolador(AvionSimple simple) {
		
	}
	
	public void recibirAterrizajeDeObjetoVolador(Helicoptero helicoptero) {
		
		if (helicoptero.getPosicion().esIgual(getPosicionDeEntrada())) {
			
			helicoptero.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeObjetoVolador(AvionComputarizado avion) {
	}
	
	
}
