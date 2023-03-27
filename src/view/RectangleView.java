package view;

import java.awt.Graphics;
import model.Rectangle;
import util.listener.FormListener;

/**
 * This class represents a view for a rectangle form.
 */
public class RectangleView implements FormsView{
	private int posX;
	private int posY;
	private FormListener formListener;
	private boolean toDestroy;
	private int height;
	private int width;
	
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
	 * This method informs the form it has been deleted
	 */
	@Override
	public void delete(){
		toDestroy = true;
		if(formListener != null)
			formListener.updateForm(this);
	}
	/**
	 * Function that move a FormView, and then notify the form from our model of a change
	 * @param shiftX (ReleaseClickPosition - PressClickPosition).x
	 * @param shiftY (ReleaseClickPosition - PressClickPosition).y
	 */
	@Override
	public void move(int shiftX, int shiftY){
		posX += shiftX;
		posY += shiftY;

		if(formListener != null)
			formListener.updateForm(this);
	}

	/**
	 * Function that resize a FormView, and then notify the form from our model of a change
	 * @param newX
	 * @param newY
	 */
	@Override
	public void resize(int newX, int newY) {

		int shiftX = newX - posX;
		int shiftY = newY - posY;

		double newRadius = (double) Math.sqrt( shiftX*shiftX + shiftY*shiftY );
		double currRadius = (double) Math.sqrt( width*width + height*height );

		if(currRadius > 0)
		{
			//we compute the new scale from the current radius and the new one
			double scale = newRadius / currRadius;

			//we compute the new W and H
			int newWidth = (int) ( (double)scale * width);
			int newHeight = (int) ( (double)scale * height);

			//we recenter around the new W and H
			posX += width/2 - newWidth/2.f;
			posY += height/2 - newHeight/2.f;

			//we apply the new W and H
			width = newWidth;
			height = newHeight;
		}


		if(formListener != null)
			formListener.updateForm(this);
	}
}
