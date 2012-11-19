package fiuba.algo3.flightcontrol;

import java.util.List;

public class Helipuerto extends Pista {
	
	public Helipuerto(Escenario unPlano, List<Vector> unasEntradas){
		
		super(unPlano,unasEntradas);
		
	}
	
	public Vector getDireccionDeEntrada(){
		
		throw new NoTieneUnaDireccionDeEntradaException();
	}
	
	
	public void recibirAterrizajeDeAvionSimple (AvionSimple simple){
		
	}
	
	public void recibirAterrizajeDeHelicoptero (Helicoptero helicoptero){
		
		if(helicoptero.getPosicion().esIgual(this.getPosicionDeEntrada())){
			
			helicoptero.aterrizar();
		}
		
		
	}
	
	public void recibirAterrizajeDeComputarizado (AvionComputarizado computarizado){
		
		
	}
	
	public void recibirAterrizajeDeAvionPesado (AvionPesado pesado){
		
	}

}
