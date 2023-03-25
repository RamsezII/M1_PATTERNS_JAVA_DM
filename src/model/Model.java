package model;

import command.Memento;
import util.listener.ModelListener;

import java.util.ArrayList;

public class Model {
    ModelListener listener;

    private Memento memento;
    private ContainerForms containers;

    public Model()
    {
        listener = null;
        memento = new Memento();
        containers = new ContainerForms();
    }

    public void setListener(ModelListener list)
    {
        listener = list;
    }

    public ContainerForms getContainerForms()
    {
        return containers;
    }

    public void createCircle(int x, int y, int radius)
    {
        containers.getListForms().add(new Circle(x, y, radius));
        memento.backup(containers);
        notifyView();
    }

    public void createRectangle(int x, int y, int w, int h)
    {
        containers.getListForms().add(new Rectangle(x, y, w, h));
        memento.backup(containers);
        notifyView();
    }

    public void deleteForm()
    {
        ArrayList<Form> list = new ArrayList<>();
        for(Form fm : containers.getListForms())
        {
            if(fm.isAlive() == false)
                list.add(fm);
        }
        if(list.size() > 0)
        {
            memento.backup(containers);
            containers.getListForms().removeAll(list);
        }

        notifyView();
    }

    public void undo()
    {
        ContainerForms newContainer = memento.undo(containers);
        if(newContainer != null)
        {
            //System.out.println("undo");
            //containers.log("Before");
            containers = newContainer;
            //containers.log("After");
            //System.out.println(" ");
            notifyView();
        }
    }

    public void redo()
    {
        ContainerForms newContainer = memento.redo(containers);
        if(newContainer != null)
        {
            //System.out.println("redo");
            //containers.log("Before");
            containers = newContainer;
            //containers.log("After");
            //System.out.println(" ");
            notifyView();
        }
    }

    public void notifyView()
    {
        if(listener != null)
            listener.updatedModel(this);
    }
}

