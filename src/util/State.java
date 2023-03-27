package util;

import model.Form;
import model.Model;
import view.FormsView;

/**
 * This interface represents a state, with a behavior for removing.
 */
public interface State {
	public void remove(Form fV, Model m);
}
