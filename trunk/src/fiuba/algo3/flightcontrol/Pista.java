package fiuba.algo3.flightcontrol;

import java.util.List;

public abstract class Pista{

	protected List<Vector> posiciones;
	protected List<Vector> direccionesDeIngreso;
	
	public Pista(Escenario unPlano, List<Vector> unasEntradas){
		/* Constructor de una pista */
		
		this.posiciones = unasEntradas;
		
		int i = 0;
		while( posiciones.size() > i ){
			
			unPlano.ocuparPosicion (posiciones.get(i), "pista");
			i++;
			
		}
	}
	
	public Vector getDireccionDeEntrada(){
		
		return this.direccionesDeIngreso.get(0);
	}
	
	public Vector getPosicionDeEntrada(){
		
		return this.posiciones.get(0);
	}
	
	abstract public void recibirAterrizajeDeAvionSimple (AvionSimple simple);
	
	abstract public void recibirAterrizajeDeHelicoptero(Helicoptero helicoptero);
	
	abstract public void recibirAterrizajeDeAvionComputarizado(AvionComputarizado computarizado);
	
	abstract public void recibirAterrizajeDeAvionPesado (AvionPesado pesado);
}