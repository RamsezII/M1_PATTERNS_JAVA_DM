package util;

import java.awt.Color;
import java.awt.Graphics;

public class FormsPresence implements State{	
	public FormsPresence() {}

	@Override
	public void removeRect(Graphics g, int x, int y, int height, int width) {
		g.fillRect(x, y, height, width);
	}

	@Override
	public void removeCircle(Graphics g, int x, int y, int radius) {
		g.setColor(Color.WHITE);
		g.fillOval(x-(radius/2), y-(radius/2), radius, radius);
	}
}
