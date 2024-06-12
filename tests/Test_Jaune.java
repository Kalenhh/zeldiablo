import Entite.Jaune;
import Labyrinthe.Labyrinthe;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class Test_Jaune {

    private Jaune jaune;
    private Labyrinthe labyrinthe;

    @Before
    public void setUp() throws IOException {
        labyrinthe = new Labyrinthe();
        labyrinthe.listeNoeud.add("0:0");
        labyrinthe.listeNoeud.add("0:1");
        labyrinthe.listeNoeud.add("1:0");
        labyrinthe.listeNoeud.add("1:1");

        jaune = new Jaune(0, 0, 10, 5);
    }

    @Test
    public void testSeDeplacer() {
        int ancienX = jaune.getX();
        int ancienY = jaune.getY();

        jaune.seDeplacer();
        int newX = jaune.getX();
        int newY = jaune.getY();

        // Vérifie que le monstre a été déplacé dans une direction aléatoire
        assertTrue(newX == 0 || newX == 1);
        assertTrue(newY == 0 || newY == 1);
    }

    @Test
    public void testPositionsPossibles() {
        jaune.seDeplacer();
        List<int[]> positionsPossibles = jaune.getPositionsPossibles();

        // Vérifie que la liste des positions possibles n'est pas vide
        assertNotNull(positionsPossibles);
        assertFalse(positionsPossibles.isEmpty());

        // Vérifie que les positions possibles sont des positions valides dans le labyrinthe
        for (int[] position : positionsPossibles) {
            String positionStr = position[0] + ":" + position[1];
            assertTrue(labyrinthe.listeNoeud.contains(positionStr));
        }
    }

    @Test
    public void testAncienXEtAncienY() {
        int ancienX = jaune.getX();
        int ancienY = jaune.getY();

        jaune.seDeplacer();

        // Vérifie que les anciennes positions ont été mises à jour
        assertEquals(ancienX, jaune.getAncienX());
        assertEquals(ancienY, jaune.getAncienY());
    }

    @Test
    public void testGetXGetY() {
        assertEquals(0, jaune.getX());
        assertEquals(0, jaune.getY());
    }
}