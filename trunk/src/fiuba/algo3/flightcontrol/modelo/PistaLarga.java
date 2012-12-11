package fiuba.algo3.flightcontrol.modelo;
import java.util.List;

public class PistaLarga extends Pista {
	
	public PistaLarga(List<Vector> unasEntradas) {
				
		super(unasEntradas);
	}
	
	public void recibirAterrizajeDeObjetoVolador(AvionPesado pesado) {
		
		boolean posicionesIguales, direccionesIguales;
		Vector miEntrada, miPosicion;
		final int tamano = 20;
		double distancia;
		
		miPosicion = this.getPosicionDeEntrada();
		miEntrada = this.getDireccionDeEntrada();
		
		distancia = pesado.getPosicion().distancia(miPosicion);
		
		posicionesIguales = distancia <= tamano;
		direccionesIguales = pesado.getDireccion().equals(miEntrada);
		
		if (posicionesIguales && direccionesIguales) {
			pesado.aterrizar();

		}
		
	}
}


