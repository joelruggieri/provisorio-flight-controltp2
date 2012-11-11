package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;


public class AvionSimpleTest extends TestCase {
	
	private AvionSimple avion;
	private int velocidad;
	private int limite;
	private Escenario plano;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		velocidad = 1;
		limite = 768;
		avion = new AvionSimple(velocidad,limite,plano);
	}
	
	public void testCrearUnAvionSimpleYQueDeUnPasoAUnaPosicionVecinaDeberiaMoverseCorrectamente(){
		//arrange
			Posicion posicionFinal = new Posicion(0,1);
			ArrayList<Posicion> unaTrayectoria = new ArrayList<Posicion>();
		//act
			avion.crearTrayectoria(unaTrayectoria);
			avion.moverse();
			Posicion posicionActualAvion = avion.getPosicion();
			
		//assert
			assertTrue (posicionActualAvion.equals(posicionFinal));	
			
	}
	
	public void testAvionVolarCuandoNoHayTrayectoriaMarcadaDeberiaActualizarSuPosicionDependiendoDeSuVelocidadYDeLaDireccionQueTraia(){
		
		//arrange
		
		Posicion direccion, posicionFinal;
		Posicion inicial = avion.getPosicion();
		
		//act
		avion.moverse();
		direccion = avion.getDireccion();
		
		Posicion posicionActualAvion = avion.getPosicion();
		posicionFinal = inicial.sumar(direccion.multiplicar(velocidad));
		
		//assert
		assertTrue (posicionActualAvion.equals(posicionFinal));		
	}
		
}