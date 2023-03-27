package model;

import java.util.ArrayList;

/**
 * This class represents a form container.
 */
public class ContainerForms {
    private ArrayList<Form> listForms;

    public ContainerForms(){
        this.listForms = new ArrayList<>();
    }

    //Getters 
    
    public ArrayList<Form> getListForms(){
        return this.listForms;
    }
    
    // Setters
    
    public void setListForms(ArrayList<Form> l){
        this.listForms = l;
    }
    
    // Methods
    
    public void log(String name){
        System.out.println(name + " nb Forms " + this.listForms.size());
        for(Form f : this.listForms){
            System.out.println("x " + f.getX() + " y " + f.getY());
        }
    }

    public ContainerForms clone(){
        ArrayList<Form> clonedList = new ArrayList<>();
        for(Form f : this.listForms){
            clonedList.add((Form) f.clone());
        }
        ContainerForms cloned = new ContainerForms();
        cloned.setListForms(clonedList);

        return cloned;
    }
}
