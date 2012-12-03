package fiuba.algo3.flightcontrol.modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public abstract class ObjetoVolador extends Observable implements ObjetoVivo, ObjetoPosicionable {
	
	private Vector posicionActual, direccion;
	private boolean aterrizado; 
	protected Trayectoria trayectoria;
	private Nivel nivel;
	private int velocidad;
	private int contadorDeTurnos;
	private final int velocidadMaxima = 10;
	
	public ObjetoVolador(int velocidad, Nivel unNivel) {
						
		this.nivel = unNivel;
		int limite = unNivel.getLimite() - 1;
		posicionActual = generarSalidaAleatoria(limite);
		
		this.direccion = new Vector(1, 1);
		this.aterrizado = false;
		
		this.velocidad = velocidad;
		contadorDeTurnos = 0;
		this.trayectoria = new Trayectoria(new ArrayList<Vector>());
		
	}
	
	public int getX() {
		
		return this.posicionActual.getPosicionX();
	}
	
	public int getY() {
		
		return this.posicionActual.getPosicionY();
	}
	
	public Nivel getNivel() {
		
		return nivel;
	}
	
	public void vivir() {
		this.mover();
		this.aterrizarSiHayPistaDeAterrizajeCompatible();
		this.setChanged();
		this.notifyObservers(this.aterrizado);
	}
	
	abstract void aterrizarSiHayPistaDeAterrizajeCompatible();
	
	private Vector generarSalidaAleatoria(int limite) {
		/* Genera una posicion random de salida de un avion. 
		 * Esta posicion se da siempre en alguno de los cuatro bordes */
				
		Random generadorDeRandoms = new Random();
		
		int pared = generadorDeRandoms.nextInt(2) * (limite);
		int borde = generadorDeRandoms.nextInt(2);
		int valorDeSalidaX = 0;
		int valorDeSalidaY = 0;
				
		
		if (borde == 0) {
			valorDeSalidaX = pared;
			valorDeSalidaY = generadorDeRandoms.nextInt(limite);
		} else {
			valorDeSalidaX = generadorDeRandoms.nextInt(limite);
			valorDeSalidaY = pared;
		}
		
		return (new Vector(valorDeSalidaX, valorDeSalidaY));
	}
	
	
	public boolean hayTrayectoria() {
		
		return (this.trayectoria.hayTrayectoria());	
	}
	
	public void aterrizar() {
				
		this.aterrizado = true;
		
	}

	public Vector getPosicion() {
				
		return this.posicionActual;
	}
		
	public Vector getDireccion() {
				
		return this.direccion;
	}
	
	public Trayectoria getTrayectoria() {
		return this.trayectoria;
	}
	
    private void mover() {
        
    	boolean tocaUnBorde;
        contadorDeTurnos++;
        
        	
        	if (contadorDeTurnos == (velocidadMaxima / velocidad)) {
            	
    	    	contadorDeTurnos = 0;
    	        		    	
    	        Vector siguientePosicion = this.getProximaPosicion();
    	        this.actualizarDireccion(siguientePosicion);
    	        
    	        //Validar bordes
    	        tocaUnBorde = this.validarBordes(siguientePosicion);
    	               
    	        if (tocaUnBorde) {
    	        	
    	            this.invertirTrayectoria(siguientePosicion);
    	        }
    	        	        
    	        this.posicionActual = siguientePosicion;
    	        
    	        Vector proximoPuntoTrayectoria;
    	        proximoPuntoTrayectoria = this.trayectoria.getProximaPosicion();
    	        
    	        if (proximoPuntoTrayectoria.esIgual(this.posicionActual)) {
    				this.trayectoria.borrarPosicion();
    	        }
            }

        
    }
	
	public boolean aterrizo() {
		
		return this.aterrizado;		
	}
	
	private boolean validarBordes(Vector posicion) {
		/* Devuelve si una posicion toca un borde o no */
		
		int x = posicion.getPosicionX();
		int y = posicion.getPosicionY();
		
		int limite = this.getNivel().getLimite();
		
		return (x == 0 || y == 0 || x == limite || y == limite);
	}
		
	private void invertirTrayectoria(Vector posicionLimite) {
		/* Invierte la trayectoria del objeto volador,
		 * actualizando su direccion y su posicion */
		
		Vector nuevaDireccion;
		int dimension = this.getNivel().getLimite();
		
		int x = this.getDireccion().getPosicionX();
		int y = this.getDireccion().getPosicionY();
		
		int sigX = posicionLimite.getPosicionX();
		int sigY = posicionLimite.getPosicionY();
		
		posicionActual = posicionLimite;
		
		if (sigX == 0 || sigX == dimension) {
			x = x * (-1);
		}
		if (sigY == 0 || sigY == dimension) {
			y = y * (-1);
		}
		
		nuevaDireccion = new Vector(x, y);
		this.direccion = nuevaDireccion;
	}
	
	private void actualizarDireccion(Vector destino) {
		
		this.direccion = destino.restar(this.posicionActual);
		this.direccion.canonizarPosicion();
	}
		
	private Vector getProximaPosicion() {
			
		Vector destino = this.trayectoria.getProximaPosicion();
		this.actualizarDireccion(destino);
		Vector proximaPosicion = this.direccion.sumar(posicionActual);
		return proximaPosicion;
	}
	
	public void setTrayectoria(Trayectoria unaTrayectoria) {
	
		this.trayectoria = unaTrayectoria;
	}
	
	public boolean chocar() {
		
		boolean choco = false;
		double distanciaDeChoque = 20; //O sea, radio de cada ObjetoVolador es de 20
		Iterator<ObjetoVolador> it;
		Vector otraPosicion;
		
		it = this.getNivel().getObjetosVoladores();
		
		while (it.hasNext() && !choco) {
			ObjetoVolador unObjetoVolador = it.next();
			if (unObjetoVolador.getPosicion() != this.getPosicion()) {
				otraPosicion = unObjetoVolador.getPosicion();
				choco = (otraPosicion.distancia(this.getPosicion()) <= distanciaDeChoque);
			}
		}
		
		return choco;
	}
	
}
