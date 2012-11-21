package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class NivelTest extends TestCase {
	
	
	public void testGetPistaValidanNuncaDeberiaRetornarUnHelipuerto(){
		
		int velocidad = 1;
		int dimension = 768;
		
		Nivel unNivel = new Nivel (velocidad,dimension);
		
		for(int i = 0 ; i < 100000 ; i++ ) { 
			
			Pista unaPista = unNivel.getUnaPistaValida();
			
			assertTrue(unaPista.getClass() != Helipuerto.class);
			
		}
	}
}
