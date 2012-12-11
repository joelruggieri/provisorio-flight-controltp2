package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;

import fiuba.algo3.flightcontrol.modelo.Helipuerto;
import fiuba.algo3.flightcontrol.modelo.Pista;
import fiuba.algo3.flightcontrol.modelo.PistaDobleEntrada;
import fiuba.algo3.flightcontrol.modelo.PistaLarga;


public class VistaPista extends Rectangulo {
	//hay que sacarlo
	private Rectangulo dibujo;
		
	public VistaPista(Pista modelo) {
		super(modelo.getPosicionFinal().getPosicionX(), 
			modelo.getPosicionFinal().getPosicionY(), modelo);
		this.setColor(this.pintar(modelo));
	}
	
	private Color pintar(Pista modelo) {
		
		Color color;
		final int color0 = 0;
		final int color50 = 50;
		final int color100 = 100;
		final int color150 = 150;
		
		if (modelo.getClass() == Helipuerto.class) {
			color = new Color(color150, color150, color150);
		} else if (modelo.getClass() == PistaLarga.class) {
			color = new Color(color100, color100, color100);
		} else if (modelo.getClass() == PistaDobleEntrada.class) {
			color = new Color(color50, color50, color50);
		} else {
			color = new Color(color0, color0, color0);
		}
		
	return color;
	}
}
