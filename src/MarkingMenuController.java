import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class MarkingMenuController implements MouseInputListener {

	public static final int WIDTH = 270; // width du marking menu
	public static final int HEIGHT = 230; // height du marking menu

	private MarkingMenuModel m; // Le marking menu associé
	private JPanel panel; // la zone de dessin associé
	private boolean left_clic; // boolean servant à savoir si l'on dragg avec le bouton gauche de la souris.
	private boolean right_clic; // boolean servant à savoir si l'on dragg avec le bouton droit de la souris.

	// constructeur prenant un marking menu ainsi qu'un jpanel (zone de dessin).
	public MarkingMenuController(MarkingMenuModel m, JPanel jp) {
		super();
		this.m = m;
		this.panel = jp;
		this.left_clic = false;
		this.right_clic = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// on ouvre le marking menu quand le bouton droit de la souris est pressé.
		if (e.getButton() == MouseEvent.BUTTON3) {
			this.right_clic = true;
			m.setBounds(e.getX() - WIDTH / 2, e.getY() - HEIGHT / 2, WIDTH, HEIGHT); // on définis les bounds du marking
																						// menu pour qu'il passe de
																						// l'état invisible à l'etat
																						// visible.
			m.setMouseX(e.getX() - (int) m.getBounds().getX()); // on transmet la position de la souris (avec un calcul
																// pour avoir la position relative et non absolue) pour
																// l'affichage de la ligne entre le centre du marking
																// menu et du curseur
			m.setMouseY(e.getY() - (int) m.getBounds().getY());

			m.repaint();
		}
		// si l'on presse le bouton gauche de la souris
		if (e.getButton() == MouseEvent.BUTTON1) {
			// On stocke l'origine du clic
			m.setO(e.getPoint());
			this.left_clic = true;
		}

	}

	// nous ne nous servons pas de cette fonction
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// lorsque le bouton droit de la souris est relaché, on ferme le menu.
		if (e.getButton() == MouseEvent.BUTTON3) {
			m.setBounds(e.getX(), e.getY(), 0, 0); // nous définissons les bounds du marking menu avec une taille de 0,0
													// pour qu'il deviennent "invisible"
			Vector<Object> liste_outils = new Vector<Object>(); // nous redefinissons les boutons du marking menu sur
																// ceux de base (Outils et Couleurs) quand le bouton
																// droit est relaché.
			liste_outils.add("Outils");
			liste_outils.add("Couleurs");
			m.setComposants(liste_outils);
		}

		m.setMenu(""); // on remet notre menu � son etat initial
		m.unset_buton_selected(); // plus aucun bouton n'est selectionné lors du relachement du bouton de la
									// souris
		MarkingMenuView.shape = null;
		this.left_clic = false;
		this.right_clic = false;
	}

	// nous ne nous servons pas de cette fonction
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// nous ne nous servons pas de cette fonction
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// nous ne nous servons pas de cette fonction
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.left_clic) { // si l'on dragg avec le bouton gauche de la souris (on veut dessiner)
			double xMouse = e.getX();
			double yMouse = e.getY();
			Point o;

			// Test de l'outil courrant de notre mod�le

			switch (m.getTool()) {
			// dessine au crayon.
			case ("pen"):

				Path2D.Double path = (Path2D.Double) MarkingMenuView.shape;
				if (path == null) {
					path = new Path2D.Double();
					path.moveTo(xMouse, yMouse);
					MarkingMenuView.couleur_shapes.put(MarkingMenuView.shape = path, m.getColor());
				}
				path.lineTo(xMouse, yMouse);
				break;
			// dessine un ellipse
			case ("ellipse"):

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
			case ("rectangle"):

				o = m.getO();

				Rectangle2D.Double rect = (Rectangle2D.Double) MarkingMenuView.shape;
				if (rect == null) {
					rect = new Rectangle2D.Double(o.getX(), o.getY(), 0, 0);
					MarkingMenuView.couleur_shapes.put(MarkingMenuView.shape = rect, m.getColor());
				}
				rect.setFrame(Math.min(xMouse, o.getX()), Math.min(yMouse, o.getY()), Math.abs(xMouse - o.getX()),
						Math.abs(yMouse - o.getY()));
				break;
			// dessine une ligne
			case ("line"):

				o = m.getO();

				Line2D.Double line = (Line2D.Double) MarkingMenuView.shape;
				if (line == null) {
					line = new Line2D.Double(o.getX(), o.getY(), 0, 0);
					MarkingMenuView.couleur_shapes.put(MarkingMenuView.shape = line, m.getColor());
				}
				line.setLine(e.getX(), e.getY(), o.getX(), o.getY());
				break;
			default:
				System.err.println("Erreur Outil Mod�le");
			}

			panel.repaint();
		} else if (this.right_clic) { // si l'on dragg avec le bouton droit de la souris (on est sur le marking menu)
			// Test du menu courant
			switch (m.getMenu()) {
			case ("Outils"): // si l'on à selectionné "Outils"
				m.setBounds(e.getX() - WIDTH / 2, e.getY() - HEIGHT / 2, WIDTH, HEIGHT); // on redefinis les nouvelles
																							// bounds du marking menu
																							// qui va etre réouvert.
				m.setMouseX(e.getX() - (int) m.getBounds().getX()); // on transmet la position de la souris (avec un
																	// calcul pour avoir la position relative et non
																	// absolue) pour l'affichage de la ligne entre le
																	// centre du marking menu et du curseur
				m.setMouseY(e.getY() - (int) m.getBounds().getY());
				m.setMenu(""); // nous ne sommes plus dans le menu (Outils, Couleurs)
				m.setLast_button_selected(null); // nous n'avons plus de dernier bouton sélectionné

				Vector<Object> liste_outils = new Vector<Object>(); // on créé notre liste d'outils
				liste_outils.add("pen");
				liste_outils.add("ellipse");
				liste_outils.add("rectangle");
				liste_outils.add("line");

				m.setComposants(liste_outils); // on change les composants du marking menu, la prochaine étape sera
												// alors de simplement repaint le marking menu
				break;
			case ("Couleurs"): // si l'on à selectionné "Couleurs"
				m.setBounds(e.getX() - WIDTH / 2, e.getY() - HEIGHT / 2, WIDTH, HEIGHT); // on redefinis les nouvelles
																							// bounds du marking menu
																							// qui va etre réouvert.
				m.setMouseX(e.getX() - (int) m.getBounds().getX()); // on transmet la position de la souris (avec un
																	// calcul pour avoir la position relative et non
																	// absolue) pour l'affichage de la ligne entre le
																	// centre du marking menu et du curseur
				m.setMouseY(e.getY() - (int) m.getBounds().getY());
				m.setMenu(""); // nous ne sommes plus dans le menu (Outils, Couleurs)
				m.setLast_button_selected(null); // on créé notre liste d'outils

				Vector<Object> liste_couleurs = new Vector<Object>(); // On créé notre liste de 8 couleurs
				liste_couleurs.add("red");
				liste_couleurs.add("green");
				liste_couleurs.add("yellow");
				liste_couleurs.add("blue");
				liste_couleurs.add("cyan");
				liste_couleurs.add("orange");
				liste_couleurs.add("magenta");
				liste_couleurs.add("black");

				m.setComposants(liste_couleurs); // on change les composants du marking menu avec la liste de couleurs,
													// la prochaine étape sera alors de simplement repaint le marking
													// menu

				break;
			default:
			}
		}

		m.setMouseX(e.getX() - (int) m.getBounds().getX()); // on transmet la position de la souris (avec un calcul pour
															// avoir la position relative et non absolue) pour
															// l'affichage de la ligne entre le centre du marking menu
															// et du curseur
		m.setMouseY(e.getY() - (int) m.getBounds().getY());
		m.repaint(); // on redessine le marking menu
		panel.repaint(); // on redessine la zone de dessin.
	}

}
