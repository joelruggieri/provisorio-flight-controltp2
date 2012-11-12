package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;

public class PistaSimpleTest extends TestCase {
	
	
	private ArrayList<Posicion> unaTrayectoria;
	private Posicion posicion1,posicion2,posicion3;
	
	
	protected void setUp () throws Exception {
		super.setUp();
		
		posicion1 = new Posicion(1,1);
		posicion2 = new Posicion(2,2);
		posicion3 = new Posicion(1,2);
		unaTrayectoria = new ArrayList<Posicion>();
		
	}
	
	private void moverAvion (ObjetoVolador unAvion, Posicion destino){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una posicion */
		/* post: El avion se movio */
		
		unaTrayectoria.add(destino);
		unAvion.crearTrayectoria (unaTrayectoria);
		
		while (!unAvion.getPosicion().equals(destino)){
			unAvion.moverse();
		}
		
	}
	
	
	public void testConstructorDeUnaPistaSimpleLasPosicionesDeLaPistaDeberianEstarOcupadasPorEsta() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		//arrange
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(4,1);
			Posicion otraPosicionDeLaPista = new Posicion(3,2);
		
		//act
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
		
		//assert
			assertEquals(unPlano.getPosicion(posicionDeEntrada),"pista");
			assertEquals(unPlano.getPosicion(otraPosicionDeLaPista),"pista");
	}
	
	public void testConstructorDeUnaPistaSimpleLaDireccionDeIngresoDeberiaQuedarDeterminadaSegunLaorientacionDeLaPista(){
		
		//arrange
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(4,1);
			Posicion otraPosicionDeLaPista = new Posicion(3,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(2,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(1,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(0,5);
		
		//act
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
		
		//assert	
			assertTrue(((pista.direccionDeEntrada().getPosicionX()) == -1) && ((pista.direccionDeEntrada().getPosicionY()) == 1));
	}

	public void testPosicionDeEntradaDeberiaRetornarLaUnicaPosicionPorLaCualSePuedeAterrizar(){
		
		//arrange
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(4,1);
			Posicion otraPosicionDeLaPista = new Posicion(3,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(2,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(1,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(0,5);
		
		//act
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
		//assert	
			assertTrue(pista.posicionDeEntrada() == posicionDeEntrada);
	}
	
	
	public void testConstructorDeUnaPistaSimpleEnHorizontalLaDireccionDeIngresoDeberiaQuedarDeterminadaSegunLaorientacionDeLaPista(){
		
		//arrange
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(4,5);
			Posicion otraPosicionDeLaPista = new Posicion(4,4);
			Posicion otraPosicionDeLaPista1 = new Posicion(4,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,2);
			Posicion ultimaPosicionDeLaPista = new Posicion(4,1);
		
		//act
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
			Posicion direccion = new Posicion(0,-1);
		
		//assert
			assertTrue(((pista.direccionDeEntrada().getPosicionX()) == direccion.getPosicionX()) && ((pista.direccionDeEntrada().getPosicionY()) == direccion.getPosicionY()));
	}
	
	
	public void testLlegadaDeUnAvionSimpleALaPistaSimpleEnUnaPosicionQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
			
		//act	
			this.moverAvion (avion,posicion1);
			this.moverAvion(avion,posicion2);
			
			/*creo las posiciones de la pista*/
			
			Posicion posicionDeEntrada = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,5);
			
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionSimple(avion);
		
		//assert
			assertTrue(avion.aterrizo());
	}
	
public void testLlegadaDeUnAvionSimpleALaPistaSimpleEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
		
		//act
			this.moverAvion(avion,posicion2);
			this.moverAvion(avion, posicion3);
			
			/*creo las posiciones de la pista*/
			
			Posicion posicionDeEntrada= new Posicion(1,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(1,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(1,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(1,5);
			
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionSimple(avion);
			
		//assert
			assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionSimpleALaPistaSimpleEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
		//arrange
			int velocidadDelAvion = 2;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
		
		//act
			this.moverAvion(avion, posicion2);
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,2);
			Posicion otraPosicionDeLaPista = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,2);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,2);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,2);
			
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionSimple(avion);
		
		//assert
			assertTrue(!avion.aterrizo());
	}


	public void testLlegadaDeUnAvionHelicopteroALaPistaSimpleEnUnaPosicionQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			Helicoptero helicoptero = new Helicoptero(velocidadDelAvion,dimension,unPlano);
		
		//act
			this.moverAvion(helicoptero,posicion1);
			this.moverAvion(helicoptero, posicion2);
		
			/*creo las posiciones de la pista*/
			
			Posicion posicionDeEntrada = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,5);
		
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
		
			pista.llegadaDeAvionHelicoptero(helicoptero);
		
		//assert
			assertTrue(helicoptero.aterrizo());
	}
	
	public void testLlegadaDeUnAvionHelicopteroALaPistaSimpleEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			Helicoptero helicoptero = new Helicoptero(velocidadDelAvion,dimension,unPlano);
		
		//act
			this.moverAvion(helicoptero, posicion3);
			this.moverAvion(helicoptero, posicion1);
		
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,1);
			Posicion otraPosicionDeLaPista = new Posicion(1,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(1,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(1,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(1,5);
			
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionHelicoptero(helicoptero);
		
		//assert
			assertTrue(!helicoptero.aterrizo());
	}

	public void testLlegadaDeUnAvionHelicopteroALaPistaSimpleEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
		//arrange
			int velocidadDelAvion = 2;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			Helicoptero helicoptero = new Helicoptero(velocidadDelAvion,dimension,unPlano);
		
		//act
			this.moverAvion(helicoptero, posicion2);
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,2);
			Posicion otraPosicionDeLaPista = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,2);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,2);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,2);
			
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionHelicoptero(helicoptero);
		
		//assert
			assertTrue(!helicoptero.aterrizo());
	}
		

	public void testLlegadaDeUnAvionPesadoALaPistaSimpleEnUnaPosicionQueEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);
		
		//act
			this.moverAvion(avion, posicion1);
			this.moverAvion(avion, posicion2);
		
			/*creo las posiciones de la pista*/
		
			Posicion posicionDeEntrada = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,5);
		
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
		
			pista.llegadaDeAvionPesado(avion);
		
		//assert
			assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaSimpleEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);
			
		//act
			this.moverAvion(avion, posicion3);
			this.moverAvion(avion, posicion1);
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,1);
			Posicion otraPosicionDeLaPista = new Posicion(1,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(1,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(1,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(1,5);
			
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionPesado(avion);
		
		//assert
			assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaSimpleEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 2;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);
		
		//act
			this.moverAvion(avion, posicion2);
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,2);
			Posicion otraPosicionDeLaPista = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,2);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,2);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,2);
			
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaSimple pista = new PistaSimple(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionPesado(avion);
			
		//assert
			assertTrue(!avion.aterrizo());
	}
			

}
