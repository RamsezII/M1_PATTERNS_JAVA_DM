package viewcontroller;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.Rectangle;
import util.listener.ModelListener;

public class RectangleView implements FormsView, ModelListener, MouseListener{
	private FormsPanel drawingPanel;
	private int posX;
	private int posY;
	private int height;
	private int width;
	
	public RectangleView(FormsPanel drawingPanel, int posX, int posY, int height, int width) {
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

	@Override
	public void updatedModel(Object source) {
		System.out.println("La forme est supprimée");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Suppression
		this.drawingPanel.removeRect(this.drawingPanel.getGraphics(), this.posX, this.posY, this.height, this.width);
		this.updatedModel(this);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
