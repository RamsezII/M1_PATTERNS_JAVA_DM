package model;

public abstract class Forms {
	private Point origin;

	public Forms(float x, float y){
		this.origin = new Point(x, y);
	}

	/* ------Getters------*/
	public Point getOrigin(){
		return origin;
	}

	/* ------Methods------*/
	public void move(float vx, float vy){
		origin.setX(origin.getX() + vx);
		origin.setY(origin.getY() + vy);


		//fire changement
	}

	public void draw() {
		
	}
}
