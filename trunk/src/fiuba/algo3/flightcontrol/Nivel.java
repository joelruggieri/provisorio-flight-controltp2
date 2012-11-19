package fiuba.algo3.flightcontrol;

import java.util.ArrayList;
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
			case 1 : AvionSimple simple = new AvionSimple( this.velocidadDelNivel , this );
					 this.avionesEnJuego.add(simple);
					 
			case 2 : AvionPesado pesado = new AvionPesado( this.velocidadDelNivel , this );
					 this.avionesEnJuego.add(pesado);
				
			case 3 : Helicoptero helicoptero = new Helicoptero( this.velocidadDelNivel , this );
			 		 this.avionesEnJuego.add(helicoptero);		 
			 		 
			case 4 : AvionComputarizado computarizado = new AvionComputarizado( this.velocidadDelNivel , this );
			 		 this.avionesEnJuego.add(computarizado);
					 
			}
			
		} else throw new YaFueronGeneradosUnTotalDeAvionesIgualAlLimitePermitidoPorElNivelException();
		
	}
	
}
