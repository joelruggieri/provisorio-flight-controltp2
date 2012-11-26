package fiuba.algo3.flightcontrol.vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class ObservadorDePista implements Observer {

	private GameLoop gameLoop;
	
	public ObservadorDePista(GameLoop unGameLoop) {
		
		this.gameLoop = unGameLoop;
	}
	
	public void update(Observable arg0, Object unObjetoVolador) {
		
		this.gameLoop.remover((ObjetoVivo)unObjetoVolador);
		
	}

}
