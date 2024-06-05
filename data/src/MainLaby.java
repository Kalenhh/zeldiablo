import Labyrinthe.LabyJeu;
import Labyrinthe.Labyrinthe;
import moteurJeu.MoteurJeu;

import java.awt.*;
import java.io.IOException;
import Labyrinthe.LabyDessin;

/**
 * charge et affiche un labyrinthe
 */
public class MainLaby {
    public static void main(String[] args) throws IOException {
        MoteurJeu.setFPS(30);
        MoteurJeu.setTaille(800, 600);

        Labyrinthe laby = new Labyrinthe("data/laby/laby1.txt");

        // charge le labyrinthe
        LabyJeu labyjeu = new LabyJeu(laby);
        LabyDessin ld = new LabyDessin();

        MoteurJeu.launch(labyjeu, ld);
    }
}
