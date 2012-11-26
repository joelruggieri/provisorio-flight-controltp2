package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;

import fiuba.algo3.flightcontrol.modelo.AvionComputarizado;
import fiuba.algo3.flightcontrol.modelo.AvionPesado;
import fiuba.algo3.flightcontrol.modelo.Helicoptero;
import fiuba.algo3.flightcontrol.modelo.Helipuerto;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.Pista;
import fiuba.algo3.flightcontrol.modelo.PistaDobleEntrada;
import fiuba.algo3.flightcontrol.modelo.PistaLarga;
import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaPista extends Cuadrado {
	
	public VistaPista(Pista modelo) {
		super(20, 20, modelo);
		this.setColor (this.pintar(modelo));
	}
	
	private Color pintar (Pista modelo){
		
		Color color = Color.GREEN;;
		
		if (modelo.getClass() == Helipuerto.class){
			color = Color.YELLOW;
		}else if (modelo.getClass() == PistaLarga.class){
			color = Color.CYAN;
		}else if (modelo.getClass() == PistaDobleEntrada.class){
			color = Color.BLUE;
		}
		
	return color;
	}
}
