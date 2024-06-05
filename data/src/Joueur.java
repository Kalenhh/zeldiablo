/**
 * Classe représentant un joueur, qui hérite de Perso
 */
public class Joueur extends Perso {

    /**
     * Nom du joueur
     */
    private String nom;

    /**
     *
     * @param nom
     * @param x
     * @param y
     * @param pv
     * @param degats
     */
    public Joueur(String nom, int x, int y,  int pv, int degats) {
        // constructeur de la classe parente Perso
        super(x, y,pv, degats);

        // Initialise le nom du joueur
        this.nom = nom;


    }

    /**
     * @return le nom du joueur
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Définit le nom du joueur
     *
     * @param nom le nouveau nom du joueur
     */


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void attaquer(Entite e){
        e.subirDegat(this.degats);
    }

    public void sedeplacer(){

    }

    public void subirDegat(int degats){
        this.pv = this.pv-degats;
    }

    public boolean etrePresent(){
        return super.etrePresent(this.getX(), this.getY());
    }

    public boolean etreMort(){
        return this.pv ==0;
    }
}
