package util;

import model.Model;
import view.FormsView;

public class NoFormsPresence implements State{
	public NoFormsPresence() {}

	@Override
	public void remove(FormsView fv, Model m) {}
	
}
