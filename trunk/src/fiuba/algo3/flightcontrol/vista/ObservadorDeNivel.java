package fiuba.algo3.flightcontrol.vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class ObservadorDeNivel implements Observer {

	private GameLoop gameLoop;
	private SuperficieDeDibujo unaSuperficie;
	private Nivel nivel;
	
	public ObservadorDeNivel(GameLoop unGameLoop, SuperficieDeDibujo unaSuperficie, Nivel unNivel) {
		this.gameLoop = unGameLoop;
		this.unaSuperficie = unaSuperficie;
		this.nivel = unNivel;
	}
	
	public void update(Observable o, Object arg) {
		ObjetoVolador objetoVolador = nivel.getUltimoObjetoVolador();
		this.gameLoop.agregar(objetoVolador);
		Circulo circulo = new VistaObjetoVolador((ObjetoVolador)objetoVolador);
		
		ObservadorDeObjetoVolador unObservador = new ObservadorDeObjetoVolador(gameLoop, circulo, unaSuperficie, objetoVolador);
	    objetoVolador.addObserver(unObservador);

	}

}
