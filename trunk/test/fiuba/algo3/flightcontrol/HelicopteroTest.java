package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;


public class HelicopteroTest extends TestCase {
	
	private Helicoptero unHelicoptero;
	private int velocidad,limite;
	private List<Vector> posicionesDestino;
	private Trayectoria unaTrayectoria;
	private Nivel unNivel;
	private Vector posicionActual;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		velocidad = 10;
		limite = 768;
		unNivel = new Nivel(velocidad, limite);
		unHelicoptero = new Helicoptero( velocidad, unNivel);
		posicionActual = unHelicoptero.getPosicion();
		posicionesDestino = new ArrayList<Vector>();
		unaTrayectoria = new Trayectoria (posicionesDestino);
		
	}
/*	
	public void testCrearUnHelicopteroEnUnaVectorYNoDarleUnaTrayectoriaDeberiaDejarloQuieto() 
		throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
		
		//act
		unHelicoptero.mover();
			
		//assert	
		assertEquals(unEscenario.getPosicion(posicionActual),"objetoVolador");
	}
*/	
	public void testMoverUnHelicopteroPor2PuntosDeberiaTerminarEnElUltimoPuntoEnAlgunMomento() 
		throws PosicionFueraDeLasDimensionesEstablecidasException{

		//arrange		
		Vector primeraPosicion = posicionActual.sumar(new Vector(0,1));
		Vector segundaPosicion = posicionActual.sumar(new Vector(0,2));
		
		posicionesDestino.add(primeraPosicion);
		posicionesDestino.add(segundaPosicion);
		
		unHelicoptero.setTrayectoria(unaTrayectoria);
			
		//act
		unHelicoptero.vivir();
		unHelicoptero.vivir();
		
		//assert
		assertTrue(unHelicoptero.getPosicion().esIgual(segundaPosicion));
	}
	
	public void testVivirDeUnHelicopteroLuegoDeHaberTerminadoLaTrayectoriaIndicadaDeberiaQuedarEnUltimaPosicion() 
			throws PosicionFueraDeLasDimensionesEstablecidasException{

			//arrange		
			Vector primeraPosicion = posicionActual.sumar(new Vector(0,1));
			Vector segundaPosicion = posicionActual.sumar(new Vector(0,2));
			
			posicionesDestino.add(primeraPosicion);
			posicionesDestino.add(segundaPosicion);
			
			unHelicoptero.setTrayectoria(unaTrayectoria);
				
			//act
			unHelicoptero.vivir();
			unHelicoptero.vivir();
			
			unHelicoptero.vivir();
			
			//assert
			assertTrue(unHelicoptero.getPosicion().esIgual(segundaPosicion));
		}
	
	
	public void testVivirDeUnHelicopteroRecienGeneradoQueNoTieneTrayectoriaDeberiaMoverseEnCualquierPosicionRandom(){
		
		
		Vector posicionDeSalida = unHelicoptero.getPosicion();
		unHelicoptero.vivir();
		
		assertTrue(!unHelicoptero.getPosicion().esIgual(posicionDeSalida));
		
		
		
		
	}
	
	
	
}
