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
	
	
	
	public Nivel(int numeroDeNivel, int limite){
		
		this.velocidadDelNivel = numeroDeNivel;
		this.avionesEnJuego = new ArrayList < ObjetoVolador > ();
		this.pistas = new ArrayList < Pista > ();
		this.cantidadDeAviones = this.velocidadDelNivel * 10;
		this.limite = limite;
		this.generarPistas();
		//faltan inicializar la frecuancia 
	}
	
	public int getLimite(){
		
		return this.limite;
	}
	
	public void generarObjetoVolador() {
		
		if ( this.avionesEnJuego.size() < this.cantidadDeAviones) {
			Random generadorDeRandoms = new Random();
			
			int codigoDeAvion = generadorDeRandoms.nextInt(4);
			
			switch ( codigoDeAvion ) {
			case 0 : AvionSimple simple = new AvionSimple( this.velocidadDelNivel , this );
					 this.avionesEnJuego.add(simple);
					 
			case 1 : AvionPesado pesado = new AvionPesado( this.velocidadDelNivel , this );
					 this.avionesEnJuego.add(pesado);
				
			case 2 : Helicoptero helicoptero = new Helicoptero( this.velocidadDelNivel , this );
			 		 this.avionesEnJuego.add(helicoptero);		 
			 		 
			case 3 : AvionComputarizado computarizado = new AvionComputarizado( this.velocidadDelNivel , this );
			 		 this.avionesEnJuego.add(computarizado);
					 
			}
			
		} else throw new YaFueronGeneradosUnTotalDeAvionesIgualAlLimitePermitidoPorElNivelException();
		
	}
	
	private List<Vector> generarPosicionesPistaSimple(){
		
		Vector posicionEntrada = new Vector(limite/2 , limite/2);
		Vector otraPosicion = new Vector(limite/2 , (limite/2) + 1);
		Vector otraPosicion2 = new Vector(limite/2 , (limite/2) + 2);
		
		List<Vector> listaPosicionesPista = new ArrayList<Vector> ();
		
		listaPosicionesPista.add(posicionEntrada);
		listaPosicionesPista.add(otraPosicion);
		listaPosicionesPista.add(otraPosicion2);
		
		return listaPosicionesPista;
		
	}
	
	private List<Vector> generarPosicionHelipuerto(){
		
		Vector posicionDelHelipuerto = new Vector(limite/2 , limite/5);
		
		List<Vector> listaPosicionHelipuerto = new ArrayList<Vector> ();
		
		listaPosicionHelipuerto.add(posicionDelHelipuerto);
		
		return listaPosicionHelipuerto;
		
	}
	
	private List<Vector> generarPosicionesPistaDobleEntrada(){
		
		Vector posicionEntrada1 = new Vector(limite/3 , limite/3);
		Vector otraPosicion = new Vector((limite/3) + 1  , (limite/3) + 1);
		Vector posicionEntrada2 = new Vector((limite/3) + 2 , (limite/3) + 2);
		
		List<Vector> listaPosicionesPista = new ArrayList<Vector> ();
		
		listaPosicionesPista.add(posicionEntrada1);
		listaPosicionesPista.add(otraPosicion);
		listaPosicionesPista.add(posicionEntrada2);
		
		return listaPosicionesPista;
		
	}
	
private List<Vector> generarPosicionesPistaLarga(){
		
		Vector posicionEntrada1 = new Vector(limite/4 , limite/4);
		Vector otraPosicion = new Vector((limite/4) + 1  , limite/4);
		Vector otraPosicion1 = new Vector((limite/4) + 2 , limite/4);
		Vector otraPosicion2 = new Vector((limite/4) + 3 , limite/4);
		Vector otraPosicion3 = new Vector((limite/4) + 4 , limite/4);
		
		List<Vector> listaPosicionesPista = new ArrayList<Vector> ();
		
		listaPosicionesPista.add(posicionEntrada1);
		listaPosicionesPista.add(otraPosicion);
		listaPosicionesPista.add(otraPosicion1);
		listaPosicionesPista.add(otraPosicion2);
		listaPosicionesPista.add(otraPosicion3);
		
		
		return listaPosicionesPista;
		
	}
	

	
	private void generarPistas() {
		
		List<Vector> posicionesPista = this.generarPosicionHelipuerto();
		Helipuerto helipuerto = new Helipuerto(posicionesPista);
		this.pistas.add(helipuerto);
		
		posicionesPista = this.generarPosicionesPistaSimple();
		PistaSimple simple = new PistaSimple(posicionesPista);
		this.pistas.add(simple);
		
		posicionesPista = this.generarPosicionesPistaDobleEntrada();
		PistaDobleEntrada dobleEntrada = new PistaDobleEntrada(posicionesPista);
		this.pistas.add(dobleEntrada);
		
		posicionesPista = this.generarPosicionesPistaLarga();
		PistaLarga pistaLarga = new PistaLarga(posicionesPista);
		this.pistas.add(pistaLarga);
	
	}
	
	
	
	public Pista getUnaPistaValida(){
		
		Random generadorDeRandoms = new Random();
		int indiceDePista = generadorDeRandoms.nextInt(3);
		
		return this.pistas.get(indiceDePista + 1);
		
	}
	
 public Iterator<Pista> getPistas(){
	 
	 return pistas.iterator();
 }
	
}
