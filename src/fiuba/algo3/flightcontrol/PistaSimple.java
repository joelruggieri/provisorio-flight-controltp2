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
	
	public Vector getDireccionDeEntrada(){
		
		return this.direccionesDeIngreso.get(0);
	}
	
	public Vector getPosicionDeEntrada(){
		
		return this.posiciones.get(0);
	}
	
	public void recibirAterrizajeDeAvionSimple (AvionSimple simple){
		
		if(simple.getPosicion().equals(this.getPosicionDeEntrada()) && simple.getDireccion().equals(this.getDireccionDeEntrada())){
			simple.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeHelicoptero (Helicoptero helicoptero){
		
		if(helicoptero.getPosicion().equals(this.getPosicionDeEntrada()) && helicoptero.getDireccion().equals(this.getDireccionDeEntrada())){
			helicoptero.aterrizar();
		}
	}
	
	public void recibirAterrizajeDeAvionComputarizado (AvionComputarizado computarizado){
		
		if(computarizado.getPosicion().equals(this.getPosicionDeEntrada()) && computarizado.getDireccion().equals(this.getDireccionDeEntrada())){
			computarizado.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeAvionPesado (AvionPesado pesado){
		
	}
}
	
