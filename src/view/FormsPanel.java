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
	private int xOnPress;
	private int yOnPress;
	private Form selectedFormOnPress;
	private State state;
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
		this.xOnPress = 0;
		this.yOnPress = 0;
		this.refModel = model;
		refModel.setListener(this);
		selectedFormOnPress = null;
		this.state = new NoFormsPresence();
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

	private Form getFormFromCollisionWithView(int mouseX, int mouseY)
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
					return fV.getAssociatedForm();
			}
			if (fV instanceof CircleView) {
				CircleView rV = (CircleView) fV;
				double distPtrCentre = Math.sqrt(Math.pow(mouseX - rV.getX(), 2) + Math.pow(mouseY - rV.getY(), 2));
				boolean collision = distPtrCentre < rV.getRadius();

				if (collision)
					return fV.getAssociatedForm();
			}
		}

		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.parent.getMode() == Modes.Remove && this.state instanceof FormsPresence) {
			Form formSelectionnee = getFormFromCollisionWithView(e.getX(), e.getY());

			if(formSelectionnee != null){
				this.state.remove(formSelectionnee, refModel);
				if(refModel.getContainerForms().getListForms().size() == 0)
					this.state = new NoFormsPresence();
			}
		}
	}
		
	/**
	 * This method saves the initial point of the mouse pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		this.xOnPress = e.getX();
		this.yOnPress = e.getY();

		if(parent.getMode() == Modes.Move || parent.getMode() == Modes.Resize) {
			Form formSelectionnee = getFormFromCollisionWithView(e.getX(), e.getY());
			selectedFormOnPress = formSelectionnee;//even if formSelectionnee is null
		}
	}

	/**
	 * This method creates forms according to the mode.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		int xmin = Math.min(e.getX(), this.xOnPress);
		int ymin = Math.min(e.getY(), this.yOnPress);
		int xmax = Math.max(e.getX(), this.xOnPress);
		int ymax = Math.max(e.getY(), this.yOnPress);

		int distance = (int) Math.sqrt(Math.pow((xmax-xmin), 2) + Math.pow((ymax-ymin), 2));

		if(this.parent.getMode() == Modes.Circle) {
			refModel.createCircle(this.xOnPress, this.yOnPress, distance);
			this.state = new FormsPresence();
		}
		else if(this.parent.getMode() == Modes.Rectangle) {
			refModel.createRectangle(xmin, ymin, xmax-xmin,ymax-ymin);
			this.state = new FormsPresence();
		}
		else if(parent.getMode() == Modes.Move || parent.getMode() == Modes.Resize) {
			if(selectedFormOnPress != null)
			{
				//The controller ask for the memento to do a backup
				//refModel.backupBeforeChange();

				//The controller applies the transformation on
				if(parent.getMode() == Modes.Move)
					selectedFormOnPress.move(e.getX() - xOnPress, e.getY() - yOnPress);
				if(parent.getMode() == Modes.Resize)
					selectedFormOnPress.resize(e.getX(), e.getY());

				//The controller updates the Forms
				//refModel.updateFormsFromController();
			}
		}
		//When the mouse is released, we reset the selectFormOnPress
		selectedFormOnPress = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
