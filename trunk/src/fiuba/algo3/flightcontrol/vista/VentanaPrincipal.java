package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fiuba.algo3.flightcontrol.controlador.Mouse;
import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.Pista;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;
import fiuba.algo3.flightcontrol.vista.ObservadorGameLoop;

import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;
public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;
	private Dimension tamano;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		try {
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			tamano = tk.getScreenSize();
			
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
				
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(0, 0, tamano.width, tamano.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Flight Control");
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnDetener = this.addBotonDetener();
		
		JPanel panel = this.addSuperficiePanel();
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		final Nivel unNivel = new Nivel(10, tamano.height - 60);
		
		this.inicializarModelo((SuperficieDeDibujo) panel, unNivel);

		this.setComponentsFocus(btnIniciar, btnDetener);

		Mouse mouse = new Mouse(panel, unNivel);
		mouse.agregarControlador();
		
	}

	private void inicializarModelo(SuperficieDeDibujo unPanel, Nivel unNivel) {
		
		ObservadorDeNivel observadorDeNivel = new ObservadorDeNivel(gameLoop, (SuperficieDeDibujo)unPanel, unNivel);
		unNivel.addObserver(observadorDeNivel);
		ObservadorDeGameLoop observadorGameLoop = new ObservadorGameLoop(observadorDeNivel, gameLoop, (SuperficieDeDibujo)unPanel );
		//guardo el observador del gameLoop
		this.gameLoop.agregarObservador(observadorGameLoop);
		this.gameLoop.agregar(unNivel);
	
		Iterator<Pista> it = unNivel.getPistas();
		while (it.hasNext()) {
			Pista unaPista = it.next();
			Rectangulo cuadrado = new VistaPista(unaPista);
			this.gameLoop.agregar(cuadrado);
		}		
	}

	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
	
	}
	
	private JPanel addSuperficiePanel() {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 150, 0));
		System.out.println(tamano.width);
		System.out.println(tamano.height);
		panel.setBounds(350, 5, tamano.height - 40, tamano.height - 40);
		frame.getContentPane().add(panel);
		return panel;
	}
	
	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(50, 20, 77, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}

	private JButton addBotonDetener() {
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(50, 50, 92, 25);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}
	
}
