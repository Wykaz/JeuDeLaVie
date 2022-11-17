package fr.sdv.thomasb.automates;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class MenuTest {

    /**
     * Test de la méthode getFigure
     */
    @Test
    public void testGetFigure() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Menu menu = new Menu();

        Figure figure = menu.getFigure();

        assertNotNull(figure);
        assertEquals(Figure.DIAGONAL, figure);
    }

    /**
     * Test de la méthode getNumberGeneration
     */
    @Test
    public void testGetNumberGeneration() {
        String input = "8";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Menu menu = new Menu();

        int numberGeneration = menu.getNumberGeneration();

        assertEquals(8, numberGeneration);
    }

    /**
     * Test de la méthode getPause
     */
    @Test
    public void testGetPause() {
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Menu menu = new Menu();

        int pause = menu.getPause();

        assertEquals(1000, pause);
    }

    /**
     * Test de la méthode isReplay
     */
    @Test
    public void testIsReplay() {
        String input = "n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Menu menu = new Menu();

        boolean replay = menu.isReplay();

        assertFalse(replay);
    }
}
