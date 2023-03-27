package view;

import java.awt.Graphics;

/**
 * A interface for the paint method of forms.
 */
public interface FormsView {
	public void paint(Graphics g);
	public void delete();
	public void move(int shiftX, int shiftY);
}
