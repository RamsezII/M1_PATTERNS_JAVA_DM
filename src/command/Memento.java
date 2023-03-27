package command;

import model.ContainerForms;

import java.util.ArrayList;

/**
 * This class represents the Memento pattern.
 * It allows us to store each state of the game
 */
public class Memento {

    //undoContainers is a list holding the X previous State of the game, it used when we want to undo changes and go back to previous states
    private ArrayList<ContainerForms> undoContainers;
    //redoContainers is a list holding the X State that have undid, it used when we want to re apply the change we undid
    private ArrayList<ContainerForms> redoContainers;

    /**
     * This Constructor initializes two lists : an Undo list and a redo list
     */
    public Memento(){
        this.undoContainers = new ArrayList<>();
        this.redoContainers = new ArrayList<>();
    }

    /**
     * This backup function makes a deep copy of the State given in argument (which in our case, is always the current State before modifying it)
     * The deepCopy with clone() is important, as in Java, objects are passed by reference, and in this base we don't want to hold reference in our list (that can be modified elsewhere in the code), but copies.
     * Also if a backup is made and the redo list is not empty, we clear it because when new changes are made that not undo(s), we have a to clear it. Why ? Because redo list is just to undo the undo(s).
     * @param currentState Is the current state of the game
     */
    public void backup(ContainerForms currentState){
        this.undoContainers.add(currentState.clone());
        
        if(this.redoContainers.size() > 0)
            this.redoContainers.clear();
    }

    /**
     * This function undo change : it store the current State into the redo list, pop the last State from the undo list, and return the new State which has been popped from the undo list
     * @param currentState the current State of the game, which we put into the redo list
     * @return the new State we want to apply to our Model
     */
    public ContainerForms undo(ContainerForms currentState){
        if(this.undoContainers.size() > 0){
            ContainerForms lastInserted = this.undoContainers.get(this.undoContainers.size()-1);

            this.undoContainers.remove(undoContainers.size()-1);
            this.redoContainers.add(0, currentState);

            return lastInserted;
        }
        return null;
    }

    /**
     * This function redo change made after an undo : it store the current State into the undo list, pop the first State from the redo list, and return the new State which has been popped from the redo list
     * @param currentState the current State of the game, which we put into the undo list
     * @return the new State we want to apply to our Model
     */
    public ContainerForms redo(ContainerForms currentState){
        if(this.redoContainers.size() > 0){
            ContainerForms lastInserted = redoContainers.get(0);
            
            redoContainers.remove(0);
            undoContainers.add(currentState);
            
            return lastInserted;
        }
        return null;
    }
}
