package ListTests;

import Lists.ProdukteBaum;
import Objects.Produkt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class ProdukteBaumTest {

    static Random random = new Random();

    @Test
    void testAdd() throws Exception
    {
        ProdukteBaum baum = new ProdukteBaum();

        Produkt[] produkts = productsCreator(4);

        baum.add(produkts[0]);
        baum.add(produkts[1]);
        baum.add(produkts[2]);
        baum.add(produkts[3]);

        assertEquals(produkts.length, baum.size());
        assertTrue(baum.contains(produkts[0]));
        assertTrue(baum.contains(produkts[1]));
        assertTrue(baum.contains(produkts[2]));
        assertTrue(baum.contains(produkts[3]));
    }

    @Test
    void testAddMany() throws Exception
    {
        ProdukteBaum baum = new ProdukteBaum();

        Produkt[] produkts = productsCreator(6);

        baum.addMany(produkts);

        assertEquals(produkts.length, baum.size());
        assertTrue(baum.contains(produkts[0]));
        assertTrue(baum.contains(produkts[1]));
        assertTrue(baum.contains(produkts[2]));
        assertTrue(baum.contains(produkts[3]));
        assertTrue(baum.contains(produkts[4]));
        assertTrue(baum.contains(produkts[5]));
    }

    @Test
    void testRemove() throws Exception
    {
        ProdukteBaum baum = new ProdukteBaum();

        Produkt[] produkts = productsCreator(6);

        baum.addMany(produkts);

        baum.remove(produkts[2]);
        baum.remove(produkts[4]);

        assertEquals(produkts.length - 2, baum.size());
        assertTrue(baum.contains(produkts[0]));
        assertFalse(baum.contains(produkts[1]));
        assertTrue(baum.contains(produkts[2]));
        assertTrue(baum.contains(produkts[3]));
        assertFalse(baum.contains(produkts[4]));
        assertTrue(baum.contains(produkts[5]));
    }

    // Im endeffekt unnötig da in allen anderen Tests schon vorausgesetzt
    // Trotzdem implementiert falls sich noch etwas ändern sollte
    @Test
    void testContains() throws Exception
    {
        ProdukteBaum baum = new ProdukteBaum();

        Produkt[] produkts = productsCreator(6);

        baum.addMany(produkts);

        assertTrue(baum.contains(produkts[0]));
        assertTrue(baum.contains(produkts[1]));
        assertTrue(baum.contains(produkts[2]));
        assertTrue(baum.contains(produkts[3]));
        assertTrue(baum.contains(produkts[4]));
        assertTrue(baum.contains(produkts[5]));
    }

    @Test
    void testSize() throws Exception
    {
        ProdukteBaum baum = new ProdukteBaum();

        Produkt[] produkts = productsCreator(6);

        assertEquals(6, baum.size());

        baum.remove(produkts[4]);

        assertEquals(5, baum.size());
    }

    private Produkt[] productsCreator(int amount) throws Exception
    {
        Produkt[] produkts = new Produkt[amount];

        for(int i = 0; i < amount; i++)
        {
            double ek = (double)random.nextInt(800);
            double vk = ek * 1.2;
            Produkt produkt = new Produkt("Produkt" + i, random.nextInt(3), ek, vk, random.nextInt(10));

            produkts[i] = produkt;
        }
        return produkts;
    }
}
