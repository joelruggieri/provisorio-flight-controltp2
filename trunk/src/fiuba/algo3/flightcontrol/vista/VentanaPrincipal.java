package fiuba.algo3.flightcontrol.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		JButton btnAyuda = this.addBotonAyuda();
		
		JButton btnSalir = this.addBotonSalir();
		
		JPanel panel = this.addSuperficiePanel();
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		final Nivel unNivel = new Nivel(10, tamano.height - 60);
		
		this.inicializarModelo((SuperficieDeDibujo) panel, unNivel);

		this.setComponentsFocus(btnIniciar, btnDetener, btnAyuda, btnSalir);

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

	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener, JButton btnAyuda, JButton btnSalir) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
		btnAyuda.setFocusable(false);
		btnSalir.setFocusable(false);
	
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
		final JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gameLoop.iniciarEjecucion();
				btnIniciar.setLabel("CONTINUAR");
			}
		});
		btnIniciar.setBounds(50, 20, 110, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}

	private JButton addBotonDetener() {
		JButton btnDetener = new JButton("DETENER");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		
		btnDetener.setBounds(50, 60, 110, 25);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}
	
	private JButton addBotonAyuda() {
		
		JButton btnAyuda = new JButton("AYUDA");
		btnAyuda.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
	            String cadena;
	            File fichero = new File("Tutorial.txt");
	            cadena = fichero.getAbsolutePath();
	            
	            try{
	            	
	            	Runtime rt = Runtime.getRuntime();
	            	String[] callAndArgs = {"C:/WINDOWS/hh.exe",cadena};
	            	Process child = rt.exec(callAndArgs);
	            	gameLoop.detenerEjecucion();
	            	
	            }catch(Exception eee){System.out.println("ERROR");}
			
			}
			
		});
		btnAyuda.setBounds(50, 100, 110, 25);
		frame.getContentPane().add(btnAyuda);
		return btnAyuda;
	}
	
	private JButton addBotonSalir() {
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		int alto = tamano.height;
		
		btnSalir.setBounds(50, alto - 100, 110, 25);
		frame.getContentPane().add(btnSalir);
		return btnSalir;
	}
	
	
}
