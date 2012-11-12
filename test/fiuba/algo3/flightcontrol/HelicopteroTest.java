package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;


public class HelicopteroTest extends TestCase {

	public void testCrearUnHelicopteroDeberiaAparecerEnElEscenarioEnElLugarQueFueCreado() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange and act
			int velocidad = 1;
			int limite = 768;
			Posicion posicionInicial = new Posicion(0,0);
			
			Escenario unEscenario = new Escenario(limite);
			
			Helicoptero unHelicoptero = new Helicoptero(velocidad, limite, unEscenario);
			
		//assert
			assertEquals(unEscenario.getPosicion(posicionInicial),"objetoVolador");	
	}
	
	public void testCrearUnHelicopteroEnUnaPosicionYNoDarleUnaTrayectoriaDeberiaDejarloQuieto() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
			int velocidad = 1;
			int limite = 768;
			Posicion posicionInicial = new Posicion(0,0);
			
			Escenario unEscenario = new Escenario(limite);
			
			Helicoptero unHelicoptero = new Helicoptero(velocidad, limite, unEscenario);
			
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
			
			ArrayList<Posicion> posicionesDestino = new ArrayList<Posicion>();
			Posicion primerPosicion = new Posicion(1,1);
			Posicion segundaPosicion = new Posicion(2,2);
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
