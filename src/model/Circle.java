package model;


public class Circle extends Forms{

    
    private float rayon;
    
    public Circle(float x, float y, float r){
        super(x, y);
        this.rayon = r;
    }
    
    /* ------Getters------*/
    public float getRadius(){
        return rayon;
    }

    /* ------Setters------*/
	public void setRadius(){
		//fire changement
	}
}
