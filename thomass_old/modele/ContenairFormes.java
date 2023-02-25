package code.modele;

public class ContenairFormes 
{
    private IObservateur observateur;

    //----------------------------------------------------------------------------------------------------------

    public void init(IObservateur observateur)
    {
        this.observateur = observateur;
    }
}
