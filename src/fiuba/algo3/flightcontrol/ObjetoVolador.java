package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

public abstract class ObjetoVolador {
	private int velocidad; //buscar para hacerlo atributo de clase
	protected Posicion posicionActual;//borre su set - Gonzalo
	protected boolean aterrizado; 
	protected Posicion direccion; //borre su set - Gonzalo
	protected Trayectoria trayectoria;
	protected Escenario plano;
	protected String tipoDeObjetoVolador;
	
	public String getTipoDeObjetoVolador(){
		/* Devuelve el tipo de objeto volador que es */
		
		return this.tipoDeObjetoVolador;
		
	}
	
	public ObjetoVolador(int velocidad, int limite, Escenario unPlano){
		/* Constructor del Objeto volador */
		
		int valorDeSalidaX = 0;
		int valorDeSalidaY = 0;
		ArrayList<Posicion> trayectoriaVacia = new ArrayList<Posicion>();
		
		this.plano = unPlano;
		this.posicionActual = new Posicion(valorDeSalidaX, valorDeSalidaY);
		
		this.plano.posicionOcupadaPor(posicionActual, "objetoVolador");
		
		this.direccion = new Posicion (1,1);
		this.aterrizado = false;
		this.trayectoria = new Trayectoria(trayectoriaVacia);
		
	}
	
	public void crearTrayectoria(ArrayList<Posicion> unaTrayectoriaNueva){
		/* Crea una nueva trayectoria para el objeto volador */
		
		this.trayectoria = new Trayectoria(unaTrayectoriaNueva);
		
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
	
	public boolean aterrizo(){
		return this.aterrizado;
	}
	
	public void moverse(){
		/* Mueve al avion siguiendo su trayectoria */
		
		Posicion direccion, siguientePosicion,posicionLimite;
		ArrayList <Posicion> trayectoriaNueva;
		boolean tocaUnBorde;
		
		if (this.trayectoria == null){
			
			direccion = this.getDireccion();
			posicionLimite = direccion.multiplicar(this.plano.getDimension());
			
			trayectoriaNueva = new ArrayList <Posicion> ();
			trayectoriaNueva.add(posicionLimite);
			
			this.crearTrayectoria(trayectoriaNueva);
	
		}
		
		for (int i=0; i < this.velocidad; i++){
			
			siguientePosicion = this.trayectoria.getProximaPosicion(this.posicionActual);
			
			//Validar bordes.
			tocaUnBorde = this.validarBordes (siguientePosicion);
			
			if (tocaUnBorde){
				
				this.invertirTrayectoria();
				siguientePosicion = this.trayectoria.getProximaPosicion(this.posicionActual);
			}
			
			this.posicionActual = siguientePosicion;
			
		}
		
		
			
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
		
	private void invertirTrayectoria (){
		/* Invierte la trayectoria del avion, causando un efecto rebote */
		
		Posicion nuevaDireccion,posicionLimite;
		ArrayList <Posicion> trayectoriaNueva = new ArrayList <Posicion> ();
		int x = this.direccion.getPosicionX();
		int y = this.direccion.getPosicionY();
		int dimension = this.plano.getDimension();
		
		if ( x == 0 || x == dimension){
			
			x = x*(-1);
		}
		if ( y == 0 || y == dimension){
			
			y = y*(-1);
		}
		
		nuevaDireccion = new Posicion (x,y);
		posicionLimite = nuevaDireccion.multiplicar(dimension);
		
		trayectoriaNueva.add(posicionLimite);
		this.crearTrayectoria(trayectoriaNueva);
		
	}
	

}
	
