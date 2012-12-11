package fiuba.algo3.flightcontrol;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.flightcontrol.modelo.AvionComputarizado;
import fiuba.algo3.flightcontrol.modelo.AvionSimple;
import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;

import junit.framework.TestCase;

public class AvionSimpleTest extends TestCase {
	
	private AvionSimple unAvion;
	private int velocidad,limite;
	private List<Vector> listaDePuntos;
	private Trayectoria unaTrayectoria;
	private Nivel unNivel;
	private Vector destino;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		velocidad = 10;
		limite = 768;
		unNivel = new Nivel (velocidad,limite);
		unAvion = new AvionSimple (velocidad,unNivel);
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
		
			unAvion.vivir();
		}
		
	}
	
	private void moverAvion (ObjetoVolador unAvion){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una posicion */
		/* post: El avion se movio */
		
		while ( unAvion.hayTrayectoria()){
			unAvion.vivir();
		}
	}
	
	private void generarAlgunAvionNoComputarizado(){
		
		unNivel.vivir();
		
		while(unNivel.getUltimoObjetoVolador().getClass() == AvionComputarizado.class){
			
			unNivel.vivir();
		}
	}
	
	public void test2AvionesDeRadio1SiSeJuntanAUnaDistanciaIgualA2DeberianChocar() {
		
		//arrange
		listaDePuntos.add(new Vector(10, 10));
		unaTrayectoria = new Trayectoria (listaDePuntos);
		unAvion.setTrayectoria(unaTrayectoria);
		
		List<Vector> otraListaDePuntos = new ArrayList<Vector>();
		otraListaDePuntos.add(new Vector(10, 12));
		Trayectoria otraTrayectoria = new Trayectoria(otraListaDePuntos);
		this.generarAlgunAvionNoComputarizado();//unNivel.vivir();
		ObjetoVolador otroAvion = unNivel.getUltimoObjetoVolador();
		otroAvion.setTrayectoria(otraTrayectoria);
		
		//act
		this.moverAvion(unAvion);
		this.moverAvion(otroAvion);
		
		//assert
		assertTrue(unAvion.chocar());
	}
	
	public void testCrearAvionSeDeberiaCrearEnUnaPosicionLimite (){
		
		//arrante
		Vector posicionDeSalida = unAvion.getPosicion();
		int posX = posicionDeSalida.getPosicionX();
		int posY = posicionDeSalida.getPosicionY();
		
		boolean estaEnElNorte, estaEnElSur, estaEnElEste, estaEnElOeste = false;
		boolean estaEnUnBorde;
		
		//act
		estaEnElNorte = (posX == 0);
		estaEnElSur = (posX == limite-1);
		estaEnElOeste = (posY == 0);
		estaEnElEste = (posY == limite-1);
		estaEnUnBorde = (estaEnElNorte || estaEnElSur || estaEnElOeste || estaEnElEste);
		
		//assert
		assertTrue (estaEnUnBorde);
	}
	
	public void testVivirDeUnAvionSimpleQueRecienFueGeneradoDeberiaMoverseDeAcuerdoASuDireccionDeSalida(){
		
		Vector posicionInicial = unAvion.getPosicion();
		Vector direccionInicial = new Vector(1,1);
		
		unAvion.vivir();
		
		assertTrue(unAvion.getPosicion().restar(posicionInicial).equals(direccionInicial));
	}
	
	public void testVivirDeUnAvionSimpleConVelocidad2DeberiaTardar5TunosParaMoverseUnaPosicion(){
		
		int otraVelocidad = 2;
		AvionSimple simple = new AvionSimple(otraVelocidad,unNivel);
		Vector posicionDeSalida = simple.getPosicion();
		Vector direccionDeSalida = new Vector(1,1);
		
		
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		
		assertTrue(simple.getPosicion().restar(posicionDeSalida).equals(direccionDeSalida));
	}
	
public void testVivirDeUnAvionSimpleConVelocidad1DeberiaTardar10TunosParaMoverseUnaPosicion(){
		
		int otraVelocidad = 1;
		AvionSimple simple = new AvionSimple(otraVelocidad,unNivel);
		Vector posicionDeSalida = simple.getPosicion();
		Vector direccionDeSalida = new Vector(1,1);
		
		
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		simple.vivir();
		
		assertTrue(simple.getPosicion().restar(posicionDeSalida).equals(direccionDeSalida));
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
	
	public void testVolarRecorriendoUnaTrayectoriaDeberiaObtenerTodosLosPuntosCorrectamente (){
		
		//arrange
		boolean pasoCorrecto = true;
		
		Vector direccion, proximoPaso, actual, inicio, intermedio1, intermedio2;
		Trayectoria otraTrayectoria;
		List <Vector> otrosPuntos = new ArrayList <Vector>();
		
		inicio = new Vector (0,0);
		intermedio1 = new Vector (7,5);
		intermedio2 = new Vector (4,7);
		destino = new Vector (2,5);
				
		otrosPuntos.add(intermedio1);
		otrosPuntos.add(intermedio2);
		otrosPuntos.add(destino);
		
		otraTrayectoria = new Trayectoria (otrosPuntos);
		
		//act
		
		//Primero se lleva al avion al (0,0)
		
		this.moverAvion(unAvion, inicio);
		
		//Se ingresa la trayectoria que se desea testear
		
		unAvion.setTrayectoria(otraTrayectoria);
		proximoPaso = new Vector (1,1);
		
		//Primero se mueve diagonalmente
		
		direccion = new Vector (1,1);
		actual = unAvion.getPosicion();
		
		while (pasoCorrecto){
						
			proximoPaso = actual.sumar(direccion);
			unAvion.vivir();
			actual = unAvion.getPosicion();
			pasoCorrecto = actual.equals(proximoPaso);
		}
		
		//Luego se mueve en linea recta
		
		direccion = new Vector (1,0);
		pasoCorrecto = true;
		
		while (pasoCorrecto){
			
			proximoPaso = actual.sumar(direccion);
			unAvion.vivir();
			actual = unAvion.getPosicion();
			pasoCorrecto = actual.equals(proximoPaso);
		}
		
		//Luego se mueve en diagonal, hasta el intermedio2
		
		direccion = new Vector (-1,1);
		pasoCorrecto = true;
		
		while (pasoCorrecto){
			
			proximoPaso = actual.sumar(direccion);
			unAvion.vivir();
			actual = unAvion.getPosicion();
			pasoCorrecto = actual.equals(proximoPaso);
		}
		
		
		//Luego se mueve en diagonal hasta el destino
		
		direccion = new Vector (-1,-1);
		pasoCorrecto = true;
		
		while (pasoCorrecto && ! proximoPaso.equals(destino)){
			
			proximoPaso = actual.sumar(direccion);
			unAvion.vivir();
			actual = unAvion.getPosicion();
			pasoCorrecto = actual.equals(proximoPaso);
		}
		
		//assert
		assertTrue (pasoCorrecto);
	}

}
