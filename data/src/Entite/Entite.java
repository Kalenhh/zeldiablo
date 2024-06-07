package Entite;

import Interaction.*;

public abstract class Entite extends Position{

    private int ancienX ;
    private int ancienY ;

    private Interaction interaction ;

    public Entite(int dx, int dy, Interaction inter){
        super(dx,dy);
        this.ancienX = 0 ;
        this.ancienY = 0 ;
        this.interaction = inter ;
    }

    //Permet de deplacer l'entite
    public abstract void seDeplacer();

    public abstract void interagir(Position cible);

    //Permet d'attaquer une autre Entite.Entite victime
    public abstract void attaquer(Entite victime);

    //Subir les dégats, retourne le contrecoup
    public abstract void subirDegat(int degat);

    //Renvoie si l'Entite.Entite est morte (pv = 0)
    public abstract boolean etreMort();

    // GETTER


    public int getAncienX() {
        return ancienX;
    }

    public int getAncienY() {
        return ancienY;
    }

    public void setAncienX(int x){
        ancienX = x ;
    }

    public void setAncienY(int y) {
        this.ancienY = y;
    }

    public Interaction getInteraction(){
        return this.interaction;
    }
}
