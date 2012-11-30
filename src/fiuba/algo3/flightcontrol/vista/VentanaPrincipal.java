package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.Pista;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;

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
		frame.setBounds(700, 300, 470, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Flight Control by Key");
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnDetener = this.addBotonDetener();
		
		JPanel panel = this.addSuperficiePanel();
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		this.inicializarModelo((SuperficieDeDibujo) panel);
		
		this.addMouseListener(panel);
		
		this.addKeyListener();

		this.setComponentsFocus(btnIniciar, btnDetener);

	}

	private void inicializarModelo(SuperficieDeDibujo unPanel) {
		Nivel unNivel = new Nivel(10,350);
		ObservadorDeNivel observadorDeNivel = new ObservadorDeNivel(gameLoop, (SuperficieDeDibujo)unPanel, unNivel);
		unNivel.addObserver(observadorDeNivel);
		this.gameLoop.agregar(unNivel);
	
		Iterator<Pista> it = unNivel.getPistas();
		while (it.hasNext()) {
			Pista unaPista = it.next();
			Cuadrado cuadrado = new VistaPista(unaPista);
			this.gameLoop.agregar(cuadrado);
		}		
	}

	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
		
	}

	private void addKeyListener() {
		frame.addKeyListener(new KeyListener(
				) {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("Key pressed");
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("Ping");
			}  
			 	
		});
	}

	private void addMouseListener(JPanel panel) {
		
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent arg0) {	

				//unaLista.add(new Vector(100, 100));

			}});
	}

	private JPanel addSuperficiePanel() {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(42, 53, 370, 370);
		frame.getContentPane().add(panel);
		return panel;
	}

	private JButton addBotonDetener() {
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(325, 16, 92, 25);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}

	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(42, 16, 77, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
}
