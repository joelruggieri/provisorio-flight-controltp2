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
		
		Color color;
		
		if (modelo.getClass() == Helipuerto.class){
			color = new Color (150,150,150);
		}else if (modelo.getClass() == PistaLarga.class){
			color = new Color (100,100,100);
		}else if (modelo.getClass() == PistaDobleEntrada.class){
			color = new Color (50,50,50);
		}else{
			color = new Color (0,0,0);
		}
		
	return color;
	}
}
