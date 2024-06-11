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
     * Attaque une entité cible en lui infligeant des dégâts.
     *
     * @param e L'entité cible de l'attaque
     */
    public void attaquer(Entite e) {
        e.subirDegat(this.degats);
    }

    /**
     * Déplace le joueur. Cette méthode est actuellement vide car le joueur est contrôlé par l'utilisateur.
     */
    public void seDeplacer() {
        return;
    }

    /**
     * Subit des dégâts infligés par une autre entité.
     *
     * @param degats Les dégâts subis
     */
    public void subirDegat(int degats) {
        super.pv = super.pv - degats;
    }

    /**
     * Vérifie si le joueur est présent à sa position actuelle.
     *
     * @return true si le joueur est présent, sinon false
     */
    public boolean etrePresent() {
        return super.etrePresent(this.getX(), this.getY());
    }

    /**
     * Vérifie si le joueur est mort (points de vie = 0).
     *
     * @return true si le joueur est mort, sinon false
     */
    public boolean etreMort() {
        return super.pv == 0;

    }

    public void interagir(Position cible) {
        System.out.println(this.getX() + " " + this.getY() + " " + cible.getX() + " " + cible.getY());
        getInteraction().interagirAvec(this, cible);
    }
}

