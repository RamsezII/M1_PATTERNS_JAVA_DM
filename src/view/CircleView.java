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
	
	/**
	 * The constructor of the view. Takes dimensions and listener on a form.
	 * 
	 * @param posX
	 * @param posY
	 * @param width
	 * @param height
	 * @param formListener
	 */
	public CircleView(int posX, int posY, int radius, FormListener formListener) {
		this.posX = posX;
		this.posY = posY;
		this.radius = radius;
		this.formListener = formListener;
	}
	
	// Getters
	
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
		if(formListener != null)
			formListener.updateForm(this);
	}
}
