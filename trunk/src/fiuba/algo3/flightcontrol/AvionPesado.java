package fiuba.algo3.flightcontrol;
import java.util.ArrayList;


public class AvionPesado extends ObjetoVolador {
	
	public AvionPesado(int nivel, Escenario unPlano){
		
		super (nivel, unPlano);
		listaDePosiciones  = new ArrayList <Vector>();
		this.trayectoria = new Trayectoria (listaDePosiciones);
		
	}
		
	public void mover() {
		/* Mueve el avion siguiendo la trayectoria o en el sentido de 
		 * la direccion si no hay trayectoria definida */
		/* post: cambia el valor de la posicion actual, buscando el movimiento mas optimo posible */
		
		if (!this.trayectoria.hayTrayectoria()){
					
			direccion = this.getDireccion();
			Vector posicionSiguiente = direccion.sumar(this.posicionActual);
			
			listaDePosiciones = new ArrayList <Vector> ();
			listaDePosiciones.add(posicionSiguiente);
			
			this.trayectoria = new Trayectoria (listaDePosiciones);
	
		}
		
		super.mover();
	}

}
