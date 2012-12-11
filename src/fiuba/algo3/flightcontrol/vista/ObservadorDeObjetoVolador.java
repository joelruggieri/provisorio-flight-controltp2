package fiuba.algo3.flightcontrol.vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class ObservadorDeObjetoVolador implements Observer {

	private Circulo unaVista;
	private SuperficieDeDibujo unaSuperficie;
	private ObjetoVolador unObjetoVolador;
	private GameLoop unGameLoop;
	
	public ObservadorDeObjetoVolador(GameLoop unGameLoop, 
			Circulo unaVista, SuperficieDeDibujo unPanel, 
			ObjetoVolador unObjetoVolador) {
		
		this.unaVista = unaVista;
		this.unaSuperficie = unPanel;
		this.unObjetoVolador = unObjetoVolador;
		this.unGameLoop = unGameLoop;
	}
	
	public void update(Observable arg0, Object aterrizo) {
		if (!this.unObjetoVolador.aterrizo()) {
			unaVista.dibujar(unaSuperficie);	
		} 
		
		if (this.unObjetoVolador.chocar()) {
			this.unGameLoop.detenerEjecucion();
		}

	}

}
