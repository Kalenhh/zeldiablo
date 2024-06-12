import Entite.Monstre;
import Entite.Rouge;
import Interaction.InteractionRouge;
import Labyrinthe.Labyrinthe;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test_Rouge {

    private Rouge rouge;
    private Labyrinthe labyrinthe;

    @Before
    public void setUp() throws IOException {
        labyrinthe = new Labyrinthe();
        Labyrinthe.listeNoeud.add("0:0");
        Labyrinthe.listeNoeud.add("0:1");
        Labyrinthe.listeNoeud.add("1:0");
        Labyrinthe.listeNoeud.add("1:1");
        labyrinthe.setPersoX(1);
        labyrinthe.setPersoY(1);

        rouge = new Rouge(0, 0, 10, 5, labyrinthe);
    }

    @Test
    public void testConstructeur() {
        assertEquals(0, rouge.getX());
        assertEquals(0, rouge.getY());
        assertEquals(10, rouge.getPv());
        assertEquals(5, rouge.getDegats());
        assertNotNull(rouge.getInteraction());
        assertTrue(rouge.getInteraction() instanceof InteractionRouge);
    }

    @Test
    public void testSeDeplacerSansChemin() {
        Labyrinthe.listeNoeud.clear();
        Labyrinthe.listeNoeud.add("0:0");
        labyrinthe.setPersoX(1);
        labyrinthe.setPersoY(1);

        int ancienX = rouge.getX();
        int ancienY = rouge.getY();

        rouge.seDeplacer();
        int newX = rouge.getX();
        int newY = rouge.getY();

        // Vérifie que le monstre n'a pas été déplacé
        assertEquals(ancienX, newX);
        assertEquals(ancienY, newY);
    }

    @Test
    public void testGetAncienXEtAncienY() {
        rouge.seDeplacer();
        assertEquals(0, rouge.getAncienX());
        assertEquals(0, rouge.getAncienY());
    }
}