package fiuba.algo3.flightcontrol.vista;

import java.util.Observable;

import fiuba.algo3.titiritero.modelo.GameLoop;

public class ObservadorDeGameLoop {
	
	
	private ObservadorDeNivel observadorNivel;
	
	
	public ObservadorDeGameLoop(ObservadorDeNivel observadorNivel){
		
		
		this.observadorNivel = observadorNivel;
	}
		
	
	
	public void update(Observable arg0, Object aterrizo){
		
		this.observadorNivel.update(arg0, aterrizo);

	}

}
