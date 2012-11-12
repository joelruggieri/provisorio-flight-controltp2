package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

public class ObjetoVolador { //LE SAQUE EL ABSTRACT PARA PROBAR ALGO
	
	private int velocidad; //buscar para hacerlo atributo de clase
	protected Posicion posicionActual;//borre su set - Gonzalo
	protected boolean aterrizado; 
	protected Posicion direccion; //borre su set - Gonzalo
	protected Trayectoria trayectoria;
	protected Escenario plano;
	protected ArrayList<Posicion> listaDePosiciones;
	
	
	public ObjetoVolador(int velocidad, int limite, Escenario unPlano){
		/* Constructor del Objeto volador */
		
		int valorDeSalidaX = 0;
		int valorDeSalidaY = 0;
		//ArrayList<Posicion> trayectoriaVacia = new ArrayList<Posicion>();
		
		this.plano = unPlano;
		this.posicionActual = new Posicion(valorDeSalidaX, valorDeSalidaY);
		
		this.plano.posicionOcupadaPor(posicionActual, "objetoVolador");
		
		this.direccion = new Posicion (1,1);
		this.aterrizado = false;
		//this.trayectoria = new Trayectoria(trayectoriaVacia);
		this.velocidad = velocidad;
		
	}
	
	public void crearTrayectoria(ArrayList<Posicion> unaTrayectoriaNueva){
		/* Crea una nueva trayectoria para el objeto volador */
		
		this.trayectoria = new Trayectoria(unaTrayectoriaNueva);
		this.actualizarDireccion(this.trayectoria.getVectorDirector(this.posicionActual));
		
	}
	
	public void aterrizar(){
		/* Aterriza el objeto volador en una Pista */
		/* pre: debe de aterrizar */
		/* post: cambia el estado del objeto volador a aterrizado */
		
		this.aterrizado = true;
		this.plano.posicionOcupadaPor(posicionActual, "pista");
	}

	public Posicion getPosicion(){
		/* Devuelve la posicion actual del objeto volador */
		
		return this.posicionActual;
	}
		
	public Posicion getDireccion(){
		/* Devuelve la direccion actual del objeto volador */
		
		return this.direccion;
		
	}
		
	public void moverse(){
		/* Mueve al avion siguiendo su trayectoria */
		
		Posicion siguientePosicion;
		boolean tocaUnBorde;
		
		siguientePosicion = this.trayectoria.getProximaPosicion(this.posicionActual);
		
		for (int i=0; i < this.velocidad; i++){
						
			this.actualizarDireccion (this.trayectoria.getVectorDirector(posicionActual));
			
			//Validar bordes.
			tocaUnBorde = this.validarBordes (siguientePosicion);
			
			if (tocaUnBorde){
				this.invertirTrayectoria(siguientePosicion);
			}
			
			this.posicionActual = siguientePosicion;
			
		}
		
	}
	
	public boolean aterrizo(){
		/* Devuelve si el avion aterrizo o no */
		return this.aterrizado;		
	}
	
	private boolean validarBordes (Posicion posicion){
		/* Devuelve si una posicion toca un borde o no */
		/* pre: Se debe ingresar una posicion */
		/* post: Devuelve un booleano */
		
		int x = posicion.getPosicionX();
		int y = posicion.getPosicionY();
		
		int limite = this.plano.getDimension();
		
		return (x == 0 || y == 0 || x == limite || y == limite);
	}
		
	private void invertirTrayectoria (Posicion posicionLimite){
		/* Invierte la trayectoria del avion, causando un efecto rebote */
		
		Posicion nuevaDireccion;
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
		
		nuevaDireccion = new Posicion (x,y);
		this.actualizarDireccion(nuevaDireccion);
		
	}
	
	private void actualizarDireccion (Posicion unaDireccion){
		/* Actualiza la direccion del avion */
		
		if (unaDireccion != null){
			this.direccion = unaDireccion;
		}
	}
}
	
