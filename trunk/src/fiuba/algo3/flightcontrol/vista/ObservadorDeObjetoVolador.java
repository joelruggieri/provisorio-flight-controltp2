package fiuba.algo3.flightcontrol.vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class ObservadorDeObjetoVolador implements Observer {

	private Circulo unaVista;
	private SuperficieDeDibujo unaSuperficie;
	private ObjetoVolador unObjetoVolador;
	private GameLoop unGameLoop;
	
	public ObservadorDeObjetoVolador(GameLoop unGameLoop, 
			Circulo unaVista, SuperficieDeDibujo unPanel, 
			ObjetoVolador unObjetoVolador) {
		
		this.unaVista = unaVista;
		this.unaSuperficie = unPanel;
		this.unObjetoVolador = unObjetoVolador;
		this.unGameLoop = unGameLoop;
	}
	
	public void update(Observable arg0, Object aterrizo) {
		if (!this.unObjetoVolador.aterrizo()) {
			unaVista.dibujar(unaSuperficie);	
		} 
		
		if (this.unObjetoVolador.chocar()) {
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension tamano = tk.getScreenSize();
			
			int lado1 = 50 + tamano.height/2;
			int lado2 = -50 + tamano.height/2;
			int lado3 = tamano.width/3;
			int lado4 = 100;
						
			JFrame ventana = new JFrame("JUEGO FINALIZADO");
						
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			
			ventana.setBounds(lado1, lado2, lado3, lado4);
					
			textArea.setText("\n	CHOCARON DOS AVIONES");
			ventana.getContentPane().add(textArea);
			ventana.setVisible(true);
			
			this.unGameLoop.detenerEjecucion();
		}

	}

}
