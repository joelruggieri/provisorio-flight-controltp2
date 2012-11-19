package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

public class AvionComputarizado extends ObjetoVolador {
	
	public AvionComputarizado(int velocidad, Nivel unNivel) {
		
		super(velocidad, unNivel);
		List<Vector> listaDePuntos;
		
		Vector posicionDePista1 = new Vector(4,3);  //todo esto es hardcodeado, el tema que falta el iterador de pistas para conseguir
		Vector posicionDePista2 = new Vector(5,3);   // una pista del iterador
		List<Vector> posicionesDeLaPista = new ArrayList<Vector>();  //
		posicionesDeLaPista.add(posicionDePista1);  // 
		posicionesDeLaPista.add(posicionDePista2);  // 
		Pista unaPista = new PistaSimple (posicionesDeLaPista);  //
		
		listaDePuntos = calcularTrayectoriaHaciaUnaPista(unaPista);
		this.setTrayectoria(new Trayectoria(listaDePuntos));
	}

	private List<Vector> calcularTrayectoriaHaciaUnaPista(Pista unaPista) {
		/* Determina una trayectoria de menor 
		 * distancia hacia una pista */
		
		List<Vector> trayectoriaDefinida = new ArrayList<Vector>();
		
		Vector posicionDeEntrada = unaPista.getPosicionDeEntrada();
		Vector direccionDeEntrada = unaPista.getDireccionDeEntrada();
		
		Vector posPreAterrizaje;
		posPreAterrizaje = posicionDeEntrada.restar(direccionDeEntrada);
				
		trayectoriaDefinida.add(posPreAterrizaje);
		trayectoriaDefinida.add(unaPista.getPosicionDeEntrada());
		
		return trayectoriaDefinida;
	}

}
