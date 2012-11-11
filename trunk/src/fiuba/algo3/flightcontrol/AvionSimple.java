package fiuba.algo3.flightcontrol;

public class AvionSimple extends ObjetoVolador {	
	
	public AvionSimple(int velocidadInicial, int limite, Escenario unPlano){
		/* Constructor de una avion simle */
		super (velocidadInicial, limite, unPlano);
		
		this.tipoDeObjetoVolador = "avionSimple" ;
		
	}
	
	public void moverse() {
		/* Mueve el objeto volador siguiendo la trayectoria o en el sentido de la direccion si no hay trayectoria definida */
		/* post: cambia el valor de la posicion actual, buscando el movimiento mas optimo posible */
		
		this.plano.posicionQuedaVacio(posicionActual);
		
		if (this.trayectoria.getPrimerPosicion() == null){
			
			this.posicionActual = this.posicionActual.sumar(this.direccion);
			
		}else{
			
			this.trayectoria.getProximaPosicion(posicionActual);
			
		}
		
			this.plano.posicionOcupadaPor(posicionActual, "objetoVolador");
		}
	}

