package util;

import model.Model;
import view.FormsView;

/**
 * This class represents a presence of forms in the drawing panel, and authorized methods.
 */
public class FormsPresence implements State{	
	public FormsPresence() {}

	/**
	 * This method calls the removing of a form.
	 */
	@Override
	public void remove(FormsView fV, Model m) {
		fV.delete();
		m.deleteForm();
	}
}
