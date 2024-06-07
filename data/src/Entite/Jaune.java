package Entite;

import Interaction.InteractionJaune;
import Labyrinthe.Labyrinthe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jaune extends Monstre {

    List<int[]> positionsPossibles = new ArrayList<>();
    int[][] directions = {
            {0, 1},  // bas
            {0, -1}, // haut
            {1, 0},  // droite
            {-1, 0}  // gauche
    };

    private Labyrinthe labyrinthe;

    /**
     * constructeur
     *
     * @param dx     position selon x
     * @param dy     position selon y
     * @param pv
     * @param degats
     */
    public Jaune(int dx, int dy, int pv, int degats) {
        super(dx, dy, pv, degats,new InteractionJaune());
    }

    /**
     * Classe représentant un Entite.Monstre, qui hérite de Entite.Perso
     */



    public void attaquer(Entite e) {
        e.subirDegat(this.degats);
    }

    public void seDeplacer() {

        setAncienX(getX());
        setAncienY(getY());

        for (int[] direction : directions) {
            int newX = this.getX() + direction[0];
            int newY = this.getY() + direction[1];

            positionsPossibles.add(new int[]{newX, newY});
        }

        if (!positionsPossibles.isEmpty()) {
            int[] nouvellePosition = positionsPossibles.get(new Random().nextInt(positionsPossibles.size()));
            this.setX(nouvellePosition[0]);
            this.setY(nouvellePosition[1]);
        }
    }

    public void interagir(Position cible){
        getInteraction().interagirAvec(this,cible);
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
