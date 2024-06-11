package Entite;

import Algorithme.Dijkstra;
import Algorithme.Valeur;
import Interaction.InteractionJaune;
import Interaction.InteractionRouge;
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
        super(dx, dy, pv, degats, new InteractionRouge());
        this.l = l;
    }

    /**
     * Attaque une entité en lui infligeant des dégâts.
     *
     * @param e L'entité victime de l'attaque
     */
    public void attaquer(Entite e) {
        super.attaquer(e);
    }

    /**
     * Se déplace de sorte à se diriger constamment vers le joueur.
     * Implémentation à définir selon la logique de déplacement spécifique.
     */
    public void seDeplacer() {
        //se deplace de sorte a ce qu'il se déplace comstamment vers le joueur
        int x = this.getX();
        int y = this.getY();
        //On résout le labyrinthe avec comme coordonnée de départ celle du slime
        System.out.println(x + " : " + y);
        Valeur v = this.dj.resoudre(this.l, x+":"+y);
        System.out.println(this.dj.resoudre(this.l,x+":"+y));
        ArrayList<String> chemin = (ArrayList<String>) v.calculerChemin(l.getPerso().getX() + ":" + l.getPerso().getY());
        System.out.println("size : " + chemin.size());
        System.out.println(chemin);
        if(chemin.size() == 1){
            return;
        }
        String[] position = chemin.get(1).split(":");

        int[] nouvellePosition = {Integer.parseInt(position[0]), Integer.parseInt(position[1])};
        System.out.println(nouvellePosition[0]);
        System.out.println(nouvellePosition[1]);
        this.setX(nouvellePosition[0]);
        this.setY(nouvellePosition[1]);
    }

    @Override
    public void interagir(Position cible) {
        getInteraction().interagirAvec(this, cible);
    }



    /**
     * Vérifie si le monstre est présent aux coordonnées (x, y).
     *
     * @return true si le monstre est présent aux coordonnées (x, y), sinon false
     */
    public boolean etrePresent() {
        return super.etrePresent(this.getX(), this.getY());
    }

}


