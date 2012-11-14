package fiuba.algo3.flightcontrol;
import java.lang.Math;

public class Posicion {
	
	private int x;
	private int y;
	
	public Posicion(){
		
		this.x = 0;
		this.y = 0;
		
	}
	
	public Posicion(int coordenadaX, int coordenadaY){
		/* Constructor de la clase Posicion */
		/* pre: Deben ingresarse dos enteros */
		/* post: La posicion fue creada */
		
		this.x = coordenadaX;
		this.y = coordenadaY;
	}
	
	public int getPosicionX(){
		/* Devuelve la coordenada x */
		return this.x;
	}

	public int getPosicionY(){
		/* Devuelve la coordenada y */
		return this.y;
	}
	
	public boolean equals (Posicion otraPosicion){
		/* Devuelve si la Posicion es igual a la posicion pasada por parametro */
		/* pre: Debe ingresarse una posicion */
		
		return (this.x == otraPosicion.getPosicionX()) && (this.y == otraPosicion.getPosicionY());
	}
	
	public Posicion sumar (Posicion otraPosicion){
		/* Suma la posicion con la posicion pasada por parametro */
		/* pre: Debe ingresarse una posicion */
		/* post: Devuelve la posicion suma */
		
		int x,y;
		Posicion suma;
		
		x = this.x + otraPosicion.getPosicionX();
		y = this.y + otraPosicion.getPosicionY();
		
		suma = new Posicion(x,y);
		
		return suma;
	}
	
	public Posicion restar (Posicion otraPosicion){
		/* Resta la posicion con la posicion pasada por parametro */
		/* pre: Debe ingresarse una posicion */
		/* post: Devuelve la posicion resta */
		
		int x,y;
		Posicion resta;
		
		x = this.x - otraPosicion.getPosicionX();
		y = this.y - otraPosicion.getPosicionY();
		
		resta = new Posicion(x,y);
		
		return resta;
	}
	
	public Posicion multiplicar (int unValor){
		/* Multiplica la posicion con la posicion pasada por parametro */
		/* pre: debe ingresar unValor entero */
		/* post: Devuelve la posicion multiplicada */
		
		int x,y;
		Posicion multiplicacion;
		
		x = this.x * unValor;
		y = this.y * unValor;
		
		multiplicacion = new Posicion(x,y);
		
		return multiplicacion;
	}

	public void ActualizarCoordenadas(int valorX, int valorY){
		/* Se reescriben las coordenadas de la posicion */
		/* pre: se deben ingresar dos enteros */
		/* post: la posicion cambio sus valores */
		
		this.x= valorX;
		this.y= valorY;
	}
	
	public Posicion InvertirDireccion(){
		/* Invierte la posicion del avion, causando un efecto rebote */
		
		int nuevoX = this.getPosicionX() * (-1);
		int nuevoY = this.getPosicionY() * (-1);
		
		return (new Posicion(nuevoX,nuevoY));
		
	
	}
	
	public void canonizarPosicion(){
		/* Convierte la posicion que fue pasada por parametro a otra posicion donde
		 * sus componentes son solo ceros, unos o unos negativos.
		 * pre: posicion debe ser una Posicion
		 * post: devuelve una posicion canonizada.
		 */
		
		if(this.getPosicionX() != 0){
			this.x = this.getPosicionX() / (Math.abs(getPosicionX()));
		}
		if (this.getPosicionY() != 0){
			this.y = this.getPosicionY() / (Math.abs(getPosicionY()));
		}
	}
	
}
