package fiuba.algo3.flightcontrol;
import java.util.List;

public class PistaLarga extends Pista {
	
	public PistaLarga(Escenario unPlano, List<Vector> unasEntradas) {
				
		super(unPlano, unasEntradas);
	}
	
	public void recibirAterrizajeDeAvionPesado(AvionPesado pesado) {
		
		boolean posicionesIguales, direccionesIguales;
		Vector miEntrada, miPosicion;
		
		miPosicion = this.getPosicionDeEntrada();
		miEntrada = this.getDireccionDeEntrada();
		
		posicionesIguales = pesado.getPosicion().esIgual(miPosicion);
		direccionesIguales = pesado.getDireccion().esIgual(miEntrada);
		
		if (posicionesIguales && direccionesIguales) {
			pesado.aterrizar();
		}
		
	}
}


