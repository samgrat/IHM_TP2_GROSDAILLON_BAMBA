import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class MarkingMenuController implements MouseInputListener  {
	
	public static final int WIDTH = 270;
	public static final int HEIGHT = 230;
	
	private MarkingMenuModel m;
	private JPanel panel;
	private boolean left_clic;
	private boolean right_clic;
	
	
	
	public MarkingMenuController(MarkingMenuModel m, JPanel jp) {
		super();
		this.m = m;
		this.panel = jp;
		this.left_clic = false;
		this.right_clic = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//on ouvre le marking menu quand le bouton droit de la souris est pressé.
		if (e.getButton() == MouseEvent.BUTTON3) {
			this.right_clic = true;
			m.setBounds(e.getX()-WIDTH/2, e.getY()-HEIGHT/2, WIDTH, HEIGHT);
			m.setMouseX(e.getX()-(int)m.getBounds().getX());
			m.setMouseY(e.getY()-(int)m.getBounds().getY());

			m.repaint();
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			this.left_clic = true;
		}

	}
	
	@Override
	public void mouseMoved(MouseEvent e) {

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		//lorsque le bouton droit de la souris est relaché, on ferme le menu.
		if (e.getButton() == MouseEvent.BUTTON3)
		m.setBounds(e.getX(), e.getY(), 0, 0);
		
		MarkingMenuView.shape = null;
		this.left_clic = false;
		this.right_clic = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//dessine au crayon.
		if (this.left_clic) {
			Path2D.Double path = (Path2D.Double)MarkingMenuView.shape;
			if(path == null) {
				path = new Path2D.Double();
				path.moveTo(e.getX(), e.getY());
				MarkingMenuView.couleur_shapes.put(MarkingMenuView.shape = path, MarkingMenuView.couleur);
			}
			path.lineTo(e.getX(), e.getY());
			panel.repaint();
		}
		
		
		m.setMouseX(e.getX()-(int)m.getBounds().getX());
		m.setMouseY(e.getY()-(int)m.getBounds().getY());
		m.repaint();		
	}

}
