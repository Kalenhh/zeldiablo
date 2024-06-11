package Entite;

import Interaction.*;

/**
 * Classe abstraite représentant une entité dans le jeu.
 * Hérite de la classe Position et ajoute des comportements spécifiques aux entités,
 */
public abstract class Entite extends Position {

    /**
     * Ancienne position X de l'entité
     */
    private int ancienX;

    /**
     * Ancienne position Y de l'entité
     */
    private int ancienY;

    /**
     * Interaction associée à l'entité
     */
    private final Interaction interaction;

    /**
     * Constructeur pour initialiser une entité avec une position et une interaction spécifique
     *
     * @param dx Position X initiale
     * @param dy Position Y initiale
     * @param inter Interaction associée à l'entité
     */
    public Entite(int dx, int dy, Interaction inter) {
        super(dx, dy);
        this.ancienX = 1;
        this.ancienY = 1;
        this.interaction = inter;
    }

    /**
     * Déplace l'entité selon des règles spécifiques définies dans les sous-classes.
     */
    public abstract void seDeplacer();

    /**
     * Interagit avec une cible donnée.
     *
     * @param cible La Position cible avec laquelle interagir
     */
    public void interagir(Position cible){
        this.interaction.interagirAvec(this, cible);
    }

    /**
     * Attaque une autre entité.
     *
     * @param victime L'entité victime de l'attaque
     */
    public abstract void attaquer(Entite victime);

    /**
     * L'entité subit des dégâts .
     *
     * @param degat Les dégâts subis
     */
    public abstract void subirDegat(int degat);


    // GETTERS

    /**
     * Obtient l'ancienne position X de l'entité.
     *
     * @return L'ancienne position X
     */
    public int getAncienX() {
        return ancienX;
    }

    /**
     * Obtient l'ancienne position Y de l'entité.
     *
     * @return L'ancienne position Y
     */
    public int getAncienY() {
        return ancienY;
    }

    /**
     * Définit l'ancienne position X de l'entité.
     *
     * @param x La nouvelle ancienne position X
     */
    public void setAncienX(int x) {
        ancienX = x;
    }

    /**
     * Définit l'ancienne position Y de l'entité.
     *
     * @param y La nouvelle ancienne position Y
     */
    public void setAncienY(int y) {
        this.ancienY = y;
    }

    /**
     * Obtient l'interaction associée à l'entité.
     *
     * @return L'interaction de l'entité
     */
    public Interaction getInteraction() {
        return this.interaction;
    }
}

