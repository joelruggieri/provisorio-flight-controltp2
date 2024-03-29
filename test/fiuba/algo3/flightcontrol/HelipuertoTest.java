package fiuba.algo3.flightcontrol;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.flightcontrol.modelo.AvionPesado;
import fiuba.algo3.flightcontrol.modelo.AvionSimple;
import fiuba.algo3.flightcontrol.modelo.Helicoptero;
import fiuba.algo3.flightcontrol.modelo.Helipuerto;
import fiuba.algo3.flightcontrol.modelo.Nivel;
import fiuba.algo3.flightcontrol.modelo.NoTieneUnaDireccionDeEntradaException;
import fiuba.algo3.flightcontrol.modelo.ObjetoVolador;
import fiuba.algo3.flightcontrol.modelo.Trayectoria;
import fiuba.algo3.flightcontrol.modelo.Vector;

public class HelipuertoTest extends TestCase {
	
	private List <Vector> posicionesDestino,posicionesDeLaPista;
	private Trayectoria unaTrayectoria;
	private Vector posicion1,posicion2,posicion3,posicion4;
	private int velocidad,dimension;
	private Nivel unNivel;
	private AvionSimple avion;
	private Helicoptero helicoptero;
	private AvionPesado avionPesado;
	
	protected void setUp () throws Exception {
		super.setUp();
		
		posicion1 = new Vector(1,1);
		posicion2 = new Vector(2,2);
		posicion3 = new Vector(1,2);
		posicion4 = new Vector(2,1);
		
		posicionesDestino = new ArrayList <Vector>();
		posicionesDeLaPista = new ArrayList <Vector>();
		
		velocidad = 10;
		dimension = 768;
		unNivel = new Nivel(velocidad, dimension);
				
		avion = new AvionSimple(velocidad,unNivel);
		helicoptero = new Helicoptero(velocidad,unNivel);
		avionPesado = new AvionPesado(velocidad,unNivel);
		
	}
	
	private void moverAvion (ObjetoVolador unAvion, Vector destino){
		/* Mueve un avion hasta el destino */
		/* pre: Se debe ingresar el avion a mover y una Vector */
		/* post: El avion se movio */
		
		posicionesDestino.add(destino);
		unaTrayectoria = new Trayectoria (posicionesDestino);
		unAvion.setTrayectoria(unaTrayectoria);
		
		while (!unAvion.getPosicion().equals(destino)){
			unAvion.vivir();
		}
		
	}
	
	public void testConstructorDeUnHelipuertoPedirLaDireccionDeberiaLanzarUnaExceocion(){
		
		//arrange
		
		/*creo las Vectores de la pista*/
		Vector posicionDeEntrada = new Vector(4,1);
		
		//act
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
	
		//assert	
		try{
			pista.getDireccionDeEntrada();
		}catch(NoTieneUnaDireccionDeEntradaException excepcion){
			
		}
	}

	public void testgetPosicionDeEntradaDeberiaSerLaCorrecta(){
		
		//arrange
		
		/*creo las Vectores de la pista*/
		Vector posicionDeEntrada = new Vector(4,1);
		
		//act
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		//assert	
		assertTrue(pista.getPosicionDeEntrada() == posicionDeEntrada);
	}
	
	
	
