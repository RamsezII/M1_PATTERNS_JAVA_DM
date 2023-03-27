package model;

import util.listener.FormListener;

/**
 * This abstract class represents a form and its settings.
 */
public abstract class Form {
	private int x;
	private int y;
	private boolean alive;
	private FormListener listener;
	
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

	public void setListener(FormListener listener)
	{
		this.listener = listener;
	}

	protected void fireChange()
	{
		if(listener != null)
			listener.updatedForm(this);
	}

	protected void fireBackupMemento()
	{
		if(listener != null)
			listener.backupMemento(this);
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


	public abstract void delete();
	public abstract void move(int shiftX, int shiftY);
	public abstract void resize(int newX, int newY);

	/**
	 * This method updates the form when it moved.
	 * @param x
	 * @param y
	 */
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
}
