import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private ArrayList<Button> buttons;
	
	public Panel(ArrayList<Button> buttons) {
		this.buttons = buttons;
	}

	@Override
	protected void paintComponent(Graphics g) {
		for(int i = 0; i < buttons.size(); i++) {
			buttons.get(i).drawStringRect(g, false, Color.GRAY, Color.BLACK);
		}
	}
}
