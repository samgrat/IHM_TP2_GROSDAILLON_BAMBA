import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

public class ClicEventListener implements MouseInputListener  {
	
	private MarkingMenu m;
	
	
	
	public ClicEventListener(MarkingMenu m) {
		super();
		this.m = m;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		/*this.setBounds(300, 300, 50, 50);
		
		this.repaint();*/
		System.out.println("test");
		m.setBounds(e.getX()-50, e.getY()-50, 500, 500);
		m.setMouseX(e.getX());
		m.setMouseY(e.getY());

		m.repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		/*this.setBounds(300, 300, 50, 50);
		
		this.repaint();*/
		System.out.println("moved");
	
		//m.setBounds(e.getX(), e.getY(), 0, 0);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		/*this.setBounds(300, 300, 50, 50);
		
		this.repaint();*/
		System.out.println("released");

		m.setBounds(e.getX(), e.getY(), 0, 0);
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
		// TODO Auto-generated method stub
		System.out.println("dragged");
		m.setMouseX(e.getX()-(int)m.getBounds().getX());

		m.setMouseY(e.getY()-(int)m.getBounds().getY());
		
		m.repaint();
		
	}
}
