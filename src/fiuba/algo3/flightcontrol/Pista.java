package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

public abstract class Pista{

	protected ArrayList<Posicion> posiciones;
	protected ArrayList<Posicion> direccionesDeIngreso;
	
	public Pista(Escenario unPlano, ArrayList<Posicion> unasEntradas){
		/* Constructor de una pista */
		
		this.posiciones = unasEntradas;
		
		int i = 0;
		while( posiciones.size() > i ){
			
			unPlano.posicionOcupadaPor(posiciones.get(i), "pista");
			i++;
			
		}
	}
	
	public Posicion direccionDeEntrada(){
		
		return this.direccionesDeIngreso.get(0);
	}
	
	public Posicion posicionDeEntrada(){
		return this.posiciones.get(0);
	}
	
	abstract public void llegadaDeAvionSimple(AvionSimple simple);
	
	abstract public void llegadaDeAvionHelicoptero(Helicoptero helicoptero);
	
	abstract public void llegadaDeAvionComputarizado(AvionComputarizado computarizado);
	
	abstract public void llegadaDeAvionPesado(AvionPesado pesado);
}