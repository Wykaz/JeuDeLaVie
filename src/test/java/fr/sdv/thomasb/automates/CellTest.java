package fr.sdv.thomasb.automates;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Classe de test de la classe Cell
 */
public class CellTest {

    /**
     * Test du constructeur par défaut
     */
    @Test
    public void testCell() {
        Cell cell = new Cell();
        assertFalse(cell.isAlive());
    }

    /**
     * Test du constructeur avec paramètre
     */
    @Test
    public void testCellBoolean() {
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

    /**
     * Test de la méthode isAlive avec une cellule morte
     */
    @Test
    public void testIsAliveOnDeadCell() {
        Cell cell = new Cell();
        assertFalse(cell.isAlive());
    }

    /**
     * Test de la méthode IsAlive avec une cellule vivante
     */
    @Test
    public void testIsAliveOnAliveCell() {
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

    /**
     * Test de la méthode setAlive
     */
    @Test
    public void testSetAlive() {
        Cell cell = new Cell();
        cell.setAlive(true);
        assertTrue(cell.isAlive());
    }

    /**
     * Test de la méthode setAlive avec un paramètre false
     */
    @Test
    public void testSetAliveFalse() {
        Cell cell = new Cell(true);
        cell.setAlive(false);
        assertFalse(cell.isAlive());
    }

    /**
     * Test de la méthode nextGeneration avec un nombre de voisins inférieur à 2.
     */
    @Test
    public void testNextGenerationWithLessThanTwoNeighbors() {
        Cell cell = new Cell(true);
        cell.nextGeneration(1);
        assertFalse(cell.isAlive());
    }

    /**
     * Test de la méthode nextGeneration avec un nombre de voisins égal à 2.
     */
    @Test
    public void testNextGenerationWithTwoNeighbors() {
        Cell cell = new Cell(true);
        cell.nextGeneration(2);
        assertTrue(cell.isAlive());
    }

    /**
     * Test de la méthode nextGeneration avec un nombre de voisins égal à 2 et une cellule morte
     */
    @Test
    public void testNextGenerationWithTwoNeighborsAndDeadCell() {
        Cell cell = new Cell();
        cell.nextGeneration(2);
        assertFalse(cell.isAlive());
    }

    /**
     * Test de la méthode nextGeneration avec un nombre de voisins égal à 3.
     */
    @Test
    public void testNextGenerationWithThreeNeighbors() {
        Cell cell = new Cell(true);
        cell.nextGeneration(3);
        assertTrue(cell.isAlive());
    }

    /**
     * Test de la méthode nextGeneration avec un nombre de voisins égal à 3 et une cellule morte
     */
    @Test
    public void testNextGenerationWithThreeNeighborsAndDeadCell() {
        Cell cell = new Cell();
        cell.nextGeneration(3);
        assertTrue(cell.isAlive());
    }

    /**
     * Test de la méthode nextGeneration avec un nombre de voisins supérieur à 3.
     */
    @Test
    public void testNextGenerationWithMoreThanThreeNeighbors() {
        Cell cell = new Cell(true);
        cell.nextGeneration(4);
        assertFalse(cell.isAlive());
    }

    /**
     * Test de la méthode nextGeneration avec un nombre de voisins égal à 1 et une cellule morte
     */
    @Test
    public void testNextGenerationWithOneNeighborsAndDeadCell() {
        Cell cell = new Cell();
        cell.nextGeneration(1);
        assertFalse(cell.isAlive());
    }
}