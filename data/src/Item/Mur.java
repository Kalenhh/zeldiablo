package Item;

import Interaction.InteractionMur;

/**
 * Obstacle mur pouvant etre casse
 */
public class Mur extends Item{
    /**
     * Construit une Item.Mur
     * @param resistance solidite
     * @param durabilite vie
     * @param x position abscisse
     * @param y position ordonnee
     */
    public Mur(int resistance, int durabilite, int x, int y){
        super(resistance, durabilite, x, y, new InteractionMur());
    }
}
