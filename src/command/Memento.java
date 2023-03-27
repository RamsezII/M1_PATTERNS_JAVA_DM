package command;

import model.ContainerForms;

import java.util.ArrayList;

/**
 * This class represents the Memento pattern.
 */
public class Memento {
    private ArrayList<ContainerForms> undoContainers;
    private ArrayList<ContainerForms> redoContainers;

    public Memento(){
        this.undoContainers = new ArrayList<>();
        this.redoContainers = new ArrayList<>();
    }
    
    public void backup(ContainerForms containerForms){
        this.undoContainers.add(containerForms.clone());
        
        if(this.redoContainers.size() > 0)
            this.redoContainers.clear();
    }



    public ContainerForms undo(ContainerForms currentContainerForm){
        if(this.undoContainers.size() > 0){
            ContainerForms lastInserted = this.undoContainers.get(this.undoContainers.size()-1);

            this.undoContainers.remove(undoContainers.size()-1);
            this.redoContainers.add(0, currentContainerForm);

            return lastInserted;
        }
        return null;
    }

    public ContainerForms redo(ContainerForms currentContainerForm){
        if(this.redoContainers.size() > 0){
            ContainerForms lastInserted = redoContainers.get(0);
            
            redoContainers.remove(0);
            undoContainers.add(currentContainerForm);
            
            return lastInserted;
        }
        return null;
    }
}
