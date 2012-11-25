package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;

import fiuba.algo3.flightcontrol.modelo.AvionComputarizado;
import fiuba.algo3.flightcontrol.modelo.AvionPesado;
import fiuba.algo3.flightcontrol.modelo.Helicoptero;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;

public class VistaObjetoVolador extends Circulo {

	public VistaObjetoVolador(ObjetoVolador modelo) {
		super(20, modelo);
		this.setColor (this.pintar(modelo));
	}
	
	private Color pintar (ObjetoVolador modelo){
		
		Color color = Color.GREEN;;
		
		if (modelo.getClass() == Helicoptero.class){
			color = Color.YELLOW;
		}else if (modelo.getClass() == AvionComputarizado.class){
			color = Color.RED;
		}else if (modelo.getClass() == AvionPesado.class){
			color = Color.ORANGE;
		}
		
	return color;
	}
	
}
