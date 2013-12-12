package cat.juli.trencaclosques;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Pantalla extends GraphicsProgram {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int WIDTH = 500;
	static int HEIGHT = 300;
	static int HORITZONTAL = 4;
	static int VERTICAL = 4;
	
	
	
	public void init() {
		// Crear pantalla
		setSize(WIDTH, HEIGHT);
		// Indicar que ha d'escoltar les tecles del teclat, si toquen una tecla
		// es dispara
		// la funció keyPressed
		//addKeyListeners(this);
	}
	public void run() {
		Tauler tauler = new Tauler("wheezy.jpg", HORITZONTAL, VERTICAL);
		tauler.generarImatges();
		tauler.pintar(this);
		
		
		
		/*
		GImage original = tauler.getImatge();
		//add(original);
		tauler.generarImatges();
		
		ArrayList<Casella> caselles = tauler.getCaselles();
		
		/*for (Casella casella : caselles) {
			add(casella.getImatge());
			pause(50);
		}*/
	}
}
