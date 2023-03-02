package model;

import java.util.ArrayList;

import util.AbstractListenableModel;
import util.ModelListener;

public class ContainerForms extends AbstractListenableModel implements ModelListener{
    public ArrayList<Forms> listForms;
    
    
    public ContainerForms(){
        this.listForms = new ArrayList<>();
    }
    

    /* ------Methods for Form------*/
    public void addForm(Forms f){
        listForms.add(f);
        f.addListener(this);

        //fire changement
    }
    
    public void deleteForm(Forms f){
        listForms.remove(f);
        f.removeListener(this);

        //fire changement
    }
    
    public void updatedModel(Object source){
        //Doit prevenir tout ceux qui l'ecoute que la liste a changer
    }

}
