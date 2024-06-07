package Entite;

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
    public Jaune(int dx, int dy, int pv, int degats) {
        super(dx, dy, pv, degats);
        this.nom = nom;

    }

    /**
     * Classe représentant un Entite.Monstre, qui hérite de Entite.Perso
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
