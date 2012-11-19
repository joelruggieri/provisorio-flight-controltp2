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
	
	
	
	public Vector getPosicionDeEntrada(){
		
		return this.posiciones.get(0);
	}
	
	public Vector getDireccionDeEntrada(){
		
		return this.direccionesDeIngreso.get(0);
	}
	
	public void recibirAterrizajeDeAvionSimple (AvionSimple simple){
		if(simple.getPosicion().esIgual(this.getPosicionDeEntrada()) && simple.getDireccion().esIgual(this.getDireccionDeEntrada())){
			simple.aterrizar();
		}
	}
	
	 public void recibirAterrizajeDeHelicoptero(Helicoptero helicoptero){
		 
	 }
	
	 public void recibirAterrizajeDeComputarizado(AvionComputarizado computarizado){
		 if(computarizado.getPosicion().esIgual(this.getPosicionDeEntrada()) && computarizado.getDireccion().esIgual(this.getDireccionDeEntrada())){
				computarizado.aterrizar();
			}
	 }
	
	 public void recibirAterrizajeDeAvionPesado (AvionPesado pesado){
		
	}
}