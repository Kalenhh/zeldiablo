import Labyrinthe.ScoreJeu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestScore {
    @Test
    public void test_mauvaisFichier(){
        assertThrows(IOException.class, () -> new ScoreJeu("feur.txt"));
    }
}
