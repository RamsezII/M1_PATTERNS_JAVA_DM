package model;

import java.util.ArrayList;

import util.listener.ContainerFormsListener;
import util.listener.ModelListener;

public class ContainerForms implements ModelListener{
    public ArrayList<Form> listForms;
    protected ArrayList<ContainerFormsListener> listeners = new ArrayList<ContainerFormsListener>();

    
    
    public ContainerForms(){
        this.listForms = new ArrayList<>();
    }
    

    /* ------Methods for Form------*/
    public void addForm(Form f){
        listForms.add(f);
        f.addListener(this);
        
        for(ContainerFormsListener e : listeners) {
			e.addedForm(this);
		}
    }
    
    public void deleteForm(Form f){
        listForms.remove(f);
        f.removeListener(this);

        for(ContainerFormsListener e : listeners) {
			e.deletedForm(this);
		}
    }

    public void updatedModel(Object source) {
        for(ContainerFormsListener e : listeners){
            e.updatedModel(source);
        }    
    }
}
