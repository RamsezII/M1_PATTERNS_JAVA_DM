package viewcontroller;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Rectangle;

public class RectangleView implements FormsView{
	private JPanel drawingPanel;
	private int posX;
	private int posY;
	private int height;
	private int width;
	
	public RectangleView(JPanel drawingPanel, int posX, int posY, int height, int width) {
		this.drawingPanel = drawingPanel;
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
	}
	
	@Override
	public void paint(Graphics g) {
		Rectangle newRectangle = new Rectangle(this.posX, this.posY, this.height, this.width); 
		g.drawRect(newRectangle.getX(), newRectangle.getY(), newRectangle.getHeight(), newRectangle.getWidth());
		g.fillRect(newRectangle.getX(), newRectangle.getY(), newRectangle.getHeight(), newRectangle.getWidth());
	}

}
