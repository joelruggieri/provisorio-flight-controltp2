package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class AvionSimpleTest extends TestCase {
	
	private AvionSimple unAvion;
	private int nivel,limite;
	private List<Vector> listaDePuntos;
	private Trayectoria unaTrayectoria;
	private Escenario plano;
	private Vector destino;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		nivel = 25;
		limite = 768;
		plano = new Escenario (limite);
		unAvion = new AvionSimple (nivel,plano);
		listaDePuntos = new ArrayList<Vector>();
		
		
	}
	
	private void moverAvion (ObjetoVolador unAvion, Vector destino){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una Vector */
		/* post: El avion se movio */
		
		listaDePuntos.add(destino);
		this.unaTrayectoria = new Trayectoria (listaDePuntos);
		unAvion.setTrayectoria(this.unaTrayectoria);
		
		
		while (!unAvion.getPosicion().equals(destino)){
		//	unAvion.getPosicion().imprimir();
			unAvion.mover();
		}
		
	}

	public void testMoverDeberiamoverALaPosicionIndicada (){
		
		//arrange
		destino = new Vector (4,5);
		Vector posicionFinal;
						
		//act
		this.moverAvion(unAvion, destino);
		posicionFinal = unAvion.getPosicion();
				
		//assert
		assertTrue (destino.equals(posicionFinal));		
		
	}


	public void testVolarEnDiagonalArribaUnaVectorLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite - 2, limite - 2);		
		Vector segundaVector = new Vector (limite -4, limite);
	
		Vector direccionNueva = new Vector (-1,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);		
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
	}
	

	public void testVolarEnDiagonalAbajoAUnaVectorLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
	
		//arrange
		Vector primeraVector = new Vector (limite / 2, limite - 2);		
		Vector segundaVector = new Vector ((limite / 2) + 2, limite);
	
		Vector direccionNueva = new Vector (1,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
			
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}

	
	public void testVolarEnDiagonalAbajoAUnaVectorLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (2, limite / 2);		
		Vector segundaVector = new Vector (0, (limite / 2) + 2);
	
		Vector direccionNueva = new Vector (1,1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
	}

	public void testVolarEnDiagonalArribaAUnaVectorLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (2, limite / 2);		
		Vector segundaVector = new Vector (0, (limite / 2) - 2);
	
		Vector direccionNueva = new Vector (1,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
				
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}

	public void testVolarEnDiagonalDerechaAUnaVectorLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite/2,2);		
		Vector segundaVector = new Vector ((limite/2) + 2,0);
	
		Vector direccionNueva = new Vector (1,1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}

	public void testVolarEnDiagonalIzquierdaAUnaVectorLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite/2,2);		
		Vector segundaVector = new Vector ((limite/2) - 2,0);
	
		Vector direccionNueva = new Vector (-1,1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
		
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}
	
	public void testVolarEnDiagonalDerechaAUnaVectorLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite/2,limite-2);		
		Vector segundaVector = new Vector ((limite/2) + 2,limite);
	
		Vector direccionNueva = new Vector (1,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}
	

	public void testVolarEnDiagonalIzquierdaaAUnaVectorLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite/2,limite-2);		
		Vector segundaVector = new Vector ((limite/2) - 2,limite);
	
		Vector direccionNueva = new Vector (-1,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}
	
	public void testVolarHorizontalAUnaVectorLateralDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite/2,limite-2);		
		Vector segundaVector = new Vector (limite/2,limite);
	
		Vector direccionNueva = new Vector (0,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
				
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}

	public void testVolarHorizontalAUnaVectorLateralIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (2,limite/2);		
		Vector segundaVector = new Vector (0,limite/2);
	
		Vector direccionNueva = new Vector (1,0);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}

	public void testVolarVerticalAUnaVectorLateralArribaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite/2,2);		
		Vector segundaVector = new Vector (limite/2,0);
	
		Vector direccionNueva = new Vector (0,1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}

	public void testVolarVerticalAUnaVectorLateralAbajoFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite/2,limite-2);		
		Vector segundaVector = new Vector (limite/2,limite);
	
		Vector direccionNueva = new Vector (0,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
	
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}

	public void testVolarDiagonalAUnaVectorEsquinaArribaDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite-2,2);		
		Vector segundaVector = new Vector (limite,0);
	
		Vector direccionNueva = new Vector (-1,1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
			
	}

	public void testVolarDiagonalAUnaVectorEsquinaArribaIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (2,2);		
		Vector segundaVector = new Vector (0,0);
	
		Vector direccionNueva = new Vector (1,1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}

	public void testVolarDiagonalAUnaVectorEsquinaAbajoDerechaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (limite-2,limite-2);		
		Vector segundaVector = new Vector (limite,limite);
	
		Vector direccionNueva = new Vector (-1,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}
	
	public void testVolarDiagonalAUnaVectorEsquinaAbajoIzquierdaFueraDelLimiteDeberiaRebotarCorrectamente (){
		
		//arrange
		Vector primeraVector = new Vector (2,limite-2);		
		Vector segundaVector = new Vector (0,limite);
	
		Vector direccionNueva = new Vector (1,-1);
		Vector direccionDespuesDemover;
		
		//act
		this.moverAvion (unAvion, primeraVector);
		this.moverAvion (unAvion, segundaVector);
	
		direccionDespuesDemover = unAvion.getDireccion();
		
		//assert
		assertTrue (direccionNueva.equals(direccionDespuesDemover));
		
	}
}
