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
	/*private ArrayList<RectangleView> rectanglesViewsList;
	private ArrayList<CircleView> circlesViewsList;*/
	private Modes mode;
	private Window parent;
	private int x;
	private int y;
	private State state;
	
	public FormsPanel(Window parent) {
		this.viewsList = new ArrayList<FormsView>();
		/*this.rectanglesViewsList = new ArrayList<RectangleView>();
		this.circlesViewsList = new ArrayList<CircleView>();*/
		this.addMouseListener(this);
		this.parent = parent;
		this.mode = this.parent.getMode();
		this.x = 0;
		this.y = 0;
		this.state = new NoFormsPresence(); // A pour etat NoFormPresence de base
	}
	
	// Pour chaques vues, le container leur demande de dessiner leur propre vue dans lui-m�me
	
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
			for (FormsView fV : this.viewsList) {
				if(fV instanceof RectangleView)
				{
					RectangleView rV = (RectangleView) fV;
					boolean collision = true;

					if(rV.getX() > e.getX() || rV.getY() > e.getY() ||
					  (rV.getWidth() +rV.getX()) < e.getX() || (rV.getHeight() +rV.getY()) < e.getY())
						collision = false;

					if(collision)
					{
						//this.state.removeRect(this.getGraphics(), rV.getX(), rV.getY(), rV.getWidth(), rV.getHeight());
						rV.setDeleted(true);
						this.revalidate();
						this.repaint();
						this.parent.revalidate();
						this.parent.repaint();
					}
				}
				if(fV instanceof CircleView)
				{
					CircleView rV = (CircleView) fV;
					double distPtrCentre = Math.sqrt(Math.pow(e.getX()-rV.getX(), 2)  + Math.pow(e.getY()-rV.getY(), 2));
					boolean collision = distPtrCentre < rV.getRadius();

					if(collision)
					{
						rV.setDeleted(true);
						this.revalidate();
						this.repaint();
						this.parent.revalidate();
						this.parent.repaint();
					}
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

		int xmin = Math.min(e.getX(), this.x);
		int ymin = Math.min(e.getY(), this.y);
		int xmax = Math.max(e.getX(), this.x);
		int ymax = Math.max(e.getY(), this.y);

		int distance = (int) Math.sqrt(Math.pow((xmax-xmin), 2) + Math.pow((ymax-ymin), 2));

		if(this.parent.getMode() == Modes.Circle) {
			CircleView cV = new CircleView(this, this.x, this.y, distance);
			this.addView(cV);
			//this.state = new FormsPresence(); // On passe � l'�tat FormsPresence
		}
		else if(this.parent.getMode() == Modes.Rectangle) {
			RectangleView rV = new RectangleView(this, xmin, ymin, xmax-xmin,ymax-ymin);
			this.addView(rV);
			//this.state = new FormsPresence(); // On passe � l'�tat FormsPresence
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
	
	public void removeRect(Graphics g, int x, int y, int width, int height) {
		if(this.parent.getMode() == Modes.Remove)
			this.state.removeRect(g, x, y, width, height);
	}
}
