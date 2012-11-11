package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.lang.Math;

public class Trayectoria {
	
	private ArrayList<Posicion> listaDePosiciones;
	
	public Trayectoria (ArrayList<Posicion> unaListaDePosiciones){
		/* Constructor de una trayectoria */
		/* pre: una lista de posiciones con posiciones, o vacia */
		/* post: establece la trayectoria deseada */
		
		this.listaDePosiciones = unaListaDePosiciones;
		
	}	
	
	public Posicion getProximaPosicion(Posicion posicionActual){
		/* Devuelve la proxima posicion mas optima para moverse. En caso de que no haya trayectoria, devuelve null */
		/* pre: la lista de posiciones debe tener al menos una posicion a ir */
		/* post: cambia la posicion actual a la posicion siguiente */
		
		Posicion destino = this.getPrimerDestino();
		Posicion proximaPosicion = null;
		Posicion direccion;
		
		if (destino != null){
			
			direccion = this.getVectorDirector(posicionActual);
			proximaPosicion = direccion.sumar(posicionActual);
			
			if (proximaPosicion.equals(destino)){
				this.listaDePosiciones.remove(0);
			}
		}
		
		return proximaPosicion;
	}
	
	private Posicion getPrimerDestino(){
		/* Devuelve la primera posicion destino de la trayectoria */
		/* post: devuelve la primer posicion, o null de no haber ningun destino definido */
		
		if (this.listaDePosiciones.isEmpty()){
			return null;
		}
		
		return this.listaDePosiciones.get(0);
	}
	
	private Posicion canonizarDireccion (Posicion posicion){
		
		int x = posicion.getPosicionX();
		int y = posicion.getPosicionY();
		int direccionX, direccionY;
		
		//Para conservar el signo de la direccion.
		direccionX = x / Math.abs(x);
		direccionY = y / Math.abs(y);
		
		if (x < y){
			direccionX = 0;
		}else if (x > y){
			direccionY = 0;
		}
		
		return (new Posicion (direccionX,direccionY));
		
	}
	
	public Posicion getVectorDirector (Posicion actual){
		/* Devuelve la direccion de la trayectoria. Si no hay trayectoria devuelve null */
		/* pre: Se ingresa una Posicion */
		/* post: Devuelve una posicion, que indica la direccion de la trayectoria */
		
		Posicion direccion = null;
		Posicion destino = this.getPrimerDestino();
		
		if (destino != null){
			
			direccion = destino.restar(actual);
			direccion = this.canonizarDireccion (direccion);
		}
		
		return direccion;
	}
		
}
