package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;


public class EscenarioTest extends TestCase {
	
	public void testConstructorDelPlanoConUnaDimensionEstablecidaDeberiaCrearUnPlanoDeDichaDimension(){
		
		int dimension = 768;
		Escenario unEscenario = new Escenario(dimension);
		
		assertTrue(unEscenario.getDimension() == dimension);
	}
	
	
	public void testConstructorDelPlanoDeberiaCrearUnPlanoConPosicionesVacias() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension= 5;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int x = 0;
		int y = 0;
		Posicion posicion1 = new Posicion (x,y);
		String valor1 = unEscenario.getPosicion(posicion1);

		 x = 1;
		 y = 0;
		Posicion posicion2 = new Posicion (x,y);
		String valor2 = unEscenario.getPosicion(posicion2);
		
		x = 0;
		y = 1;
		Posicion posicion3 = new Posicion (x,y);
		String valor3 = unEscenario.getPosicion(posicion3);
		
		x = 1;
		y = 1;
		Posicion posicion4 = new Posicion (x,y);
		String valor4 = unEscenario.getPosicion(posicion4);
		
		
		assertEquals(valor1 , "vacio");
		assertEquals(valor2 , "vacio");
		assertEquals(valor3 , "vacio");
		assertEquals(valor4 , "vacio");
		
	
	}
	
	
	
	public void testDevolverUnaPosicionFueraDelRangoDelPlanoDeberiaLanzarUnaExcepcion(){
		
		int dimension = 25;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int x = 30;
		int y = 4;
		Posicion unaPosicion = new Posicion(x,y);
		
		try{
			unEscenario.getPosicion(unaPosicion);
		
		}catch(PosicionFueraDeLasDimensionesEstablecidasException excepcion){
			
		}
		
	}
	
	public void testPosicionQuedaOcupadaPorAvionDichaPosicionDeberiaQuedarActualzadaConAvion() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Posicion unaPosicion = new Posicion(coordenadaX, coordenadaY);
		
		String avion = "avion";
		
		unEscenario.posicionOcupadaPor(unaPosicion, avion);
		
		assertEquals(unEscenario.getPosicion(unaPosicion),avion);
	}
	
	public void testPosicionQuedaOcupadaPorUnaPistaDichaPosicionDeberiaQuedarActualzadaConUnaPista() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Posicion unaPosicion = new Posicion(coordenadaX, coordenadaY);
		
		String unaPista = "pista";
		
		unEscenario.posicionOcupadaPor(unaPosicion, unaPista);
		
		assertEquals(unEscenario.getPosicion(unaPosicion),unaPista);
	}
	
	public void testPosicionQuedaVaciaDeUnaPosicionOcupadaDeberiaQuedarEnEstadoVacia() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Posicion unaPosicion = new Posicion(coordenadaX, coordenadaY);
		
		String avion = "avion";
		unEscenario.posicionOcupadaPor(unaPosicion, avion);
		
		unEscenario.posicionQuedaVacio(unaPosicion);
		
		assertEquals(unEscenario.getPosicion(unaPosicion), "vacio");
		
	}
	
	public void testPosicionQuedaOcupadaPorUnaPistaCuandoYaHabiaUnAvionAlliDeberiaQuedarOcupadaPorAmbasCosas() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Posicion unaPosicion = new Posicion(coordenadaX, coordenadaY);
		
		String avion = "avion";
		String pista = "pista";
		unEscenario.posicionOcupadaPor(unaPosicion, avion);
		
		unEscenario.posicionOcupadaPor(unaPosicion, pista);
		
		assertEquals(unEscenario.getPosicion(unaPosicion), "avion y pista");
		
	}
	
	
	public void testPosicionQuedaOcupadaPorUnAvionCuandoYaHabiaUnaPistaAlliDeberiaQuedarOcupadaPorAmbasCosas() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Posicion unaPosicion = new Posicion(coordenadaX, coordenadaY);
		
		String pista = "pista";
		String avion = "avion";
		
		unEscenario.posicionOcupadaPor(unaPosicion, pista);
		
		unEscenario.posicionOcupadaPor(unaPosicion, avion);
		
		assertEquals(unEscenario.getPosicion(unaPosicion), "avion y pista");
		
	}
	
		
}
	
		
		

