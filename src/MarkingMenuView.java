//////////////////////////////////////////////////////////////////////////////
// file    : Paint.java
// content : basic painting app
//////////////////////////////////////////////////////////////////////////////

/* imports *****************************************************************/

import static java.lang.Math.*;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

//import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import java.awt.event.*;
import javax.swing.event.*;

//import com.sun.org.glassfish.gmbal.ParameterNames;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

/* paint *******************************************************************/

class MarkingMenuView extends JFrame {
	public static HashMap<Shape, Color> couleur_shapes = new HashMap<Shape, Color>(); // Hashmap contenant les shapes
																						// déssinées sur le Jpanel ainsi
																						// que leur couleurs.

	public static JPanel panel; // zone de dessin
	public static Shape shape; // shape

	public MarkingMenuView(String title) {
		super(title);
		JLayeredPane lpanel = new JLayeredPane(); // le JLayeredPane permet de superposer les composants, notre marking
													// menu est superposé sur le jpanel qui est la zone de dessin
		Vector<Object> composants = new Vector<Object>(); // liste de nos composants de base pour créer le marking menu
		composants.add("Outils");
		composants.add("Couleurs");

		MarkingMenuModel m = new MarkingMenuModel("pen", Color.BLACK, composants); // création du marking menu avec les
																					// boutons Outils et Couleurs,
																					// l'outil pen sélectionné ainsi que
																					// la couleur black.

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());
				g2.setColor(Color.BLACK);
				g2.drawString("Outil : " + m.getTool(), 10, 20); // outil courrant, pour que l'utilisateur sache ou il
																	// en est.
				g2.drawString("Couleur : " + m.getNom_couleur(), 10, 40); // couleur courrante, pour que l'utilisateur
																			// sache ou il en est.

				for (Entry<Shape, Color> entry : couleur_shapes.entrySet()) { // boucle sur la hashmap de shape pour
																				// dessiner tout ce qu'on à déjà dessiné
																				// précédemment
					g2.setColor(entry.getValue());
					g2.draw(entry.getKey());
				}
			}
		};

		MarkingMenuController c = new MarkingMenuController(m, panel); // création de notre controlleur
		lpanel.addMouseListener(c); // ajout de notre controleur comme MouseListener
		lpanel.addMouseMotionListener(c); // ajout de notre controleur comme MouseMotionListener

		setDefaultCloseOperation(EXIT_ON_CLOSE); // stop le processus si l'on ferme la fenetre de dessin
		setMinimumSize(new Dimension(800, 600));

		panel.setBounds(0, 0, this.getSize().width, this.getSize().height); // le JlayeredPanel fonctionne avec des
																			// bounds il nous est nécessaire de définir
																			// la taille de chaque composants pour
																			// pouvoir l'afficher, la zone de dessin à
																			// une taille équivalente a la fenetre.
		lpanel.add(panel, JLayeredPane.DEFAULT_LAYER); // on ajoute le jpanel au JLayeredPanel comme premiere couche
		lpanel.add(m, JLayeredPane.PALETTE_LAYER); // on ajoute le marking menu au JLayeredPanel comme seconde couche
													// (nous n'avons pas défini ses bounds, il est pour le moment
													// invisible)
		add(lpanel); // on ajoute le JLayeredPanel à notre fenetre

		pack();
		setVisible(true);
	}

	/* main *********************************************************************/

	public static void main(String argv[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MarkingMenuView paint = new MarkingMenuView("paint");
			}
		});
	}
}