package model;

import java.util.ArrayList;

public class ContainerForms {
    private ArrayList<Form> listForms;
    //protected ArrayList<ContainerFormsListener> listeners = new ArrayList<ContainerFormsListener>();

    
    public ContainerForms(){
        listForms = new ArrayList<>();
    }

    public ArrayList<Form>  getListForms()
    {
        return listForms;
    }
}
