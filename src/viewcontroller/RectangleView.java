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
	private boolean deleted;
	
	public RectangleView(FormsPanel drawingPanel, int posX, int posY, int height, int width) {
		this.drawingPanel = drawingPanel;
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
		this.deleted = false;
	}
	
	@Override
	public void paint(Graphics g) {
		if(!this.deleted) {

		Rectangle newRectangle = new Rectangle(this.posX, this.posY, this.height, this.width); 
		g.drawRect(newRectangle.getX(), newRectangle.getY(), newRectangle.getHeight(), newRectangle.getWidth());
		g.fillRect(newRectangle.getX(), newRectangle.getY(), newRectangle.getHeight(), newRectangle.getWidth());
		}
	}

	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.height;
	}
	
	public void setDeleted(boolean b) {
		this.deleted = b;
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
