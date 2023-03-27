package model;

import view.CircleView;

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
	}


    /**
     * This method informs the form is has been deleted
     */
    public void delete(){
        fireBackupMemento();
        setAlive(false);
        fireChange();
    }

    /**
     * Function that move a FormView, and then notify the form from our model of a change
     * @param shiftX (ReleaseClickPosition - PressClickPosition).x
     * @param shiftY (ReleaseClickPosition - PressClickPosition).y
     */
    public void move(int shiftX, int shiftY){

        fireBackupMemento();
        setXY( getX() + shiftX, getY()+shiftY );
        fireChange();
    }

    /**
     * Function that resize a FormView, and then notify the form from our model of a change
     * @param newX
     * @param newY
     */
    public void resize(int newX, int newY) {

        fireBackupMemento();
        int shiftX = newX - getX();
        int shiftY = newY - getY();
        radius = (int) Math.sqrt( shiftX*shiftX + shiftY*shiftY );
        fireChange();
    }
}
