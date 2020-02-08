package fr.cnam.tp5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetTest {
    private static String setClassName;

    private Set set;
    private int[] tab0;
    private int[] tab1;
    private int[] tab2;
    private int[] tab3;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage : java SetTest <réalisation>" + "\n"
                    + "\t" + "où <réalisation> est la réalisation "
                    + "de Set à tester");
            System.exit(1);
        }
        setClassName = args[0];

        org.junit.runner.JUnitCore.main("fr.cnam.tp5.SetTest");
        junit.textui.TestRunner.run(new junit.framework.TestSuite(SetTest.class));
    }

    private static void addAll(Set ens, int... elements) {
        for (int n : elements) {
            ens.add(n);
        }
    }

    @Before
    public void setUp() throws Exception {
        this.tab0 = new int[]{10, 15, -5};
        this.tab1 = new int[]{10, 15, 12, 5, 20, -5, 0};
        this.tab2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.tab3 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        this.set = SetFabric.newSetFrom(SetTest.setClassName, 10);
    }

    @Test
    public void testInitEmpty() {
        assertNotNull(this.set);
        assertTrue(this.set.isEmpty());
        assertEquals(0, this.set.cardinal());
    }

    @Test
    public void testAddFirst() {
        assertTrue(this.set.isEmpty());
        this.set.add(10);
        assertFalse(this.set.isEmpty());
        assertEquals(1, this.set.cardinal());
        assertTrue(this.set.contains(10));
    }

    @Test
    public void testAddMultipleTimes() {
        assertTrue(this.set.isEmpty());
        this.set.add(10);
        this.set.add(10);
        this.set.add(10);
        this.set.add(10);
        assertFalse(this.set.isEmpty());
        assertEquals(1, this.set.cardinal());
        assertTrue(this.set.contains(10));
    }

    @Test
    public void testAddThreeElements() {
        this.set.add(10);
        this.set.add(15);
        this.set.add(-5);
        assertEquals(3, this.set.cardinal());
        assertTrue(this.set.contains(10));
        assertTrue(this.set.contains(-5));
        assertTrue(this.set.contains(15));
    }

    @Test
    public void testContains() {
        this.set.add(10);
        this.set.add(15);
        this.set.add(-5);
        assertEquals(3, this.set.cardinal());
        assertTrue(this.set.contains(10));
        assertTrue(this.set.contains(-5));
        assertTrue(this.set.contains(15));
        assertFalse(this.set.contains(1));
        assertFalse(this.set.contains(2));
        assertFalse(this.set.contains(100));
        assertFalse(this.set.contains(0));
    }

    @Test
    public void testRemoveAbsent() {
        addAll(this.set, this.tab0);
        assertFalse(this.set.contains(1));
        assertEquals(3, this.set.cardinal());
        this.set.remove(1);
        assertFalse(this.set.contains(1));
        assertEquals(3, this.set.cardinal());
        this.set.remove(1);
        this.set.remove(1);
        assertTrue(this.set.contains(10));
        assertTrue(this.set.contains(-5));
        assertTrue(this.set.contains(15));
        assertFalse(this.set.contains(1));
        assertFalse(this.set.contains(2));
        assertEquals(3, this.set.cardinal());
    }

    @Test
    public void testRemovePresent() {
        addAll(this.set, this.tab0);
        assertEquals(3, this.set.cardinal());
        assertTrue(this.set.contains(10));
        this.set.remove(10);
        assertFalse(this.set.contains(10));
        assertEquals(2, this.set.cardinal());
        this.set.remove(10);
        this.set.remove(10);
        assertFalse(this.set.contains(10));
        assertTrue(this.set.contains(-5));
        assertTrue(this.set.contains(15));
        assertFalse(this.set.contains(1));
        assertFalse(this.set.contains(2));
        assertEquals(2, this.set.cardinal());
    }

    @Test
    public void testRemoveSeveralCases() {
        addAll(this.set, this.tab0);
        this.set.remove(10);
        assertFalse(this.set.contains(10));
        this.set.remove(-5);
        assertFalse(this.set.contains(10));
        assertFalse(this.set.contains(-5));
        assertTrue(this.set.contains(15));
        assertFalse(this.set.contains(1));
        assertFalse(this.set.contains(2));
        assertEquals(1, this.set.cardinal());

        this.set.remove(15);
        assertFalse(this.set.contains(10));
        assertFalse(this.set.contains(-5));
        assertFalse(this.set.contains(15));
        assertFalse(this.set.contains(1));
        assertFalse(this.set.contains(2));
        assertEquals(0, this.set.cardinal());
        assertTrue(this.set.isEmpty());
    }

    @Test
    public void testMin() {
        // Ajout d'éléments
        this.set.add(10);
        assertEquals(10, this.set.min());
        this.set.add(15);
        assertEquals(10, this.set.min());
        this.set.add(5);
        assertEquals(5, this.set.min());
        this.set.add(44);
        assertEquals(5, this.set.min());
        this.set.add(-5);
        assertEquals(-5, this.set.min());

        // Suppression d'éléments
        this.set.remove(10);
        assertEquals(-5, this.set.min());
        this.set.remove(-5);
        assertEquals(5, this.set.min());
        this.set.remove(5);
        assertEquals(15, this.set.min());
        this.set.remove(44);
        assertEquals(15, this.set.min());
        this.set.remove(15);
        assertTrue(this.set.isEmpty());
    }

    private void testWithArray(int[] tab) {
        int min = tab[0];
        for (int i = 0; i < tab.length; i++) {
            this.set.add(tab[i]);
            min = Math.min(min, tab[i]);
            assertEquals(min, this.set.min());
            assertEquals(i + 1, this.set.cardinal());
            for (int j = 0; j <= i; j++) {
                assertTrue(this.set.contains(tab[j]));
            }
            for (int j = i + 1; j < tab.length; j++) {
                assertFalse(this.set.contains(tab[j]));
            }
        }
    }

    @Test
    public void testWithArray1() {
        testWithArray(this.tab1);
    }

    @Test
    public void testWithArray2() {
        testWithArray(this.tab2);
    }

    @Test
    public void testWithArray3() {
        testWithArray(this.tab3);
    }

    @Test
    public void testArrayFull() throws Exception {
        this.set = SetFabric.newSetFrom(SetTest.setClassName, 4);
        addAll(this.set, 1, 2, 3, 4);
        assertEquals(4, this.set.cardinal());
        assertTrue(this.set.contains(4));
        assertFalse(this.set.contains(5));
        this.set.remove(5);
        this.set.add(4);
    }

    @Test
    public void testArrayOverflow() throws Exception {
        this.set = SetFabric.newSetFrom(SetTest.setClassName, 2);
        addAll(this.set, 1, 2, 3);
        assertEquals(3, this.set.cardinal());
        assertTrue(this.set.contains(1));
        assertTrue(this.set.contains(2));
        assertTrue(this.set.contains(3));
    }

    @Test
    public void testInitialCapacityIsOne() throws Exception {
        this.set = SetFabric.newSetFrom(SetTest.setClassName, 1);
        addAll(this.set, 1, 2);
        assertEquals(2, this.set.cardinal());
        assertTrue(this.set.contains(1));
    }

}