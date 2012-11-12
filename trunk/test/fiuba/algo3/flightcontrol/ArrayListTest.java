package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

import junit.framework.TestCase;

public class ArrayListTest extends TestCase {

	public void testElMetodoSizeEnUnArrayVacioDeberiaDarCero(){
		
		//arrange and act
			ArrayList<Integer> unaLista = new ArrayList<Integer>();
		
		//assert
			assertEquals(unaLista.size(), 0);
	}
	
	public void testCargarValoresYRecorrerElArrayListDeberiaDevolvermelos(){
		
		//arrange
			ArrayList<Integer> unaLista = new ArrayList<Integer>();
			
		//act	
			unaLista.add(0);
			unaLista.add(1);
			unaLista.add(2);
			unaLista.add(3);
			
			boolean todosIguales = true;
			int i=0;
			
			while(unaLista.size()>i && todosIguales){
				
				todosIguales = (unaLista.get(i) == i);
				i++;
			}
		
		//assert
			assertTrue(todosIguales);
	}
	
	public void testCuandoBorroUnDatoElProximoDeberiaQuedarEnLaPosicionCero(){
		
		//arrange
			ArrayList<Integer> unaLista = new ArrayList<Integer>();
		
		//act
			unaLista.add(0);
			unaLista.add(1);
			unaLista.add(2);
					
			unaLista.remove(0);
			int dato1 = unaLista.get(0);
			
			unaLista.remove(0);
			
			int dato2 = unaLista.get(0);
			
		//assert
			assertTrue(dato1 == 1 && dato2 == 2);
	}
	
}
