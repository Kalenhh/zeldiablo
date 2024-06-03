import moteurJeu.*;

import java.io.IOException;
import java.util.Objects;

public class LabyJeu implements Jeu {

    private Labyrinthe laby;
    public LabyJeu(Labyrinthe laby){
        this.laby = laby;
    }


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

    }

    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Labyrinthe getLaby(){
        return this.laby;
    }
}
