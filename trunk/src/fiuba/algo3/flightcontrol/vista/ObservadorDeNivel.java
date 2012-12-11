package fiuba.algo3.flightcontrol.vista;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class ObservadorDeNivel implements Observer {

	private Nivel nivel;
	private ObjetoVolador objetoVolador;
	
	public ObservadorDeNivel(GameLoop unGameLoop, SuperficieDeDibujo unaSuperficie, Nivel unNivel) {

		this.nivel = unNivel;
	}
	
	public void update(Observable o, Object arg) {
		this.objetoVolador = nivel.getUltimoObjetoVolador();

	}
	
	public ObjetoVolador getNave() {
		
		return this.objetoVolador;
	}
	
	public Nivel getNivel() {
		
		return nivel;
	}

}
