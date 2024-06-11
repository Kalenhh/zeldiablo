package Interaction;

import Entite.*;

/**
 * Interface représentant une interaction entre deux entités dans le labyrinthe.
 */
public interface Interaction {

    /**
     * Méthode pour gérer l'interaction entre une entité et une position cible.
     *
     * @param e L'entité qui interagit
     * @param p La position cible de l'interaction
     */
    void interagirAvec(Entite e, Position p);
}
