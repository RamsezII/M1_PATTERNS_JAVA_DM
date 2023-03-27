package model;

import util.listenable.AbstractListenableModel;
import util.listener.FormListener;

/**
 * This abstract class represents a form and its settings.
 */
public abstract class Form extends AbstractListenableModel implements FormListener {
	private int x;
	private int y;
	private boolean alive;
	
	/**
	 * The constructor of this abstract class. Takes coordinates and a boolean "alive".
	 * @param x
	 * @param y
	 */
	public Form(int x, int y){
		this.x = x;
		this.y = y;
		this.alive = true;
	}

	// Getters
	
	public int getX() {
		return this.x;
	}
		
	public int getY() {
		return this.y;
	}
	
	// Setters 
	
	protected void setAlive(boolean alive){
		this.alive = alive;
	}
	
	// Methods
	
	public abstract Object clone();

	public boolean isAlive(){
		return alive;
	}

	/**
	 * This method updates the form when it moved.
	 * @param x
	 * @param y
	 */
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
		fireChange();//useless for now
	}
}
