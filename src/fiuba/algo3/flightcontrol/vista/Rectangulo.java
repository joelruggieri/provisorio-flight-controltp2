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
	
	public Rectangulo (int ultimaPosicionX, int ultimaPosicionY, ObjetoPosicionable objetoPosicionable) {
		
		super(objetoPosicionable);
		extremoX = ultimaPosicionX;
		extremoY = ultimaPosicionY;
		
	}


	public void dibujar(SuperficieDeDibujo superficie) {
	
		Graphics grafico = ((SuperficiePanel)superficie).getBuffer();
		grafico.setColor(this.getColor());
		Pista objeto = (Pista) getPosicionable();
		 Vector direccionSur = new Vector(0, 1);
		 Vector direccionOeste = new Vector(1, 0);
		 
		 try{
			 Vector direccion = objeto.getDireccionDeEntrada();
		 
		 } catch(NoTieneUnaDireccionDeEntradaException e) {
			 
			 grafico.fillRect(objeto.getX(), objeto.getY(), 20, 20);
			 grafico.fillOval(objeto.getX(), objeto.getY(), 20, 20);
			 return;
		 }
		 
		 if (objeto.getDireccionDeEntrada().esIgual(direccionSur)) {
			 grafico.fillRect(objeto.getX(), objeto.getY(), 20, objeto.getLargo());
			 grafico.fillOval(objeto.getX(), objeto.getY(), 20, 20);
		 
		 } else if (objeto.getDireccionDeEntrada().esIgual(direccionSur.invertirDireccion())) {
			 grafico.fillRect(extremoX, extremoY, 20, objeto.getLargo());
			 grafico.fillOval(objeto.getX(), objeto.getY(), 20, 20);
		 
		 } else if (objeto.getDireccionDeEntrada().esIgual(direccionOeste)){
			 grafico.fillRect(objeto.getX(), objeto.getY(), objeto.getLargo(), 20);
			 grafico.fillOval(objeto.getX(), objeto.getY(), 20, 20);
		 
		 } else /*if(objeto.getDireccionDeEntrada().esIgual(direccionOeste.invertirDireccion()))*/{
			 grafico.fillRect(extremoX, extremoY, objeto.getLargo(), 20);
			 grafico.fillOval(objeto.getX(), objeto.getY(), 20, 20);
		 
		 }
	}
}
	
	
	
