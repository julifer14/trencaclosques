package cat.juli.trencaclosques;

import acm.graphics.GImage;

public class Casella {
	GImage imatge;
	boolean tocada;
	public Casella(GImage imatge){
		this.imatge = imatge;
		tocada = false;
	}
	
	public GImage getImatge(){
		return imatge;
	}
	
	public boolean getTocada(){
		return tocada;
	}
	public void setTocada(boolean toc){
		tocada = toc;
	}
}
