package util;

import model.Form;
import model.Model;
import view.FormsView;

/**
 * This class represents a presence of forms in the drawing panel, and authorized methods.
 */
public class FormsPresence implements State{	//to remove
	public FormsPresence() {}

	/**
	 * This method calls the removing of a form.
	 */
	@Override
	public void remove(Form fV, Model m) {
		fV.delete();
	}
}
