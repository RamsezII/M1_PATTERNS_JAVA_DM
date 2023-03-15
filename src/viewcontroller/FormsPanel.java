package viewcontroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.listener.ContainerFormsListener;

public class FormsPanel extends JPanel implements MouseListener{
	private ArrayList<FormsView> viewsList;
	private Modes mode;
	private Window parent;
	private int x;
	private int y;
	
	public FormsPanel(Window parent) {
		this.viewsList = new ArrayList<FormsView>();
		this.addMouseListener(this);
		this.parent = parent;
		this.mode = this.parent.getMode();
		this.x = 0;
	}
	
	// Pour chaques vues, le container leur demande de dessiner leur propre vue dans lui-même
	
	@Override
	protected void paintComponent(Graphics g) {
		for(FormsView v : this.viewsList) {
			v.paint(g);
		}
	}
	
	public void addView(FormsView view) {
		this.viewsList.add(view);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		if(this.parent.getMode() == Modes.Circle) {
//			this.addView(new CircleView(this, e.getX(), e.getY()));
//			
//		}
//		else if(this.parent.getMode() == Modes.Rectangle) {
//			this.addView(new RectangleView(this, e.getX(), e.getY()));
//			// Penser a passer en FormsPresence
//		}
//		
//		this.revalidate();
//		this.repaint();
		
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// On sauvegarde le point initial
		this.x = e.getX();
		this.y = e.getY();
		System.out.println(this.x);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int distance = (int) Math.sqrt(Math.pow((e.getY()-this.y), 2) + Math.pow((e.getX()-this.x), 2));
		System.out.println(distance);

		if(this.parent.getMode() == Modes.Circle) {
			this.addView(new CircleView(this, this.x, this.y, distance));

		}
		else if(this.parent.getMode() == Modes.Rectangle) {
			this.addView(new RectangleView(this, this.x, this.y, e.getX()-this.y,e.getX()-this.x));
			// Penser a passer en FormsPresence
		}
		
		this.revalidate();
		this.repaint();	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
