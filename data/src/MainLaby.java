import moteurJeu.MoteurJeu;
import java.io.IOException;

/**
 * charge et affiche un labyrinthe
 */
public class MainLaby {
    public static void main(String[] args) throws IOException {

        MoteurJeu mj = new MoteurJeu();
        mj.setFPS(30);
        mj.setTaille(500,500);

        // charge le labyrinthe
        LabyJeu laby = new LabyJeu("data/laby/laby1.txt");
        LabyDessin ld = new LabyDessin();

        mj.launch(laby,ld);


    }
}
