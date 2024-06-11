package Interaction;

import Entite.*;
import Item.Fleur;
import Item.Mur;
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
            Random rand = new Random();
            int pv = ((Perso) e).getPv();
            ((Perso) e).setPv(pv + 1);
            Score.score += 1;
            LabyDessin.dessinerScore();
            if(Score.bestScore < Score.score){
                Score.bestScore = Score.score;
            }
            int randomInt = rand.nextInt(Labyrinthe.listeNoeud.size()-1);
            String randomPos = Labyrinthe.listeNoeud.get(randomInt);
            p.setX(Integer.parseInt(randomPos.split(":")[0]));
            p.setY(Integer.parseInt(randomPos.split(":")[1]));
        }
    }
}
