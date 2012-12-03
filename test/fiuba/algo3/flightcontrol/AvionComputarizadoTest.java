package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.flightcontrol.modelo.AvionComputarizado;
import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;

public class AvionComputarizadoTest extends TestCase {

	private AvionComputarizado unAvionComputarizado;
	private int velocidad,limite;
	private Nivel unNivel;
	private Vector destino;
	
	List<Vector> posicionesDeLaPista;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		velocidad = 10;
		limite = 768;
		unNivel = new Nivel(velocidad, limite);
				
	}
	
	private void moverAvion (AvionComputarizado unAvion){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una posicion */
		/* post: El avion se movio */
		
		while ( unAvion.hayTrayectoria()){
			unAvion.vivir();
		}
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEncualquieraDeLasPistasValidas(){
	
		//arrange

		unAvionComputarizado = new AvionComputarizado (velocidad, unNivel);
		
		//act
		this.moverAvion(unAvionComputarizado);
		
		
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
	
}

