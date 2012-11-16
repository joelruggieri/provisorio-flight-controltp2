package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class AvionComputarizadoTest extends TestCase {

	private AvionComputarizado unAvionComputarizado;
	private int nivel,limite;
	private Escenario escenario;
	private Vector destino;
	
	List<Vector> posicionesDeLaPista;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		nivel = 1;
		limite = 768;
		escenario = new Escenario (limite);
				
	}
	
	private void moverAvion (ObjetoVolador unAvion){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una posicion */
		/* post: El avion se movio */
		
		while ( unAvion.hayTrayectoria()){
			unAvion.mover();
		}
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaHorizontalDeIzquierdaADerecha(){
	
		//arrange
		destino = new Vector(4,3);
		Vector posicionDePista = new Vector(5,3);
		List<Vector> posicionesDeLaPista = new ArrayList<Vector>();
		posicionesDeLaPista.add(destino);
		posicionesDeLaPista.add(posicionDePista);
		
		PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
		unAvionComputarizado = new AvionComputarizado (nivel,escenario, unaPista);
		
		//act
		this.moverAvion(unAvionComputarizado);
		
		unaPista.recibirAterrizajeDeAvionComputarizado (unAvionComputarizado);
		
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaHorizontalDeDerechaAIzquierda(){
		
		//arrange
		destino = new Vector(4,3);
		Vector posicionDeLaPista = new Vector(3,3);
		List<Vector> posicionesDePista = new ArrayList<Vector>();
		posicionesDePista.add(destino);
		posicionesDePista.add(posicionDeLaPista);
		
		PistaSimple unaPista = new PistaSimple(escenario, posicionesDePista);
		unAvionComputarizado = new AvionComputarizado (nivel,escenario, unaPista);
			
		//act
		this.moverAvion(unAvionComputarizado);
		unaPista.recibirAterrizajeDeAvionComputarizado(unAvionComputarizado);
			
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaDiagonalDelNorOesteHaciaSurEste(){
		
		//arrange
		destino = new Vector(4,4);
		Vector posicionDeLaPista = new Vector(5,5);
		List<Vector> posicionesDePista = new ArrayList<Vector>();
		posicionesDePista.add(destino);
		posicionesDePista.add(posicionDeLaPista);
		
		PistaSimple unaPista = new PistaSimple(escenario, posicionesDePista);
		unAvionComputarizado = new AvionComputarizado (nivel,escenario, unaPista);
			
		//act
		this.moverAvion(unAvionComputarizado);
		unaPista.recibirAterrizajeDeAvionComputarizado(unAvionComputarizado);
			
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaDiagonalDelNorEsteHaciaSurOeste(){
		
		//arrange
		destino = new Vector(4,4);
		Vector posicionDeLaPista = new Vector(5,3);
		List<Vector> posicionesDePista = new ArrayList<Vector>();
		posicionesDePista.add(destino);
		posicionesDePista.add(posicionDeLaPista);
		
		PistaSimple unaPista = new PistaSimple(escenario, posicionesDePista);
		unAvionComputarizado = new AvionComputarizado (nivel,escenario, unaPista);
			
		//act
		this.moverAvion(unAvionComputarizado);
		unaPista.recibirAterrizajeDeAvionComputarizado(unAvionComputarizado);
			
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaDiagonalDelSurOesteHaciaNorEste(){
		
		//arrange
		destino = new Vector(4,4);
		Vector posicionDeLaPista = new Vector(3,5);
		List<Vector> posicionesDePista = new ArrayList<Vector>();
		posicionesDePista.add(destino);
		posicionesDePista.add(posicionDeLaPista);
		
		PistaSimple unaPista = new PistaSimple(escenario, posicionesDePista);
		unAvionComputarizado = new AvionComputarizado (nivel,escenario, unaPista);
			
		//act
		this.moverAvion(unAvionComputarizado);
		unaPista.recibirAterrizajeDeAvionComputarizado(unAvionComputarizado);
			
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaDiagonalDelSurEsteHaciaNorOeste(){
		
		//arrange
		destino = new Vector(4,4);
		Vector posicionDeLaPista = new Vector(3,3);
		List<Vector> posicionesDePista = new ArrayList<Vector>();
		posicionesDePista.add(destino);
		posicionesDePista.add(posicionDeLaPista);
		
		PistaSimple unaPista = new PistaSimple(escenario, posicionesDePista);
		unAvionComputarizado = new AvionComputarizado (nivel,escenario, unaPista);
			
		//act
		this.moverAvion(unAvionComputarizado);
		unaPista.recibirAterrizajeDeAvionComputarizado(unAvionComputarizado);
			
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaVerticalDeArribaAAbajo(){
		
		//arrange
		destino = new Vector(4,4);
		Vector posicionDeLaPista = new Vector(4,5);
		List<Vector> posicionesDePista = new ArrayList<Vector>();
		posicionesDePista.add(destino);
		posicionesDePista.add(posicionDeLaPista);
		
		PistaSimple unaPista = new PistaSimple(escenario, posicionesDePista);
		unAvionComputarizado = new AvionComputarizado (nivel,escenario, unaPista);
			
		//act
		this.moverAvion(unAvionComputarizado);
		unaPista.recibirAterrizajeDeAvionComputarizado(unAvionComputarizado);
			
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaVerticalDeAbajoAArriba(){
		
		//arrange
		destino = new Vector(4,5);
		Vector posicionDeLaPista = new Vector(4,4);
		List<Vector> posicionesDePista = new ArrayList<Vector>();
		posicionesDePista.add(destino);
		posicionesDePista.add(posicionDeLaPista);
		
		PistaSimple unaPista = new PistaSimple(escenario, posicionesDePista);
		unAvionComputarizado = new AvionComputarizado (nivel,escenario, unaPista);
			
		//act
		this.moverAvion(unAvionComputarizado);
		unaPista.recibirAterrizajeDeAvionComputarizado(unAvionComputarizado);
			
		//assert
		assertTrue(unAvionComputarizado.aterrizo());
	}
}
