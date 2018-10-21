import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class MarkingMenuModel extends JComponent{
	// Liste des outils support�s par notre appli
	private final List<String> TOOLS = Arrays.asList("rectangle", "ellipse", "pen");
	
	private String tool = "pen";
	private Color color = Color.BLACK;
	private Vector<Object> composants = new Vector<Object>();
	private Vector<Button> liste_composants = new Vector<Button>();
	private Button last_button_selected;
	private int mouseX = -99999; //valeur de base non affectée.
	private int mouseY = -99999;
	private Point origine;
	
	public MarkingMenuModel(String tool, Color color, Vector<Object> composants) {
		super();
		this.tool = tool;
		this.color = color;
		this.composants = composants;
		for (int i = 0; i<composants.size(); i++) {
			this.liste_composants.addElement(new Button(composants.get(i).toString(),0,0));
		}
		//this.addMouseListener(new ClicEventListener());
	}

	public void setO(Point o) {
		this.origine = o;
	}
	public Point getO() {
		return origine;
	}
	
	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void unset_buton_selected() {
		this.last_button_selected = null;
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
	
	public Vector<Object> getComposants() {
		return composants;
	}

	public void setComposants(Vector<Object> composants) {
		this.composants = composants;
	}
	
	public void addComponent(Object component) {
		this.getComposants().addElement(component);
	}

	public boolean isATool(String s) {
		return TOOLS.contains(s);
	}

	@Override
	public void paintComponent( Graphics g) {
		Button b = new Button("saaaaaalut", 0, 0);
		//this.setBounds(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 500, 500);
		g.setColor(Color.LIGHT_GRAY);
		//g.fillRect(0, 0, 100, 100);
		//g.fillOval(0, 0, 100, 100);
		g.setColor(Color.BLACK);
		System.out.println(this.getMouseX()+ " " + this.getMouseY());
		System.out.println(b.x+ " " + b.y);
		System.out.println(b.contains(this.getMouseX(),this.getMouseY()));

		//definission de la position des boutons en fonction de la taille du marking menu.
		//nous avons décidés de choisir l'emplacement de cette façon car nous avons décidés que notre marking menu ne pouvait pas avoir plus de 8 éléments. (vu en cours).
		if (this.composants.size() == 1) {
			(new Button(composants.get(0).toString(), 200, 100)).drawStringRect(g, true, Color.RED, Color.WHITE);
		} else if (this.composants.size() == 2) {
			(new Button(composants.get(0).toString(), 200, 100)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(1).toString(), 0, 100)).drawStringRect(g, true, Color.RED, Color.WHITE);

		} else if (this.composants.size() == 3) {
			(new Button(composants.get(0).toString(), 200, 100)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(1).toString(), 100, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(2).toString(), 0, 100)).drawStringRect(g, true, Color.RED, Color.WHITE);
			
		} else if (this.composants.size() == 4) {
			(new Button(composants.get(0).toString(), 200, 100)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(1).toString(), 100, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(2).toString(), 0, 100)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(3).toString(), 100, 0)).drawStringRect(g, true, Color.RED, Color.WHITE);
			
		} else if (this.composants.size() == 5) {
			(new Button(composants.get(0).toString(), 100, 0)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(1).toString(), 200, 50)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(2).toString(), 150, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(3).toString(), 50, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(4).toString(), 0, 50)).drawStringRect(g, true, Color.RED, Color.WHITE);

		} else if (this.composants.size() == 6) {
			(new Button(composants.get(0).toString(), 100, 0)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(1).toString(), 200, 50)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(2).toString(), 200, 150)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(3).toString(), 100, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(4).toString(), 0, 150)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(5).toString(), 0, 50)).drawStringRect(g, true, Color.RED, Color.WHITE);

		} else if (this.composants.size() == 7) {
			(new Button(composants.get(0).toString(), 100, 0)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(1).toString(), 200, 50)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(2).toString(), 200, 150)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(3).toString(), 150, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(4).toString(), 50, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(5).toString(), 0, 150)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(6).toString(), 0, 50)).drawStringRect(g, true, Color.RED, Color.WHITE);

		} else if (this.composants.size() == 8) {
			this.liste_composants.get(0).setXY(50,0);
			this.liste_composants.get(1).setXY(150,0);
			this.liste_composants.get(2).setXY(200,50);
			this.liste_composants.get(3).setXY(200,150);
			this.liste_composants.get(4).setXY(150,200);
			this.liste_composants.get(5).setXY(50,200);
			this.liste_composants.get(6).setXY(0,150);
			this.liste_composants.get(7).setXY(0,50);

			for (int i = 0; i< liste_composants.size(); i++) {
				Button composant = this.liste_composants.get(i);
				String composantName = composant.getText();
				Line2D l1 = new Line2D.Float(135, 115, this.getMouseX(), this.getMouseY());
				
				// Si notre ligne croise un boutton
				if (l1.intersects(composant) || composant.equals(this.last_button_selected)) {
					
					//On change l'outil en m�me temps qu'un feedback visuel
					if(isATool(composantName))
						setTool(composantName);
					else
						setColor(stringToColor(composantName));
						
					composant.drawStringRect(g, true, Color.GREEN, Color.WHITE);
					this.last_button_selected = composant;
				} else {
					composant.drawStringRect(g, true, Color.RED, Color.WHITE);
				}
			}
//			this.liste_composants.get(0).drawStringRect(g, true, Color.RED, Color.WHITE);
//			this.liste_composants.get(1).drawStringRect(g, true, Color.RED, Color.WHITE);
//			this.liste_composants.get(2).drawStringRect(g, true, Color.RED, Color.WHITE);
//			this.liste_composants.get(3).drawStringRect(g, true, Color.RED, Color.WHITE);
//			this.liste_composants.get(4).drawStringRect(g, true, Color.RED, Color.WHITE);
//			this.liste_composants.get(5).drawStringRect(g, true, Color.RED, Color.WHITE);
//			this.liste_composants.get(6).drawStringRect(g, true, Color.RED, Color.WHITE);
//			this.liste_composants.get(7).drawStringRect(g, true, Color.RED, Color.WHITE);
	}
	

		if (b.contains(this.getMouseX(),this.getMouseY())) {
		//	(b).drawStringRect(g, true, Color.RED, Color.WHITE);
		} else {
			//(b).drawStringRect(g, false, Color.RED, Color.WHITE);
		}
		g.setColor(Color.RED);
		g.fillOval(135-10, 115-10, 20, 20);
		g.setColor(Color.BLACK);

		if (this.getMouseX() != -99999 && this.getMouseY() != -99999)
		g.drawLine(135, 115, this.getMouseX(), this.getMouseY());
		
	}

	/**
	 * Essaie de traduire une string en couleur
	 * @param composantName la string
	 * @return color l'objet Color
	 */
	private Color stringToColor(String composantName) {
		Color color;
		try {
		    Field field = Class.forName("java.awt.Color").getField(composantName);
		    color = (Color)field.get(null);
		} catch (Exception e) {
		    color = Color.BLACK; 
		    System.err.println("Outil non reconnu");
		}
		return color;
	}
	
}
