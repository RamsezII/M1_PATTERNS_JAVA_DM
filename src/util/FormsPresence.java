package util;

import java.awt.Color;
import java.awt.Graphics;

import model.Model;
import view.FormsView;

public class FormsPresence implements State{	
	public FormsPresence() {}

	@Override
	public void remove(FormsView fV, Model m) {
		fV.delete();
		m.deleteForm();
	}
}
