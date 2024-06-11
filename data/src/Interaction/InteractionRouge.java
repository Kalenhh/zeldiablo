package Interaction;

import Entite.*;
import Item.Fleur;
import Item.Mur;
import Labyrinthe.Score;

/**
 * Classe représentant les interactions spécifiques pour le monstre Jaune.
 */
public class InteractionRouge implements Interaction {

    /**
     * Gère l'interaction entre une entité Jaune et une autre position du labyrinthe.
     *
     * @param e L'entité Jaune
     * @param p La position cible de l'interaction
     */
    @Override
    public void interagirAvec(Entite e, Position p) {
        if (p instanceof Mur) {
            // Si la position cible est un Mur, l'entité Jaune revient à sa position précédente
            e.setX(e.getAncienX());
            e.setY(e.getAncienY());
        }


        if (p instanceof Joueur) {
            // Si la position cible est un Joueur, l'entité Jaune attaque le joueur et revient à sa position précédente
            if (!((Joueur) p).etreMort())
                e.attaquer((Entite) p);
            e.setX(e.getAncienX());
            e.setY(e.getAncienY());
            Score.score += 1;
        }

        if (p instanceof Fleur) {
            // Si la position cible est une Fleur, le personnage gagne un point de vie
            if (e instanceof Perso) {
                int pv = ((Perso) e).getPv();
                ((Perso) e).setPv(pv + 1);
            }
        }
    }
}

