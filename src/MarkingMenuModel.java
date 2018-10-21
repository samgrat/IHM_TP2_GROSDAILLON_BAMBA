import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class MarkingMenuModel extends JComponent{
	private String tool;
	private Color color;
	private Vector<Object> composants = new Vector<Object>();
	private int mouseX = -99999; //valeur de base non affectée.
	private int mouseY = -99999;
	
	public MarkingMenuModel(String tool, Color color) {
		super();
		this.tool = tool;
		this.color = color;
		//this.addMouseListener(new ClicEventListener());
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
			(new Button(composants.get(0).toString(), 50, 0)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(1).toString(), 150, 0)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(2).toString(), 200, 50)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(3).toString(), 200, 150)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(4).toString(), 150, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(5).toString(), 50, 200)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(6).toString(), 0, 150)).drawStringRect(g, true, Color.RED, Color.WHITE);
			(new Button(composants.get(7).toString(), 0, 50)).drawStringRect(g, true, Color.RED, Color.WHITE);


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
	
}
