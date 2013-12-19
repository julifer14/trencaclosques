package cat.juli.trencaclosques;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import acm.graphics.GImage;

public class Casella  {
	static int ultimid = 0;
	GImage imatge;
	boolean tocada;
	int id;
	public Casella(Tauler t, GImage imatge, int x, int y){
		this.imatge = imatge;
		tocada = false;
		double xD = (double) (x);
		double yD = (double) (y);
		id = ultimid;
		ultimid++;
		this.imatge.setLocation(xD, yD);
		this.imatge.addMouseListener(t);
	}
	
	public void moure(double x, double y){
		imatge.setLocation(x, y);
	}
	
	public GImage getImatge(){
		return imatge;
	}
	
	public boolean tocada(double x, double y){
		return imatge.contains(x, y);
	}
	public void setTocada(boolean toc){
		tocada = toc;
	}

	
}
