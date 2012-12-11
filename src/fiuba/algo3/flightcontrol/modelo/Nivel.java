package fiuba.algo3.flightcontrol.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

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
	private int numeroDeAvionesGenerados;
	static int maximo;
	
	public Nivel(int numeroDeNivel, int limite) {
		
		this.maximo = 100;
		this.numeroDeAvionesGenerados = 0;
		this.velocidadDelNivel = numeroDeNivel;
		this.avionesEnJuego = new ArrayList<ObjetoVolador>();
		this.pistas = new ArrayList<Pista>();
		this.frecuenciaDeSalida = 100;
		this.contadorDeTurnos = 100;
		this.cantidadDeAviones = this.velocidadDelNivel + 10;
		this.limite = limite;
		this.generarPistas();
		
	}
	
	public int getLimite() {
		
		return this.limite;
	}
	
	public void vivir() {
		
		this.validarActualizacionDeNivel();
		this.generarObjetoVolador();
		this.actualizarListaDeAvionesEnJuego();
	}
	
	private void validarActualizacionDeNivel() {
		if(velocidadDelNivel < maximo){
			
			if ((this.numeroDeAvionesGenerados == this.cantidadDeAviones) && (this.avionesEnJuego.isEmpty())) {
				this.velocidadDelNivel =+ 10;
				this.frecuenciaDeSalida =- 10;
				this.contadorDeTurnos = this.frecuenciaDeSalida;
			}
		}
		
	}

	private void actualizarListaDeAvionesEnJuego() {
		
		Iterator<ObjetoVolador> it = this.getObjetosVoladores();
		while (it.hasNext()) {
			if (it.next().aterrizo()) {
				it.remove();
			}
		}
	}
	
	private void generarObjetoVolador() {
			
		if (contadorDeTurnos == frecuenciaDeSalida)	{
			contadorDeTurnos = 0;
		
			if (this.numeroDeAvionesGenerados < this.cantidadDeAviones) {
				
				Random generadorDeRandoms = new Random();
				int vel, codigoDeAvion;
				final int cantidad = 4;
				
				vel = this.velocidadDelNivel;
				codigoDeAvion = generadorDeRandoms.nextInt(cantidad);
				
				System.out.println(codigoDeAvion);
				
				
				if (codigoDeAvion == 0) {
					AvionSimple simple = new AvionSimple(vel, this);
					this.avionesEnJuego.add(simple);
				} else if (codigoDeAvion == 1) {
					AvionPesado pesado = new AvionPesado(vel, this);
					this.avionesEnJuego.add(pesado);
				} else if (codigoDeAvion == 2) {
					Helicoptero helicoptero;
					helicoptero = new Helicoptero(vel, this);
				 	this.avionesEnJuego.add(helicoptero);	
				} else{
					AvionComputarizado avionComp;
					avionComp = new AvionComputarizado(vel, this);
				 	this.avionesEnJuego.add(avionComp);
				}
				
				numeroDeAvionesGenerados ++;
				this.setChanged();
			} 
			
			this.notifyObservers(this.getUltimoObjetoVolador());	
		}
		contadorDeTurnos ++;
	}
	
	public ObjetoVolador getUltimoObjetoVolador() {
		
		return this.avionesEnJuego.get(avionesEnJuego.size() - 1);
	}

	private List<Vector> generarPosicionesPistaSimple() {
		
		final int numeroPredeterminado = 2;
		int posicion = limite / numeroPredeterminado;
		int corrido = 0;
		List<Vector> listaPosicionesPista = new ArrayList<Vector>();
		Vector posicionPista;
		for (int i = 0; i < 75 ; i ++) {
			posicionPista = new Vector(posicion, posicion + corrido);
			corrido++;
			listaPosicionesPista.add(posicionPista);
		}
		
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
		List<Vector> listaPosicionesPista = new ArrayList<Vector>();
		Vector posicionPista;
		
		for (int i = 0; i < 100 ; i ++) {
			posicionPista = new Vector(pos + corrido, pos);
			corrido++;
			listaPosicionesPista.add(posicionPista);
		}
		
		return listaPosicionesPista;
		
	}
	
	private List<Vector> generarPosicionesPistaLarga() {
		
		final int numeroPredeterminado = 4;
		int pos = limite / numeroPredeterminado;
		int corrido = 0;
		List<Vector> listaPosicionesPista = new ArrayList<Vector>();
		Vector posicionPista;
		
		for (int i = 0; i < 200 ; i ++) {
			posicionPista = new Vector(pos + corrido, pos);
			corrido++;
			listaPosicionesPista.add(posicionPista);
		}
	
		return listaPosicionesPista;
	}
	
	private void generarPistas() {
		
		List<Vector> posPista = this.generarPosicionHelipuerto();
		Helipuerto helipuerto = new Helipuerto(posPista);
		this.pistas.add(helipuerto);
		
		posPista = this.generarPosicionesPistaSimple();
		PistaSimple simple = new PistaSimple(posPista);
		this.pistas.add(simple);
		
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
	
	public int getContadorDeTurno() {
		
		return this.contadorDeTurnos;
	}
	
	public int getFrecunciaDeSalida() {
		
		return this.frecuenciaDeSalida;
	}
	
	public int getCantidadDeAvionesGenerados() {
		
		return this.numeroDeAvionesGenerados;
	}
}
