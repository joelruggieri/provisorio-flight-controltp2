package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

public class Helicoptero extends ObjetoVolador {

	public Helicoptero(int nivel, Escenario unPlano) {
		
		super(nivel, unPlano);
		List<Vector> listaDePosiciones = new ArrayList<Vector>();
		this.setTrayectoria(new Trayectoria(listaDePosiciones));
		
	}
	
	public void mover() {
		/* Mueve el helicoptero siguiendo la trayectoria, y si no hay
		 * trayectoria definida se queda en el lugar */
		/* post: cambia el valor de la posicion actual, 
		 * buscando el movimiento mas optimo posible */
		
		if (this.getTrayectoria().hayTrayectoria()) {
			super.vivir();
		}
	}
	
}
