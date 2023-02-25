package util;

public interface ListenableModel {
	public void addListener(ModelListener e);
	public void removeListener(ModelListener e);
}
