package util.listenable;

import java.util.ArrayList;

import util.listener.ModelListener;

public abstract class AbstractListenableModel implements ListenableModel{
	protected ArrayList<ModelListener> listeners = new ArrayList<ModelListener>();
	
	public void addListener(ModelListener e) {
		listeners.add(e);
	}
	
	public void removeListener(ModelListener e) {
		listeners.remove(e);
	}
	
	protected void fireChange() {
		for(ModelListener e : listeners) {
			e.updatedModel(this);
		}
	}
}
