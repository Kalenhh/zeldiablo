import Item.Piege;
import Interaction.InteractionPiege;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test_Piege {

    private Piege piege;

    @Before
    public void setUp() {
        piege = new Piege(10, 5, 3, 4);
    }

    @Test
    public void testConstructeur() {
        assertEquals(3, piege.getX());
        assertEquals(4, piege.getY());
        assertEquals(10, piege.getResistance());
        assertEquals(5, piege.getDurabilite());
        assertTrue(piege.etreOuvert());
    }

    @Test
    public void testEtreOuvert() {
        assertTrue(piege.etreOuvert());
        piege.fermerPiege();
        assertFalse(piege.etreOuvert());
    }

    @Test
    public void testFermerPiege() {
        assertTrue(piege.etreOuvert());
        piege.fermerPiege();
        assertFalse(piege.etreOuvert());
        piege.fermerPiege();
        assertFalse(piege.etreOuvert());
    }
}