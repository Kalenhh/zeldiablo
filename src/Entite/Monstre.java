package Entite;

import Interaction.Interaction;

/**
 * Classe représentant un monstre, qui hérite de la classe Perso.
 */
public abstract class Monstre extends Perso {

    /**
     * Constructeur pour initialiser un monstre avec une position, des points de vie, des dégâts, et une interaction.
     *
     * @param dx     Position X initiale
     * @param dy     Position Y initiale
     * @param pv     Points de vie initiaux
     * @param degats Dégâts infligés par le monstre
     * @param inter  Interaction spécifique du monstre
     */
    public Monstre(int dx, int dy, int pv, int degats, Interaction inter) {
        super(dx, dy, pv, degats, inter);
    }
}




