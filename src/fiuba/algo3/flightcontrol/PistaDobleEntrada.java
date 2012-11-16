package fiuba.algo3.flightcontrol;
import java.util.List;
import java.util.ArrayList;

public class PistaDobleEntrada extends Pista {
	
	public PistaDobleEntrada(Escenario unPlano, List<Vector> unasEntradas){
				
		super(unPlano,unasEntradas);
		
		/* Se toman los dos extremos de la pista para conocer la direccion en que deben entrar los
		 * objetos voladores por el extremo de entrada*/

		Vector segundoExtremo = (this.posiciones).get((this.posiciones.size())-1);
		Vector extremoDeEntrada = (this.posiciones).get(0);
		
		Vector direccionDeEntrada = segundoExtremo.restar(extremoDeEntrada);
		direccionDeEntrada.canonizarPosicion();
		/* obtengo la otra direccion en la que pueden entrar los aviones por el otro extremo de la
		 * pista*/
		 
		Vector otraDireccionDeEntrada = direccionDeEntrada.InvertirDireccion();
		
		this.direccionesDeIngreso = new ArrayList<Vector>();
		this.direccionesDeIngreso.add(direccionDeEntrada);
		this.direccionesDeIngreso.add(otraDireccionDeEntrada);

	}
	

	private boolean validarPrimeraEntradaYDireccion (ObjetoVolador avion){
		
		return (avion.getDireccion().equals(this.direccionesDeIngreso.get(0))) &&
				(avion.getPosicion().equals(this.posiciones.get(0)));
	}
	
	private boolean validarSegundaEntradaYDireccion (ObjetoVolador avion){
		
		return (avion.getDireccion().equals(this.direccionesDeIngreso.get(1))) &&
				(avion.getPosicion().equals(this.posiciones.get(posiciones.size()-1)));
	}
	
	public boolean validarEntradaYDireccion (ObjetoVolador avion){
		
		return (this.validarPrimeraEntradaYDireccion(avion) || this.validarSegundaEntradaYDireccion(avion));
	}
	
	
	public void recibirAterrizajeDeAvionSimple (AvionSimple simple){
		
		if(this.validarEntradaYDireccion(simple)){
			simple.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeHelicoptero (Helicoptero helicoptero){
		
		if(this.validarEntradaYDireccion(helicoptero)){
			helicoptero.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeAvionComputarizado (AvionComputarizado computarizado){
		
		if(this.validarEntradaYDireccion(computarizado)){
			computarizado.aterrizar();
		}
		
	}
	
	public void recibirAterrizajeDeAvionPesado (AvionPesado pesado){
		
	}
}

