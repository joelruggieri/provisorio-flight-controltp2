package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;

public class TrayectoriaTest extends TestCase {
	
	private Vector destino, primerPunto, segundoPunto,proximaPosicion;
	private List<Vector> puntos;
	private Trayectoria trayectoria;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		puntos = new ArrayList<Vector>();
		primerPunto = new Vector (3,8);
		segundoPunto = new Vector (7,9);
	}
	
	public void testDeberiaDevolverLaProximaPosicionCorrectamente (){
		
		//arrange
		puntos.add(primerPunto);
		puntos.add(segundoPunto);
		trayectoria = new Trayectoria (puntos);
		
		//act
		proximaPosicion = trayectoria.getProximaPosicion();
		
		//assert
		assertTrue (proximaPosicion.equals(primerPunto));
	}
	
	public void testObtenerLaProximaPosicionDespuesDeBorrarDeberiaDevolverLaSegundaPosicionDeLaTrayectoria (){
		
		//arrange
		puntos.add(primerPunto);
		puntos.add(segundoPunto);
		trayectoria = new Trayectoria (puntos);
		
		//act
		trayectoria.borrarPosicion();
		proximaPosicion = trayectoria.getProximaPosicion();
		
		//assert
		assertTrue (proximaPosicion.equals(segundoPunto));
	}
	
	public void testCuandoNoHayPuntosASeguirDeberiaDevolverQueNoHayTrayectoria (){
		
		//arrange
		trayectoria = new Trayectoria (puntos);
		
		//act

		//assert
		assertFalse (trayectoria.contienePuntos());
	}
	
	public void testCuandoHayPuntosASeguirDeberiaDevolverQueHayTrayectoria (){
		
		//arrange
		destino = new Vector (5,2);
		puntos.add(destino);
		trayectoria = new Trayectoria (puntos);
		
		//act
	
		//assert
		assertTrue (trayectoria.contienePuntos());
	}

}
