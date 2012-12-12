package fiuba.algo3.flightcontrol.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;

public class Mouse {

	private JPanel panel;
	private Nivel unNivel;
	
	public Mouse(JPanel unPanel, Nivel unNivel) {
		
		this.panel = unPanel;
		this.unNivel = unNivel;
	}
	
	public void agregarControlador() {
		
		panel.addMouseListener(new MouseAdapter() {
			
			private ObjetoVolador unAvion;
			private List<Vector> unaLista;
			JFrame frame;
			
			public void mouseClicked(MouseEvent click) {	
				
				JTextArea textArea = new JTextArea();
				textArea.setLineWrap(true);
				if (frame == null) {
					frame = new JFrame("ATENCION");
					frame.setBounds(50, 200, 200, 70);	
				}
	
				if (click.isAltDown()) {
					if (this.unAvion == null) {
					
						this.unAvion = this.obtenerAvion(click);
						if (this.unAvion != null) {
							unaLista = new ArrayList<Vector>();
							
							textArea.setText("Agarro un Objeto Volador");
							frame.getContentPane().add(textArea);
							frame.setVisible(true);
	
						}
					
					} else {
						
						Vector posicionClick = new Vector (click.getX(), click.getY());
						unaLista.add(posicionClick);
						
						textArea.setText("Seteo una Posicion");
						frame.getContentPane().add(textArea);
						frame.setVisible(true);
					}
					
				} else {
						
					if (this.unAvion != null) {
						Trayectoria unaTrayectoria = new Trayectoria(unaLista);
						this.unAvion.setTrayectoria(unaTrayectoria);
						this.unAvion = null;
						
						textArea.setText("Seteo una nueva Trayectoria");
						frame.getContentPane().add(textArea);
						frame.setVisible(true);
					}
						
				}
					
			}
		

		private ObjetoVolador obtenerAvion(MouseEvent click) {
			boolean encontrado = false;
			ObjetoVolador unAvion, avionEncontrado = null;
			Vector posicionClick = new Vector (click.getX(), click.getY());
			Vector posicionDeAvion;
			double diferencia;
			
			Iterator<ObjetoVolador> it = unNivel.getObjetosVoladores();
			while (it.hasNext() && !encontrado) {
				unAvion = it.next();
				posicionDeAvion = unAvion.getPosicion();
				diferencia =  posicionClick.distancia(posicionDeAvion);
				encontrado = (diferencia <= 20);
				
				if (encontrado){ 
					avionEncontrado = unAvion;
				}
			}
			
			return avionEncontrado;
		}});
	}
}
