package fiuba.algo3.flightcontrol;
import java.util.List;
import java.util.Random;

public abstract class ObjetoVolador {
	
	protected Vector posicionActual,direccion;
	protected boolean aterrizado; 
	protected Trayectoria trayectoria;
	protected Escenario plano;
	protected List <Vector> listaDePosiciones;
	protected int velocidad,contadorDeTurnos,limite;
	protected int prueba;
	
	public ObjetoVolador(int nivel, Escenario unPlano){
						
		this.plano = unPlano;
		this.limite = unPlano.getDimension();
		
		this.posicionActual = this.generarPosicionDeSalidaAleatoria(limite-1);
		//this.posicionActual = new Posicion (0,0);
		this.plano.ocuparPosicion(posicionActual, "objetoVolador");
		
		this.direccion = new Vector (1,1);
		this.aterrizado = false;
		
		this.velocidad = nivel;
		contadorDeTurnos = 0;
		
	}
	
	private Vector generarPosicionDeSalidaAleatoria (int limite){
		/* Genera una posicion random de salida de un avion */
		
		Random generadorDeRandoms = new Random ();
		
		int pared = generadorDeRandoms.nextInt (2)*(limite);
		int borde = generadorDeRandoms.nextInt (2);
		int valorDeSalidaX = 0;
		int valorDeSalidaY = 0;
				
		
		if (borde == 0){
			valorDeSalidaX = pared;
			valorDeSalidaY = generadorDeRandoms.nextInt (limite);
		}else{
			valorDeSalidaX = generadorDeRandoms.nextInt (limite);;
			valorDeSalidaY = pared;
		}
		
		return (new Vector (valorDeSalidaX,valorDeSalidaY));
	}
	
	
	public boolean hayTrayectoria(){
		
		return (this.trayectoria.hayTrayectoria());	
	}
	
	public void aterrizar(){
				
		this.aterrizado = true;
		this.plano.ocuparPosicion(posicionActual, "pista");
	}

	public Vector getPosicion(){
				
		return this.posicionActual;
	}
		
	public Vector getDireccion(){
				
		return this.direccion;
	}
	
    public void mover(){
        
    	boolean tocaUnBorde;
        contadorDeTurnos ++;
                      
        if (contadorDeTurnos == this.velocidad){
        	
	    	contadorDeTurnos = 0;
	        		    	
	        Vector siguientePosicion = this.getProximaPosicion();
	        //siguientePosicion.imprimir();
	        this.actualizarDireccion (siguientePosicion);
	        //this.getDireccion().imprimir();
	        //Validar bordes.
	        tocaUnBorde = this.validarBordes (siguientePosicion);
	               
	        if (tocaUnBorde){
	        	
	            this.invertirTrayectoria(siguientePosicion);
	        }
	        	        
	        this.posicionActual = siguientePosicion;
	        
	        if (this.trayectoria.getProximaPosicion().equals(this.posicionActual)){
				this.trayectoria.borrarPosicion();
	        }
        }
    }
	
	public boolean aterrizo(){
		
		return this.aterrizado;		
	}
	
	private boolean validarBordes (Vector posicion){
		/* Devuelve si una posicion toca un borde o no */
		
		int x = posicion.getPosicionX();
		int y = posicion.getPosicionY();
		
		int limite = this.plano.getDimension();
		
		return (x == 0 || y == 0 || x == limite || y == limite);
	}
		
	private void invertirTrayectoria (Vector posicionLimite){
		/* Invierte la trayectoria del objeto volador,
		 * actualizando su direccion y su posicion */
		
		Vector nuevaDireccion;
		int dimension = this.plano.getDimension();
		
		int x = this.getDireccion().getPosicionX();
		int y = this.getDireccion().getPosicionY();
		
		int sigX = posicionLimite.getPosicionX();
		int sigY = posicionLimite.getPosicionY();
		
		posicionActual = posicionLimite;
		
		if ( sigX == 0 || sigX == dimension){
			x = x*(-1);
		}
		if ( sigY == 0 || sigY == dimension){
			y = y*(-1);
		}
		
		nuevaDireccion = new Vector (x,y);
		this.direccion = nuevaDireccion;
		
	}
	
	private void actualizarDireccion (Vector destino){
		
		this.direccion = destino.restar(this.posicionActual);
		this.direccion.canonizarPosicion();
		
	}
		
	private Vector getProximaPosicion(){
			
		Vector destino = this.trayectoria.getProximaPosicion();
		this.actualizarDireccion(destino);
		Vector proximaPosicion = this.direccion.sumar (posicionActual);
		return proximaPosicion;
		
	}
	
	public void setTrayectoria (Trayectoria unaTrayectoria){
		
		this.trayectoria = unaTrayectoria;
	}
		
}
	
