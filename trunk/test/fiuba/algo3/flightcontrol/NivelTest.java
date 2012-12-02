package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.algo3.flightcontrol.modelo.EstanTodosLosOVDelNivelException;
import fiuba.algo3.flightcontrol.modelo.Helipuerto;
import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.Pista;
import fiuba.algo3.flightcontrol.modelo.PistaDobleEntrada;
import fiuba.algo3.flightcontrol.modelo.PistaLarga;
import fiuba.algo3.flightcontrol.modelo.PistaSimple;
import fiuba.algo3.flightcontrol.modelo.Vector;

public class NivelTest extends TestCase {
	
	
	private void pasarFrecuencia(Nivel unNivel){
		
		while(unNivel.getContadorDeTurno() < unNivel.getFrecunciaDeSalida()){
			
			unNivel.vivir();
			
		}
	}
	
	
	
	public void testConstructorDelNivelDeberiaGenerarUnaPistaDeCadaTipo(){
		
		int velocidad = 1;
		int dimension = 768;
		
		Nivel unNivel = new Nivel(velocidad,dimension);
		
		Iterator<Pista> iterador = unNivel.getPistas();
		assertTrue(iterador.next().getClass() == Helipuerto.class);
		assertTrue(iterador.next().getClass() == PistaSimple.class);
		assertTrue(iterador.next().getClass() == PistaDobleEntrada.class);
		assertTrue(iterador.next().getClass() == PistaLarga.class);
		
		
	}
	
	public void testGetPistaValidaNuncaDeberiaRetornarUnHelipuerto(){
		
		int velocidad = 1;
		int dimension = 768;
		
		Nivel unNivel = new Nivel (velocidad,dimension);
		
		for(int i = 0 ; i < 100000 ; i++ ) { 
			
			Pista unaPista = unNivel.getUnaPistaValida();
			
			assertTrue(unaPista.getClass() != Helipuerto.class);
			
		}
	}
	
	
	
	public void testGenerarObjetoVoladorMasVecesQueLaCantidadDeAvionesPermitidaEnElNivelDeberiaNoDeberiaAumentarLaCantidadDeAviones(){
		int velocidad = 1;
		int dimension = 768;
		
		Nivel unNivel = new Nivel(velocidad,dimension);
		
		//genero los 10 aviones permitidos en el nivel
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		unNivel.vivir();
		this.pasarFrecuencia(unNivel);
		assertTrue(unNivel.getCantidadDeAvionesGenerados() == 11);
		
	
	}
	
	public void testGenerarObjetoVoladorDebeGenerarAvionesConPosicionesEnLosBordes(){
		
		int velocidad = 100;
		int dimension = 768;
		
		Nivel unNivel = new Nivel(velocidad,dimension);
		
		for(int i = 0 ; i < 1000 ; i++){
			
			unNivel.vivir();
			this.pasarFrecuencia(unNivel);
			Iterator<ObjetoVolador> iteradorDeAviones = unNivel.getObjetosVoladores();
			ObjetoVolador unAvion = iteradorDeAviones.next();
			Vector posicionDelAvion = unAvion.getPosicion();
			
			assertTrue((posicionDelAvion.getPosicionX() == 0) || (posicionDelAvion.getPosicionX() == dimension-1) ||
					(posicionDelAvion.getPosicionY() == 0) || (posicionDelAvion.getPosicionY() == dimension-1));
		}
	}
}
