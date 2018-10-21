import java.awt.Component;
import java.awt.Graphics;
import java.awt.MouseInfo;

import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.ToolBarUI;

public class MarkingUI extends ComponentUI {
	
	private MarkingMenu menu;
	
	public MarkingUI(MarkingMenu m) {
		super();
		this.menu = m;
	}
	
	@Override
	public void paint( Graphics g, JComponent c ) {
		g.fillRect(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 100, 100);
		/*JToolBar j = (JToolBar) c;
		Component components[] = j.getComponents();
		int x = 10;
		int y = 10;
		for (int i = 0; i< components.length; i++) {
			System.out.println(components[i].toString());
			components[i].setLocation(x, y);
			x=x+10;
			y=y+10;
		}*/
	}
}
