import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class MarkingMenu extends JComponent{
	private String tool;
	private Color color;
	private Vector<Object> composants = new Vector<Object>();
	private int mouseX = 0;
	private int mouseY = 0;
	
	public MarkingMenu(String tool, Color color) {
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

	@Override
	public void paintComponent( Graphics g) {
		//this.setBounds(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 500, 500);
		g.setColor(Color.LIGHT_GRAY);
		//g.fillRect(0, 0, 100, 100);
		g.fillOval(0, 0, 100, 100);
		g.setColor(Color.BLACK);
		g.drawLine(50, 50, this.getMouseX(), this.getMouseY());
		
	}
	
}
