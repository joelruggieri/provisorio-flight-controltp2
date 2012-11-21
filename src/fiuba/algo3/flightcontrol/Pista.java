package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

public abstract class Pista {

	private List<Vector> posiciones;
	private List<Vector> direccionesDeIngreso;

	
	public Pista(List<Vector> unasEntradas) {
		/* Constructor de una pista */
		
		this.posiciones = unasEntradas;
		
		/* Se toman los dos extremos de la pista para conocer la 
		 * direccion en que deben entrar los
		 * objetos voladores por el extremo de entrada*/

		int limite = this.posiciones.size() - 1;
		
		Vector segundoExtremo = this.posiciones.get(limite);
		Vector extremoDeEntrada = this.posiciones.get(0);
		
		Vector direccionDeEntrada;
		
		direccionDeEntrada = segundoExtremo.restar(extremoDeEntrada);
		direccionDeEntrada.canonizarPosicion();
		
		this.direccionesDeIngreso = new ArrayList<Vector>();
		this.direccionesDeIngreso.add(direccionDeEntrada);
	}
		
	public Vector getPosicionDeEntrada() {
		
		return this.posiciones.get(0);
	}
	
	protected List<Vector> getListaDePosicionesDeEntrada() {
		
		return this.posiciones;
	}
	
	public Vector getDireccionDeEntrada() {
		
		return this.direccionesDeIngreso.get(0);
	}
	
	protected List<Vector> getListaDeDireccionesDeEntrada() {
		
		return this.direccionesDeIngreso;
	}
	
	protected void agregarDireccionesDeIngreso(List<Vector> direcciones) {
		
		this.direccionesDeIngreso = direcciones;
	}
	
	public void recibirAterrizajeDeAvionSimple(AvionSimple simple) {
		
		boolean posicionesIguales, direccionesIguales;
		Vector miEntrada, miPosicion;
		
		miPosicion = this.getPosicionDeEntrada();
		miEntrada = this.getDireccionDeEntrada();
		
		posicionesIguales = simple.getPosicion().esIgual(miPosicion);
		direccionesIguales = simple.getDireccion().esIgual(miEntrada);
		
		if (posicionesIguales && direccionesIguales) {
			simple.aterrizar();
		}
	}
	
	 public void recibirAterrizajeDeHelicoptero(Helicoptero helicoptero) {
	 }
	
	 public void recibirAterrizajeDeComputarizado(AvionComputarizado ac) {
		 
		boolean posicionesIguales, direccionesIguales;
		Vector miEntrada, miPosicion;
		
		miPosicion = this.getPosicionDeEntrada();
		miEntrada = this.getDireccionDeEntrada();
		
		posicionesIguales = ac.getPosicion().esIgual(miPosicion);
		direccionesIguales = ac.getDireccion().esIgual(miEntrada);
		
		if (posicionesIguales && direccionesIguales) {
			ac.aterrizar();
		}
	 }
	
	 public void recibirAterrizajeDeAvionPesado(AvionPesado pesado) {
	}
	 
	
}
