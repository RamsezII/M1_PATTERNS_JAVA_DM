package code.modele;

public interface IObservateur 
{
    void ajouterForme(Forme forme);
    void modifierForme(Forme forme);
    void supprimerForme(Forme forme);
}
