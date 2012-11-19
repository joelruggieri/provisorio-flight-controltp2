package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class PistaLargaTest extends TestCase {
	
	
	private List<Vector> listaDePuntos,posicionesDeLaPista;
	private Trayectoria unaTrayectoria;
	private Vector posicion1,posicion2,posicion3;
	private int nivel,dimension;
	private Escenario unPlano;
	private AvionSimple avion;
	private Helicoptero helicoptero;
	private AvionPesado avionPesado;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		posicion1 = new Vector(1,1);
		posicion2 = new Vector(2,2);
		posicion3 = new Vector(1,2);
		listaDePuntos = new ArrayList <Vector>();
		nivel = 1;
		dimension = 768;
		unPlano = new Escenario(dimension);
		posicionesDeLaPista = new ArrayList <Vector>();
		avion = new AvionSimple(nivel,unPlano);
		helicoptero = new Helicoptero(nivel,unPlano);
		avionPesado = new AvionPesado(nivel,unPlano);
	}
	
	private void moverAvion (ObjetoVolador unAvion, Vector destino){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una Vector */
		/* post: El avion se movio */
		
		listaDePuntos.add(destino);
		unaTrayectoria = new Trayectoria (listaDePuntos);
		unAvion.setTrayectoria(unaTrayectoria);
		
		while (!unAvion.getPosicion().esIgual(destino)){
			unAvion.vivir();
		}
		
	}
	
	
	public void testConstructorDeUnaPistaLargaLasposicionesDeLaPistaDeberianEstarOcupadasPorEsta()
	throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
			
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(4,1);
		Vector otraVectorDeLaPista = new Vector(3,2);
		
		//act
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		//assert
		assertEquals(unPlano.getPosicion(VectorDeEntrada),"pista");
		assertEquals(unPlano.getPosicion(otraVectorDeLaPista),"pista");
	}
	
	public void testConstructorDeUnaPistaLargaLaDireccionDeIngresoDeberiaQuedarDeterminadaSegunLaorientacionDeLaPista(){
		
		//arrange
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(4,1);
		Vector otraVectorDeLaPista = new Vector(3,2);
		Vector otraVectorDeLaPista1 = new Vector(2,3);
		Vector otraVectorDeLaPista2 = new Vector(1,4);
		Vector ultimaVectorDeLaPista = new Vector(0,5);
	
		//act
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
	
		//assert	
		assertTrue(((pista.getDireccionDeEntrada().getPosicionX()) == -1) && ((pista.getDireccionDeEntrada().getPosicionY()) == 1));
	}

	public void testVectorDeEntradaDeberiaRetornarLaUnicaVectorPorLaCualSePuedeAterrizar(){
		
		//arrange
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(4,1);
		Vector otraVectorDeLaPista = new Vector(3,2);
		Vector otraVectorDeLaPista1 = new Vector(2,3);
		Vector otraVectorDeLaPista2 = new Vector(1,4);
		Vector ultimaVectorDeLaPista = new Vector(0,5);
	
		//act
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		//assert	
		assertTrue(pista.getPosicionDeEntrada() == VectorDeEntrada);
	}
	
	
	public void testConstructorDeUnaPistaLargaEnHorizontalLaDireccionDeIngresoDeberiaQuedarDeterminadaSegunLaorientacionDeLaPista(){
		
		//arrange
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(4,5);
		Vector otraVectorDeLaPista = new Vector(4,4);
		Vector otraVectorDeLaPista1 = new Vector(4,3);
		Vector otraVectorDeLaPista2 = new Vector(4,2);
		Vector ultimaVectorDeLaPista = new Vector(4,1);
	
		//act
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		Vector direccion = new Vector(0,-1);
	
		//assert
		assertTrue(((pista.getDireccionDeEntrada().getPosicionX()) == direccion.getPosicionX()) && ((pista.getDireccionDeEntrada().getPosicionY()) == direccion.getPosicionY()));
	}
	
	
	public void testLlegadaDeUnAvionLargaALaPistaSimpleEnUnaVectorQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avion,posicion1);
		this.moverAvion(avion,posicion2);
		
		/*creo las Vectores de la pista*/
		
		Vector VectorDeEntrada = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
		
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		pista.recibirAterrizajeDeAvionSimple (avion);
	
		//assert
		assertTrue(avion.aterrizo());
	}
	
