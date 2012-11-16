package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

public class AvionComputarizado extends ObjetoVolador {
	
	public AvionComputarizado(int nivel, Escenario unPlano, Pista unaPista){
		
		super (nivel, unPlano);
		listaDePosiciones = this.calcularTrayectoriaHaciaUnaPista(unaPista);
		this.trayectoria = new Trayectoria (listaDePosiciones);
	}

	private List <Vector> calcularTrayectoriaHaciaUnaPista(Pista unaPista){
		/* Determina una trayectoria de menor distancia hacia una pista */
		
		List <Vector> trayectoriaDefinida = new ArrayList <Vector>();
		
		Vector posicionPreAterrizaje = ( unaPista.getPosicionDeEntrada().restar(unaPista.getDireccionDeEntrada()) );
				
		trayectoriaDefinida.add(posicionPreAterrizaje);
		trayectoriaDefinida.add(unaPista.getPosicionDeEntrada());
		
		return trayectoriaDefinida;
	}

}
