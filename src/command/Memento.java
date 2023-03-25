package command;

import model.ContainerForms;

import java.util.ArrayList;

public class Memento {
    ArrayList<ContainerForms> undoContainers;
    ArrayList<ContainerForms> redoContainers;

    public Memento()
    {
        undoContainers = new ArrayList<>();
        redoContainers = new ArrayList<>();
    }
    public void backup(ContainerForms containerForms)
    {
        undoContainers.add(containerForms.clone());

        /*int i = 0;
        for(ContainerForms f : undoContainers)
        {
            f.log("" + i );
        }
        System.out.println(" ");*/

        if(redoContainers.size() > 0)
            redoContainers.clear();
    }



    public ContainerForms undo(ContainerForms currentContainerForm)
    {
        if(undoContainers.size() > 0)
        {
            ContainerForms lastInserted = undoContainers.get(undoContainers.size()-1);

            undoContainers.remove(undoContainers.size()-1);
            redoContainers.add(0,currentContainerForm);

            return lastInserted;
        }
        return null;
    }

    public ContainerForms redo(ContainerForms currentContainerForm)
    {
        if(redoContainers.size() > 0)
        {
            ContainerForms lastInserted = redoContainers.get(0);
            redoContainers.remove(0);

            undoContainers.add(currentContainerForm);
            return lastInserted;
        }

        return null;
    }

}
