package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;

public class PistaDobleEntradaTest extends TestCase {
	
public void testConstructorDeUnaPistaDobleEntradaLasPosicionesDeLaPistaDeberianEstarOcupadasPorEsta() throws PosicionFueraDeLasDimensionesEstablecidasException{
		
		int dimension = 7;
		Escenario unPlano = new Escenario(dimension);
		ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
		
		/*creo las posiciones de la pista*/
		Posicion posicionDeEntrada = new Posicion(4,1);
		Posicion otraPosicionDeLaPista = new Posicion(3,2);
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
		
		assertEquals(unPlano.getPosicion(posicionDeEntrada),"pista");
		assertEquals(unPlano.getPosicion(otraPosicionDeLaPista),"pista");
	}

public void testConstructorDeUnaPistaDobleEntradaDeberianQuedarDefinidasLasDosdireccionesDeEntrada() throws PosicionFueraDeLasDimensionesEstablecidasException{
	
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	
	/*creo las posiciones de la pista*/
	Posicion posicionDeEntrada = new Posicion(4,1);
	Posicion otraPosicionDeLaPista = new Posicion(3,2);
	
	posicionesDeLaPista.add(posicionDeEntrada);
	posicionesDeLaPista.add(otraPosicionDeLaPista);
	
	PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
	
	Posicion direccionDePrimeraEntrada = new Posicion(-1,1);
	Posicion direccionDeSegundaEntrada = new Posicion(1,-1);
	
	assertTrue(pista.direccionesDeIngreso.get(0).equals(direccionDePrimeraEntrada));
	assertTrue(pista.direccionesDeIngreso.get(1).equals(direccionDeSegundaEntrada));
}


	public void testValidarEntradaYDireccionDeUnAvionQueSeEncuentreEnAlgunaDeLasPosicionesDeEntradaYConLaDireccionAdecuadaDeberiaDarVerdadero(){
		
		int dimension = 7;
		int velocidad = 1;
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
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
		
		assertTrue(pista.validarEntradaYDireccion(simple));
		
	}
	
	
public void testValidarEntradaYDireccionDeUnAvionQueSeEncuentreEnAlgunaDeLasPosicionesDeEntradaPeroConUnaDireccionIndaecuadaDeberiaDarFalso(){
		
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
		
		posicionesDeLaPista.add(posicionDeEntrada);
		posicionesDeLaPista.add(otraPosicionDeLaPista);
		posicionesDeLaPista.add(otraPosicionDeLaPista1);
		posicionesDeLaPista.add(otraPosicionDeLaPista2);
		posicionesDeLaPista.add(ultimaPosicionDeLaPista);
		
		PistaDobleEntrada pista = new PistaDobleEntrada(unPlano,posicionesDeLaPista);
		
		assertTrue(!pista.validarEntradaYDireccion(simple));
		
	}


public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaPosicionQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
	
	int velocidadDelAvion = 1;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
	
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
	
	assertTrue(avion.aterrizo());
}


public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
	int velocidadDelAvion = 1;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
	
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
	
	assertTrue(!avion.aterrizo());
}


public void testLlegadaDeUnAvionSimpleALaPistaDobleEntradaEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
	int velocidadDelAvion = 2;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	AvionSimple avion = new AvionSimple(velocidadDelAvion,dimension,unPlano);
	
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
	
	assertTrue(!avion.aterrizo());
}


public void testLlegadaDeUnAvionHelicopteroALaPistaDobleEntradaEnUnaPosicionQueEsLaDeEntradaYConDireccionApropiadaDeberiaAterrizar(){
	
	int velocidadDelAvion = 1;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	Helicoptero helicoptero = new Helicoptero(velocidadDelAvion,dimension,unPlano);

	helicoptero.moverse();

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

	pista.llegadaDeAvionHelicoptero(helicoptero);

	assertTrue(helicoptero.aterrizo());
	
	
}

public void testLlegadaDeUnAvionHelicopteroALaPistaSimpleEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
	int velocidadDelAvion = 1;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	Helicoptero helicoptero = new Helicoptero(velocidadDelAvion,dimension,unPlano);
	
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
	
	assertTrue(!helicoptero.aterrizo());
}

public void testLlegadaDeUnAvionHelicopteroALaPistaDobleEntradaEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
	int velocidadDelAvion = 2;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	Helicoptero helicoptero = new Helicoptero(velocidadDelAvion,dimension,unPlano);
	
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
	
	assertTrue(!helicoptero.aterrizo());
}


public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaEnUnaPosicionQueEsLaDeEntradaNoDeberiaAterrizar(){
	
	int velocidadDelAvion = 1;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);

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

	assertTrue(!avion.aterrizo());
}


public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaEnUnaDireccionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
	int velocidadDelAvion = 1;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);
	
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
	
	assertTrue(!avion.aterrizo());
}

public void testLlegadaDeUnAvionPesadoALaPistaDobleEntradaeEnUnaPosicionQueNoEsLaDeEntradaNoDeberiaAterrizar(){
	
	int velocidadDelAvion = 2;
	int dimension = 7;
	Escenario unPlano = new Escenario(dimension);
	ArrayList<Posicion> posicionesDeLaPista = new ArrayList<Posicion>();
	AvionPesado avion = new AvionPesado(velocidadDelAvion,dimension,unPlano);
	
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
	
	assertTrue(!avion.aterrizo());
}

}
