import moteurJeu.MoteurJeu;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class Test_MoteurJeu{

    private MoteurJeu moteurJeu;

    @Before
    public void setUp() {
        moteurJeu = new MoteurJeu();
    }
    @Test
    public void testStopAnimation() {
        MoteurJeu.stopAnimation();

        // Assert
        assertNull(MoteurJeu.timer);
    }

    @Test
    public void testAfficherEcranGameOver() {
        MoteurJeu.afficherEcranGameOver();
    }

    @Test
    public void testQuitterJeu() {
        MoteurJeu.quitterJeu();
    }

    @Test
    public void testRetournerAuMenu() throws IOException {
        MoteurJeu.retournerAuMenu();

        // vérifier que le menu estaffiché
    }
}