package Entite;

import Algorithme.Dijkstra;
import Algorithme.Valeur;
import Labyrinthe.Labyrinthe;

import java.util.ArrayList;

/**
 * Classe représentant un monstre Rouge, qui hérite de Entite.Monstre.
 */
public class Rouge extends Monstre {

    Labyrinthe l;
    Dijkstra dj = new Dijkstra();

    /**
     * Constructeur pour initialiser un monstre Rouge avec une position, des points de vie, et des dégâts.
     *
     * @param dx     Position X initiale
     * @param dy     Position Y initiale
     * @param pv     Points de vie initiaux
     * @param degats Dégâts infligés par le monstre
     */
    public Rouge(int dx, int dy, int pv, int degats, Labyrinthe l) {
        super(dx, dy, pv, degats, null);
        this.l = l;
    }

    /**
     * Attaque une entité en lui infligeant des dégâts.
     *
     * @param e L'entité victime de l'attaque
     */
    public void attaquer(Entite e) {
        e.subirDegat(super.degats);
    }

    /**
     * Se déplace de sorte à se diriger constamment vers le joueur.
     * Implémentation à définir selon la logique de déplacement spécifique.
     */
    public void seDeplacer() {
        //se deplace de sorte a ce qu'il se déplace comstamment vers le joueur
        int x = this.getX();
        int y = this.getY();
        Valeur v = this.dj.resoudre(this.l, x+":"+y);
        ArrayList<String> chemin = (ArrayList<String>) v.calculerChemin(l.getPerso().getX() + ":" + l.getPerso().getY());
        System.out.println("size : " + chemin.size());
        String[] position = chemin.get(0).split(":");
        System.out.println("Chemin pris : " + chemin);
        ArrayList<int[]> liste = new ArrayList<int[]>();

        int[] nouvellePosition = {Integer.parseInt(position[0]), Integer.parseInt(position[1])};
        liste.add(nouvellePosition);
        if(liste.isEmpty()){
            this.setX(nouvellePosition[0]);
            this.setY(nouvellePosition[1]);
        }
    }

    /**
     * Subit des dégâts et les soustrait aux points de vie du monstre.
     *
     * @param degats Les dégâts subis
     */
    public void subirDegat(int degats) {
        super.pv = super.pv - degats;
    }

    /**
     * Vérifie si le monstre est présent aux coordonnées (x, y).
     *
     * @return true si le monstre est présent aux coordonnées (x, y), sinon false
     */
    public boolean etrePresent() {
        return super.etrePresent(this.getX(), this.getY());
    }

    /**
     * Vérifie si le monstre est mort (points de vie égaux à 0).
     *
     * @return true si les points de vie sont égaux à 0, sinon false
     */
    public boolean etreMort() {
        return super.etreMort();
    }
}


