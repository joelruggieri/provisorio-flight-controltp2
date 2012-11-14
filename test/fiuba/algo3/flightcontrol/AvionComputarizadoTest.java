package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;

public class AvionComputarizadoTest extends TestCase {

	private AvionComputarizado unAvionComputarizado;
	private int velocidad,limite;
	private Escenario escenario;
	private Posicion destino;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		velocidad = 1;
		limite = 768;
		escenario = new Escenario (limite);
		
	}
	
	private void moverAvion (ObjetoVolador unAvion, Posicion destino){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una posicion */
		/* post: El avion se movio */
		
		while (!unAvion.getPosicion().equals(destino) || unAvion.hayTrayectoria()){
			unAvion.moverse();
		}
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaHorizontalDeIzquierdaADerecha(){
		//arrange
			destino = new Posicion(4,3);
			Posicion posicionDePista = new Posicion(5,3);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			posicionesDeLaPista.add(destino);
			posicionesDeLaPista.add(posicionDePista);
			
			PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
			unAvionComputarizado = new AvionComputarizado (velocidad,limite,escenario, unaPista);
			
		//act
			this.moverAvion(unAvionComputarizado,destino);
			
			unaPista.llegadaDeAvionComputarizado(unAvionComputarizado);
			
		//assert
			assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaHorizontalDeDerechaAIzquierda(){
		//arrange
			destino = new Posicion(4,3);
			Posicion posicionDePista = new Posicion(3,3);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			posicionesDeLaPista.add(destino);
			posicionesDeLaPista.add(posicionDePista);
			
			PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
			unAvionComputarizado = new AvionComputarizado (velocidad,limite,escenario, unaPista);
			
		//act
			this.moverAvion(unAvionComputarizado,destino);
			
			unaPista.llegadaDeAvionComputarizado(unAvionComputarizado);
			
		//assert
			assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaDiagonalDelNorOesteHaciaSurEste(){
		//arrange
			destino = new Posicion(4,4);
			Posicion posicionDePista = new Posicion(5,5);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			posicionesDeLaPista.add(destino);
			posicionesDeLaPista.add(posicionDePista);
			
			PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
			unAvionComputarizado = new AvionComputarizado (velocidad,limite,escenario, unaPista);
			
		//act
			this.moverAvion(unAvionComputarizado,destino);
			
			unaPista.llegadaDeAvionComputarizado(unAvionComputarizado);
			
		//assert
			assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaDiagonalDelNorEsteHaciaSurOeste(){
		//arrange
			destino = new Posicion(4,4);
			Posicion posicionDePista = new Posicion(5,3);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			posicionesDeLaPista.add(destino);
			posicionesDeLaPista.add(posicionDePista);
			
			PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
			unAvionComputarizado = new AvionComputarizado (velocidad,limite,escenario, unaPista);
			
		//act
			this.moverAvion(unAvionComputarizado,destino);
			
			unaPista.llegadaDeAvionComputarizado(unAvionComputarizado);
			
		//assert
			assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaDiagonalDelSurOesteHaciaNorEste(){
		//arrange
			destino = new Posicion(4,4);
			Posicion posicionDePista = new Posicion(3,5);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			posicionesDeLaPista.add(destino);
			posicionesDeLaPista.add(posicionDePista);
			
			PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
			unAvionComputarizado = new AvionComputarizado (velocidad,limite,escenario, unaPista);
			
		//act
			this.moverAvion(unAvionComputarizado,destino);
			
			unaPista.llegadaDeAvionComputarizado(unAvionComputarizado);
			
		//assert
			assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaDiagonalDelSurEsteHaciaNorOeste(){
		//arrange
			destino = new Posicion(4,4);
			Posicion posicionDePista = new Posicion(3,3);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			posicionesDeLaPista.add(destino);
			posicionesDeLaPista.add(posicionDePista);
			
			PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
			unAvionComputarizado = new AvionComputarizado (velocidad,limite,escenario, unaPista);
			
		//act
			this.moverAvion(unAvionComputarizado,destino);
			
			unaPista.llegadaDeAvionComputarizado(unAvionComputarizado);
			
		//assert
			assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaVerticalDeArribaAAbajo(){
		//arrange
			destino = new Posicion(4,4);
			Posicion posicionDePista = new Posicion(4,5);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			posicionesDeLaPista.add(destino);
			posicionesDeLaPista.add(posicionDePista);
			
			PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
			unAvionComputarizado = new AvionComputarizado (velocidad,limite,escenario, unaPista);
			
		//act
			this.moverAvion(unAvionComputarizado,destino);
			
			unaPista.llegadaDeAvionComputarizado(unAvionComputarizado);
			
		//assert
			assertTrue(unAvionComputarizado.aterrizo());
	}
	
	public void testUnAvionComputarizadoDeberiaEstacionarCorrectamenteEnSuPistaVerticalDeAbajoAArriba(){
		//arrange
			destino = new Posicion(4,5);
			Posicion posicionDePista = new Posicion(4,4);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			posicionesDeLaPista.add(destino);
			posicionesDeLaPista.add(posicionDePista);
			
			PistaSimple unaPista = new PistaSimple(escenario, posicionesDeLaPista);
			unAvionComputarizado = new AvionComputarizado (velocidad,limite,escenario, unaPista);
			
		//act
			this.moverAvion(unAvionComputarizado,destino);

			unaPista.llegadaDeAvionComputarizado(unAvionComputarizado);
			
		//assert
			assertTrue(unAvionComputarizado.aterrizo());
	}
}
