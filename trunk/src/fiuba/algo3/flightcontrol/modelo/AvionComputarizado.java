package fiuba.algo3.flightcontrol.modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class AvionComputarizado extends ObjetoVolador {
	
	public AvionComputarizado(int velocidad, Nivel unNivel) {
		
		super(velocidad, unNivel);
		List<Vector> listaDePuntos;
		
		Pista unaPista = unNivel.getUnaPistaValida();
		listaDePuntos = calcularTrayectoriaHaciaUnaPista(unaPista);
		this.setTrayectoria(new Trayectoria(listaDePuntos));
	}

	private List<Vector> calcularTrayectoriaHaciaUnaPista(Pista unaPista) {
		/* Determina una trayectoria de menor 
		 * distancia hacia una pista */
		
		List<Vector> trayectoriaDefinida = new ArrayList<Vector>();
		
		Vector posicionDeEntrada = unaPista.getPosicionDeEntrada();
		Vector direccionDeEntrada = unaPista.getDireccionDeEntrada();
		
		Vector posPreAterrizaje;
		posPreAterrizaje = posicionDeEntrada.restar(direccionDeEntrada.multiplicar(30));
				
		trayectoriaDefinida.add(posPreAterrizaje);
		trayectoriaDefinida.add(unaPista.getPosicionDeEntrada());
		
		return trayectoriaDefinida;
	}

	
    public void aterrizarSiHayPistaDeAterrizajeCompatible() {
    	
    	Iterator<Pista> it = this.getNivel().getPistas();
    	
    	while (it.hasNext() && !this.aterrizo()) {
    		
    		it.next().recibirAterrizajeDeObjetoVolador(this);
    	}
    	
    }
    
	public void vivir() {

		if (this.getTrayectoria().hayTrayectoria()) {
			super.vivir();
		}
	}
	
}
