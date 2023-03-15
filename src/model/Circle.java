package model;


public class Circle extends Form{
    private int radius;
    
    public Circle(int x, int y, int r){
        super(x, y);
        this.radius = r;
    }
    
    /* ------Getters------*/
    public int getRadius(){
        return this.radius;
    }

    /* ------Setters------*/
	public void setRadius(int r){
        this.radius = r;
		fireChange();
	}
}
