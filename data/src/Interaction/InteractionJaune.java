package Interaction;

import Entite.*;
import Item.Fleur;
import Item.Mur;
import Item.Piege;
import Labyrinthe.Score;

/**
 * Classe représentant les interactions spécifiques pour le monstre Jaune.
 */
public class InteractionJaune implements Interaction {

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
            if (!((Joueur) p).etreMort()) {
                    e.attaquer((Entite) p);
                    e.setX(e.getAncienX());
                    e.setY(e.getAncienY());
            }
            Score.score++;
        }

        if(p instanceof Monstre){
            e.setX(e.getAncienX());
            e.setY(e.getAncienY());
        }

        if (p instanceof Piege){
            if(((Piege) p).etreOuvert()){
                ((Perso) e).subirDegat(1);
                ((Piege) p).fermerPiege();
            }
        }
    }
}

