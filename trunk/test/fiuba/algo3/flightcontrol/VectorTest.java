package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;


public class VectorTest extends TestCase {
	
	
	Vector unaPosicion = new Vector (1,2);
	Vector otraPosicion = new Vector (4,7);
	
	protected void setUp () throws Exception {
		super.setUp();
		
		unaPosicion = new Vector (1,2);
		otraPosicion = new Vector (4,7);
	}
	
	public void testConstructorDeunaPosicionDeberiaSetearSusCoordenadas(){		
		
		//arrange
		int coordenadaX = 1;
		int coordenadaY = 2;
	
		//act
	
		//assert
		assertTrue ( coordenadaX == unaPosicion.getPosicionX() && coordenadaY == unaPosicion.getPosicionY());
	}
   
	public void testDeDosVectoresIgualesEqualsDeberiaDarVerdadero () {		
		
		//arrange
		boolean sonIguales;
	
		Vector Vector = new Vector (1,2);
	
		//act
		sonIguales = unaPosicion.equals(Vector);
	
		//assert
		assertTrue (sonIguales);
		
	}
   
	public void testDeDosVectoresDistintasEqualsDeberiaDarFalso () {		
		
		//arrange
		boolean sonIguales;
	
		//act
		sonIguales = unaPosicion.equals(otraPosicion);
	
		//assert
		assertFalse (sonIguales);
		
	}
  
	public void testSumarDosVectoresDeberiaDarLaSuma (){
		
		//arange
		Vector adicion = new Vector (5,9);
		Vector suma;
	
		//act
		suma = unaPosicion.sumar (otraPosicion);
	
		//assert
		assertTrue (suma.equals(adicion));
		
	}
	
	public void testRestarDosVectoresDeberiaDarLaResta (){
		
		//arange
		Vector sustraccion = new Vector (-3,-5);
		Vector resta;
	
		//act
		resta = unaPosicion.restar (otraPosicion);
	
		//assert
		assertTrue (resta.equals(sustraccion));

	}
	
	public void testMultiplicarUnNumeroPorUnVectorDeberiaRealizarElProductoEscalar (){
		
		//arrange
		int escalar = 3;
		Vector productoFinal = new Vector (3,6);
		Vector producto;
	
		//act
		producto = unaPosicion.multiplicar(escalar);
	
		//assert
		assertTrue (producto.equals(productoFinal));
	}
	
}
