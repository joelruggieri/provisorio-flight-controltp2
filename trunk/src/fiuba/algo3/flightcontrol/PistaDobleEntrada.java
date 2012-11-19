package fiuba.algo3.flightcontrol;
import java.util.List;
import java.util.ArrayList;

public class PistaDobleEntrada extends Pista {
	
		
	public PistaDobleEntrada(Escenario unPlano, List<Vector> unasEntradas) {
				
		super(unPlano, unasEntradas);
		
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
	
	private boolean validarPrimeraEntradaYDireccion(ObjetoVolador avion) {
		
		boolean ingresoPorDireccion, ingresoPorPosicion;
		Vector direcDeIngreso, miDireccion;
		Vector posDeIngreso, miPosicion;
		
		miPosicion = avion.getPosicion();
		posDeIngreso = this.getListaDePosicionesDeEntrada().get(0);
		
		miDireccion = avion.getDireccion();
		direcDeIngreso = this.getListaDeDireccionesDeEntrada().get(0);
		
		ingresoPorPosicion = miPosicion.esIgual(posDeIngreso);
		ingresoPorDireccion = miDireccion.esIgual(direcDeIngreso);
		
		return (ingresoPorPosicion && ingresoPorDireccion);
	}
	
	private boolean validarSegundaEntradaYDireccion(ObjetoVolador avion) {
		
		boolean ingresoPorDireccion, ingresoPorPosicion;
		Vector direcDeIngreso, miDireccion;
		Vector posDeIngreso, miPosicion;
		int pos = this.getListaDePosicionesDeEntrada().size() - 1;
		
		miPosicion = avion.getPosicion();
		posDeIngreso = this.getListaDePosicionesDeEntrada().get(pos);
		
		miDireccion = avion.getDireccion();
		direcDeIngreso = this.getListaDeDireccionesDeEntrada().get(1);
		
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
	
	
	public void recibirAterrizajeDeAvionSimple(AvionSimple simple) {
		
		if (this.validarEntradaYDireccion(simple)) {
			simple.aterrizar();
		}
		
	}
		
	public void recibirAterrizajeDeComputarizado(AvionComputarizado avion) {
		
		if (this.validarEntradaYDireccion(avion)) {
			avion.aterrizar();
		}
		
	}
	
}
