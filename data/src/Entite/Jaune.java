package Entite;

import Interaction.InteractionJaune;
import Labyrinthe.Labyrinthe;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe représentant un monstre de type Jaune, héritant de la classe Monstre.
 * Ce monstre a des comportements spécifiques pour l'attaque, le déplacement, et l'interaction.
 */
public class Jaune extends Monstre {

    /**
     * Liste des positions possibles pour le déplacement.
     */
    List<int[]> positionsPossibles = new ArrayList<>();

    /**
     * Directions possibles pour le déplacement.
     */
    int[][] directions = {
            {0, 1},  // bas
            {0, -1}, // haut
            {1, 0},  // droite
            {-1, 0}  // gauche
    };

    /**
     * Constructeur pour initialiser un monstre de type Jaune avec une position, des points de vie, et des dégâts.
     *
     * @param dx     Position X initiale
     * @param dy     Position Y initiale
     * @param pv     Points de vie initiaux
     * @param degats Dégâts infligés par le monstre
     */
    public Jaune(int dx, int dy, int pv, int degats) {
        super(dx, dy, pv, degats, new InteractionJaune());
    }



    /**
     * Déplace le monstre dans une direction aléatoire parmi les positions possibles.
     */
    public void seDeplacer() {
        positionsPossibles.clear();

        setAncienX(getX());
        setAncienY(getY());

        for (int[] direction : directions) {
            int newX = this.getX() + direction[0];
            int newY = this.getY() + direction[1];

            if(Labyrinthe.listeNoeud.contains(newX+":"+newY)){
                positionsPossibles.add(new int[]{newX, newY});
            }
        }

        if (!positionsPossibles.isEmpty()) {
            int[] nouvellePosition = positionsPossibles.get(new Random().nextInt(positionsPossibles.size()));
            this.setX(nouvellePosition[0]);
            this.setY(nouvellePosition[1]);
        }
    }

    /**
     * Interagit avec une position cible en utilisant l'interaction définie pour ce type de monstre.
     *
     * @param cible La position cible de l'interaction
     */
    public void interagir(Position cible) {
        getInteraction().interagirAvec(this, cible);
    }
}
