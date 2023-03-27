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
        listener = null;
        memento = new Memento();
        containers = new ContainerForms();
    }

    // Getter
    
    public ContainerForms getContainerForms(){
        return containers;
    }
    
    // Setters
    
    public void setListener(ModelListener list){
    	this.listener = list;
    }

   // Methods 

    /**
     * A function that add a circle to our containers, after it has been backup(containers) and notifity the view
     * @param x center of our circle x
     * @param y center of our cicle y
     * @param radius radius of our circle
     */
    public void createCircle(int x, int y, int radius){
        memento.backup(this.containers);
        containers.getListForms().add(new Circle(x, y, radius));
        notifyView();
    }

    /**
     * A function that add a rectangle to our containers, after it has been backup(containers) and notifity the view
     * @param x origin x
     * @param y origin y
     * @param w witdh
     * @param h height
     */
    public void createRectangle(int x, int y, int w, int h){
        memento.backup(this.containers);
        containers.getListForms().add(new Rectangle(x, y, w, h));
        notifyView();
    }

    /**
     * Delete all form which are not alive anymore and notify the view of a change
     */
    public void deleteForm(){
        ArrayList<Form> list = new ArrayList<>();
        for(Form fm : containers.getListForms()){
            if(fm.isAlive() == false)
                list.add(fm);
        }
        if(list.size() > 0){
            memento.backup(containers);
            containers.getListForms().removeAll(list);
        }

        notifyView();
    }

    /**
     * Undo change, and notifiy the View
     */
    public void undo(){
        ContainerForms newContainer = this.memento.undo(this.containers);
        if(newContainer != null){
            containers = newContainer;
            notifyView();
        }
    }
    /**
     * Redo change that has been undid, and notifiy the View
     */
    public void redo(){
        ContainerForms newContainer = memento.redo(containers);
        if(newContainer != null){
            containers = newContainer;
            notifyView();
        }
    }


    /**
     * Notify the view, so it can repaint all the forms
     */
    public void notifyView(){
        if(listener != null)
            listener.updatedModel(this);
    }
}

