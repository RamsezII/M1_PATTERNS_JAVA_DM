package util;

import java.util.ArrayList;

public abstract class AbstractListenableModel implements ListenableModel{
	protected ArrayList<ModelListener> listeners = new ArrayList<ModelListener>();
	
	public void addListener(ModelListener e) {
		listeners.add(e);
	}
	
	public void removeListener(ModelListener e) {
		listeners.remove(e);
	}
	
	protected void change() {
		for(ModelListener e : listeners) {
		}
	}
}
