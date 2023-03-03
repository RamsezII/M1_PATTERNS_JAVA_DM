package model;

import util.listenable.AbstractListenableModel;

public abstract class Form extends AbstractListenableModel{
	private Point origin;

	public Form(float x, float y){
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
		fireChange();
	}
}
