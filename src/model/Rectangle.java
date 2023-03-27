package model;

import view.CircleView;
import view.RectangleView;

public class Rectangle extends Form{
	private int height;
	private int width;
	
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

	public Object clone()
	{
		Rectangle cloned = new Rectangle(getX(), getY(), getWidth(), getHeight());
		return cloned;
	}

	public void setHeight(int height) {
		this.height = height;
		fireChange();
	}
	
	public void setWidth(int width) {
		this.width = width;
		fireChange();
	}

	@Override
	public void updateForm(Object form) {
		boolean isAlive = ((RectangleView) form).isToDestroy() == false;
		setXY(((RectangleView) form).getX(), ((RectangleView) form).getY());
		setAlive(isAlive);
	}
}