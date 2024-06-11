package Entite;

import Interaction.InteractionJoueur;

/**
 * Classe représentant un joueur, qui hérite de Entite.Perso.
 */
public class Joueur extends Perso {

    /**
     * Constructeur pour initialiser un joueur avec une position, des points de vie, et des dégâts.
     *
     * @param x      Position X initiale
     * @param y      Position Y initiale
     * @param pv     Points de vie initiaux
     * @param degats Dégâts infligés par le joueur
     */
    public Joueur(int x, int y, int pv, int degats) {
        // constructeur de la classe parente Entite.Perso
        super(x, y, pv, degats, new InteractionJoueur());
    }


    /**
     * Déplace le joueur. Cette méthode est actuellement vide car le joueur est contrôlé par l'utilisateur.
     */
    public void seDeplacer() {
    }


    public void interagir(Position cible) {
        System.out.println(this.getX() + " " + this.getY() + " " + cible.getX() + " " + cible.getY());
        getInteraction().interagirAvec(this, cible);
    }

    public boolean estMort() {
        return pv == 0;
    }


    public void subirDegat(int degat) {
        pv -= degat;
        if (pv < 0) {
            pv = 0;
        }
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int i) {
        this.pv = i;
    }
}

