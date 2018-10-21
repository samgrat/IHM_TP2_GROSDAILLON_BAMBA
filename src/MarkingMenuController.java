import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class MarkingMenuController implements MouseInputListener {

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
		// on ouvre le marking menu quand le bouton droit de la souris est pressÃ©.
		if (e.getButton() == MouseEvent.BUTTON3) {
			this.right_clic = true;
			m.setBounds(e.getX() - WIDTH / 2, e.getY() - HEIGHT / 2, WIDTH, HEIGHT);
			m.setMouseX(e.getX() - (int) m.getBounds().getX());
			m.setMouseY(e.getY() - (int) m.getBounds().getY());

			m.repaint();
		}
		if (e.getButton() == MouseEvent.BUTTON1) {
			// On stocke l'origine du clic
			m.setO(e.getPoint());
			this.left_clic = true;
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// lorsque le bouton droit de la souris est relachÃ©, on ferme le menu.
		if (e.getButton() == MouseEvent.BUTTON3)
			m.setBounds(e.getX(), e.getY(), 0, 0);
		m.unset_buton_selected();
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

		if (this.left_clic) {
			double xMouse = e.getX();
			double yMouse = e.getY();
			Point o;

			// Test de l'outil courrant de notre modèle
			
			switch(m.getTool()) {
			// dessine au crayon.
			case("pen"): 
				Path2D.Double path = (Path2D.Double) MarkingMenuView.shape;
			if (path == null) {
				path = new Path2D.Double();
				path.moveTo(xMouse, yMouse);
				MarkingMenuView.couleur_shapes.put(MarkingMenuView.shape = path, m.getColor());
			}
			path.lineTo(xMouse, yMouse);
			break;
			// dessine un ellipse
			case("ellipse"):
				o = m.getO();

			Ellipse2D.Double ellipse = (Ellipse2D.Double) MarkingMenuView.shape;
			if (ellipse == null) {
				ellipse = new Ellipse2D.Double(o.getX(), o.getY(), 0, 0);
				MarkingMenuView.couleur_shapes.put(MarkingMenuView.shape = ellipse, m.getColor());
			}
			ellipse.setFrame(Math.min(xMouse, o.getX()), Math.min(yMouse, o.getY()), Math.abs(xMouse - o.getX()),
					Math.abs(yMouse - o.getY()));
			break;
			// dessine un rectangle
			case("rectangle"):
				o = m.getO();

			Rectangle2D.Double rect = (Rectangle2D.Double) MarkingMenuView.shape;
			if (rect == null) {
				rect = new Rectangle2D.Double(o.getX(), o.getY(), 0, 0);
				MarkingMenuView.couleur_shapes.put(MarkingMenuView.shape = rect, m.getColor());
			}
			rect.setFrame(Math.min(xMouse, o.getX()), Math.min(yMouse, o.getY()), Math.abs(xMouse - o.getX()),
					Math.abs(yMouse - o.getY()));
			break;
			default:
				System.err.println("Erreur Outil Modèle");
			}
			
			panel.repaint();
		}

		m.setMouseX(e.getX() - (int) m.getBounds().getX());
		m.setMouseY(e.getY() - (int) m.getBounds().getY());
		m.repaint();
	}

}
