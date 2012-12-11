package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;

import fiuba.algo3.flightcontrol.modelo.Helipuerto;
import fiuba.algo3.flightcontrol.modelo.Pista;
import fiuba.algo3.flightcontrol.modelo.PistaDobleEntrada;
import fiuba.algo3.flightcontrol.modelo.PistaLarga;


public class VistaPista extends Rectangulo {
	private Rectangulo dibujo;
		
	public VistaPista(Pista modelo) {
		super (modelo.getPosicionFinal().getPosicionX(), modelo.getPosicionFinal().getPosicionY(), modelo);
		this.setColor(this.pintar(modelo));
	}
	
	private Color pintar(Pista modelo) {
		
		Color color;
		
		if (modelo.getClass() == Helipuerto.class) {
			color = new Color(150, 150, 150);
		} else if (modelo.getClass() == PistaLarga.class) {
			color = new Color(100, 100, 100);
		} else if (modelo.getClass() == PistaDobleEntrada.class) {
			color = new Color(50, 50, 50);
		} else {
			color = new Color(0, 0, 0);
		}
		
	return color;
	}
}
