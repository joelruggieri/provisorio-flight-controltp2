package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;

import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaPista extends Cuadrado {
	
	public VistaPista(ObjetoPosicionable modelo) {
		super(20, 20, modelo);
		this.setColor(Color.BLUE);
	}
}
