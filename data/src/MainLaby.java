import moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * charge et affiche un labyrinthe
 */
public class MainLaby {
    public static void main(String[] args) throws IOException {

        MoteurJeu.setFPS(30);
        MoteurJeu.setTaille(500, 500);

        Labyrinthe laby = new Labyrinthe("data/laby/laby1.txt");

        // charge le labyrinthe
        LabyJeu labyjeu = new LabyJeu(laby);
        LabyDessin ld = new LabyDessin();

        MoteurJeu.launch(labyjeu, ld);
    }
}
