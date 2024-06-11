package Entite;
import Interaction.Interaction;
/**
 * Classe représentant un monstre, qui hérite de la classe Perso.
 */
public abstract class Monstre extends Perso {

    /**
     * Constructeur pour initialiser un monstre avec une position, des points de vie, des dégâts, et une interaction.
     *
     * @param dx     Position X initiale
     * @param dy     Position Y initiale
     * @param pv     Points de vie initiaux
     * @param degats Dégâts infligés par le monstre
     * @param inter  Interaction spécifique du monstre
     */
    public Monstre(int dx, int dy, int pv, int degats, Interaction inter) {
        super(dx, dy, pv, degats, inter);
    }

    public void interagir(Position cible) {
        System.out.println(this.getX() + " " + this.getY() + " " + cible.getX() + " " + cible.getY());
        getInteraction().interagirAvec(this, cible);
    }

    /**
     * Attaque une entité cible en lui infligeant des dégâts.
     *
     * @param e L'entité cible de l'attaque
     */
    public void attaquer(Entite e) {
        super.attaquer(e);
    }







    /**
     * Vérifie si le monstre est présent à sa position actuelle.
     *
     * @return true si le monstre est présent, sinon false
     */
    public boolean etrePresent() {
        return super.etrePresent(this.getX(), this.getY());
    }


}




