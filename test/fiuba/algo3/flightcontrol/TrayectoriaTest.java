package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class TrayectoriaTest extends TestCase {
	
	private Vector actual,destino,proximoPaso;
	private List<Vector> puntos;
	private Trayectoria trayectoria;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		actual = new Vector (1, 1);
		puntos = new ArrayList<Vector>();
	}
	/*
	public void testRecorrerLaTrayectoriaDeberiaObtenerTodosLosPuntosCorrectamente (){
		
		//arrange
		destino = new Vector (7,5);
		proximoPaso = new Vector (1,1);
		Vector direccion;
		boolean pasoCorrecto = true;
	
		//act
		puntos.add(destino);
		trayectoria = new Trayectoria (puntos);
	
		//Luego se mueve diagonalmente
	
		direccion = new Vector (1,1);
			
		while (pasoCorrecto){
		
			proximoPaso = trayectoria.getProximaPosicion();
			actual = actual.sumar(direccion);
			pasoCorrecto = actual.equals(proximoPaso);
		}
		
		//Primero se mueve en linea recta
		
		direccion = new Vector (1,0);
		actual = proximoPaso;
		pasoCorrecto = actual.equals(proximoPaso);
	
		while (pasoCorrecto && ! proximoPaso.equals(destino)){
		
			proximoPaso = trayectoria.getProximaPosicion();
			actual = actual.sumar(direccion);
			pasoCorrecto = actual.equals(proximoPaso);
		}
			
		//assert
		assertTrue (pasoCorrecto);
	}
	
	public void testDespuesDeObtenerLaUltimaPosicionDeLaTrayectoriaDeberiaDevolverNull (){
		
		//arrange
		destino = new Vector (2,2);
		puntos.add(destino);
		trayectoria = new Trayectoria (puntos);
	
		//act
		proximoPaso = trayectoria.getProximaPosicion();
		proximoPaso = trayectoria.getProximaPosicion();
	
		//assert
		assertTrue (proximoPaso == null);
		
	}*/
	
	public void testCuandoNoHayPuntosASeguirDeberiaDevolverQueNoHayTrayectoria (){
		
		//arrange
		trayectoria = new Trayectoria (puntos);
		
		//act

		//assert
		assertFalse (trayectoria.hayTrayectoria());
	}
	
	public void testCuandoHayPuntosASeguirDeberiaDevolverQueHayTrayectoria (){
		
		//arrange
		destino = new Vector (5,2);
		puntos.add(destino);
		trayectoria = new Trayectoria (puntos);
		
		//act
	
		//assert
		assertTrue (trayectoria.hayTrayectoria());
	}

}
