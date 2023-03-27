package model;

import view.RectangleView;

/**
 * This class represents a rectangle from the point of view of the model.
 */
public class Rectangle extends Form{
	private int height;
	private int width;
	
	/**
	 * The constructor of this class. Creates a rectangle with coordinates, width and height.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.height = height;
		this.width = width;
	}
	
	/* ------Getters------*/
	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}
	
	/* ------Setters------*/

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	// Methods

    /**
     * This method clones the circle.
     */
	public Object clone(){
		Rectangle cloned = new Rectangle(getX(), getY(), getWidth(), getHeight());
		return cloned;
	}

	/**
	 * This method informs the form it has been deleted
	 */
	public void delete(){
		fireBackupMemento();
		setAlive(false);

		fireChange();
	}
	/**
	 * Function that move a FormView, and then notify the form from our model of a change
	 * @param shiftX (ReleaseClickPosition - PressClickPosition).x
	 * @param shiftY (ReleaseClickPosition - PressClickPosition).y
	 */
	public void move(int shiftX, int shiftY){

		fireBackupMemento();
		setXY(getX()+shiftX, getY()+shiftY);
		fireChange();
	}

	/**
	 * Function that resize a FormView, and then notify the form from our model of a change
	 * @param newX
	 * @param newY
	 */
	public void resize(int newX, int newY) {

		fireBackupMemento();
		int shiftX = newX - getX();
		int shiftY = newY - getY();

		double newRadius = (double) Math.sqrt( shiftX*shiftX + shiftY*shiftY );
		double currRadius = (double) Math.sqrt( width*width + height*height );

		if(currRadius > 0)
		{
			//we compute the new scale from the current radius and the new one
			double scale = newRadius / currRadius;

			//we compute the new W and H
			int newWidth = (int) ( (double)scale * width);
			int newHeight = (int) ( (double)scale * height);

			//we re center around the new W and H
			setXY((int) (getX() + width/2 - newWidth/2.f), (int)(getY() + height/2 - newHeight/2.f) );

			//we apply the new W and H
			width = newWidth;
			height = newHeight;
		}

		fireChange();
	}
}