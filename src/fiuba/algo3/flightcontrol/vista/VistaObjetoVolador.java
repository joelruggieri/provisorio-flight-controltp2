package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;

import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;

public class VistaObjetoVolador extends Circulo {

	public VistaObjetoVolador(ObjetoVolador modelo) {
		super(20, modelo);
		this.setColor(Color.GREEN);
	}	
}
