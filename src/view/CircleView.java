package view;

import java.awt.Graphics;
import model.Circle;
import util.listener.FormListener;

/**
 * This class represents a view for a circle form.
 */
public class CircleView implements FormsView{
	private int posX;
	private int posY;
	private int radius;
	private FormListener formListener;
	private boolean toDestroy = false;
	
	/**
	 * The constructor of the view. Takes dimensions and listener on a form.
	 * 
	 * @param posX
	 * @param posY
	 * @param radius
	 * @param formListener
	 */
	public CircleView(int posX, int posY, int radius, FormListener formListener) {
		this.posX = posX;
		this.posY = posY;
		this.radius = radius;
		this.formListener = formListener;
		this.toDestroy = false;
	}


	// Getters
	public boolean isToDestroy() { return toDestroy; }
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	/**
	 * This method allows the drawing of a rectangle on a component, here a JPanel.
	 */
	@Override
	public void paint(Graphics g) {
		Circle newCircle = new Circle(this.posX, this.posY, this.radius); 
		g.fillOval(newCircle.getX()-(newCircle.getRadius()), newCircle.getY()-(newCircle.getRadius()), newCircle.getRadius()*2, newCircle.getRadius()*2);
	}
	
	/**
	 * This method informs if the form is removed.
	 */
	@Override
	public void delete(){
		toDestroy = true;

		if(formListener != null)
			formListener.updateForm(this);
	}

	@Override
	public void move(int shiftX, int shiftY){
		posX += shiftX;
		posY += shiftY;

		if(formListener != null)
			formListener.updateForm(this);
	}
}
