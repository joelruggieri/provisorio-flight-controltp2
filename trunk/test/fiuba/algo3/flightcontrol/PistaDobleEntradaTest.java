package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;

public class PistaDobleEntradaTest extends TestCase {
	
	public void testConstructorDeUnaPistaDobleEntradaLasPosicionesDeLaPistaDeberianEstarOcupadasPorEsta() throws PosicionFueraDeLasDimensionesEstablecidasException{
	
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
			
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
		//assert	
			assertEquals(unPlano.getPosicion(posicionDeEntrada),"pista");
			assertEquals(unPlano.getPosicion(otraPosicionDeLaPista),"pista");
	}

	public void testConstructorDeUnaPistaDobleEntradaDeberianQuedarDefinidasLasDosdireccionesDeEntrada() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
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
		
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
		
			Posicion direccionDePrimeraEntrada = new Posicion(-1,1);
			Posicion direccionDeSegundaEntrada = new Posicion(1,-1);
			
		//assert
			assertTrue(pista.direccionesDeIngreso.get(0).equals(direccionDePrimeraEntrada));
			assertTrue(pista.direccionesDeIngreso.get(1).equals(direccionDeSegundaEntrada));
	}

	public void testValidarEntradaYDireccionDeUnAvionQueSeEncuentreEnAlgunaDeLasPosicionesDeEntradaYConLaDireccionAdecuadaDeberiaDarVerdadero(){
		
		//arrange
			int dimension = 7;
			int velocidad = 1;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionSimple simple = new AvionSimple(velocidad,dimension,unPlano);
		
			ArrayList<Posicion> unaTrayectoria = new ArrayList<Posicion>();
			
			//simple.moverse();
	
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,1);
			Posicion otraPosicionDeLaPista = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,5);
		
		//act
			unaTrayectoria.add(posicionDeEntrada);
			simple.crearTrayectoria(unaTrayectoria);
		
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
			simple.moverse();
		
		//assert
			assertTrue(pista.validarEntradaYDireccion(simple));
		
	}
	
	public void testValidarEntradaYDireccionDeUnAvionQueSeEncuentreEnAlgunaDeLasPosicionesDeEntradaPeroConUnaDireccionIndaecuadaDeberiaDarFalso(){
		
		//arrange
			int dimension = 7;
			int velocidad = 5;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionSimple simple = new AvionSimple(velocidad,dimension,unPlano);
			//simple.moverse();
	
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,1);
			Posicion otraPosicionDeLaPista = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,5);
		
		//act	
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
		
		//assert
			assertTrue(!pista.validarEntradaYDireccion(simple));
		
	}

	public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaPosicionQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
		
		//act
			avion.moverse();
			
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,1);
			Posicion otraPosicionDeLaPista = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,5);
			
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionSimple(avion);
			
		//assert
			assertTrue(avion.aterrizo());
	}

	public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
		
		//act
			avion.moverse();
			
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
			
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionSimple(avion);
		
		//assert
			assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
			
		//act	
			avion.moverse();
			
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
			
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionSimple(avion);
		
		//assert
			assertTrue(!avion.aterrizo());
	}


	public void testLlegadaDeUnHelicopteroALaPistaDobleEntradaEnUnaPosicionQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			Helicoptero helicoptero = new Helicoptero(velocidadDelAvion,dimension,unPlano);
			ArrayList<Posicion> unaTrayectoria = new ArrayList<Posicion>();
		
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,1);
			Posicion otraPosicionDeLaPista = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,5);
		
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
			
		//act	
			unaTrayectoria.add(posicionDeEntrada);
			helicoptero.crearTrayectoria(unaTrayectoria);
			
			helicoptero.moverse();
		
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
		
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
			helicoptero.moverse();
			
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
			
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionHelicoptero(helicoptero);
			
		//assert
			assertTrue(!helicoptero.aterrizo());
	}

	public void testLlegadaDeUnAvionHelicopteroALaPistaDobleEntradaEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 2;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			Helicoptero helicoptero = new Helicoptero(velocidadDelAvion,dimension,unPlano);
		
		//act
			helicoptero.moverse();
			
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
			
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionHelicoptero(helicoptero);
			
		//assert
			assertTrue(!helicoptero.aterrizo());
	}


	public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaEnUnaPosicionQueEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);
		
		//act
			avion.moverse();
		
			/*creo las posiciones de la pista*/
			Posicion posicionDeEntrada = new Posicion(1,1);
			Posicion otraPosicionDeLaPista = new Posicion(2,2);
			Posicion otraPosicionDeLaPista1 = new Posicion(3,3);
			Posicion otraPosicionDeLaPista2 = new Posicion(4,4);
			Posicion ultimaPosicionDeLaPista = new Posicion(5,5);
		
			posicionesDeLaPista.add(posicionDeEntrada);
			posicionesDeLaPista.add(otraPosicionDeLaPista);
			posicionesDeLaPista.add(otraPosicionDeLaPista1);
			posicionesDeLaPista.add(otraPosicionDeLaPista2);
			posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
		
			pista.llegadaDeAvionPesado(avion);
		
		//assert
			assertTrue(!avion.aterrizo());
	}


	public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);
			
		//act
			avion.moverse();
			
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
			
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionPesado(avion);
		
		//assert
			assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaeEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
		
		//arrange
			int velocidadDelAvion = 1;
			int dimension = 7;
			Escenario unPlano = new Escenario(dimension);
			ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
			AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);
			
		//act
			avion.moverse();
			
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
			
			PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
			
			pista.llegadaDeAvionPesado(avion);
			
		//assert
			assertTrue(!avion.aterrizo());
	}
}
