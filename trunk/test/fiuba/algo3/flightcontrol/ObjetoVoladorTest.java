package fiuba.algo3.flightcontrol;
import java.util.ArrayList;

import junit.framework.TestCase;

public class ObjetoVoladorTest extends TestCase {
	
	private AvionSimple unAvion;
	private int velocidad,limite;
	private ArrayList<Posicion> primeraTrayectoria, segundaTrayectoria;
	private Escenario plano;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		velocidad = 1;
		limite = 768;
		unAvion = new AvionSimple(velocidad,limite,plano);
		
		primeraTrayectoria = new ArrayList<Posicion>();
		segundaTrayectoria = new ArrayList<Posicion>();
	}
	
	private void moverAvion (Posicion deUnaPosicion, Posicion aOtraPosicion){
		/* Mueve un avion dependiendo de las dos trayectorias pasadas por parametro */
		/* pre: Se debe ingresar son posiciones */
		/* post: El avion se movio */
		
		primeraTrayectoria.add(deUnaPosicion);
		segundaTrayectoria.add(aOtraPosicion);
		
		unAvion.crearTrayectoria (primeraTrayectoria);
		unAvion.moverse();
		
		unAvion.crearTrayectoria (segundaTrayectoria);
		unAvion.moverse();
	}
	
	public void testMoverseDeberiaMoverseALaPosicionIndicada (){
		
		//arrange
		Posicion unaPosicion = new Posicion (4,5);
		Posicion posicionFinal;
		ArrayList<Posicion> puntosDeTrayectoria = new ArrayList<Posicion>();
		
		//act
		unAvion.crearTrayectoria (puntosDeTrayectoria);
		unAvion.moverse();
		posicionFinal = unAvion.getPosicion();
		
		//assert
		assertTrue (unaPosicion.equals(posicionFinal));		
		
	}
	
	public void testVolarEnDiagonalArribaUnaPosicionLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite - 2, limite - 2);		
		Posicion segundaPosicion = new Posicion (limite + 2, limite - 2);
		
		Posicion direccionNueva = new Posicion (-1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
	}
	
	public void testVolarEnDiagonalAbajoAUnaPosicionLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
	
		//arrange
		Posicion primeraPosicion = new Posicion (limite - 2, limite / 2);		
		Posicion segundaPosicion = new Posicion (limite + 2, (limite / 2) + 2);
		
		Posicion direccionNueva = new Posicion (-1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarEnDiagonalAbajoAUnaPosicionLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2, limite / 2);		
		Posicion segundaPosicion = new Posicion (0, (limite / 2) + 2);
		
		Posicion direccionNueva = new Posicion (1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarEnDiagonalArribaAUnaPosicionLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2, limite / 2);		
		Posicion segundaPosicion = new Posicion (0, (limite / 2) - 2);
		
		Posicion direccionNueva = new Posicion (1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	public void testVolarEnDiagonalDerechaAUnaPosicionLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,2);		
		Posicion segundaPosicion = new Posicion ((limite/2) + 2,0);
		
		Posicion direccionNueva = new Posicion (1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarEnDiagonalIzquierdaAUnaPosicionLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,2);		
		Posicion segundaPosicion = new Posicion ((limite/2) - 2,0);
		
		Posicion direccionNueva = new Posicion (-1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarEnDiagonalDerechaAUnaPosicionLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,limite-2);		
		Posicion segundaPosicion = new Posicion ((limite/2) + 2,limite);
		
		Posicion direccionNueva = new Posicion (1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarEnDiagonalIzquierdaaAUnaPosicionLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,limite-2);		
		Posicion segundaPosicion = new Posicion ((limite/2) - 2,limite);
		
		Posicion direccionNueva = new Posicion (-1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarHorizontalAUnaPosicionLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite-2,limite/2);		
		Posicion segundaPosicion = new Posicion (limite+2,limite/2);
		
		Posicion direccionNueva = new Posicion (-1,0);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarHorizontalAUnaPosicionLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2,limite/2);		
		Posicion segundaPosicion = new Posicion (0,limite/2);
		
		Posicion direccionNueva = new Posicion (1,0);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarVerticalAUnaPosicionLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,2);		
		Posicion segundaPosicion = new Posicion (limite/2,0);
		
		Posicion direccionNueva = new Posicion (0,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarVerticalAUnaPosicionLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,limite-2);		
		Posicion segundaPosicion = new Posicion (limite/2,limite);
		
		Posicion direccionNueva = new Posicion (0,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarDiagonalAUnaPosicionEsquinaArribaDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite-2,2);		
		Posicion segundaPosicion = new Posicion (limite,0);
		
		Posicion direccionNueva = new Posicion (-1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarDiagonalAUnaPosicionEsquinaArribaIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2,2);		
		Posicion segundaPosicion = new Posicion (0,0);
		
		Posicion direccionNueva = new Posicion (1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarDiagonalAUnaPosicionEsquinaAbajoDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite-2,limite-2);		
		Posicion segundaPosicion = new Posicion (limite,limite);
		
		Posicion direccionNueva = new Posicion (-1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarDiagonalAUnaPosicionEsquinaAbajoIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2,limite-2);		
		Posicion segundaPosicion = new Posicion (0,limite);
		
		Posicion direccionNueva = new Posicion (1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (primeraPosicion, segundaPosicion);
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
}
