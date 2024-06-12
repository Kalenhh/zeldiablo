import Entite.Joueur;
import Entite.Perso;
import Interaction.InteractionJoueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test_Joueur {

    private Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur(0, 0, 10, 5);
    }

    @Test
    public void testConstructeur() {
        assertEquals(0, joueur.getX());
        assertEquals(0, joueur.getY());
        assertEquals(10, joueur.getPv());
        assertEquals(5, joueur.getDegats());
        assertNotNull(joueur.getInteraction());
        assertTrue(joueur.getInteraction() instanceof InteractionJoueur);
    }

    @Test
    public void testSeDeplacer() {
        // La méthode seDeplacer est vide, donc elle ne doit pas changer les coordonnées du joueur
        int ancienX = joueur.getX();
        int ancienY = joueur.getY();

        joueur.seDeplacer();

        assertEquals(ancienX, joueur.getX());
        assertEquals(ancienY, joueur.getY());
    }
}