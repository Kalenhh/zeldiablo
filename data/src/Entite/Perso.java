package Entite;

import Interaction.Interaction;
import Labyrinthe.Labyrinthe;

/**
 * Gère un personnage situé en (x, y).
 */
public abstract class Perso extends Entite {

    /**
     * Points de vie du personnage.
     */
    int pv;

    /**
     * Dégâts infligés par le personnage.
     */
    int degats;

    private Labyrinthe laby;


    /**
     * Constructeur pour initialiser un personnage avec une position, des points de vie, des dégâts, et une interaction.
     *
     * @param dx     Position X initiale
     * @param dy     Position Y initiale
     * @param pv     Points de vie initiaux
     * @param degats Dégâts infligés par le personnage
     * @param inter  Interaction spécifique du personnage
     */
    public Perso(int dx, int dy, int pv, int degats, Interaction inter) {
        super(dx, dy, inter);
        this.pv = pv;
        this.degats = degats;
    }

    /**
     * Permet de savoir si le personnage est en (dx, dy).
     *
     * @param dx Position X testée
     * @param dy Position Y testée
     * @return true si le personnage est bien en (dx, dy), sinon false
     */
    public boolean etrePresent(int dx, int dy) {
        return (this.getX() == dx && this.getY() == dy);
    }

    /**
     * Méthode d'attaque. Implémentation vide à redéfinir par les sous-classes.
     *
     * @param victime L'entité victime de l'attaque
     */
    @Override
    public void attaquer(Entite victime) {
        victime.subirDegat(degats);
    }

    /**
     * Méthode pour subir des dégâts. Implémentation vide à redéfinir par les sous-classes.
     *
     * @param degat Les dégâts subis
     */
    @Override
    public void subirDegat(int degat) {
        this.pv -= degat ;
    }

    /**
     * Vérifie si le personnage est mort. Implémentation vide à redéfinir par les sous-classes.
     *
     * @return false par défaut
     */
    @Override
    public boolean etreMort() {
        return pv<=0;
    }

    /**
     * Retourne les dégâts infligés par le personnage.
     *
     * @return Les dégâts infligés
     */
    public int getDegats() {
        return degats;
    }

    /**
     * Retourne les points de vie du personnage.
     *
     * @return Les points de vie
     */
    public int getPv() {
        return pv;
    }



    public void setPv(int i) {
        this.pv = i;
    }
}
