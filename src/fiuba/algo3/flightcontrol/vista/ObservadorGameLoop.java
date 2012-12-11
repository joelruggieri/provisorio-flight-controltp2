package fiuba.algo3.flightcontrol.vista;

import java.util.Iterator;

import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class ObservadorGameLoop implements ObservadorDeGameLoop {
	
	private SuperficieDeDibujo unaSuperficie;
	private ObservadorDeNivel observadorNivel;
	private GameLoop gameLoop;
	
	public ObservadorGameLoop(ObservadorDeNivel observadorNivel, 
			GameLoop gameLoop, SuperficieDeDibujo unaSuperficie) {
		
		this.gameLoop = gameLoop;
		this.observadorNivel = observadorNivel;
		this.unaSuperficie = unaSuperficie;
	}
		
	
	
	public void notificarCicloFinalizado() {
		ObjetoVolador avion = this.observadorNivel.getNave();
		this.gameLoop.agregar(avion);
		Circulo circulo = new VistaObjetoVolador((ObjetoVolador) avion);
		
		ObservadorDeObjetoVolador unObservador;
		
		unObservador = new ObservadorDeObjetoVolador(gameLoop, 
					circulo, unaSuperficie, avion);
		
	    avion.addObserver(unObservador);
		
	    this.removerAvionesAterrizados();
	    
	}
	
	private void removerAvionesAterrizados() {
		
		Nivel unNivel = this.observadorNivel.getNivel();
		Iterator iteradorObjetosVoladores;
		ObjetoVolador avion;
		
		iteradorObjetosVoladores = unNivel.getObjetosVoladores();
		
		while (iteradorObjetosVoladores.hasNext()) {
			
			avion = (ObjetoVolador) iteradorObjetosVoladores.next();
			
			if (avion.aterrizo()) {
				this.gameLoop.remover(avion); 
			}
		}
	}
	
}

