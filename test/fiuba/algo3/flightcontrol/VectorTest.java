package fiuba.algo3.flightcontrol;
import fiuba.algo3.flightcontrol.modelo.Vector;
import junit.framework.TestCase;


public class VectorTest extends TestCase {
	
	
	Vector unaPosicion = new Vector (1,2);
	Vector otraPosicion = new Vector (4,7);
	
	protected void setUp () throws Exception {
		super.setUp();
		
		unaPosicion = new Vector (1,2);
		otraPosicion = new Vector (4,7);
	}
	
	public void testConstructorDeunaPosicionDeberiaSetearSusCoordenadas() {		
		
		//arrange
		int coordenadaX = 1;
		int coordenadaY = 2;
	
		//act
	
		//assert
		assertTrue ( coordenadaX == unaPosicion.getPosicionX() && coordenadaY == unaPosicion.getPosicionY());
	}
   
	public void testDeDosVectoresIgualesEqualsDeberiaDarVerdadero() {		
		
		//arrange
		boolean sonIguales;
	
		Vector Vector = new Vector (1,2);
	
		//act
		sonIguales = unaPosicion.esIgual(Vector);
	
		//assert
		assertTrue (sonIguales);
		
	}
   
	public void testDeDosVectoresDistintasEqualsDeberiaDarFalso() {		
		
		//arrange
		boolean sonIguales;
	
		//act
		sonIguales = unaPosicion.esIgual(otraPosicion);
	
		//assert
		assertFalse (sonIguales);
		
	}
  
	public void testSumarDosVectoresDeberiaDarLaSuma() {
		
		//arange
		Vector adicion = new Vector (5,9);
		Vector suma;
	
		//act
		suma = unaPosicion.sumar (otraPosicion);
	
		//assert
		assertTrue (suma.esIgual(adicion));
		
	}
	
	public void testRestarDosVectoresDeberiaDarLaResta() {
		
		//arange
		Vector sustraccion = new Vector (-3,-5);
		Vector resta;
	
		//act
		resta = unaPosicion.restar (otraPosicion);
	
		//assert
		assertTrue (resta.esIgual(sustraccion));

	}
	
	public void testMultiplicarUnNumeroPorUnVectorDeberiaRealizarElProductoEscalar() {
		
		//arrange
		int escalar = 3;
		Vector productoFinal = new Vector (3,6);
		Vector producto;
	
		//act
		producto = unaPosicion.multiplicar(escalar);
	
		//assert
		assertTrue (producto.esIgual(productoFinal));
	}
	
	public void testUnVectorAlCualdradoDeberiaDarmeSuXeYAlCuadrado() {
		
		//arrange
		Vector resultadoEsperado = new Vector(1,4);
		Vector alCuadrado;
		
		//act
		alCuadrado = unaPosicion.alCuadrado();
		
		//assert
		assertTrue (alCuadrado.esIgual(resultadoEsperado));
	}
	
	public void testLaDistanciaEntreUnVectorYOtroDeberiaSerSuNorma() {
		
		//arrange
		double resultadoEsperado = 1;
		Vector vector1 = new Vector(1, 1);
		Vector vector2 = new Vector(1, 2);
		
		//act
		double resultado = vector1.distancia(vector2);
		
		//assert
		assertTrue (resultado == resultadoEsperado);
	}
	
	public void testLaDistanciaEntreUnVectorYOtroDeberiaSerSuNorma2() {
		
		//arrange
		double resultadoEsperado = 2;
		Vector vector1 = new Vector(1, 0);
		Vector vector2 = new Vector(1, 2);
		
		//act
		double resultado = vector1.distancia(vector2);
		
		//assert
		assertTrue (resultado == resultadoEsperado);
	}
	
	public void testLaDistanciaEntreUnVectorYOtroDeberiaSerSuNorma3() {
		
		//arrange
		double resultadoEsperado = Math.sqrt(8);
		Vector vector1 = new Vector(0, 0);
		Vector vector2 = new Vector(2, 2);
		
		//act
		double resultado = vector1.distancia(vector2);
		
		//assert
		assertTrue (resultado == resultadoEsperado);
	}
	
}
