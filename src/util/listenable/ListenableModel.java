package util.listenable;

import util.listener.ModelListener;

public interface ListenableModel {
	public void addListener(ModelListener e);
	public void removeListener(ModelListener e);
}