	public void testLlegadaDeUnAvionSimpleALHelipuertoEnDireccionNorteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avion,posicion4);
		this.moverAvion(avion,posicion1);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}
	
	
	public void testLlegadaDeUnAvionSimpleALHelipuertoEnDireccionSurNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avion,posicion1);
		this.moverAvion(avion,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}
	
	public void testLlegadaDeUnAvionSimpleALHelipuertoEnDireccionEsteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avion,posicion1);
		this.moverAvion(avion,posicion3);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,2);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}
	
	public void testLlegadaDeUnAvionSimpleALHelipuertoEnDireccionOesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avion,posicion2);
		this.moverAvion(avion,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}
	

	public void testLlegadaDeUnAvionSimpleALHelipuertoEnDireccionNoresteNoDeberiaAterrizar(){
	
	//arrange
	
	//act	
	this.moverAvion (avion,posicion4);
	this.moverAvion(avion,posicion3);
	
	/*creo las Vectores de la pista*/
	
	Vector posicionDeEntrada = new Vector(1,2);
	posicionesDeLaPista.add(posicionDeEntrada);
	
	Helipuerto pista = new Helipuerto(posicionesDeLaPista);
	
	pista.recibirAterrizajeDeObjetoVolador(avion);

	//assert
	assertTrue(!avion.aterrizo());
	}
	
	
	public void testLlegadaDeUnAvionSimpleALHelipuertoEnDireccionNoroesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avion,posicion2);
		this.moverAvion(avion,posicion1);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}

	public void testLlegadaDeUnAvionSimpleALHelipuertoEnDireccionSuresteNoDeberiaAterrizar(){
	
	//arrange
	
	//act	
	this.moverAvion (avion,posicion1);
	this.moverAvion(avion,posicion4);
	
	/*creo las Vectores de la pista*/
	
	Vector posicionDeEntrada = new Vector(2,1);
	posicionesDeLaPista.add(posicionDeEntrada);
	
	Helipuerto pista = new Helipuerto(posicionesDeLaPista);
	
	pista.recibirAterrizajeDeObjetoVolador(avion);

	//assert
	assertTrue(!avion.aterrizo());
	}
	
	public void testLlegadaDeUnAvionSimpleALHelipuertoEnDireccionSuroesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avion,posicion3);
		this.moverAvion(avion,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avion);
	
		//assert
		assertTrue(!avion.aterrizo());
	}
	
	public void testLlegadaDeUnAvionPesadoALHelipuertoEnDireccionNorteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avionPesado,posicion4);
		this.moverAvion(avionPesado,posicion1);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}
	
	
	public void testLlegadaDeUnAvionPesadoALHelipuertoEnDireccionSurNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avionPesado,posicion1);
		this.moverAvion(avionPesado,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}
	
	public void testLlegadaDeUnAvionPesadoALHelipuertoEnDireccionEsteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avionPesado,posicion1);
		this.moverAvion(avionPesado,posicion3);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,2);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}
	
	public void testLlegadaDeUnAvionPesadoALHelipuertoEnDireccionOesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avionPesado,posicion2);
		this.moverAvion(avionPesado,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}
	

	public void testLlegadaDeUnAvionPesadoALHelipuertoEnDireccionNoresteNoDeberiaAterrizar(){
	
	//arrange
	
	//act	
	this.moverAvion (avionPesado,posicion4);
	this.moverAvion(avionPesado,posicion3);
	
	/*creo las Vectores de la pista*/
	
	Vector posicionDeEntrada = new Vector(1,2);
	posicionesDeLaPista.add(posicionDeEntrada);
	
	Helipuerto pista = new Helipuerto(posicionesDeLaPista);
	
	pista.recibirAterrizajeDeObjetoVolador(avionPesado);

	//assert
	assertTrue(!avionPesado.aterrizo());
	}
	
	
	public void testLlegadaDeUnAvionPesadoALHelipuertoEnDireccionNoroesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avionPesado,posicion2);
		this.moverAvion(avionPesado,posicion1);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}

	public void testLlegadaDeUnAvionPesadoALHelipuertoEnDireccionSuresteNoDeberiaAterrizar(){
	
	//arrange
	
	//act	
	this.moverAvion (avionPesado,posicion1);
	this.moverAvion(avionPesado,posicion4);
	
	/*creo las Vectores de la pista*/
	
	Vector posicionDeEntrada = new Vector(2,1);
	posicionesDeLaPista.add(posicionDeEntrada);
	
	Helipuerto pista = new Helipuerto(posicionesDeLaPista);
	
	pista.recibirAterrizajeDeObjetoVolador(avionPesado);

	//assert
	assertTrue(!avionPesado.aterrizo());
	}
	
	public void testLlegadaDeUnAvionPesadoALHelipuertoEnDireccionSuroesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (avionPesado,posicion3);
		this.moverAvion(avionPesado,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(avionPesado);
	
		//assert
		assertTrue(!avionPesado.aterrizo());
	}
	
	public void testLlegadaDeUnHelicopteroALHelipuertoEnDireccionNorteDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (helicoptero,posicion4);
		this.moverAvion(helicoptero,posicion1);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(helicoptero.aterrizo());
	}
	
	
	public void testLlegadaDeUnHelicopteroALHelipuertoEnDireccionSurNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (helicoptero,posicion1);
		this.moverAvion(helicoptero,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(helicoptero.aterrizo());
	}
	
	public void testLlegadaDeUnHelicopteroALHelipuertoEnDireccionEsteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (helicoptero,posicion1);
		this.moverAvion(helicoptero,posicion3);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,2);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(helicoptero.aterrizo());
	}
	
	public void testLlegadaDeUnHelicopteroALHelipuertoEnDireccionOesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (helicoptero,posicion2);
		this.moverAvion(helicoptero,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(helicoptero.aterrizo());
	}
	

	public void testLlegadaDeUnHelicopteroALHelipuertoEnDireccionNoresteNoDeberiaAterrizar(){
	
		//arrange
		
		//act	
		this.moverAvion (helicoptero,posicion4);
		this.moverAvion(helicoptero,posicion3);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,2);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(helicoptero.aterrizo());
	}
	
	
public void testLlegadaDeUnHelicopteroALHelipuertoEnDireccionNoroesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (helicoptero,posicion2);
		this.moverAvion(helicoptero,posicion1);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(1,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(helicoptero.aterrizo());
	}

	public void testLlegadaDeUnHelicopteroALHelipuertoEnDireccionSuresteNoDeberiaAterrizar(){
	
		//arrange
	
		//act	
		this.moverAvion (helicoptero,posicion1);
		this.moverAvion(helicoptero,posicion4);
	
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
	
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
	
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);

		//assert
		assertTrue(helicoptero.aterrizo());
	}
	
	public void testLlegadaDeUnHelicopteroALHelipuertoEnDireccionSuroesteNoDeberiaAterrizar(){
		
		//arrange
		
		//act	
		this.moverAvion (helicoptero,posicion3);
		this.moverAvion(helicoptero,posicion4);
		
		/*creo las Vectores de la pista*/
		
		Vector posicionDeEntrada = new Vector(2,1);
		posicionesDeLaPista.add(posicionDeEntrada);
		
		Helipuerto pista = new Helipuerto(posicionesDeLaPista);
		
		pista.recibirAterrizajeDeObjetoVolador(helicoptero);
	
		//assert
		assertTrue(helicoptero.aterrizo());
	}
	

	
	
}


