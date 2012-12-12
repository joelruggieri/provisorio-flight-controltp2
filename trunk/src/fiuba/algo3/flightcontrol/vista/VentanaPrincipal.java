package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.flightcontrol.controlador.Mouse;
import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.Pista;

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
					VentanaPrincipal window;
					window = new VentanaPrincipal();
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
		
		final int tono = 0;
		final int lado = 0;
		final int nivel = 10;
		final int resto = 60;
		
		frame = new JFrame();
		frame.setForeground(new Color(tono, tono, tono));
		frame.setBounds(lado, lado, tamano.width, tamano.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Flight Control");
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnDetener = this.addBotonDetener();
		
		JPanel panel = this.addSuperficiePanel();
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		final Nivel unNivel = new Nivel(nivel, tamano.height - resto);
		
		this.inicializarModelo((SuperficieDeDibujo) panel, unNivel);

		this.setComponentsFocus(btnIniciar, btnDetener);

		Mouse mouse = new Mouse(panel, unNivel);
		mouse.agregarControlador();
		
	}

	private void inicializarModelo(SuperficieDeDibujo unPanel, Nivel unNivel) {
		
		ObservadorDeNivel observadorDeNivel = new ObservadorDeNivel(gameLoop, (SuperficieDeDibujo) unPanel, unNivel);
		unNivel.addObserver(observadorDeNivel);
		ObservadorDeGameLoop observadorGameLoop = new ObservadorGameLoop(observadorDeNivel, gameLoop, (SuperficieDeDibujo) unPanel);
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
		
		final int tono1 = 0;
		final int tono2 = 150;
		
		final int lado1 = 350;
		final int lado2 = 5;
		final int resto = 40;
		
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(tono1, tono2, tono1));
		System.out.println(tamano.width);
		System.out.println(tamano.height);
		panel.setBounds(lado1, lado2, tamano.height - resto, tamano.height - resto);
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
		
		final int lado1 = 50;
		final int lado2 = 20;
		final int lado3 = 77;
		final int lado4 = 25;
		
		btnIniciar.setBounds(lado1, lado2, lado3, lado4);
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
		
		final int lado1 = 50;
		final int lado2 = 50;
		final int lado3 = 92;
		final int lado4 = 25;
				
		btnDetener.setBounds(lado1, lado2, lado3, lado4);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}
	
	
}
