package model;

import view.CircleView;
import view.RectangleView;

/**
 * This class represents a circle from the point of view of the model.
 */
public class Circle extends Form{
    private int radius;
    
    /**
     * The constructor of this class. Creates a circle with coordinates and radius.
     * @param x
     * @param y
     * @param r
     */
    public Circle(int x, int y, int r){
        super(x, y);
        this.radius = r;
    }

    /**
     * This method clones the circle.
     */
    public Object clone(){
        Circle cloned = new Circle(getX(), getY(), getRadius());
        return cloned;
    }
    
    // Getters
    
    public int getRadius(){
        return this.radius;
    }

    // Setters
    
	public void setRadius(int r){
        this.radius = r;
		fireChange();
	}

	/**
	 * This method sets the circle to "not alive" when it is updated.
	 */
    @Override
    public void updateForm(Object form) {

        boolean isAlive = ((CircleView) form).isToDestroy() == false;
        System.out.println("new x " + ((CircleView) form).getX() + " y " + ((CircleView) form).getY());
        setXY(((CircleView) form).getX(), ((CircleView) form).getY());
        radius = ((CircleView) form).getRadius();

        setAlive(isAlive);
    }
}
