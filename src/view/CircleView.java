package view;

import java.awt.Graphics;
import model.Circle;
import model.Form;
import util.listener.FormListener;

/**
 * This class represents a view for a circle form.
 */
public class CircleView implements FormsView{
	private int posX;
	private int posY;
	private Form formAssociated;
	private int radius;

	
	/**
	 * The constructor of the view. Takes dimensions and listener on a form.
	 * 
	 * @param posX
	 * @param posY
	 * @param radius
	 * @param formAssociated
	 */
	public CircleView(int posX, int posY, int radius, Form formAssociated) {
		this.posX = posX;
		this.posY = posY;
		this.radius = radius;
		this.formAssociated = formAssociated;
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
	



	public Form getAssociatedForm()
	{
		return formAssociated;
	}

}
