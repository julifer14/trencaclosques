package cat.juli.trencaclosques;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.ArrayList;
import java.util.Random;

import acm.graphics.GImage;

public class Tauler implements MouseListener {
	ArrayList<Casella> caselles = new ArrayList<Casella>();
	// Imatge original
	GImage imatgeOriginal;
	int horitzonatal;
	int vertical;
	int buida;

	public Tauler(String imatge, int h, int v) {
		this.imatgeOriginal = new GImage(imatge);
		// this.imatgeOriginal.setSize(500, 300);
		horitzonatal = h;
		vertical = v;
		

	}

	public void ultimaPeca(boolean estat) {
		caselles.get(caselles.size() - 1).getImatge().setVisible(estat);

	}

	public void pintar(Pantalla principal) {
		for (Casella c : caselles) {
			System.out.println("Imatge!");
			principal.add(c.getImatge());
			principal.pause(20);

		}

	}

	public ArrayList<Casella> getCaselles() {
		return caselles;
	}

	public void generarImatges() {
		Random r = new Random();
		int w = (int) (imatgeOriginal.getWidth() / horitzonatal);
		int h = (int) (imatgeOriginal.getHeight() / vertical);
		for (int x = 0; x < horitzonatal; x++) {
			for (int y = 0; y < vertical; y++) {

				System.out.println("Estic tallant!");
				GImage img = tallaImatge(imatgeOriginal, w * x, h * y, w, h);
				Casella cas = new Casella(this, img, y * w, x * h);
				caselles.add(cas);

			}
		}
		buida= caselles.size() - 1;
		System.out.println(caselles.size());

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Has clicat!");
		boolean trobada  = false;
		
		int tocada = 0;
		while (trobada != true){
			double x = arg0.getX();
			double y = arg0.getY();
			trobada = caselles.get(tocada).tocada(x, y);
			tocada++;
		}
		System.out.println("La tocada és: " + tocada);
		//Si la posició Y del lloc al que vull moure la peça es igual a la meva y + l'altura puc moure
		//Moure de dalt a abaix
		System.out.println(buida);
		System.out.println("Altura pesa: " + retornarImatgeCasella(tocada).getHeight());
		if(retornarImatgeCasella(buida).getY() == (retornarImatgeCasella(tocada).getY()+retornarImatgeCasella(tocada).getHeight())){
			double xPerMoure = retornarImatgeCasella(buida).getX();
			double yPerMoure =  retornarImatgeCasella(buida).getY();
			double xBuida = retornarImatgeCasella(tocada).getX();
			double yBuida = retornarImatgeCasella(tocada).getY();
			caselles.get(tocada).moure(xPerMoure,yPerMoure);
			caselles.get(buida).moure(xBuida, yBuida);
			this.buida = tocada;
			System.out.println("Sóc lliure! Em moc cap abaix!");
			
		}
		
		
	}
	
	private GImage retornarImatgeCasella(int i){
		return caselles.get(i).getImatge();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
