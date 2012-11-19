package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;


public class HelicopteroTest extends TestCase {
	
	private Helicoptero unHelicoptero;
	private int nivel,limite;
	private List<Vector> posicionesDestino;
	private Trayectoria unaTrayectoria;
	private Escenario unEscenario;
	private Vector posicionActual;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		nivel = 1;
		limite = 768;
		unEscenario = new Escenario(limite);
		unHelicoptero = new Helicoptero(nivel, unEscenario);
		posicionActual = unHelicoptero.getPosicion();
		posicionesDestino = new ArrayList<Vector>();
		unaTrayectoria = new Trayectoria (posicionesDestino);
		
	}
	
	public void testCrearUnHelicopteroDeberiaAparecerEnElEscenarioEnElLugarQueFueCreado() 
		throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
		
		//act	
		Vector posicionActual = unHelicoptero.getPosicion();
						
		//assert
		assertEquals(unEscenario.getPosicion(posicionActual),"objetoVolador");	
	}
	
	public void testCrearUnHelicopteroEnUnaVectorYNoDarleUnaTrayectoriaDeberiaDejarloQuieto() 
		throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
		
		//act
		unHelicoptero.mover();
			
		//assert	
		assertEquals(unEscenario.getPosicion(posicionActual),"objetoVolador");
	}
	
	public void testMoverUnHelicopteroPor2PuntosDeberiaTerminarEnElUltimoPuntoEnAlgunMomento() 
		throws PosicionFueraDeLasDimensionesEstablecidasException{

		//arrange		
		Vector primeraPosicion = posicionActual.sumar(new Vector(0,1));
		Vector segundaPosicion = posicionActual.sumar(new Vector(0,2));
		
		posicionesDestino.add(primeraPosicion);
		posicionesDestino.add(segundaPosicion);
		
		unHelicoptero.setTrayectoria(unaTrayectoria);
			
		//act
		unHelicoptero.mover();
		unHelicoptero.mover();
		
		//assert
		assertTrue(unHelicoptero.getPosicion().esIgual(segundaPosicion));
	}
	
}
