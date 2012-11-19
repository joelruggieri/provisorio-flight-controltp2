package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

public class AvionComputarizado extends ObjetoVolador {
	
	public AvionComputarizado(int nivel, Escenario plano, Pista pista) {
		
		super(nivel, plano);
		List<Vector> listaDePuntos;
		listaDePuntos = calcularTrayectoriaHaciaUnaPista(pista);
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
