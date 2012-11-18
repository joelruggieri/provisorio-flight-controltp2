package fiuba.algo3.flightcontrol;
import java.lang.Math;

public class Vector {
	
	private int x;
	private int y;
	
	public Vector(){
		
		this.x = 0;
		this.y = 0;
		
	}
	
	public Vector (int coordenadaX, int coordenadaY){
				
		this.x = coordenadaX;
		this.y = coordenadaY;
	}
	
	public int getPosicionX(){
		
		return this.x;
	}

	public int getPosicionY(){
		
		return this.y;
	}
	
	public boolean equals (Vector otraPosicion){
		/* Devuelve si la Posicion es igual a la posicion pasada por parametro */
				
		return (this.x == otraPosicion.getPosicionX()) && (this.y == otraPosicion.getPosicionY());
	}
	
	public Vector sumar (Vector otraPosicion){
		/* Suma la posicion con la posicion pasada por parametro */
				
		int x,y;
				
		x = this.x + otraPosicion.getPosicionX();
		y = this.y + otraPosicion.getPosicionY();
		
		return (new Vector(x,y));
	}
	
	public Vector restar (Vector otraPosicion){
		/* Resta la posicion con la posicion pasada por parametro */
				
		int x,y;
				
		x = this.x - otraPosicion.getPosicionX();
		y = this.y - otraPosicion.getPosicionY();
		
		return (new Vector(x,y));
	}
	
	public Vector multiplicar (int unValor){
		/* Realiza el producto escalar */
				
		int x,y;
				
		x = this.x * unValor;
		y = this.y * unValor;
		
		return (new Vector(x,y));
		
	}


	public Vector InvertirDireccion(){
		/* Invierte la posicion del avion, causando un efecto rebote */
		
		int nuevoX = this.getPosicionX() * (-1);
		int nuevoY = this.getPosicionY() * (-1);
		
		return (new Vector(nuevoX,nuevoY));
	}
	
	public void canonizarPosicion(){
		 /*Convierte la posicion que fue pasada por parametro a otra posicion donde
		 sus componentes son solo ceros, unos o unos negativos */
		 		
		if(this.getPosicionX() != 0){
			this.x = this.getPosicionX() / (Math.abs(getPosicionX()));
		}
		if (this.getPosicionY() != 0){
			this.y = this.getPosicionY() / (Math.abs(getPosicionY()));
		}
	}
	
}
