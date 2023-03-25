package util;

import model.Model;
import view.FormsView;

public interface State {
	public void remove(FormsView fV, Model m);
}
