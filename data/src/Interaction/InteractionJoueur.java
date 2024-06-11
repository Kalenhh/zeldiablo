package Interaction;

import Entite.*;
import Item.Fleur;
import Item.Mur;
import Labyrinthe.LabyDessin;
import Labyrinthe.Score;

public class InteractionJoueur implements Interaction {
    @Override
    public void interagirAvec(Entite e, Position p) {
        if (p instanceof Mur) {
            // Si la position cible est un Mur, l'entité joueur revient à sa position précédente
            e.setX(e.getAncienX());
            e.setY(e.getAncienY());
        }

        if (p instanceof Monstre) {
            e.attaquer((Entite) p);
            e.setX(e.getAncienX());
            e.setY(e.getAncienY());
            ((Monstre) p).attaquer(e);
        }

        if (p instanceof Fleur) {
            // Si la position cible est une Fleur, le personnage gagne un point de vie
            if (e instanceof Perso) {
                int pv = ((Perso) e).getPv();
                ((Perso) e).setPv(pv + 1);
                Score.score += 1;
                LabyDessin.dessinerScore();
                if(Score.bestScore < Score.score){
                    Score.bestScore = Score.score;
                }
            }
        }
    }
}
