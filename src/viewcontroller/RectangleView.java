package viewcontroller;

import java.awt.Graphics;

import javax.swing.JPanel;

public class RectangleView implements FormsView{
	private JPanel drawingPanel;
	
	public RectangleView(JPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}
	
	@Override
	public void paint(Graphics g) {
		this.drawingPanel.paintComponents(g);
	}

}
