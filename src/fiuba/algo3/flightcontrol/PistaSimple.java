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
	

}
	
