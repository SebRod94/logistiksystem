package ListTests;

import Lists.ArrList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrListTest {
    @Test
    void testAdd()
    {
        ArrList<String> list = new ArrList<String>();
        list.add("Hallo");
        list.add("Hallo");
        list.addMany(new String[]{"Hi", "Was", "Wie"});
        ArrList<String> testlist = new ArrList<String>(2);
        testlist.addMany(new String[]{"Wo", "Warum"});
        list.addMany(testlist);
        list.add("Hallo");
        list.add("Hallo");
        list.add("Hallo");
        list.add("Hallo");

        String[] str = new String[]{"Hallo", "Hallo", "Hi", "Was", "Wie", "Wo", "Warum", "Hallo", "Hallo", "Hallo", "Hallo"};

        assertArrayEquals(str, list.toArray());
    }

    @Test
    void testContains(){
        ArrList list = new ArrList();

        assertFalse(list.contains(0));

        list.add(1);
        list.add(2);
        list.add(3);

        assertFalse(list.contains(4));
        assertFalse(list.contains(0));
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }

    @Test
    void testInsert()
    {
        ArrList list = new ArrList();

        list.insert(1, 0);
        list.add(2);
        list.add(4);
        list.insert(3, 2);
        list.insert(0,0);

        assertEquals(5, list.size());

        Integer[] ints = new Integer[]{0,1,2,3,4};
        assertArrayEquals(ints, list.toArray());
    }

    @Test
    void testRemove()
    {
        ArrList list = new ArrList();

        list.addMany(new Integer[] {1, 2, 3, 4});

        list.remove(3);
        assertArrayEquals(new Integer[]{1, 2, 4}, list.toArray());

        list.removeByIndex(1);
        assertArrayEquals(new Integer[]{1, 4}, list.toArray());
    }

    @Test
    void testGet()
    {
        ArrList list = new ArrList();

        list.addMany(new Integer[] {1, 2, 3, 4});

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    void testSize()
    {
        ArrList list = new ArrList();

        list.addMany(new Integer[] {1, 2, 3, 4});

        assertEquals(4, list.size());

        list.addMany(new Integer[]{5, 6});

        assertEquals(6, list.size());
    }

    //To string methode nicht vorhanden
    /*@Test
    void testToString()
    {
        ArrList list = new ArrList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals("[1, 2, 3, 4]", list.toString());
    }*/
}
