package util;

import java.awt.Color;
import java.awt.Graphics;

public class NoFormsPresence implements State{
	public NoFormsPresence() {}

	@Override
	public void removeRect(Graphics g, int x, int y, int height, int width) {
	}

	@Override
	public void removeCircle(Graphics g, int x, int y, int radius) {
	
	}
	
}
