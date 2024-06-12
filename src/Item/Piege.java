package Item;

/**
 * Obstacle piege empechant le joueur d'avancer
 */
public class Piege extends Item{

    boolean piegeOuvert;
    /**
     * Construit un Item.Piege
     * @param resistance solidite
     * @param durabilite vie
     * @param x position abscisse
     * @param y position ordonnee
     */
    public Piege(int resistance, int durabilite, int x, int y){
        super(resistance, durabilite, x ,y);
        this.piegeOuvert = true;
    }

    public boolean etreOuvert(){
        return this.piegeOuvert;
    }

    public void fermerPiege(){
        this.piegeOuvert = false;
    }
}
