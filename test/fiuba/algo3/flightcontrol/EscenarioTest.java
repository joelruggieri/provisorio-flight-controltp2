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
		Vector Vector1 = new Vector (x,y);
		String valor1 = unEscenario.getPosicion(Vector1);

		 x = 1;
		 y = 0;
		Vector Vector2 = new Vector (x,y);
		String valor2 = unEscenario.getPosicion(Vector2);
		
		x = 0;
		y = 1;
		Vector Vector3 = new Vector (x,y);
		String valor3 = unEscenario.getPosicion(Vector3);
		
		x = 1;
		y = 1;
		Vector Vector4 = new Vector (x,y);
		String valor4 = unEscenario.getPosicion(Vector4);
		
		
		assertEquals(valor1 , "vacio");
		assertEquals(valor2 , "vacio");
		assertEquals(valor3 , "vacio");
		assertEquals(valor4 , "vacio");
		
	
	}
	
	
	
	public void testDevolverUnaVectorFueraDelRangoDelPlanoDeberiaLanzarUnaExcepcion(){
		
		int dimension = 25;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int x = 30;
		int y = 4;
		Vector unaVector = new Vector(x,y);
		
		try{
			unEscenario.getPosicion(unaVector);
		
		}catch(PosicionFueraDeLasDimensionesEstablecidasException excepcion){
			
		}
		
	}
	
	public void testVectorQuedaOcupadaPorAvionDichaVectorDeberiaQuedarActualzadaConAvion() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Vector unaVector = new Vector(coordenadaX, coordenadaY);
		
		String avion = "avion";
		
		unEscenario.ocuparPosicion(unaVector, avion);
		
		assertEquals(unEscenario.getPosicion(unaVector),avion);
	}
	
	public void testVectorQuedaOcupadaPorUnaPistaDichaVectorDeberiaQuedarActualzadaConUnaPista() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Vector unaVector = new Vector(coordenadaX, coordenadaY);
		
		String unaPista = "pista";
		
		unEscenario.ocuparPosicion(unaVector, unaPista);
		
		assertEquals(unEscenario.getPosicion(unaVector),unaPista);
	}
	
	public void testVectorQuedaVaciaDeUnaVectorOcupadaDeberiaQuedarEnEstadoVacia() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Vector unaVector = new Vector(coordenadaX, coordenadaY);
		
		String avion = "avion";
		unEscenario.ocuparPosicion(unaVector, avion);
		
		unEscenario.setPosicionVacia(unaVector);
		
		assertEquals(unEscenario.getPosicion(unaVector), "vacio");
		
	}
	
	public void testVectorQuedaOcupadaPorUnaPistaCuandoYaHabiaUnAvionAlliDeberiaQuedarOcupadaPorAmbasCosas() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Vector unaVector = new Vector(coordenadaX, coordenadaY);
		
		String avion = "avion";
		String pista = "pista";
		unEscenario.ocuparPosicion(unaVector, avion);
		
		unEscenario.ocuparPosicion(unaVector, pista);
		
		assertEquals(unEscenario.getPosicion(unaVector), "avion y pista");
		
	}
	
	
	public void testVectorQuedaOcupadaPorUnAvionCuandoYaHabiaUnaPistaAlliDeberiaQuedarOcupadaPorAmbasCosas() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 30;
		
		Escenario unEscenario = new Escenario(dimension);
		
		int coordenadaX = 4;
		int coordenadaY = 6;
		Vector unaVector = new Vector(coordenadaX, coordenadaY);
		
		String pista = "pista";
		String avion = "avion";
		
		unEscenario.ocuparPosicion(unaVector, pista);
		
		unEscenario.ocuparPosicion(unaVector, avion);
		
		assertEquals(unEscenario.getPosicion(unaVector), "avion y pista");
		
	}
			
}
