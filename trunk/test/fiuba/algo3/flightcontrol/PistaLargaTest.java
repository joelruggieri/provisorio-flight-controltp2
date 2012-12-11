package fiuba.algo3.flightcontrol;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.flightcontrol.modelo.AvionPesado;
import fiuba.algo3.flightcontrol.modelo.AvionSimple;
import fiuba.algo3.flightcontrol.modelo.Helicoptero;
import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.PistaLarga;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;

public class PistaLargaTest extends TestCase {
	
	
	private List<Vector> listaDePuntos,posicionesDeLaPista;
	private Trayectoria unaTrayectoria;
	private Vector posicion1,posicion2,posicion3;
	private int velocidad,dimension;
	private Nivel unNivel;
	private AvionSimple avion;
	private Helicoptero helicoptero;
	private AvionPesado avionPesado;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		posicion1 = new Vector(1,1);
		posicion2 = new Vector(2,2);
		posicion3 = new Vector(1,2);
		listaDePuntos = new ArrayList <Vector>();
		velocidad = 1;
		dimension = 768;
		unNivel = new Nivel(velocidad, dimension);
		posicionesDeLaPista = new ArrayList <Vector>();
		avion = new AvionSimple(velocidad,unNivel);
		helicoptero = new Helicoptero(velocidad,unNivel);
		avionPesado = new AvionPesado(velocidad,unNivel);
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
	
	private void removerLasPistasDelNivel(){
		
		Iterator iterador = this.unNivel.getPistas();
		
		while(iterador.hasNext()){
			iterador.next();
			iterador.remove();
		}
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
	
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
		Vector direccion = new Vector(0,-1);
	
		//assert
		assertTrue(((pista.getDireccionDeEntrada().getPosicionX()) == direccion.getPosicionX()) && ((pista.getDireccionDeEntrada().getPosicionY()) == direccion.getPosicionY()));
	}
	
	
	public void testLlegadaDeUnAvionSimpleALaPistaLargaEnUnaVectorQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (avion);
	
		//assert
		assertTrue(avion.aterrizo());
	}
	
	public void testLlegadaDeUnAvionSimpleALaPistaLargaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		//borramos las pistas del nivel para evitar que el avion aterrice antes en una de ellas antes de llegar a la pista creada en el
		//test
		this.removerLasPistasDelNivel();
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (avion);
		
		//assert
		assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionSimpleALaPistaLargaEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
		//arrange
		//borramos las pistas del nivel para evitar que el avion aterrice antes en una de ellas antes de llegar a la pista creada en el
		//test
		this.removerLasPistasDelNivel();
		//act
		this.moverAvion(avion, posicion1);
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}


	public void testLlegadaDeUnAvionHelicopteroALaPistaLargaEnUnaVectorQueEsLaDeEntradaYConDireccionApropiadaNoDeberiaAterrizarPeroSiAntesYaPasoPorUnHelipuertoDeberiaEstarEnLaPosicionDelHelipuerto(){
		
		//arrange
		Iterator iterador = this.unNivel.getPistas();
		// borramos el helipuerto para evitar que aterrice antes de llegar a la pista que queremos
		iterador.next();
		iterador.remove();
		//act
		
		/*creo las Vectores de la pista*/
		
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
	
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
	
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(!helicoptero.aterrizo());
	}
	
	public void testLlegadaDeUnAvionHelicopteroALaPistaLargaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		Iterator iterador = this.unNivel.getPistas();
		// borramos el helipuerto para evitar que aterrice antes de llegar a la pista que queremos
		iterador.next();
		iterador.remove();
		//act
		
		/*creo las Vectores de la pista*/
		
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (helicoptero);
	
		//assert
		assertTrue(!helicoptero.aterrizo());
	}

	public void testLlegadaDeUnAvionHelicopteroALaPistaLargaEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
		//arrange
		Iterator iterador = this.unNivel.getPistas();
		// borramos el helipuerto para evitar que aterrice antes de llegar a la pista que queremos
		iterador.next();
		iterador.remove();
		//act
		
		/*creo las Vectores de la pista*/
		
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (helicoptero);
	
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
	
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
	
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(avionPesado.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaLargaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		//borramos las pistas del nivel para evitar que el avion aterrice antes en una de ellas antes de llegar a la pista creada en el
		//test
		this.removerLasPistasDelNivel();
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaLargaEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		//borramos las pistas del nivel para evitar que el avion aterrice antes en una de ellas antes de llegar a la pista creada en el
		//test
		this.removerLasPistasDelNivel();
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
		
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (avionPesado);
		
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
	
		PistaLarga pista = new PistaLarga(posicionesDeLaPista);
	
		pista.recibirAterrizajeDeObjetoVolador (avionPesado);
	
		//assert
		assertTrue(avionPesado.aterrizo());
	}
			

}


