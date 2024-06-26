import Labyrinthe.LabyJeu;
import Labyrinthe.Labyrinthe;
import moteurJeu.MoteurJeu;

import java.io.IOException;
import Labyrinthe.LabyDessin;

/**
 * charge et affiche un labyrinthe
 */
public class MainLaby {
    public static void main(String[] args) throws IOException {
        MoteurJeu.setFPS(30);

        Labyrinthe laby = new Labyrinthe();

        // charge le labyrinthe
        LabyJeu labyjeu = new LabyJeu(laby);
        LabyDessin ld = new LabyDessin();

        MoteurJeu.launch(labyjeu, ld);
    }
}
