package Entite;

/**
 * Classe représentant une position avec des coordonnées (x, y).
 */
public abstract class Position {

    /**
     * Coordonnée X de la position.
     */
    private int x;

    /**
     * Coordonnée Y de la position.
     */
    private int y;

    /**
     * Constructeur pour initialiser une position avec des coordonnées (x, y).
     *
     * @param dx Position X initiale
     * @param dy Position Y initiale
     */
    public Position(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * Définit la coordonnée X.
     *
     * @param x Nouvelle coordonnée X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Définit la coordonnée Y.
     *
     * @param y Nouvelle coordonnée Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Retourne la coordonnée X.
     *
     * @return La coordonnée X
     */
    public int getX() {
        return x;
    }

    /**
     * Retourne la coordonnée Y.
     *
     * @return La coordonnée Y
     */
    public int getY() {
        return y;
    }

    /**
     * Vérifie si l'objet se trouve aux coordonnées (x, y) spécifiées.
     *
     * @param x Coordonnée X à vérifier
     * @param y Coordonnée Y à vérifier
     * @return true si l'objet est aux coordonnées (x, y), sinon false
     */
    public boolean etrePresent(int x, int y) {
        return this.x == x && this.y == y;
    }
}
