package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

public class AvionComputarizado extends ObjetoVolador {
	
	public AvionComputarizado(int velocidadInicial, int limite, Escenario unPlano, Pista unaPista){
		/* Constructor de una avion Computarizado*/

		super (velocidadInicial, limite, unPlano);
		this.crearTrayectoria(calcularTrayectoriaHaciaUnaPista(unaPista));
	}

	private ArrayList<Posicion> calcularTrayectoriaHaciaUnaPista(Pista unaPista){
		/* Determina una trayectoria de menor distancia hacia una pista */
		
		ArrayList<Posicion> trayectoriaDefinida = new ArrayList<Posicion>();
		
		Posicion posicionPreAterrizaje = ( unaPista.posicionDeEntrada().restar(unaPista.direccionDeEntrada()) );
				
		trayectoriaDefinida.add(posicionPreAterrizaje);
		trayectoriaDefinida.add(unaPista.posicionDeEntrada());
		
		return trayectoriaDefinida;
	}

}
