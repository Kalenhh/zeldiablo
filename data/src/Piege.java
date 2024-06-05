/**
 * Obstacle piege empechant le joueur d'avancer
 */
public class Piege extends Item{
    /**
     * Construit un Piege
     * @param resistance solidite
     * @param durabilite vie
     * @param x position abscisse
     * @param y position ordonnee
     */
    public Piege(int resistance, int durabilite, int x, int y){
        super(resistance, durabilite, x ,y);
    }
}
