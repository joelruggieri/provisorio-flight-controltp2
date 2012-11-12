package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import junit.framework.TestCase;

public class AvionSimpleTest extends TestCase {
	
	private AvionSimple unAvion;
	private int velocidad,limite;
	private ArrayList<Posicion> unaTrayectoria;
	private Escenario plano;
	Posicion actual,destino;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		velocidad = 1;
		limite = 768;
		plano = new Escenario (limite);
		unAvion = new AvionSimple (velocidad,limite,plano);
		unaTrayectoria = new ArrayList<Posicion>();
		
	}
	
	private void moverAvion (ObjetoVolador unAvion, Posicion destino){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una posicion */
		/* post: El avion se movio */
		
		unaTrayectoria.add(destino);
		unAvion.crearTrayectoria (unaTrayectoria);
		//destino.imprimirPosicion();
		while (!unAvion.getPosicion().equals(destino)){
			unAvion.moverse();
			//unAvion.getPosicion().imprimirPosicion();
		}
		
	}

	
	public void testMoverseDeberiaMoverseALaPosicionIndicada (){
		
		//arrange
		destino = new Posicion (4,5);
		Posicion posicionFinal;
				
		//act
		this.moverAvion(unAvion, destino);
		posicionFinal = unAvion.getPosicion();
		
		//assert
		assertTrue (destino.equals(posicionFinal));		
		
	}


	public void testVolarEnDiagonalArribaUnaPosicionLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite - 2, limite - 2);		
		Posicion segundaPosicion = new Posicion (limite -4, limite);
		
		Posicion direccionNueva = new Posicion (-1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);		
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 1");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
	}
	

	public void testVolarEnDiagonalAbajoAUnaPosicionLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
	
		//arrange
		Posicion primeraPosicion = new Posicion (limite / 2, limite - 2);		
		Posicion segundaPosicion = new Posicion ((limite / 2) + 2, limite);
		
		Posicion direccionNueva = new Posicion (1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 2");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	
	public void testVolarEnDiagonalAbajoAUnaPosicionLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2, limite / 2);		
		Posicion segundaPosicion = new Posicion (0, (limite / 2) + 2);
		
		Posicion direccionNueva = new Posicion (1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 3");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
	}

	public void testVolarEnDiagonalArribaAUnaPosicionLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2, limite / 2);		
		Posicion segundaPosicion = new Posicion (0, (limite / 2) - 2);
		
		Posicion direccionNueva = new Posicion (1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		//System.out.println("Segundo movimiento");
		
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
				
		//assert
		System.out.println("TERMINO 4");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	public void testVolarEnDiagonalDerechaAUnaPosicionLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,2);		
		Posicion segundaPosicion = new Posicion ((limite/2) + 2,0);
		
		Posicion direccionNueva = new Posicion (1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 5");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	public void testVolarEnDiagonalIzquierdaAUnaPosicionLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,2);		
		Posicion segundaPosicion = new Posicion ((limite/2) - 2,0);
		
		Posicion direccionNueva = new Posicion (-1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 6");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarEnDiagonalDerechaAUnaPosicionLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,limite-2);		
		Posicion segundaPosicion = new Posicion ((limite/2) + 2,limite);
		
		Posicion direccionNueva = new Posicion (1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 7");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	

	public void testVolarEnDiagonalIzquierdaaAUnaPosicionLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,limite-2);		
		Posicion segundaPosicion = new Posicion ((limite/2) - 2,limite);
		
		Posicion direccionNueva = new Posicion (-1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 8");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	
	public void testVolarHorizontalAUnaPosicionLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,limite-2);		
		Posicion segundaPosicion = new Posicion (limite/2,limite);
		
		Posicion direccionNueva = new Posicion (0,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
				
		//assert
		System.out.println("TERMINO 13");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}



	public void testVolarHorizontalAUnaPosicionLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2,limite/2);		
		Posicion segundaPosicion = new Posicion (0,limite/2);
		
		Posicion direccionNueva = new Posicion (1,0);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO X");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	public void testVolarVerticalAUnaPosicionLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,2);		
		Posicion segundaPosicion = new Posicion (limite/2,0);
		
		Posicion direccionNueva = new Posicion (0,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO X");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	
	public void testVolarVerticalAUnaPosicionLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite/2,limite-2);		
		Posicion segundaPosicion = new Posicion (limite/2,limite);
		
		Posicion direccionNueva = new Posicion (0,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO X");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	public void testVolarDiagonalAUnaPosicionEsquinaArribaDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite-2,2);		
		Posicion segundaPosicion = new Posicion (limite,0);
		
		Posicion direccionNueva = new Posicion (-1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 9");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	public void testVolarDiagonalAUnaPosicionEsquinaArribaIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2,2);		
		Posicion segundaPosicion = new Posicion (0,0);
		
		Posicion direccionNueva = new Posicion (1,1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 10");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}

	public void testVolarDiagonalAUnaPosicionEsquinaAbajoDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (limite-2,limite-2);		
		Posicion segundaPosicion = new Posicion (limite,limite);
		
		Posicion direccionNueva = new Posicion (-1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 11");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
	


	public void testVolarDiagonalAUnaPosicionEsquinaAbajoIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Posicion primeraPosicion = new Posicion (2,limite-2);		
		Posicion segundaPosicion = new Posicion (0,limite);
		
		Posicion direccionNueva = new Posicion (1,-1);
		Posicion direccionDespuesDeMoverse;
		
		//act
		this.moverAvion (unAvion, primeraPosicion);
		this.moverAvion (unAvion, segundaPosicion);
		
		direccionDespuesDeMoverse = unAvion.getDireccion();
		
		//assert
		System.out.println("TERMINO 12");
		assertTrue (direccionNueva.equals(direccionDespuesDeMoverse));
		
	}
}
