package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;

public class TrayectoriaTest extends TestCase {
	
	private Posicion actual,destino,proximoPaso;
	private ArrayList<Posicion> puntos;
	private Trayectoria trayectoria;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		actual = new Posicion (1, 1);
		puntos = new ArrayList<Posicion>();
	}
	
	public void testProximaPosicionDeberiaRetornarUnaPosicionParaContinuarConlaDireccionQueTraia(){
		
		//arrange	
		destino = new Posicion (4, 4);
		proximoPaso = new Posicion (2,2);
		Posicion proximaPosicion;
		
		puntos.add(destino);		
		
		trayectoria = new Trayectoria (puntos);
		//act
		
		proximaPosicion = trayectoria.getProximaPosicion(actual);
				
		//assert
		assertTrue (proximaPosicion.equals(proximoPaso));
	}
	
	public void testObtenerVectorDirectorDeberiaDarUnVectorQueIndiqueLaDireccionASeguirParaLlegarADestino (){
		
		//arrange
		destino = new Posicion (4, 4);
		Posicion direccion = new Posicion (1,1);
		
		puntos.add(destino);
		
		trayectoria = new Trayectoria (puntos);
		
		//act
		Posicion direccionDeLaTrayectoria = trayectoria.getVectorDirector(actual);
				
		//assert
		assertTrue (direccionDeLaTrayectoria.equals(direccion));
	}
	
	public void testRecorrerLaTrayectoriaDeberiaObtenerTodosLosPuntosCorrectamente (){
		
		//arrange
		destino = new Posicion (7,5);
		proximoPaso = new Posicion (1,1);
		Posicion direccion;
		boolean pasoCorrecto = true;
		
		puntos.add(destino);
		trayectoria = new Trayectoria (puntos);
		
		//act
		
		//Primero se mueve en linea recta
		
		direccion = new Posicion (1,0);
		while (pasoCorrecto){
			
			proximoPaso = trayectoria.getProximaPosicion(actual);
			actual = actual.sumar(direccion);
			pasoCorrecto = actual.equals(proximoPaso);
			
		}
		
		//Luego se mueve diagonalmente
		
		direccion = new Posicion (1,1);
		actual = proximoPaso;
		pasoCorrecto = actual.equals(proximoPaso);
		
		while (pasoCorrecto && ! proximoPaso.equals(destino)){
			
			proximoPaso = trayectoria.getProximaPosicion(actual);
			
			actual = actual.sumar(direccion);
			
			pasoCorrecto = actual.equals(proximoPaso);
			
			
		}
		
		//assert
		assertTrue (pasoCorrecto);
	}
	
	public void testDespuesDeObtenerLaUltimaPosicionDeLaTrayectoriaDeberiaDevolverNull (){
		
		//arrange
		destino = new Posicion (2,2);
		puntos.add(destino);
		trayectoria = new Trayectoria (puntos);
		
		//act
		proximoPaso = trayectoria.getProximaPosicion(actual);
		proximoPaso = trayectoria.getProximaPosicion(actual);
		
		//assert
		assertTrue (proximoPaso == null);
		
	}

}
