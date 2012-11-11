package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;

public class PistaTest extends TestCase {

	
	public void testPistaColocadaDentroDeLasDimensionesDeberiaCrearseCorrectamente() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
			int unLimite = 768;
			String objetoVoladorQuePuedeRecibir = "avionSimple";
			
			Posicion unaEntrada = new Posicion(1,1);
	
			ArrayList<Posicion> posicionDeEntradaDeAviones = new ArrayList<Posicion>();
			posicionDeEntradaDeAviones.add(unaEntrada);
			
			Escenario unEscenario = new Escenario(unLimite);

		//act
			Pista unaPista = new Pista(unEscenario,objetoVoladorQuePuedeRecibir,posicionDeEntradaDeAviones);
		
		//assert
			assertTrue( unEscenario.getPosicion(unaEntrada).equals("pista"));
		
	}
	
	public void testCrearUnaPistaDeDosEntradasDeberiaFigurarLasDosEntradasEnElEscenario() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
			int unLimite = 768;
			String objetoVoladorQuePuedeRecibir = "avionSimple";
		
			Posicion unaEntrada = new Posicion(1,1);
			Posicion otraEntrada = new Posicion(1,3);

			ArrayList<Posicion> posicionDeEntradaDeAviones = new ArrayList<Posicion>();
			posicionDeEntradaDeAviones.add(unaEntrada);
			posicionDeEntradaDeAviones.add(otraEntrada);
		
			Escenario unEscenario = new Escenario(unLimite);
			
		//act
			Pista unaPista = new Pista(unEscenario,objetoVoladorQuePuedeRecibir,posicionDeEntradaDeAviones);
			
			boolean existenLasDosPistas = false;
			existenLasDosPistas = ( (unEscenario.getPosicion(unaEntrada) == "pista") && (unEscenario.getPosicion(otraEntrada) == "pista"));
			
		//assert
			assertTrue( existenLasDosPistas );
			
	}
	
}
