package view;

import java.awt.Graphics;

import model.Form;
import model.Rectangle;
import util.listener.FormListener;

/**
 * This class represents a view for a rectangle form.
 */
public class RectangleView implements FormsView{
	private int posX;
	private int posY;
	private Form associatedForm;
	private int height;
	private int width;
	
	/**
	 * The constructor of the view. Takes dimensions and listener on a form.
	 * 
	 * @param posX
	 * @param posY
	 * @param width
	 * @param height
	 * @param associatedForm
	 */
	public RectangleView(int posX, int posY, int width, int height, Form associatedForm) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.associatedForm = associatedForm;
	}
	
	//Getters

	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * This method allows the drawing of a rectangle on a component, here a JPanel.
	 */
	@Override
	public void paint(Graphics g) {
		Rectangle newRectangle = new Rectangle(this.posX, this.posY, this.width, this.height); // Creates the model's view
		g.drawRect(newRectangle.getX(), newRectangle.getY(), newRectangle.getWidth(), newRectangle.getHeight()); // Draws the rectangle
		g.fillRect(newRectangle.getX(), newRectangle.getY(), newRectangle.getWidth(), newRectangle.getHeight()); // Fills the rectangle
	}



	@Override
	public Form getAssociatedForm() {
		return associatedForm;
	}
}
