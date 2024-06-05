/**
 * Obstacle mur pouvant etre casse
 */
public class Mur extends Item{
    /**
     * Construit un Mur
     * @param resistance solidite
     * @param pointVie durabilite
     * @param x position abscisse
     * @param y position ordonnee
     */
    public Mur(int resistance, int pointVie, int x, int y){
        super(resistance, pointVie, x, y);
    }
}
