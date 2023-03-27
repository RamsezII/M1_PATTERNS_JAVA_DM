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
		fireChange();
	}
	
	public void setWidth(int width) {
		this.width = width;
		fireChange();
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
	 * This method sets the circle to "not alive" when it is updated.
	 */
	@Override
	public void updateForm(Object form) {
		boolean isAlive = ((RectangleView) form).isToDestroy() == false;
		setXY(((RectangleView) form).getX(), ((RectangleView) form).getY());

		width = ((RectangleView) form).getWidth();
		height = ((RectangleView) form).getHeight();

		setAlive(isAlive);
	}
}