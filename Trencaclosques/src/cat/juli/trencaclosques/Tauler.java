package cat.juli.trencaclosques;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.ArrayList;

import acm.graphics.GImage;

public class Tauler {
	ArrayList<Casella> caselles = new ArrayList<Casella>();
	//Imatge original
	GImage imatgeOriginal;
	int horitzonatal;
	int vertical;

	public Tauler(String imatge, int h, int v) {
		this.imatgeOriginal = new GImage(imatge);
		this.imatgeOriginal.setSize(500, 300);
		horitzonatal = h;
		vertical = v;

	}
	
	public void pintar(Pantalla principal){
		for(Casella c: caselles){
			System.out.println("Imatge!");
			principal.add(c.getImatge());
			principal.pause(500);
			
		}
	}
	
	public ArrayList<Casella> getCaselles(){
		return caselles;
	}

	public void generarImatges() {
		int w = (int) (imatgeOriginal.getWidth() / horitzonatal);
		int h = (int) (imatgeOriginal.getHeight() / vertical);
		for (int x = 0; x < horitzonatal; x++) {
			for (int y = 0; y < vertical; y++) {
				System.out.println("Estic tallant!");
				GImage img = tallaImatge(imatgeOriginal, w*x, h*y, w, h);
				Casella cas = new Casella(imatgeOriginal);
				caselles.add(cas);

			}
		}

		System.out.println(caselles.size());

	}

	public GImage getImatge() {
		return imatgeOriginal;
	}

	/**
	 * Funció que rep com a paràmetre un GImage que té la imatge sencera i
	 * retorna una subimatge definida per les coordenades x, y, w i h
	 * 
	 * @param src
	 *            Imatge que es vol tallar
	 * @param x
	 *            coordenada x del tall
	 * @param y
	 *            coordenada y del tall
	 * @param w
	 *            amplada del tall
	 * @param h
	 *            altura del tall
	 * @return Imatge escapçada
	 * 
	 *         .--------------------------------. | x,y | | *--------------* | |
	 *         | | | | *--------------* | | | ---------------------------------.
	 */
	public static GImage tallaImatge(GImage src, int x, int y, int w, int h) {
		Image imatge = src.getImage();
		imatge = Toolkit.getDefaultToolkit().createImage(
				new FilteredImageSource(imatge.getSource(),
						new CropImageFilter(x, y, w, h)));
		return new GImage(imatge);
	}

}
