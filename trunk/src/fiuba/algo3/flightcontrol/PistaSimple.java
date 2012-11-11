package fiuba.algo3.flightcontrol;

import java.util.ArrayList;

	public class PistaSimple extends Pista {
	
	public PistaSimple(Escenario unPlano, ArrayList<Posicion> unasEntradas){
		/* Constructor de una pista Simple */
		
		super(unPlano,unasEntradas);
		
		/*tomamos los dos extremos de la pista para conocer la direccion en que deben entrar los
		 * objetos voladores por el extremo de entrada*/

		Posicion segundoExtremo = (this.posiciones).get((this.posiciones.size())-1);
		Posicion extremoDeEntrada = (this.posiciones).get(0);
		
		Posicion direccionDeEntrada = segundoExtremo.restar(extremoDeEntrada);
		direccionDeEntrada.canonizarPosicion();
		
		this.direccionesDeIngreso = new ArrayList<Posicion>();
		this.direccionesDeIngreso.add(direccionDeEntrada);

	}
	
	public Posicion direccionDeEntrada(){
		
		return this.direccionesDeIngreso.get(0);
	}
	
	public Posicion posicionDeEntrada(){
		return this.posiciones.get(0);
	}
	
	public void llegadaDeAvionSimple(AvionSimple simple){
		if(simple.getPosicion().equals(this.posicionDeEntrada()) && simple.getDireccion().equals(this.direccionDeEntrada())){
			simple.aterrizar();
		}
		
	}
	
	public void llegadaDeAvionHelicoptero(Helicoptero helicoptero){
		if(helicoptero.getPosicion().equals(this.posicionDeEntrada()) && helicoptero.getDireccion().equals(this.direccionDeEntrada())){
			helicoptero.aterrizar();
		}
	}
	
	public void llegadaDeAvionComputarizado(AvionComputarizado computarizado){
		if(computarizado.getPosicion().equals(this.posicionDeEntrada()) && computarizado.getDireccion().equals(this.direccionDeEntrada())){
			computarizado.aterrizar();
		}
		
	}
	
	public void llegadaDeAvionPesado(AvionPesado pesado){
		
	}
}
	
