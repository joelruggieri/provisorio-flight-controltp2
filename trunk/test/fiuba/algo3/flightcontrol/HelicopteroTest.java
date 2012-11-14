package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;


public class HelicopteroTest extends TestCase {

	public void testCrearUnHelicopteroDeberiaAparecerEnElEscenarioEnElLugarQueFueCreado() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
		int velocidad = 1;
		int limite = 768;
		
		Escenario unEscenario = new Escenario(limite);
		Helicoptero unHelicoptero = new Helicoptero(velocidad, limite, unEscenario);
		
		//act
		Posicion posicionInicial = unHelicoptero.getPosicion();
						
		//assert
		assertEquals(unEscenario.getPosicion(posicionInicial),"objetoVolador");	
	}
	
	public void testCrearUnHelicopteroEnUnaPosicionYNoDarleUnaTrayectoriaDeberiaDejarloQuieto() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
		int velocidad = 1;
		int limite = 768;
		
		Escenario unEscenario = new Escenario(limite);
		Helicoptero unHelicoptero = new Helicoptero(velocidad, limite, unEscenario);
		Posicion posicionInicial = unHelicoptero.getPosicion();
			
		//act
		unHelicoptero.moverse();
			
		//assert	
		assertEquals(unEscenario.getPosicion(posicionInicial),"objetoVolador");
	}
	
	public void testMoverUnHelicopteroPor2PuntosDeberiaTerminarEnElUltimoPuntoEnAlgunMomento() throws PosicionFueraDeLasDimensionesEstablecidasException{

		//arrange
		int velocidad = 1;
		int limite = 768;
		
		Escenario unEscenario = new Escenario(limite);
		Helicoptero unHelicoptero = new Helicoptero(velocidad, limite, unEscenario);
		Posicion posicionActual = unHelicoptero.getPosicion();
		
		ArrayList<Posicion> posicionesDestino = new ArrayList<Posicion>();
		
		Posicion primerPosicion = posicionActual.sumar(new Posicion(0,1));
		Posicion segundaPosicion = posicionActual.sumar(new Posicion(0,2));
		
		posicionesDestino.add(primerPosicion);
		posicionesDestino.add(segundaPosicion);
		
		unHelicoptero.crearTrayectoria(posicionesDestino);
			
		//act
		unHelicoptero.moverse();
		unHelicoptero.moverse();
		
		//assert
		assertTrue(unHelicoptero.getPosicion().equals(segundaPosicion));
	}
	
}
