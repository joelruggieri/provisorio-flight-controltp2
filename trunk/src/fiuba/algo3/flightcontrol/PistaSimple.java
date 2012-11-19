package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

	public class PistaSimple extends Pista {
		
	
	public PistaSimple(Escenario unPlano, List<Vector> unasEntradas){
		
		super(unPlano,unasEntradas);
		
		/* Se los dos extremos de la pista para conocer la direccion en que deben entrar los
		 * objetos voladores por el extremo de entrada*/

		Vector segundoExtremo = (this.posiciones).get((this.posiciones.size())-1);
		Vector extremoDeEntrada = (this.posiciones).get(0);
		
		Vector direccionDeEntrada = segundoExtremo.restar(extremoDeEntrada);
		direccionDeEntrada.canonizarPosicion();
		
		this.direccionesDeIngreso = new ArrayList <Vector>();
		this.direccionesDeIngreso.add(direccionDeEntrada);

	}
	

	
	
	public void recibirAterrizajeDeAvionSimple (AvionSimple simple){
		
		if(simple.getPosicion().esIgual(this.getPosicionDeEntrada()) && simple.getDireccion().esIgual(this.getDireccionDeEntrada())){
			simple.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeHelicoptero (Helicoptero helicoptero){
		
	}
	
	public void recibirAterrizajeDeComputarizado (AvionComputarizado computarizado){
		
		if(computarizado.getPosicion().esIgual(this.getPosicionDeEntrada()) && computarizado.getDireccion().esIgual(this.getDireccionDeEntrada())){
			computarizado.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeAvionPesado (AvionPesado pesado){
		
	}
}
	
