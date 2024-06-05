public abstract class Entite extends Position{

    public Entite(int dx, int dy){
        super(dx,dy);
    }

    //Permet de deplacer l'entite
    public void seDeplacer(int dx, int dy){
        setX(getX()+dx);
        setY(getY()+dy);
    }

    //Permet d'attaquer une autre Entite victime
    public abstract void attaquer(Entite victime);

    //Subir les dégats, retourne le contrecoup
    public abstract void subirDegat(int degat);

    //Renvoie si l'Entite est morte (pv = 0)
    public abstract boolean etreMort();

}
