package fiuba.algo3.flightcontrol.modelo;
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
		
		final int radio = 20;
		double distancia;
		Vector posDeHelicoptero;
		
		posDeHelicoptero = helicoptero.getPosicion();
		distancia = posDeHelicoptero.distancia(getPosicionDeEntrada());
		
		if (distancia <= radio) {
			
			helicoptero.aterrizar();

		}	
	}
	
	public void recibirAterrizajeDeObjetoVolador(AvionComputarizado avion) {
	}
	
}
