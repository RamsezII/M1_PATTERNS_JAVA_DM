package model;

import util.listenable.AbstractListenableModel;
import util.listener.FormListener;

public abstract class Form extends AbstractListenableModel implements FormListener {
	private int x;
	private int y;
	private boolean alive;
	
	public Form(int x, int y){
		this.x = x;
		this.y = y;
		this.alive = true;
	}

	public abstract Object clone();


	public boolean isAlive()
	{
		return alive;
	}

	protected void setAlive(boolean alive)
	{
		this.alive = alive;
	}


	/* ------Getters------*/
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	/* ------Methods------*/
	public void move(float vx, float vy){
		x += vx;
		y += vy;
		fireChange();
	}
}
