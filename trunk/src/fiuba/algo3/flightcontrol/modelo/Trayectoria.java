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
		
		if (this.noEstaVacia()) {
			this.listaDePosiciones.remove(0);
		}
	}
		
	public boolean noEstaVacia() {
		
		return (!this.listaDePosiciones.isEmpty());
	}
}
