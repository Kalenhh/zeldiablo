package Entite;

/**
 * Classe représentant un joueur, qui hérite de Entite.Perso
 */
public class Joueur extends Perso {

    /**
     *
     * @param x
     * @param y
     * @param pv
     * @param degats
     */
    public Joueur(int x, int y,  int pv, int degats) {
        // constructeur de la classe parente Entite.Perso
        super(x, y,pv, degats, null);
    }

    public void attaquer(Entite e){
        e.subirDegat(this.degats);
    }

    public void sedeplacer(){

    }

    public void subirDegat(int degats){
        super.pv = super.pv-degats;
    }

    public boolean etrePresent(){
        return super.etrePresent(this.getX(), this.getY());
    }

    public boolean etreMort(){
        return super.pv ==0;
    }
}
