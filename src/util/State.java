package util;

import model.Model;
import view.FormsView;

/**
 * This interface represents a state, with a behavior for removing.
 */
public interface State {
	public void remove(FormsView fV, Model m);
}
