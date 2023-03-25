package model;

import util.listenable.AbstractListenableModel;
import util.listener.FormListener;

public abstract class Form extends AbstractListenableModel implements FormListener {
	private Point origin;
	private int x;
	private int y;
	private boolean alive;
	
	public Form(int x, int y){
		this.origin = new Point(x, y);
		this.x = x;
		this.y = y;
		this.alive = true;
	}


	public boolean isAlive()
	{
		return alive;
	}

	protected void setAlive(boolean alive)
	{
		this.alive = alive;
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
