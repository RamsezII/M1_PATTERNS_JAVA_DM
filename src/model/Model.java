package model;

import command.Memento;
import util.listener.ModelListener;

import java.util.ArrayList;

/**
 * This class represents the actions'functions of the software.
 */
public class Model {
    private ModelListener listener;
    private Memento memento;
    private ContainerForms containers;

    /**
     * The constructor of this class.
     */
    public Model(){
        this.listener = null;
        this.memento = new Memento();
        this.containers = new ContainerForms();
    }

    // Getter
    
    public ContainerForms getContainerForms(){
        return this.containers;
    }
    
    // Setters
    
    public void setListener(ModelListener list){
    	this.listener = list;
    }

   // Methods 

    public void createCircle(int x, int y, int radius){
        this.containers.getListForms().add(new Circle(x, y, radius));
        this.memento.backup(this.containers);
        notifyView();
    }

    public void createRectangle(int x, int y, int w, int h){
        this.containers.getListForms().add(new Rectangle(x, y, w, h));
        this.memento.backup(this.containers);
        notifyView();
    }

    public void deleteForm(){
        ArrayList<Form> list = new ArrayList<>();
        for(Form fm : this.containers.getListForms()){
            if(fm.isAlive() == false)
                list.add(fm);
        }
        if(list.size() > 0){
            this.memento.backup(this.containers);
            this.containers.getListForms().removeAll(list);
        }

        notifyView();
    }

    public void undo(){
        ContainerForms newContainer = this.memento.undo(this.containers);
        if(newContainer != null){
            this.containers = newContainer;
            notifyView();
        }
    }

    public void redo(){
        ContainerForms newContainer = memento.redo(this.containers);
        if(newContainer != null){
            this.containers = newContainer;
            notifyView();
        }
    }

    public void notifyView(){
        if(listener != null)
            this.listener.updatedModel(this);
    }
}

