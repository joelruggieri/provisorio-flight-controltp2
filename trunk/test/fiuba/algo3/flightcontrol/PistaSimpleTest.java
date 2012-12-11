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
import fiuba.algo3.flightcontrol.modelo.PistaSimple;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;

public class PistaSimpleTest extends TestCase {
	
	private List <Vector> posicionesDestino,posicionesDeLaPista;
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
		
		posicionesDestino = new ArrayList <Vector>();
		posicionesDeLaPista = new ArrayList <Vector>();
		
		velocidad = 1;
		dimension = 768;
		unNivel = new Nivel(velocidad, dimension);
				
		avion = new AvionSimple(velocidad, unNivel);
		helicoptero = new Helicoptero(velocidad, unNivel);
		avionPesado = new AvionPesado(velocidad, unNivel);
		
		
	}
	
	private void moverAvion (ObjetoVolador unAvion, Vector destino){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una Vector */
		/* post: El avion se movio */
		
		posicionesDestino.add(destino);
		unaTrayectoria = new Trayectoria (posicionesDestino);
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
	
	public void testConstructorDeUnaPistaSimpleLaDireccionDeIngresoDeberiaQuedarDeterminadaSegunLaorientacionDeLaPista(){
		
		//arrange
		
		/*creo las Vectores de la pista*/
		Vector posicionDeEntrada = new Vector(4,1);
		Vector otraPosicionDeLaPista = new Vector(3,2);
		Vector otraPosicionDeLaPista1 = new Vector(2,3);
		Vector otraPosicionDeLaPista2 = new Vector(1,4);
		Vector ultimaPosicionDeLaPista = new Vector(0,5);
		
		//act
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
	
		//assert	
		assertTrue(((pista.getDireccionDeEntrada().getPosicionX()) == -1) && ((pista.getDireccionDeEntrada().getPosicionY()) == 1));
	}

	public void testPosicionDeEntradaDeberiaRetornarLaUnicaPosicionPorLaCualSePuedeAterrizar(){
		
		//arrange
		
		/*creo las Vectores de la pista*/
		Vector posicionDeEntrada = new Vector(4,1);
		Vector otraPosicionDeLaPista = new Vector(3,2);
		Vector otraPosicionDeLaPista1 = new Vector(2,3);
		Vector otraPosicionDeLaPista2 = new Vector(1,4);
		Vector ultimaPosicionDeLaPista = new Vector(0,5);
	
		//act
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		//assert	
		assertTrue(pista.getPosicionDeEntrada() == posicionDeEntrada);
	}
	
	
	public void testConstructorDeUnaPistaSimpleEnHorizontalLaDireccionDeIngresoDeberiaQuedarDeterminadaSegunLaorientacionDeLaPista(){
		
		//arrange
		
		/*creo las Vectores de la pista*/
		Vector posicionDeEntrada = new Vector(4,5);
		Vector otraPosicionDeLaPista = new Vector(4,4);
		Vector otraPosicionDeLaPista1 = new Vector(4,3);
		Vector otraPosicionDeLaPista2 = new Vector(4,2);
		Vector ultimaPosicionDeLaPista = new Vector(4,1);
	
		//act
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		Vector direccion = new Vector(0,-1);
	
		//assert
		assertTrue(((pista.getDireccionDeEntrada().getPosicionX()) == direccion.getPosicionX()) && ((pista.getDireccionDeEntrada().getPosicionY()) == direccion.getPosicionY()));
	}
	
	
	public void testLlegadaDeUnAvionSimpleALaPistaSimpleEnUnaVectorQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
		//arrange
		
		//act
		
		/*creo las Vectores de la pista*/
		
		//act	
		this.moverAvion (avion,posicion1);
		this.moverAvion(avion,posicion2);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,2);
		Vector otraPosicionDeLaPista1 = new Vector(3,3);
		Vector otraPosicionDeLaPista2 = new Vector(4,4);
		Vector ultimaPosicionDeLaPista = new Vector(5,5);
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(avion.aterrizo());
	}
	
	public void testLlegadaDeUnAvionSimpleALaPistaSimpleEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		// removemos las pistas del nivel para evitar que el avion pueda aterrizar antes de llegar a la pista creada
		this.removerLasPistasDelNivel();
		//act
		this.moverAvion(avion,posicion2);
		this.moverAvion(avion, posicion3);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada= new Vector(1,2);
		Vector otraPosicionDeLaPista1 = new Vector(1,3);
		Vector otraPosicionDeLaPista2 = new Vector(1,4);
		Vector ultimaPosicionDeLaPista = new Vector(1,5);
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
		
		//assert
		assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionSimpleALaPistaSimpleEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
		//arrange
		// removemos las pistas del nivel para evitar que el avion pueda aterrizar antes de llegar a la pista creada
		this.removerLasPistasDelNivel();
		//act
		this.moverAvion(avion,posicion1);
		this.moverAvion(avion, posicion2);
		
		/*creo las Vectores de la pista*/
		Vector posicionDeEntrada = new Vector(1,2);
		Vector otraPosicionDeLaPista = new Vector(2,2);
		Vector otraPosicionDeLaPista1 = new Vector(3,2);
		Vector otraPosicionDeLaPista2 = new Vector(4,2);
		Vector ultimaPosicionDeLaPista = new Vector(5,2);
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}


	public void testLlegadaDeUnAvionHelicopteroALaPistaSimpleEnUnaVectorQueEsLaDeEntradaYConDireccionApropiadaNoDeberiaAterrizar(){
		
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
		
		Vector posicionDeEntrada = new Vector(2,2);
		Vector otraPosicionDeLaPista1 = new Vector(3,3);
		Vector otraPosicionDeLaPista2 = new Vector(4,4);
		Vector ultimaPosicionDeLaPista = new Vector(5,5);
	
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
	
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
	
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
		
		//assert
		assertTrue(!helicoptero.aterrizo());
	}
	
	public void testLlegadaDeUnAvionHelicopteroALaPistaSimpleEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
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
		Vector posicionDeEntrada = new Vector(1,1);
		Vector otraPosicionDeLaPista = new Vector(1,2);
		Vector otraPosicionDeLaPista1 = new Vector(1,3);
		Vector otraPosicionDeLaPista2 = new Vector(1,4);
		Vector ultimaPosicionDeLaPista = new Vector(1,5);
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(!helicoptero.aterrizo());
	}

	public void testLlegadaDeUnAvionHelicopteroALaPistaSimpleEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
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
		Vector posicionDeEntrada = new Vector(1,2);
		Vector otraPosicionDeLaPista = new Vector(2,2);
		Vector otraPosicionDeLaPista1 = new Vector(3,2);
		Vector otraPosicionDeLaPista2 = new Vector(4,2);
		Vector ultimaPosicionDeLaPista = new Vector(5,2);
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (helicoptero);
	
		//assert
		assertTrue(!helicoptero.aterrizo());
	}
		
	public void testLlegadaDeUnAvionPesadoALaPistaSimpleEnUnaVectorQueEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		// removemos las pistas del nivel para evitar que el avion pueda aterrizar antes de llegar a la pista creada
		this.removerLasPistasDelNivel();
		//act
		this.moverAvion(avionPesado, posicion1);
		this.moverAvion(avionPesado, posicion2);
	
		/*creo las Vectores de la pista*/
	
		Vector posicionDeEntrada = new Vector(2,2);
		Vector otraPosicionDeLaPista1 = new Vector(3,3);
		Vector otraPosicionDeLaPista2 = new Vector(4,4);
		Vector ultimaPosicionDeLaPista = new Vector(5,5);
	
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
	
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
	
		pista.recibirAterrizajeDeObjetoVolador (avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaSimpleEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		// removemos las pistas del nivel para evitar que el avion pueda aterrizar antes de llegar a la pista creada
		this.removerLasPistasDelNivel();
		//act
		this.moverAvion(avionPesado, posicion3);
		this.moverAvion(avionPesado, posicion1);
		
		/*creo las Vectores de la pista*/
		Vector posicionDeEntrada = new Vector(1,1);
		Vector otraPosicionDeLaPista = new Vector(1,2);
		Vector otraPosicionDeLaPista1 = new Vector(1,3);
		Vector otraPosicionDeLaPista2 = new Vector(1,4);
		Vector ultimaPosicionDeLaPista = new Vector(1,5);
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (avionPesado);
			
		//assert
		assertTrue(!avionPesado.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaSimpleEnUnaVectorQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
		// removemos las pistas del nivel para evitar que el avion pueda aterrizar antes de llegar a la pista creada
		this.removerLasPistasDelNivel();
		//act
		this.moverAvion(avionPesado, posicion2);
		
		/*creo las Vectores de la pista*/
		Vector posicionDeEntrada = new Vector(1,2);
		Vector otraPosicionDeLaPista = new Vector(2,2);
		Vector otraPosicionDeLaPista1 = new Vector(3,2);
		Vector otraPosicionDeLaPista2 = new Vector(4,2);
		Vector ultimaPosicionDeLaPista = new Vector(5,2);
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaSimple pista = new PistaSimple(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador (avionPesado);
			
		//assert
		assertTrue(!avionPesado.aterrizo());
	}
	
	
}
