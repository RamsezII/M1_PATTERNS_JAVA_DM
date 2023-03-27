package view;

import java.awt.Graphics;
import model.Rectangle;
import util.listener.FormListener;

/**
 * This class represents a view for a rectangle form.
 */
public class RectangleView implements FormsView{
	private FormListener formListener;
	private int posX;
	private int posY;
	private int height;
	private int width;
	private boolean toDestroy;
	
	/**
	 * The constructor of the view. Takes dimensions and listener on a form.
	 * 
	 * @param posX
	 * @param posY
	 * @param width
	 * @param height
	 * @param formListener
	 */
	public RectangleView(int posX, int posY, int width, int height, FormListener formListener) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.formListener = formListener;
		toDestroy = false;
	}
	
	//Getters

	public boolean isToDestroy() { return toDestroy; }

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
