package fiuba.algo3.flightcontrol.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import java.util.List;

import java.util.Random;

import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class Nivel extends Observable implements ObjetoVivo {
	
	private List<ObjetoVolador> avionesEnJuego;
	private List<Pista> pistas;
	private int frecuenciaDeSalida;
	private int contadorDeTurnos;
	private int cantidadDeAviones;
	private int velocidadDelNivel;
	private int limite;
	
	
	
	public Nivel(int numeroDeNivel, int limite) {
		
		final int maximo = 10;
		
		this.velocidadDelNivel = numeroDeNivel;
		this.avionesEnJuego = new ArrayList<ObjetoVolador>();
		this.pistas = new ArrayList<Pista>();
		this.frecuenciaDeSalida = 30;
		this.contadorDeTurnos = 30;
		this.cantidadDeAviones = this.velocidadDelNivel * maximo;
		this.limite = limite;
		this.generarPistas();
		//faltan inicializar la frecuancia 
	}
	
	public int getLimite() {
		
		return this.limite;
	}
	
	public void vivir() {
		
		this.generarObjetoVolador();
	}
	
	public void generarObjetoVolador() {
			
		if (contadorDeTurnos == frecuenciaDeSalida)	{
			contadorDeTurnos = 0;
		
			if (this.avionesEnJuego.size() < this.cantidadDeAviones) {
				
				Random generadorDeRandoms = new Random();
				int vel, codigoDeAvion;
				final int cantidad = 4;
				
				vel = this.velocidadDelNivel;
				codigoDeAvion = generadorDeRandoms.nextInt(cantidad);
							
				switch (codigoDeAvion) {
				case 0 : 
					AvionSimple simple = new AvionSimple(vel, this);
					this.avionesEnJuego.add(simple);
						 
				case 1 : 
					AvionPesado pesado = new AvionPesado(vel, this);
					this.avionesEnJuego.add(pesado);
					
				case 2 : 
					Helicoptero helicoptero;
					helicoptero = new Helicoptero(vel, this);
				 	this.avionesEnJuego.add(helicoptero);		
				 		 
				default : 
					AvionComputarizado avionComp;
					avionComp = new AvionComputarizado(vel, this);
				 	this.avionesEnJuego.add(avionComp);
						 
				}
				
				this.setChanged();
			} else throw new EstanTodosLosOVDelNivelException();
			
			this.notifyObservers(this.getUltimoObjetoVolador());	
		}
		contadorDeTurnos ++;
	}
	
	private ObjetoVolador getUltimoObjetoVolador() {
		
		return this.avionesEnJuego.get(avionesEnJuego.size()-1);
	}

	private List<Vector> generarPosicionesPistaSimple() {
		
		final int numeroPredeterminado = 2;
		int posicion = limite / numeroPredeterminado;
		int corrido = 0;
		Vector posEntrada = new Vector(posicion, posicion + corrido);
		corrido++;
		Vector otraPosicion = new Vector(posicion, posicion + corrido);
		corrido++;
		Vector otraPosicion2 = new Vector(posicion, posicion + corrido);
		
		List<Vector> listaPosicionesPista = new ArrayList<Vector>();
		
		listaPosicionesPista.add(posEntrada);
		listaPosicionesPista.add(otraPosicion);
		listaPosicionesPista.add(otraPosicion2);
		
		return listaPosicionesPista;
		
	}
	
	private List<Vector> generarPosicionHelipuerto() {
		
		final int numeroPredeterminado1 = 2;
		int pos1 = limite / numeroPredeterminado1;
		
		final int numeroPredeterminado2 = 5;
		int pos2 = limite / numeroPredeterminado2;
		
		Vector posicionDelHelipuerto = new Vector(pos1, pos2);
		
		List<Vector> listaPosicionHelipuerto = new ArrayList<Vector>();
		
		listaPosicionHelipuerto.add(posicionDelHelipuerto);
		
		return listaPosicionHelipuerto;
		
	}
	
	private List<Vector> generarPosicionesPistaDobleEntrada() {
		
		final int numeroPredeterminado = 3;
		int pos = limite / numeroPredeterminado;
		int corrido = 0;
		
		Vector posicionEntrada1;
		posicionEntrada1 = new Vector(pos + corrido, pos + corrido);
		corrido++;
		Vector otraPosicion = new Vector(pos + corrido, pos + corrido);
		corrido++;
		Vector posicionEntrada2;
		posicionEntrada2 = new Vector(pos + corrido, pos + corrido);
		
		List<Vector> listaPosicionesPista = new ArrayList<Vector>();
		
		listaPosicionesPista.add(posicionEntrada1);
		listaPosicionesPista.add(otraPosicion);
		listaPosicionesPista.add(posicionEntrada2);
		
		return listaPosicionesPista;
		
	}
	
	private List<Vector> generarPosicionesPistaLarga() {
		
		final int numeroPredeterminado = 4;
		int pos = limite / numeroPredeterminado;
		int corrido = 0;
		
		Vector posEntrada1 = new Vector(pos + corrido, pos + corrido);
		corrido++;
		Vector otraPosicion = new Vector(pos + corrido, pos);
		corrido++;
		Vector otraPosicion1 = new Vector(pos + corrido, pos);
		corrido++;
		Vector otraPosicion2 = new Vector(pos + corrido, pos);
		corrido++;
		Vector otraPosicion3 = new Vector(pos + corrido, pos);
		
		List<Vector> listaPosicionesPista = new ArrayList<Vector>();
		
		listaPosicionesPista.add(posEntrada1);
		listaPosicionesPista.add(otraPosicion);
		listaPosicionesPista.add(otraPosicion1);
		listaPosicionesPista.add(otraPosicion2);
		listaPosicionesPista.add(otraPosicion3);
		
		return listaPosicionesPista;
	}
	
	private void generarPistas() {
		
		List<Vector> posPista = this.generarPosicionesPistaSimple();
		PistaSimple simple = new PistaSimple(posPista);
		this.pistas.add(simple);
		
		posPista = this.generarPosicionHelipuerto();
		Helipuerto helipuerto = new Helipuerto(posPista);
		this.pistas.add(helipuerto);
		
		posPista = this.generarPosicionesPistaDobleEntrada();
		PistaDobleEntrada dobleEntrada;
		dobleEntrada = new PistaDobleEntrada(posPista);
		this.pistas.add(dobleEntrada);
		
		posPista = this.generarPosicionesPistaLarga();
		PistaLarga pistaLarga = new PistaLarga(posPista);
		this.pistas.add(pistaLarga);
	}
	
	public Pista getUnaPistaValida() {
		
		final int cantidadDePistas = 3;
		int indiceDePista;
		Random generadorDeRandoms = new Random();
		indiceDePista = generadorDeRandoms.nextInt(cantidadDePistas);
		
		return this.pistas.get(indiceDePista + 1);
	}
	
	public Iterator<Pista> getPistas() {
	 
		return pistas.iterator();
	}
	
	public Iterator<ObjetoVolador> getObjetosVoladores() {
		
		return avionesEnJuego.iterator();
	}
	
}
