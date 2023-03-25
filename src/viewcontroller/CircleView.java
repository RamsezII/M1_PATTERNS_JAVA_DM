package viewcontroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.Circle;
import util.listener.FormListener;
import util.listener.ModelListener;

public class CircleView implements FormsView, MouseListener{
	private FormsPanel drawingPanel;
	private int posX;
	private int posY;
	private int radius;
	private FormListener formListener;
	
	public CircleView(FormsPanel drawingPanel, int posX, int posY, int radius, FormListener formListener) {
		this.drawingPanel = drawingPanel;
		this.posX = posX;
		this.posY = posY;
		this.radius = radius;
		this.formListener = formListener;
	}
	
	@Override
	public void paint(Graphics g) {
		//if(!this.deleted)
		{
			Circle newCircle = new Circle(this.posX, this.posY, this.radius); 
			g.fillOval(newCircle.getX()-(newCircle.getRadius()), newCircle.getY()-(newCircle.getRadius()), newCircle.getRadius()*2, newCircle.getRadius()*2);
		}
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public int getRadius() {
		return this.radius;
	}

	public void delete()
	{
		if(formListener != null)
		formListener.updateForm(this);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// Suppression
		//this.drawingPanel.removeCircle(this.drawingPanel.getGraphics(), this.posX, this.posY, this.radius);
		//this.updatedModel(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
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