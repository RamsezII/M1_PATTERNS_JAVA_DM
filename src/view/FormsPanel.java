package view;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Circle;
import model.Form;
import model.Model;
import model.Rectangle;
import util.FormsPresence;
import util.NoFormsPresence;
import util.State;
import util.listener.ModelListener;

/**
 * This class represents the drawing panel view in the window.
 */
public class FormsPanel extends JPanel implements MouseListener, ModelListener{
	private ArrayList<FormsView> viewsList;
	//
	private int x;
	private int y;
	private FormsView selectedFormOnPress;
	//

	private Window parent;
	private Model refModel;

	/**
	 * The constructor of the view. Takes a reference on the main window and model.
	 * @param parent
	 * @param model
	 */
	public FormsPanel(Window parent, Model model) {
		this.viewsList = new ArrayList<FormsView>();
		this.addMouseListener(this);
		this.parent = parent;
		this.x = 0;
		this.y = 0;
		this.refModel = model;
		refModel.setListener(this);
		selectedFormOnPress = null;
	}
	
	/**
	 * This method updates the view of this panel.
	 */
	@Override
	public void updatedModel(Object source) {
		this.viewsList.clear();
		
		for(int i = 0; i < refModel.getContainerForms().getListForms().size(); i++){
			Form mForm = refModel.getContainerForms().getListForms().get(i);
			if(mForm instanceof Rectangle){
				Rectangle mRect = (Rectangle)mForm;
				RectangleView rV = new RectangleView(mRect.getX(), mRect.getY(), mRect.getWidth(),mRect.getHeight(), mRect);
				this.addView(rV);
			}
			if(mForm instanceof Circle){
				Circle mCirc = (Circle)mForm;
				CircleView rV = new CircleView(mCirc.getX(), mCirc.getY(), mCirc.getRadius(), mCirc);
				this.addView(rV);
			}
		}
		this.revalidate();
		this.repaint();
		this.parent.revalidate();
		this.parent.repaint();
	}
	
	/**
	 * This method asks to the different views to update themselves.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		for(FormsView v : this.viewsList) {
			v.paint(g);
		}
	}
	
	/**
	 * This method adds a view to the views' list.
	 * @param view
	 */
	public void addView(FormsView view) {
		this.viewsList.add(view);
	}

	private FormsView getCollisionWithView(int mouseX, int mouseY)
	{
		for (int i = viewsList.size()-1; i >= 0; i--) {
			FormsView fV = viewsList.get(i);
			if (fV instanceof RectangleView) {
				RectangleView rV = (RectangleView) fV;
				boolean collision = true;

				if (rV.getX() > mouseX || rV.getY() > mouseY ||
						(rV.getWidth() + rV.getX()) < mouseX || (rV.getHeight() + rV.getY()) < mouseY)
					collision = false;

				if (collision)
					return fV;
			}
			if (fV instanceof CircleView) {
				CircleView rV = (CircleView) fV;
				double distPtrCentre = Math.sqrt(Math.pow(mouseX - rV.getX(), 2) + Math.pow(mouseY - rV.getY(), 2));
				boolean collision = distPtrCentre < rV.getRadius();

				if (collision)
					return fV;
			}
		}

		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.parent.getMode() == Modes.Remove) {
			FormsView formSelectionnee = getCollisionWithView(e.getX(), e.getY());

			if(formSelectionnee != null)
			{
				formSelectionnee.delete();
				refModel.updateFormsFromController();
			}
		}
	}
		
	/**
	 * This method saves the initial point of the mouse pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();

		if(parent.getMode() == Modes.Move || parent.getMode() == Modes.Resize) {
			FormsView formSelectionnee = getCollisionWithView(e.getX(), e.getY());
			selectedFormOnPress = formSelectionnee;//even if formSelectionnee is null
		}
	}

	/**
	 * This method creates forms according to the mode.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		int xmin = Math.min(e.getX(), this.x);
		int ymin = Math.min(e.getY(), this.y);
		int xmax = Math.max(e.getX(), this.x);
		int ymax = Math.max(e.getY(), this.y);

		int distance = (int) Math.sqrt(Math.pow((xmax-xmin), 2) + Math.pow((ymax-ymin), 2));

		if(this.parent.getMode() == Modes.Circle) {
			refModel.createCircle(this.x, this.y, distance);
		}
		else if(this.parent.getMode() == Modes.Rectangle) {
			refModel.createRectangle(xmin, ymin, xmax-xmin,ymax-ymin);
		}
		else if(parent.getMode() == Modes.Move || parent.getMode() == Modes.Resize) {
			if(selectedFormOnPress != null)
			{
				refModel.backupBeforeChange();
				if(parent.getMode() == Modes.Move)
					selectedFormOnPress.move(e.getX() - x, e.getY() - y);
				if(parent.getMode() == Modes.Resize)
					selectedFormOnPress.resize(e.getX(), e.getY());
				refModel.updateFormsFromController();
			}
		}

		selectedFormOnPress = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
