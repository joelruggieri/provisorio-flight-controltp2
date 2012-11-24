package fiuba.algo3.flightcontrol.modelo;
import java.util.List;

public class Trayectoria {
	
	private List<Vector> listaDePosiciones;
	
	public Trayectoria(List<Vector> unaListaDePosiciones) {
		
		this.listaDePosiciones = unaListaDePosiciones;
	}	
	
	public Vector getProximaPosicion() {
		
		return this.listaDePosiciones.get(0);
	}
		
	public void borrarPosicion() {
		
		if (this.hayTrayectoria()) {
			this.listaDePosiciones.remove(0);
		}
	}
		
	public boolean hayTrayectoria() {
		
		return (!this.listaDePosiciones.isEmpty());
	}
}
