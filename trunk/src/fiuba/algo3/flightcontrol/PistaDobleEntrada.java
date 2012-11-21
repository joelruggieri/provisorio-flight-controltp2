package fiuba.algo3.flightcontrol;
import java.util.List;
import java.util.ArrayList;

public class PistaDobleEntrada extends Pista {
	
		
	public PistaDobleEntrada(List<Vector> unasEntradas) {
				
		super(unasEntradas);
		
		/* obtengo la otra direccion en la que pueden entrar los
		 * aviones por el otro extremo de la pista*/
		
		List<Vector> direccionesDeIngreso;
		
		Vector direccionDeEntrada = this.getDireccionDeEntrada();
		Vector otraDireccionDeEntrada;
		otraDireccionDeEntrada = direccionDeEntrada.invertirDireccion();
		
		direccionesDeIngreso = new ArrayList<Vector>();
		direccionesDeIngreso.add(direccionDeEntrada);
		direccionesDeIngreso.add(otraDireccionDeEntrada);
		
		this.agregarDireccionesDeIngreso(direccionesDeIngreso);
	}
	
	
	private Vector getPosicionDeSegundaEntrada() {
		
		int indiceUltimaPosicion = this.posiciones.size() - 1;	
		return this.posiciones.get(indiceUltimaPosicion);
	}
	
	protected void agregarDireccionesDeIngreso(List<Vector> direcciones) {
		
		this.direccionesDeIngreso = direcciones;
	}

	private Vector getDireccionDeSegundaEntrada() {
	
		return this.direccionesDeIngreso.get(1);
	}
	
	private boolean validarPrimeraEntradaYDireccion(ObjetoVolador avion) {
		
		boolean ingresoPorDireccion, ingresoPorPosicion;
		Vector direcDeIngreso, miDireccion;
		Vector posDeIngreso, miPosicion;
		
		miPosicion = avion.getPosicion();
		posDeIngreso = this.getPosicionDeEntrada();
		
		miDireccion = avion.getDireccion();
		direcDeIngreso = this.getDireccionDeEntrada();
		
		ingresoPorPosicion = miPosicion.esIgual(posDeIngreso);
		ingresoPorDireccion = miDireccion.esIgual(direcDeIngreso);
		
		return (ingresoPorPosicion && ingresoPorDireccion);
	}
	
	private boolean validarSegundaEntradaYDireccion(ObjetoVolador avion) {
		
		boolean ingresoPorDireccion, ingresoPorPosicion;
		Vector direcDeIngreso, miDireccion;
		Vector posDeIngreso, miPosicion;
		
		
		miPosicion = avion.getPosicion();
		posDeIngreso = this.getPosicionDeSegundaEntrada();
		
		miDireccion = avion.getDireccion();
		direcDeIngreso = this.getDireccionDeSegundaEntrada();
		
		ingresoPorPosicion = miPosicion.esIgual(posDeIngreso);
		ingresoPorDireccion = miDireccion.esIgual(direcDeIngreso);
		
		return (ingresoPorPosicion && ingresoPorDireccion);
	}
	
	public boolean validarEntradaYDireccion(ObjetoVolador avion) {
		
		boolean hayPrimeraEntrada, haySegundaEntrada;
		
		hayPrimeraEntrada = this.validarPrimeraEntradaYDireccion(avion);
		haySegundaEntrada = this.validarSegundaEntradaYDireccion(avion);
		
		return (hayPrimeraEntrada || haySegundaEntrada);
	}
	
	
	public void recibirAterrizajeDeObjetoVolador(AvionSimple simple) {
		
		if (this.validarEntradaYDireccion(simple)) {
			simple.aterrizar();
		}
		
	}
		
	public void recibirAterrizajeDeObjetoVolador(AvionComputarizado avion) {
		
		if (this.validarEntradaYDireccion(avion)) {
			avion.aterrizar();
		}
		
	}
	
}
