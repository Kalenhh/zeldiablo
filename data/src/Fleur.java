/**
 * gere un personnage situe en x,y
 */
public class Fleur extends Item{
    /**
     * Construit une Fleur
     * @param resistance solidite
     * @param pointVie durabilite
     * @param x position abscisse
     * @param y position ordonnee
     */
    public Fleur(int resistance, int pointVie, int x, int y) {
        super(resistance, pointVie, x, y);
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.getX() == dx && this.getY() == dy);
    }
}