public void testLlegadaDeUnAvionSimpleALaPistaLargaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		
		//act
		this.moverAvion(avion,posicion2);
		this.moverAvion(avion, posicion3);
		
		/*creo las Vectores de la pista*/
		
		Vector VectorDeEntrada= new Vector(1,2);
		Vector otraVectorDeLaPista1 = new Vector(1,3);
		Vector otraVectorDeLaPista2 = new Vector(1,4);
		Vector ultimaVectorDeLaPista = new Vector(1,5);
		
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		pista.recibirAterrizajeDeAvionSimple (avion);
		
		//assert
		assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionLargaALaPistaSimpleEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
		//arrange
		
		//act
		this.moverAvion(avion, posicion2);
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,2);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,2);
		Vector otraVectorDeLaPista2 = new Vector(4,2);
		Vector ultimaVectorDeLaPista = new Vector(5,2);
		
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		pista.recibirAterrizajeDeAvionSimple (avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}


	public void testLlegadaDeUnAvionHelicopteroALaPistaLargaEnUnaVectorQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
		//arrange
	
		//act
		this.moverAvion(helicoptero,posicion1);
		this.moverAvion(helicoptero, posicion2);
	
		/*creo las Vectores de la pista*/
		
		Vector VectorDeEntrada = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
	
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
	
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
	
		pista.recibirAterrizajeDeHelicoptero (helicoptero);
	
		//assert
		assertTrue(helicoptero.aterrizo());
	}
	
	public void testLlegadaDeUnAvionHelicopteroALaPistaLargaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
	
		//act
		this.moverAvion(helicoptero, posicion3);
		this.moverAvion(helicoptero, posicion1);
	
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(1,2);
		Vector otraVectorDeLaPista1 = new Vector(1,3);
		Vector otraVectorDeLaPista2 = new Vector(1,4);
		Vector ultimaVectorDeLaPista = new Vector(1,5);
		
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		pista.recibirAterrizajeDeHelicoptero (helicoptero);
	
		//assert
		assertTrue(!helicoptero.aterrizo());
	}

	public void testLlegadaDeUnAvionHelicopteroALaPistaLargaEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
		//arrange
	
		//act
		this.moverAvion(helicoptero, posicion2);
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,2);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,2);
		Vector otraVectorDeLaPista2 = new Vector(4,2);
		Vector ultimaVectorDeLaPista = new Vector(5,2);
		
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		pista.recibirAterrizajeDeHelicoptero (helicoptero);
	
		//assert
		assertTrue(!helicoptero.aterrizo());
	}
		

	public void testLlegadaDeUnAvionPesadoALaPistaLargaEnUnaVectorQueEsLaDeEntradaDeberiaAterrizar(){
		
		//arrange
	
		//act
		this.moverAvion(avionPesado, posicion1);
		this.moverAvion(avionPesado, posicion2);
	
		/*creo las Vectores de la pista*/
	
		Vector VectorDeEntrada = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
	
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
	
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
	
		pista.recibirAterrizajeDeAvionPesado (avionPesado);
	
		//assert
		assertTrue(avionPesado.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaLargaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		
		//act
		this.moverAvion(avionPesado, posicion3);
		this.moverAvion(avionPesado, posicion1);
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,1);
		Vector otraVectorDeLaPista = new Vector(1,2);
		Vector otraVectorDeLaPista1 = new Vector(1,3);
		Vector otraVectorDeLaPista2 = new Vector(1,4);
		Vector ultimaVectorDeLaPista = new Vector(1,5);
		
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		pista.recibirAterrizajeDeAvionPesado(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaLargaEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
	
		//act
		this.moverAvion(avionPesado, posicion2);
		
		/*creo las Vectores de la pista*/
		Vector VectorDeEntrada = new Vector(1,2);
		Vector otraVectorDeLaPista = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,2);
		Vector otraVectorDeLaPista2 = new Vector(4,2);
		Vector ultimaVectorDeLaPista = new Vector(5,2);
		
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
		
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
		
		pista.recibirAterrizajeDeAvionPesado (avionPesado);
		
		//assert
		assertTrue(!avionPesado.aterrizo());
	}
			
	public void testLlegadaDeUnAvionPesadoALaPistaLargaEnUnaVectorQueEsLaDeEntradaYConDireccionAdecuadaDeberiaAterrizar(){
		
		//arrange
	
		//act
		this.moverAvion(avionPesado, posicion1);
		this.moverAvion(avionPesado, posicion2);
	
		/*creo las Vectores de la pista*/
	
		Vector VectorDeEntrada = new Vector(2,2);
		Vector otraVectorDeLaPista1 = new Vector(3,3);
		Vector otraVectorDeLaPista2 = new Vector(4,4);
		Vector ultimaVectorDeLaPista = new Vector(5,5);
	
		posicionesDeLaPista.add(VectorDeEntrada);
		posicionesDeLaPista.add(otraVectorDeLaPista1);
		posicionesDeLaPista.add(otraVectorDeLaPista2);
		posicionesDeLaPista.add(ultimaVectorDeLaPista);
	
		PistaLarga pista = new PistaLarga(unPlano,posicionesDeLaPista);
	
		pista.recibirAterrizajeDeAvionPesado (avionPesado);
	
		//assert
		assertTrue(avionPesado.aterrizo());
	}
			

}


