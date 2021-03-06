import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.event.MouseInputAdapter;

import java.awt.geom.Rectangle2D;

//code récupéré et modifié sur https://coderanch.com/t/333121/java/Text-java-awt-Rectangle 

//classe permettant d'avoir un rectangle avec un texte centré à l'intérieur du rectangle.
public class Button extends Rectangle {

	private static final long serialVersionUID = 1L;
	static final int WIDTH = 70;
	static final int HEIGHT = 30;

	int x;
	int y;
	int width;
	int height;

	String text;
	int x_text;
	int y_text;
	
	// methode permettant de redefinir l'emplacement du boutton.
	public void setXY(int x, int y) {
		super.x = x;
		super.y = y;
		this.x = x;
		this.y = y;
	}

	//constructeur prenant un texte et une position x,y
	public Button(String text, int x, int y) {
		super(x,y, WIDTH, HEIGHT);
		this.x = x;
		this.y = y;
		this.width = WIDTH;
		this.height = HEIGHT;

		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	/**
	 * Dessine un rectangle avec un texte centré
	 * @param g graphics
	 * @param fill condition de re;plissage du rectangle
	 * @param rectColor couleur rectangle
	 * @param stringColor couleur string
	 */
	public void drawStringRect(Graphics g, boolean fill, Color rectColor, Color stringColor) {
		Color old = g.getColor();
		g.setColor(rectColor);
		
		if (fill) { //si on veut un rectangle remplis
			g.fillRect(x, y, width, height);
		} else { // si on le veut vide.
			g.drawRect(x, y, width, height);
		}
		FontMetrics fm = g.getFontMetrics();
		
		g.setColor(stringColor);
		int stringWidth = fm.stringWidth(text);
		
		x_text = x + ((width - stringWidth) / 2); //definission du x et y du texte en fonction de la taille du rectangle et de la taille du texte
		y_text = y + ((height + fm.getHeight()) / 2);
		g.drawString(text, x_text, y_text); //dessin du texte du bouton
		g.setColor(old);
	}

}