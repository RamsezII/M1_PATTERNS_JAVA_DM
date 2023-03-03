package model;


public class Circle extends Forms{

    
    private float radius;
    
    public Circle(float x, float y, float r){
        super(x, y);
        this.radius = r;
    }
    
    /* ------Getters------*/
    public float getRadius(){
        return this.radius;
    }

    /* ------Setters------*/
	public void setRadius(float r){
        this.radius = r;
		fireChange();
	}
}
