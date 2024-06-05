public class Jaune extends Monstre {

    private String nom;

    /**
     * constructeur
     *
     * @param dx     position selon x
     * @param dy     position selon y
     * @param pv
     * @param degats
     */
    public Jaune(int dx, int dy, int pv, int degats, String nom) {
        super(dx, dy, pv, degats, nom);
        this.nom = nom;

    }

    /**
     * Classe représentant un Monstre, qui hérite de Perso
     */


    /**
     * @return le nom du Monstre
     */
    public String getNom() {
        return super.getNom();
    }

    /**
     * Définit le nom du joueur
     *
     * @param nom le nouveau nom du Monstre
     */


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void attaquer(Entite e) {
        e.subirDegat(this.degats);
    }

    public void sedeplacer() {
        //se déplace aleatoirement sur le terrain
    }

    public void subirDegat(int degats) {
        super.subirDegat(degats);
    }

    public boolean etrePresent() {
        return super.etrePresent(this.getX(), this.getY());
    }

    public boolean etreMort() {
        return super.etreMort();
    }
}
