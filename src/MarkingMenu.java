import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class MarkingMenu extends JComponent{
	private String tool;
	static final int RADIUS = 100;
	static final int N_MAX_BUTTONS_ON_CIRCLE = 8;
	private Color colorMenu = Color.LIGHT_GRAY;
	private Color colorButton = Color.BLACK;
	private Vector<Object> composants = new Vector<Object>();
	private int mouseX = 0;
	private int mouseY = 0;
	// Nos Outils
	private ArrayList<Button> buttons = new ArrayList<Button>();
	
	public MarkingMenu(String tool) {
		super();
		this.tool = tool;
		
		buttons.add(new Button("test1"));
		buttons.add(new Button("test2"));
		buttons.add(new Button("test3"));
		buttons.add(new Button("test4"));	
	}
	
//	public MarkingMenu(String tool, Color colorMenu, Color colorButton) {
//		super();
//		this.tool = tool;
//		this.colorMenu = colorMenu;
//		this.colorMenu = colorButton;
//		
//		//this.addMouseListener(new ClicEventListener());		
//	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public Color getColor() {
		return colorMenu;
	}

	public void setColor(Color color) {
		this.colorMenu = color;
	}
	
	
	
	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	@Override
	public void paintComponent( Graphics g) {
		
		// paramètres du bouton à dessiner
		double xCurrent;
		double yCurrent;
		Button bCurrent;
		
		//this.setBounds(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 500, 500);
		g.setColor(colorMenu);
		g.fillOval(0, 0, RADIUS*2, RADIUS*2);
		g.setColor(colorButton);
		// On récupère la position de la souris pour tracer notre ligne
		g.drawLine(RADIUS, RADIUS, this.getMouseX(), this.getMouseY());
		
		// Ensuite on tourne autour du cercle pour dessiner nos bouttons
		for(int i = 0; i < buttons.size(); i++) {
			bCurrent = buttons.get(i);
			xCurrent = RADIUS*Math.cos(i * Math.PI/(N_MAX_BUTTONS_ON_CIRCLE));
			yCurrent = RADIUS*Math.sin(i * Math.PI/(N_MAX_BUTTONS_ON_CIRCLE));

			bCurrent.drawStringRect(g, (int) xCurrent, (int) yCurrent);
		}
		
	}
	
}
