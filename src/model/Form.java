package model;

import util.listenable.AbstractListenableModel;

public abstract class Form extends AbstractListenableModel{
	private Point origin;
	private int x;
	private int y;
	
	public Form(int x, int y){
		this.origin = new Point(x, y);
		this.x = x;
		this.y = y;
	}

	/* ------Getters------*/
	public Point getOrigin(){
		return origin;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	/* ------Methods------*/
	public void move(float vx, float vy){
		origin.setX(origin.getX() + vx);
		origin.setY(origin.getY() + vy);
		fireChange();
	}
}
