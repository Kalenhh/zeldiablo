package Interaction;

import Entite.*;
import Item.Fleur;
import Item.Mur;
import Item.Piege;
import Labyrinthe.LabyDessin;
import Labyrinthe.Labyrinthe;
import Labyrinthe.Score;

import java.util.Random;

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
            //hasard pour la fleur
            Random rand = new Random();
            //gain de pv et score
            int pv = ((Perso) e).getPv();
            ((Perso) e).setPv(pv + 1);
            Score.score += 1;
            LabyDessin.dessinerScore();
            if(Score.bestScore < Score.score){
                Score.bestScore = Score.score;
            }
            //Recherche d'une nouvelle position
            int newX, newY;
            Position newPosition;
            //Tant que la nouvelle position est un piege, on
            do {
                int randomInt = rand.nextInt(Labyrinthe.listeNoeud.size()-1);
                String randomPos = Labyrinthe.listeNoeud.get(randomInt);
                newX = Integer.parseInt(randomPos.split(":")[0]);
                newY = Integer.parseInt(randomPos.split(":")[1]);
                newPosition = new Position(newX, newY);
            } while (newPosition instanceof Piege);
            p.setX(newPosition.getX());
            p.setY(newPosition.getY());
        }


        if (p instanceof Piege){
            if(((Piege) p).etreOuvert()){
                e.subirDegat(1);
                ((Piege) p).fermerPiege();
            }
        }
    }
}