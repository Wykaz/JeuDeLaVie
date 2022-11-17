package fr.sdv.thomasb.automates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FigureTest {

    /**
     * Test de la méthode getFigure
     */
    @Test
    public void testGetName() {
        assertEquals("Clignotant", Figure.BLINKER.getName());
    }

    /**
     * Test de la méthode getOscillationPeriod
     */
    @Test
    public void testGetOscillationPeriod() {
        assertEquals(2, Figure.BLINKER.getOscillationPeriod());
    }

    /**
     * Test de la méthode getFigure
     */
    @Test
    public void testGetFigure() {
        boolean[][] expected = new boolean[][]{
                {false, false, false},
                {true, true, true},
                {false, false, false}
        };
        boolean[][] actual = Figure.BLINKER.getFigure();

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }
}
