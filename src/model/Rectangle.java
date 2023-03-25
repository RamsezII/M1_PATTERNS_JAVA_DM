package model;

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

	public void setHeight(int height) {
		this.height = height;
		fireChange();
	}
	
	public void setWidth(int width) {
		this.width = width;
		fireChange();
	}
}