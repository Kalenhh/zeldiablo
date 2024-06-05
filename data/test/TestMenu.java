import javafx.scene.control.Button;
import javafx.scene.text.Text;
import moteurJeu.Menu;
import org.testng.annotations.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class TestMenu {

    private Menu menu;

    public void test_Constructeur() {
        //Initialisation
        menu = new Menu(800, 600);

        //Tests
        assertNotNull(menu);
    }

    @Test
    public void test_BoutonJouer() {
        //Initialisation
        menu = new Menu(800, 600);
        Button boutonJouer = menu.getBoutonJouer();

        //Tests
        assertNotNull(boutonJouer);
        assertEquals("Jouer", boutonJouer.getText());
        assertEquals(60, boutonJouer.getMinWidth(), 0.01);
        assertEquals(30, boutonJouer.getMinHeight(), 0.01);
    }

    @Test
    public void test_BoutonQuitter() {
        //Initialisation
        menu = new Menu(800, 600);
        Button boutonQuitter = menu.getBoutonQuitter();

        //Tests
        assertNotNull(boutonQuitter);
        assertEquals("Quitter", boutonQuitter.getText());
        //Bonne taille
        assertEquals(60, boutonQuitter.getMinWidth(), 0.01);
        assertEquals(30, boutonQuitter.getMinHeight(), 0.01);
    }

    @Test
    public void test_Texte() {
        //Initialisation
        menu = new Menu(800, 600);
        Text texte = menu.getTexte();

        //Tests
        assertNotNull(texte);
        assertTrue(texte.getText().contains("Bienvenue dans Blob Adventure\n l'objectif est simple : defendre votre labyrinthe contre les envahisseurs !"));
    }
}
