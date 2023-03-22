package util;

import java.awt.Color;
import java.awt.Graphics;

public interface State {
	public void removeRect(Graphics g, int x, int y, int height, int width);
	public void removeCircle(Graphics g, int x, int y, int radius, Color bg);
}
