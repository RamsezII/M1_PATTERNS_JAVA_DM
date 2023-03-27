package view;

import model.Form;

import java.awt.Graphics;

/**
 * A interface for the paint method of forms.
 */
public interface FormsView {
	public void paint(Graphics g);

	public Form getAssociatedForm();
}
