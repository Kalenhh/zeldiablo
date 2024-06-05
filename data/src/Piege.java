/**
 * Obstacle piege empechant le joueur d'avancer
 */
public class Piege extends Item{
    /**
     * Construit un Piege
     * @param resistance solidite
     * @param pointVie durabilite
     * @param x position abscisse
     * @param y position ordonnee
     */
    public Piege(int resistance, int pointVie, int x, int y){
        super(resistance, pointVie, x ,y);
    }
}
