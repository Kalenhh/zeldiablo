package Interaction;

import Entite.*;
import Labyrinthe.Labyrinthe;

/**
 * Classe représentant les interactions avec les plantes
 */
public class InteractionFleur implements Interaction{
    @Override
    public void interagirAvec(Entite e, Position p) {
        if(p instanceof Joueur){
            e.setX((int)(Math.random()*Labyrinthe.NBR_COLONNE));
            e.setY((int)(Math.random()*Labyrinthe.NBR_LIGNE));
        }
    }
}
