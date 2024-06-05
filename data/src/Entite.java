public abstract class Entite extends Position{

    //Permet de deplacer l'entite
    public abstract void seDeplacer();

    //Permet d'attaquer une autre Entite victime
    public abstract void attaquer(Entite victime);

    //Subir les dégats, retourne le contrecoup
    public abstract void subirDegat(int degat);

    //Renvoie si l'Entite est morte (pv = 0)
    public abstract boolean etreMort();

}
