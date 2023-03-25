package model;

import java.util.ArrayList;

public class ContainerForms {
    private ArrayList<Form> listForms;
    //protected ArrayList<ContainerFormsListener> listeners = new ArrayList<ContainerFormsListener>();


    public ContainerForms(){
        listForms = new ArrayList<>();
    }

    public void log(String name)
    {
        System.out.println(name + " nb Forms " + listForms.size());
        for(Form f : listForms)
        {
            System.out.println("x " + f.getX() + " y " + f.getY());
        }
    }

    public ContainerForms clone()
    {
        ArrayList<Form> clonedList = new ArrayList<>();

        for(Form f : listForms)
        {
            clonedList.add((Form) f.clone());
        }

        ContainerForms cloned = new ContainerForms();

        cloned.listForms = clonedList;

        return cloned;
    }

    public ArrayList<Form>  getListForms()
    {
        return listForms;
    }
}
