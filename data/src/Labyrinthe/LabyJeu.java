package Labyrinthe;
import moteurJeu.*;

/**
 * Classe LabyJeu qui implémente l'interface Jeu.
 * Elle est responsable de la gestion du jeu, des mises à jour et des interactions.
 */
public class LabyJeu implements Jeu {

    public static final Double VITESSE_ENNEMIE = 2.0;

    private final Labyrinthe laby;
    private double temps;

    /**
     * Constructeur de la classe LabyJeu
     *
     * @param laby Labyrinthe utilisé pour initialiser le jeu
     */
    public LabyJeu(Labyrinthe laby) {
        this.laby = laby;
        this.temps = 0;
    }

    /**
     * Met à jour l'objet Labyrinthe selon l'entrée de l'utilisateur.
     * Est appelée à chaque frame de l'exécution.
     *
     * @param secondes temps écoulé depuis la dernière mise à jour
     * @param clavier  objet contenant l'état du clavier
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

        temps = temps + secondes;
        if (temps > VITESSE_ENNEMIE) {
            temps = 0;
            System.out.println(temps);
            this.laby.deplacementEntite();
            this.laby.gererInteraction();
        }
    }

    /**
     * Initialisation du jeu
     */
    @Override
    public void init() {
        System.out.println("init() called");
    }

    /**
     * Indique si le jeu est fini ou non
     *
     * @return boolean true si le jeu est fini, false sinon
     */
    @Override
    public boolean etreFini() {
        return true;
    }

    /**
     * Getter de l'attribut laby de type Labyrinthe
     *
     * @return laby le labyrinthe du jeu
     */
    public Labyrinthe getLaby() {
        return this.laby;
    }
}
