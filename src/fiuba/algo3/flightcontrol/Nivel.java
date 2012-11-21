package fiuba.algo3.flightcontrol;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

import java.util.Random;

public class Nivel {
	
	private List<ObjetoVolador> avionesEnJuego;
	private List<Pista> pistas;
	private int frecuenciaDeSalida;
	private int cantidadDeAviones;
	private int velocidadDelNivel;
	private int limite;
	
	
	
	public Nivel(int numeroDeNivel, int limite) {
		
		this.velocidadDelNivel = numeroDeNivel;
		this.avionesEnJuego = new ArrayList<ObjetoVolador>();
		this.pistas = new ArrayList<Pista>();
		int maximo = 10;
		this.cantidadDeAviones = this.velocidadDelNivel * maximo;
		this.limite = limite;
		this.generarPistas();
		//faltan inicializar la frecuancia 
	}
	
	public int getLimite() {
		
		return this.limite;
	}
	
	public void generarObjetoVolador() {
		
		if (this.avionesEnJuego.size() < this.cantidadDeAviones) {
			Random generadorDeRandoms = new Random();
			
			int codigoDeAvion = generadorDeRandoms.nextInt(4);
			
			int vel = this.velocidadDelNivel;
			switch (codigoDeAvion) {
			case 0 : AvionSimple simple = new AvionSimple(vel, this);
					 this.avionesEnJuego.add(simple);
					 
			case 1 : AvionPesado pesado = new AvionPesado(vel, this);
					 this.avionesEnJuego.add(pesado);
				
			case 2 : Helicoptero helicoptero = new Helicoptero(vel, this);
			 		 this.avionesEnJuego.add(helicoptero);		
			 		 
			case 3 : AvionComputarizado comp = new AvionComputarizado(vel, this);
			 		 this.avionesEnJuego.add(comp);
					 
			}
			
		} else throw new EstanTodosLosOVDelNivelException();
		
	}
	
	private List<Vector> generarPosicionesPistaSimple() {
		
		int posicion = limite / 2;
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
		
		int pos1 = limite / 2;
		int pos2 = limite / 5;
		
		Vector posicionDelHelipuerto = new Vector(pos1, pos2);
		
		List<Vector> listaPosicionHelipuerto = new ArrayList<Vector>();
		
		listaPosicionHelipuerto.add(posicionDelHelipuerto);
		
		return listaPosicionHelipuerto;
		
	}
	
	private List<Vector> generarPosicionesPistaDobleEntrada() {
		
		int pos = limite / 3;
		int corrido = 0;
		
		Vector posicionEntrada1 = new Vector(pos + corrido, pos + corrido);
		corrido++;
		Vector otraPosicion = new Vector(pos + corrido, pos + corrido);
		corrido++;
		Vector posicionEntrada2 = new Vector(pos + corrido, pos + corrido);
		
		List<Vector> listaPosicionesPista = new ArrayList<Vector>();
		
		listaPosicionesPista.add(posicionEntrada1);
		listaPosicionesPista.add(otraPosicion);
		listaPosicionesPista.add(posicionEntrada2);
		
		return listaPosicionesPista;
		
	}
	
	private List<Vector> generarPosicionesPistaLarga() {
		
		int pos = limite / 4;
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
		
		List<Vector> posPista = this.generarPosicionHelipuerto();
		Helipuerto helipuerto = new Helipuerto(posPista);
		this.pistas.add(helipuerto);
		
		posPista = this.generarPosicionesPistaSimple();
		PistaSimple simple = new PistaSimple(posPista);
		this.pistas.add(simple);
		
		posPista = this.generarPosicionesPistaDobleEntrada();
		PistaDobleEntrada dobleEntrada = new PistaDobleEntrada(posPista);
		this.pistas.add(dobleEntrada);
		
		posPista = this.generarPosicionesPistaLarga();
		PistaLarga pistaLarga = new PistaLarga(posPista);
		this.pistas.add(pistaLarga);
	
	}
	
	
	
	public Pista getUnaPistaValida() {
		
		Random generadorDeRandoms = new Random();
		int indiceDePista = generadorDeRandoms.nextInt(3);
		
		return this.pistas.get(indiceDePista + 1);
		
	}
	
	public Iterator<Pista> getPistas() {
	 
		return pistas.iterator();
	}
	
	public Iterator<ObjetoVolador> getObjetosVoladores() {
		
		return avionesEnJuego.iterator();
	}
}
