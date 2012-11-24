package fiuba.algo3.flightcontrol.vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class ObservadorDeNivel implements Observer {

	private GameLoop gameLoop;
	
	public ObservadorDeNivel(GameLoop unGameLoop) {
		this.gameLoop = unGameLoop;
	}
	
	public void update(Observable o, Object unObjetoVolador) {
		this.gameLoop.agregar((ObjetoVolador)unObjetoVolador);
		Circulo circulo = new VistaObjetoVolador((ObjetoVolador)unObjetoVolador);
		this.gameLoop.agregar(circulo);
	}

}
