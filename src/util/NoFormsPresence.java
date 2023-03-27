package util;

import model.Model;
import view.FormsView;

/**
 * This class represents a presence of forms in the drawing panel, and authorized methods.
 */
public class NoFormsPresence implements State{
	public NoFormsPresence() {}

	/**
	 * This method calls the removing of a form. It doesn't do anything because there is nothing in the drawing panel.
	 */
	@Override
	public void remove(FormsView fv, Model m) {}	
}
