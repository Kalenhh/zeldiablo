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
        return;
    }


    public void interagir(Position cible) {
        getInteraction().interagirAvec(this, cible);
    }
}

