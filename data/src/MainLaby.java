import moteurJeu.MoteurJeu;
import java.io.IOException;

/**
 * charge et affiche un labyrinthe
 */
public class MainLaby {
    public static void main(String[] args) throws IOException {

        MoteurJeu.setFPS(30);
        MoteurJeu.setTaille(500,500);

        // charge le labyrinthe
        LabyJeu laby = new LabyJeu();
        LabyDessin ld = new LabyDessin();

        MoteurJeu.launch(laby,ld);


    }
}
