package model;

public class Rectangle extends Forms{
	private float height;
	private float width;
	
	public Rectangle(float x, float y, float height, float width) {
		super(x, y);
		this.height = height;
		this.width = width;
	}
	
	/* ------Getters------*/
	public float getHeight() {
		return this.height;
	}

	public float getWidth() {
		return this.width;
	}

	/* ------Setters------*/

	public void setHeight(float height) {
		this.height = height;

		//fire changement
	}
	
	public void setWidth(float width) {
		this.width = width;
		//fire changement
	}
}