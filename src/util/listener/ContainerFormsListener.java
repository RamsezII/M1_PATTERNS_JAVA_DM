package util.listener;

import model.Forms;

public interface ContainerFormsListener {
    public void addedForm(Forms f);
    public void deletedForm(Forms f);
    public void modifiedForm(Forms f);
}
