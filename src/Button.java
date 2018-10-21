import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.event.MouseInputAdapter;

import java.awt.geom.Rectangle2D;

// https://coderanch.com/t/333121/java/Text-java-awt-Rectangle
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

	public void setXY(int x, int y) {
		super.x = x;
		super.y = y;
		this.x = x;
		this.y = y;
	}

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
		
		if (fill) {
			g.fillRect(x, y, width, height);
		} else {
			g.drawRect(x, y, width, height);
		}
		FontMetrics fm = g.getFontMetrics();
		
		g.setColor(stringColor);
		int stringWidth = fm.stringWidth(text);
		
		x_text = x + ((width - stringWidth) / 2);
		y_text = y + ((height + fm.getHeight()) / 2);
		g.drawString(text, x_text, y_text);
		g.setColor(old);
	}

}