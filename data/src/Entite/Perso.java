package Entite;

import Interaction.Interaction;

/**
 * gere un personnage situe en x,y
 */
public class Perso extends Entite{

    /**
     * position du personnage
     */
    int pv, degats;


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy, int pv, int degats, Interaction inter) {
        super(dx,dy,inter);
        this.pv = pv;
        this.degats = degats;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.getX() == dx && this.getY() == dy);
    }

    // ############################################
    // GETTER
    // ############################################





    @Override
    public void attaquer(Entite victime) {
        return ;
    }

    @Override
    public void subirDegat(int degat) {
        return ;
    }

    @Override
    public boolean etreMort() {
        return false;
    }

    public void seDeplacer() {
    }

    @Override
    public void interagir(Position cible) {
        return;
    }

    public void interagir(){

    }

}
