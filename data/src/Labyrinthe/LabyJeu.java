package Labyrinthe;
import Entite.Joueur;
import Entite.Monstre;
import Entite.Perso;
import Entite.Position;
import moteurJeu.*;

import java.io.IOException;
import java.util.Iterator;

/**
 * Classe LabyJeu qui implémente l'interface Jeu.
 * Elle est responsable de la gestion du jeu, des mises à jour et des interactions.
 */
public class LabyJeu implements Jeu {

    public static final Double VITESSE_ENNEMIE = 2.0;

    public static final Double VITESSE_JOUEUR = 0.5 ;

    private Labyrinthe laby;
    private double temps;
    private double temps_joueur ;

    /**
     * Constructeur de la classe LabyJeu
     *
     * @param laby Labyrinthe utilisé pour initialiser le jeu
     */
    public LabyJeu(Labyrinthe laby) {
        this.laby = laby;
        this.temps = 0;
        this.temps_joueur = 0 ;
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
        temps_joueur += secondes ;

        if (clavier.droite && temps_joueur > VITESSE_JOUEUR) {
            this.laby.deplacerPerso("Droite");
            temps_joueur = 0 ;
        } else if (clavier.gauche && temps_joueur > VITESSE_JOUEUR) {
            this.laby.deplacerPerso("Gauche");
            temps_joueur = 0 ;
        } else if (clavier.haut && temps_joueur > VITESSE_JOUEUR) {
            this.laby.deplacerPerso("Haut");
            temps_joueur = 0 ;
        } else if (clavier.bas && temps_joueur > VITESSE_JOUEUR) {
            this.laby.deplacerPerso("Bas");
            temps_joueur = 0 ;
        }

        temps = temps + secondes;
        if (temps > VITESSE_ENNEMIE) {
            temps = 0;
            System.out.println(temps);
            this.laby.deplacementEntite();
            this.laby.gererInteraction();
        }

        System.out.println("Pv du joueur : " + laby.getPerso().getPv());

        Joueur joueur = (Joueur)laby.getPerso();
        if (joueur.etreMort()) {
            laby.etreFini();
            MoteurJeu.stopAnimation();
            MoteurJeu.afficherEcranGameOver();

        }

        verifierMonstresMorts(laby);

    }


    protected void verifierMonstresMorts(Labyrinthe laby) {
        Iterator<Position> iterator = laby.getGrid().iterator();
        while (iterator.hasNext()) {
            Position pos = iterator.next();
            if (pos instanceof Monstre) {
                Monstre monstre = (Monstre) pos;
                if (monstre.etreMort()) {
                    iterator.remove();
                }
            }
        }
    }


    /**
     * Initialisation du jeu
     */
    @Override
    public void init() throws IOException {
        this.laby = new Labyrinthe("data/laby/laby1.txt");
        this.temps = 0;
        this.temps_joueur = 0 ;
        Joueur joueur = (Joueur)laby.getPerso();
        joueur.setPv(2);
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

    public void reset() {
        Joueur joueur = (Joueur)laby.getPerso();
        joueur.setPv(2); // Réinitialiser les PV du joueur
        // Réinitialiser le jeu à son état initial

    }

}
