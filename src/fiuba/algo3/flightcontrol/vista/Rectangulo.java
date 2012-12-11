package fiuba.algo3.flightcontrol.vista;

import fiuba.algo3.flightcontrol.modelo.NoTieneUnaDireccionDeEntradaException;
import fiuba.algo3.flightcontrol.modelo.Pista;
import fiuba.algo3.flightcontrol.modelo.Vector;
import fiuba.algo3.titiritero.dibujables.Figura;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import java.awt.Graphics;

public class Rectangulo  extends Figura {
	
	private int extremoX;
	private int extremoY;
	
	public Rectangulo(int ultimaPosicionX, int ultimaPosicionY, 
			ObjetoPosicionable objetoPosicionable) {
		
		super(objetoPosicionable);
		extremoX = ultimaPosicionX;
		extremoY = ultimaPosicionY;
		
	}

	public void dibujar(SuperficieDeDibujo superficie) {
	
		final int tamano = 20;
		final int uno = 1;
		final int cero = 0;
		int x, y, largo;
		
		Graphics grafico = ((SuperficiePanel) superficie).getBuffer();
		grafico.setColor(this.getColor());
		Pista objeto = (Pista) getPosicionable();
		Vector direccionSur = new Vector(cero, uno);
		Vector direccionOeste = new Vector(uno, cero);
		
		x = objeto.getX();
		y = objeto.getY();
		largo = objeto.getLargo();
		
		try {
		 Vector direccion = objeto.getDireccionDeEntrada();
		
		} catch (NoTieneUnaDireccionDeEntradaException e) {
		 
			grafico.fillRect(x, y, tamano, tamano);
			grafico.fillOval(x, y, tamano, tamano);
			return;
		}
		
		if (objeto.getDireccionDeEntrada().equals(direccionSur)) {
			grafico.fillRect(x, y, tamano, objeto.getLargo());
			grafico.fillOval(x, y, tamano, tamano);
		
		} else if (objeto.getDireccionDeEntrada().
				equals(direccionSur.invertirDireccion())) {
			
			grafico.fillRect(extremoX, extremoY, tamano, largo);
			grafico.fillOval(x, y, tamano, tamano);
		
		} else if (objeto.getDireccionDeEntrada().
				equals(direccionOeste)) {
			
			grafico.fillRect(x, y, largo, tamano);
			grafico.fillOval(x, y, tamano, tamano);
		
		} else {
			grafico.fillRect(extremoX, extremoY, largo, tamano);
			grafico.fillOval(x, y, tamano, tamano);
			
		}
	}
}
	
	
	
