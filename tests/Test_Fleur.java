import Item.Fleur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test_Fleur {

    private Fleur fleur;

    @Before
    public void setUp() {
        fleur = new Fleur(10, 5, 3, 4);
    }

    @Test
    public void testConstructeur() {
        assertEquals(3, fleur.getX());
        assertEquals(4, fleur.getY());
        assertEquals(10, fleur.getResistance());
        assertEquals(5, fleur.getDurabilite());
    }

    @Test
    public void testEtrePresent() {
        assertTrue(fleur.etrePresent(3, 4));
        assertFalse(fleur.etrePresent(4, 4));
        assertFalse(fleur.etrePresent(3, 5));
    }
}
