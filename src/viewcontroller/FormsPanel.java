package viewcontroller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import util.FormsPresence;
import util.NoFormsPresence;
import util.State;

public class FormsPanel extends JPanel implements MouseListener{
	private ArrayList<FormsView> viewsList;
	private ArrayList<RectangleView> rectanglesViewsList;
	private ArrayList<CircleView> circlesViewsList;
	private Modes mode;
	private Window parent;
	private int x;
	private int y;
	private State state;
	
	public FormsPanel(Window parent) {
		this.viewsList = new ArrayList<FormsView>();
		this.rectanglesViewsList = new ArrayList<RectangleView>();
		this.circlesViewsList = new ArrayList<CircleView>();
		this.addMouseListener(this);
		this.parent = parent;
		this.mode = this.parent.getMode();
		this.x = 0;
		this.state = new NoFormsPresence(); // A pour etat NoFormPresence de base
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
		if(this.parent.getMode() == Modes.Remove) {
			for(RectangleView rV : this.rectanglesViewsList) {
				System.out.println(rV.getX());
				if(e.getX() >= rV.getX()) {
					this.state.removeRect(this.getGraphics(), rV.getX(), rV.getY(), rV.getHeight(), rV.getWidth());
					rV.setDeleted(true);
					System.out.println("Haaa");
					this.revalidate();
					this.repaint();	
					this.parent.revalidate();
					this.parent.repaint();
				}
				else if(e.getX() <= rV.getX() && e.getX() >= rV.getX() - rV.getWidth() && e.getY() <= rV.getY() && e.getY() >= rV.getY() - rV.getHeight()) {
					this.state.removeRect(this.getGraphics(), rV.getX(), rV.getY(), rV.getHeight(), rV.getWidth());
					
					this.revalidate();
					this.repaint();
				}
				else if(e.getY() >= rV.getY() && e.getY() <= rV.getY() + rV.getHeight()) {
					this.state.removeRect(this.getGraphics(), rV.getX(), rV.getY(), rV.getHeight(), rV.getWidth());
					this.revalidate();
					this.repaint();
				}
				else if(e.getY() <= rV.getY() && e.getY() >= rV.getY() - rV.getHeight()) {
					this.state.removeRect(this.getGraphics(), rV.getX(), rV.getY(), rV.getHeight(), rV.getWidth());
					this.revalidate();
					this.repaint();
				}
			}
			for(CircleView rV : this.circlesViewsList) {
				System.out.println(rV.getX());
				if(e.getX() >= rV.getX()) {
					this.state.removeCircle(this.getGraphics(), rV.getX(), rV.getY(), rV.getRadius(), this.getBackground());
					rV.setDeleted(true);
					this.revalidate();
					this.repaint();	
					this.parent.revalidate();
					this.parent.repaint();
				}
				else if(e.getX() <= rV.getX() && e.getX() >= rV.getX() && e.getY() <= rV.getY() && e.getY() >= rV.getY()) {
					this.state.removeCircle(this.getGraphics(), rV.getX(), rV.getY(), rV.getRadius(), this.getBackground());
					
					this.revalidate();
					this.repaint();
				}
				else if(e.getY() >= rV.getY() && e.getY() <= rV.getY()) {
					this.state.removeCircle(this.getGraphics(), rV.getX(), rV.getY(), rV.getRadius(), this.getBackground());
					this.revalidate();
					this.repaint();
				}
				else if(e.getY() <= rV.getY()) {
					this.state.removeCircle(this.getGraphics(), rV.getX(), rV.getY(), rV.getRadius(), this.getBackground());
					this.revalidate();
					this.repaint();
				}
			}
		}
	}
		
	@Override
	public void mousePressed(MouseEvent e) {
		// On sauvegarde le point initial
		this.x = e.getX();
		this.y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int distance = (int) Math.sqrt(Math.pow((e.getY()-this.y), 2) + Math.pow((e.getX()-this.x), 2));

		if(this.parent.getMode() == Modes.Circle) {
			CircleView cV = new CircleView(this, this.x, this.y, distance);
			this.addView(cV);
			this.circlesViewsList.add(cV);
			this.state = new FormsPresence(); // On passe à l'état FormsPresence
		}
		else if(this.parent.getMode() == Modes.Rectangle) {
			RectangleView rV = new RectangleView(this, this.x, this.y, e.getX()-this.y,e.getX()-this.x);
			this.addView(rV);
			this.rectanglesViewsList.add(rV);
			this.state = new FormsPresence(); // On passe à l'état FormsPresence
		}
		
		this.revalidate();
		this.repaint();	
		this.parent.revalidate();
		this.parent.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void removeCircle(Graphics g, int x, int y, int radius, Color bg) {
		if(this.parent.getMode() == Modes.Remove)
			this.state.removeCircle(g, x, y, radius, bg);
	}
	
	public void removeRect(Graphics g, int x, int y, int height, int width) {
		if(this.parent.getMode() == Modes.Remove)
			this.state.removeRect(g, x, y, height, width);
	}
}
