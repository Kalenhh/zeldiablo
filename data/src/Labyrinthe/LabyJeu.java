package Labyrinthe;

import moteurJeu.*;


public class LabyJeu implements Jeu {

    public static Double VITESSE_ENNEMIE = 2.0 ;

    private Labyrinthe laby;


    public LabyJeu(Labyrinthe laby) {
        this.laby = laby;
    }

    /**
     * Met a jour l'objet Labyrinthe.Labyrinthe selon l'entrée de l'utilisateur
     * Est appelé à toute les frames de l'execution
     *
     * @param secondes temps ecoule depuis la derniere mise a jour
     * @param clavier  objet contenant l'état du clavier'
     */
    @Override
    public void update(double secondes, Clavier clavier) {

        if (clavier.droite) {
            this.laby.deplacerPerso("Droite");
        } else if (clavier.gauche) {
            this.laby.deplacerPerso("Gauche");
        } else if (clavier.haut) {
            this.laby.deplacerPerso("Haut");
        } else if (clavier.bas) {
            this.laby.deplacerPerso("Bas");
        }

        if(secondes>VITESSE_ENNEMIE){
            this.laby.deplacementEntite();
            this.laby.gererInteraction();
        }

    }

    /**
     * Initialisation
     */
    @Override
    public void init() {
        System.out.println("init() called");
    }

    /**
     * Indique si le jeu est fini ou non
     *
     * @return booleen
     */
    @Override
    public boolean etreFini() {
        return true;
    }

    /**
     * Getter de l'attribut laby de type Labyrinthe.Labyrinthe
     *
     * @return laby
     */
    public Labyrinthe getLaby() {
        return this.laby;
    }
}
