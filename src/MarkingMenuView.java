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
	public static HashMap<Shape, Color> couleur_shapes = new HashMap<Shape, Color>();
	public static Color couleur = Color.BLACK;
	
	//public static Tool tool;
	public static JPanel panel;
	public static Shape shape;
	public static Point o;

	/*class Tool extends AbstractAction
	           implements MouseInputListener {
	   //Point o;
		//Shape shape;
		public Tool(String name) { super(name); }
		public void actionPerformed(ActionEvent e) {
			System.out.println("using tool " + this);
			panel.removeMouseListener(tool);
			panel.removeMouseMotionListener(tool);
			tool = this;
			panel.addMouseListener(tool);
			panel.addMouseMotionListener(tool);
		}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) { o = e.getPoint(); }
		public void mouseReleased(MouseEvent e) { shape = null; }
		public void mouseDragged(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {}
	}
	
	Tool tools[] = {
		new Tool("pen") {
			public void mouseDragged(MouseEvent e) {
				Path2D.Double path = (Path2D.Double)shape;
				if(path == null) {
					path = new Path2D.Double();
					path.moveTo(o.getX(), o.getY());
					couleur_shapes.put(shape = path, couleur);
				}
				path.lineTo(e.getX(), e.getY());
				panel.repaint();
			}
		},
		new Tool("ellipse") {
			public void mouseDragged(MouseEvent e) {
				Ellipse2D.Double ellipse = (Ellipse2D.Double)shape;
				if(ellipse == null) {
					ellipse = new Ellipse2D.Double(o.getX(), o.getY(), 0, 0);
					couleur_shapes.put(shape = ellipse, couleur);
				}
				ellipse.setFrame(min(e.getX(), o.getX()), min(e.getY(), o.getY()),
				             abs(e.getX()- o.getX()), abs(e.getY()- o.getY()));
				panel.repaint();
			}
		},
		new Tool("rect") {
			public void mouseDragged(MouseEvent e) {
				Rectangle2D.Double rect = (Rectangle2D.Double)shape;
				if(rect == null) {
					rect = new Rectangle2D.Double(o.getX(), o.getY(), 0, 0);
					couleur_shapes.put(shape = rect, couleur);
				}
				rect.setRect(min(e.getX(), o.getX()), min(e.getY(), o.getY()),
				             abs(e.getX()- o.getX()), abs(e.getY()- o.getY()));
				panel.repaint();
			}
		}
	};
	*/
	
	
	
	public MarkingMenuView(String title) {
		super(title);
		JLayeredPane lpanel = new JLayeredPane();
		Vector<Object> composants = new Vector<Object>();
		composants.add("Outils");
		composants.add("Couleurs");

		
		MarkingMenuModel m = new MarkingMenuModel("pen", Color.BLACK, composants);	
		
		JPanel panel = new JPanel() {	
			public void paintComponent(Graphics g) {
				super.paintComponent(g);	
				Graphics2D g2 = (Graphics2D)g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				                    RenderingHints.VALUE_ANTIALIAS_ON);
		
				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());
				g2.setColor(Color.BLACK);
				g2.drawString("Outil : " + m.getTool(), 10, 20);
				g2.drawString("Couleur : " + m.getNom_couleur(), 10, 40);
				System.out.println(couleur);
				g2.setColor(couleur);

				for(Entry<Shape, Color> entry : couleur_shapes.entrySet()) {
					g2.setColor(entry.getValue());
					g2.draw(entry.getKey());
				}
			}
		};
		
		MarkingMenuController c = new MarkingMenuController(m,panel);
		lpanel.addMouseListener(c);
		lpanel.addMouseMotionListener(c);
		JButton rouge = new JButton("Rouge");
		rouge.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
	            couleur = Color.RED;  
	        }  
	    });
		
		JButton bleu = new JButton("Bleu");
		bleu.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
	            couleur = Color.blue;  
	        }  
	    });
		
		JButton buttons[] = {
				rouge,
				bleu
		};
		JLayeredPane p = new JLayeredPane();
		JToolBar j = new JToolBar();
		//j.setUI(new MarkingUI());
		j.setSize(100, 100);
		
		//j.setOpaque(false);
		//j.setLayout(new BoxLayout(j, BoxLayout.PAGE_AXIS));
		//j.setBackground(Color.WHITE);
		/*for(AbstractAction tool: tools) {
			j.add(tool);
		}
		for(JButton button: buttons) {
			j.add(button);
		}*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		//add(j,BorderLayout.NORTH);
		
		
		panel.setBounds(0, 0, this.getSize().width, this.getSize().height);
		lpanel.add(panel, JLayeredPane.DEFAULT_LAYER);
		//m.setBounds(0,0,0,0);
		lpanel.add(m, JLayeredPane.PALETTE_LAYER);
		//lpanel.add(j, JLayeredPane.POPUP_LAYER);
		add(lpanel);
		//add(m);
		

		

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