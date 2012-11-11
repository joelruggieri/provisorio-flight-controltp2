package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

import junit.framework.TestCase;

public class ArrayListTest extends TestCase {

	public void testElMetodoSizeEnUnArrayVacioDeberiaDarCero(){
		
		ArrayList<Integer> unaLista = new ArrayList<Integer>();
		
		assertEquals(unaLista.size(), 0);
	}
	
	public void testCargarValoresYRecorrerElArrayListDeberiaDevolvermelos(){
		
		ArrayList<Integer> unaLista = new ArrayList<Integer>();
		
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
		
		assertTrue(todosIguales);
	}
	
}
