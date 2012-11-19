package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

public abstract class Pista {

	public List<Vector> posiciones;
	public List<Vector> direccionesDeIngreso;
	
	public Pista(Escenario unPlano, List<Vector> unasEntradas) {
		/* Constructor de una pista */
		
		this.posiciones = unasEntradas;
		
		int i = 0;
		while(posiciones.size() > i) {
			
			unPlano.ocuparPosicion(posiciones.get(i), "pista");
			i++;
		}
		
		int limite = this.posiciones.size() - 1;
		
		Vector segundoExtremo = this.posiciones.get(limite);
		Vector extremoDeEntrada = this.posiciones.get(0);
		
		Vector direccionDeEntrada;
		
		direccionDeEntrada = segundoExtremo.restar(extremoDeEntrada);
		direccionDeEntrada.canonizarPosicion();
		
		this.direccionesDeIngreso = new ArrayList<Vector>();
		this.direccionesDeIngreso.add(direccionDeEntrada);
		
	}
	
	public Vector getDireccionDeEntrada() {
		
		return this.direccionesDeIngreso.get(0);
	}
	
	public Vector getPosicionDeEntrada() {
		
		return this.posiciones.get(0);
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
		
		boolean posIguales, direcIguales;
		Vector miEntrada, miPosicion;
		
		miPosicion = this.getPosicionDeEntrada();
		miEntrada = this.getDireccionDeEntrada();
		
		posIguales = helicoptero.getPosicion().esIgual(miPosicion);
		direcIguales = helicoptero.getDireccion().esIgual(miEntrada);
		
		if (posIguales && direcIguales) {
			helicoptero.aterrizar();
		}
	}
	
	public void recibirAterrizajeDeComputarizado(AvionComputarizado avion) {
		
		boolean posicionesIguales, direccionesIguales;
		Vector miEntrada, miPosicion;
		
		miPosicion = this.getPosicionDeEntrada();
		miEntrada = this.getDireccionDeEntrada();
		
		posicionesIguales = avion.getPosicion().esIgual(miPosicion);
		direccionesIguales = avion.getDireccion().esIgual(miEntrada);
		
		if (posicionesIguales && direccionesIguales) {
			avion.aterrizar();
		}
	}
	
	abstract public void recibirAterrizajeDeAvionPesado(AvionPesado pesado);
	
	
}
