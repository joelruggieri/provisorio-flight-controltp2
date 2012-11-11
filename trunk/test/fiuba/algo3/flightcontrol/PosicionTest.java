package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;


public class PosicionTest extends TestCase {
	
	
	Posicion unaPosicion = new Posicion (1,2);
	Posicion otraPosicion = new Posicion (4,7);
	
	protected void setUp () throws Exception {
		super.setUp();
		
		unaPosicion = new Posicion (1,2);
		otraPosicion = new Posicion (4,7);
	}
	
	public void testConstructorDeUnaPosicionDeberiaSetearSusCoordenadas(){		
		
		//arrange
		int coordenadaX = 1;
		int coordenadaY = 2;
		
		//act
		
		//assert
		assertTrue ( coordenadaX == unaPosicion.getPosicionX() && coordenadaY == unaPosicion.getPosicionY());
	
	}
   
	public void testDeDosPosicionesIgualesEqualsDeberiaDarVerdadero () {		
		
		//arrange
		boolean sonIguales;
		
		Posicion posicion = new Posicion (1,2);
		
		//act
		sonIguales = unaPosicion.equals(posicion);
		
		//assert
		assertTrue (sonIguales);
		
	}
   
	public void testDeDosPosicionesDistintasEqualsDeberiaDarFalso () {		
		
		//arrange
		boolean sonIguales;
		
		//act
		sonIguales = unaPosicion.equals(otraPosicion);
		
		//assert
		assertFalse (sonIguales);
		
	}
  
	public void testSumarDosPosicionesDeberiaDarLaSuma (){
		
		//arange
		Posicion adicion = new Posicion (5,9);
		Posicion suma;
		
		//act
		suma = unaPosicion.sumar (otraPosicion);
		
		//assert
		assertTrue (suma.equals(adicion));
		
	}
	
	public void testRestarDosPosicionesDeberiaDarLaResta (){
		
		//arange
		Posicion sustraccion = new Posicion (-3,-5);
		Posicion resta;
		
		//act
		resta = unaPosicion.restar (otraPosicion);
		
		//assert
		assertTrue (resta.equals(sustraccion));

	}
	
	public void testMultiplicarUnNumeroPorUnVectorDeberiaRealizarElProductoEscalar (){
		
		//arrange
		int escalar = 3;
		Posicion productoFinal = new Posicion (3,6);
		Posicion producto;
		
		//act
		producto = unaPosicion.multiplicar(escalar);
		
		//assert
		assertTrue (producto.equals(productoFinal));
	}
	
}
