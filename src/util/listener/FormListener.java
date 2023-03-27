package util.listener;

/**
 * This interface declares a method when a form is updating.
 */
public interface FormListener {
    public void backupMemento(Object form);
    public void updatedForm(Object form);
}
