package viewcontroller;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Circle;

public class CircleView implements FormsView{
	private JPanel drawingPanel;
	private int posX;
	private int posY;
	private int radius;
	
	public CircleView(JPanel drawingPanel, int posX, int posY, int radius) {
		this.drawingPanel = drawingPanel;
		this.posX = posX;
		this.posY = posY;
		this.radius = radius;
	}
	
	@Override
	public void paint(Graphics g) {
		Circle newCircle = new Circle(this.posX, this.posY, this.radius); 
		g.fillOval(newCircle.getX()-(newCircle.getRadius()/2), newCircle.getY()-(newCircle.getRadius()/2), newCircle.getRadius(), newCircle.getRadius());
	}

}
