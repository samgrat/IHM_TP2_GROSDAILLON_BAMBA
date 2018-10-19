import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class test {
	
	public static void main(String[] args) {
		JFrame app = new JFrame();
		BorderLayout all = new BorderLayout();
		app.setLayout(all);
		app.setSize(760, 428);
		app.setResizable(false);
			
/*		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(300, 310));
		layeredPane.setBorder(BorderFactory.createTitledBorder("Move the Mouse to Move Duke"));
		
		layeredPane.add(new Button("test", 30, 30), JLayeredPane.PALETTE_LAYER);
		layeredPane.add(new JPanel(), JLayeredPane.DEFAULT_LAYER);*/
		
		ArrayList<Button> list = new ArrayList<Button>();
		list.add(new Button("test1", 30, 30));
		list.add(new Button("test2", 90, 30));
		list.add(new Button("test3", 30, 90));
		list.add(new Button("test4", 90, 90));
		
		Panel p = new Panel(list);
		
		
		app.add(p);
		app.setVisible(true);
	}

}
