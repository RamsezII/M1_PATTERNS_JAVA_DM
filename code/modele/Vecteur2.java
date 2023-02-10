package code.modele;

public class Vecteur2
{
    public float x, y;

    //----------------------------------------------------------------------------------------------------------

    public void diviser(float facteur)
    {
        x /= facteur;
        y /= facteur;
    }

    public void multiplier(float facteur)
    {
        x *= facteur;
        y *= facteur;
    }

    public void additioner(Vecteur2 autre)
    {
        x += autre.x;
        y += autre.y;
    }

    public void soustraire(Vecteur2 autre)
    {
        x -= autre.x;
        y -= autre.y;
    }
}
