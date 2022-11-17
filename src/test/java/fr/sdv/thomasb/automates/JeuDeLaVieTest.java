package fr.sdv.thomasb.automates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test du jeu de la vie
 */
public class JeuDeLaVieTest {

    /**
     * Teste de la méthode toString
     */
    @Test
    public void testToString() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{
                {false, false, false},
                {false, true, false},
                {false, false, false}
        });

        assertEquals("""
                | | | |
                | |X| |
                | | | |
                """, jeuDeLaVie.toString());
    }

    /**
     * Teste la méthode nextGeneration
     */
    @Test
    public void testNextGeneration() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        });

        jeuDeLaVie.nextGeneration();

        assertEquals(new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false},
        }), jeuDeLaVie);
    }

    /**
     * Teste la méthode nextGeneration avec une oscillation simple
     */
    @Test
    public void testNextGenerationOscillationSimple() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, true, true, true, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        });

        jeuDeLaVie.nextGeneration();

        assertEquals(new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, true, false, false, false, false},
                {false, false, false, false, false, true, false, false, false, false},
                {false, false, false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        }), jeuDeLaVie);

        jeuDeLaVie.nextGeneration();

        assertEquals(new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, true, true, true, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        }), jeuDeLaVie);
    }

    /**
     * Teste la création d'un jeu de la vie avec une grille null
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNextGenerationGrilleNull() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(null);
        jeuDeLaVie.nextGeneration();
    }

    /**
     * Teste la création d'un jeu de la vie avec une grille vide
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNextGenerationGrilleEmpty() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{});
        jeuDeLaVie.nextGeneration();
    }

    /**
     * Teste la création d'un jeu de la vie avec une grille de taille 1
     */
    @Test
    public void testNextGenerationGrilleSize1() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{{true}});

        jeuDeLaVie.nextGeneration();

        assertEquals(new JeuDeLaVie(new boolean[][]{
                {false}
        }), jeuDeLaVie);
    }


    /**
     * Teste de la méthode numberVoisins
     */
    @Test
    public void testNumberVoisins() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, true, true, true, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        });
        assertEquals(3, jeuDeLaVie.numberNeighbors(5, 3));
    }

    /**
     * Teste de la méthode numberVoisins quand on est sur un bord
     */
    @Test
    public void testNumberVoisinsBord() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        });
        assertEquals(1, jeuDeLaVie.numberNeighbors(4, 0));
    }

    /**
     * Teste de la méthode numberVoisins quand on est sur un coin
     */
    @Test
    public void testNumberVoisinsCoin() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, true, false, false, false, false}
        });
        assertEquals(1, jeuDeLaVie.numberNeighbors(0, 0));
    }

    /**
     * Teste de la méthode numberVoisins quand on est sur une cellule vivante
     */
    @Test
    public void testNumberVoisinsCelluleVivante() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, true, true, true, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        });
        assertEquals(2, jeuDeLaVie.numberNeighbors(4, 5));
    }

    /**
     * Teste de la méthode numberVoisins quand on est hors du tableau
     */
    @Test
    public void testNumberVoisinsHorsTableau() {
        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(new boolean[][]{
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, true, true, true, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false}
        });
        assertEquals(0, jeuDeLaVie.numberNeighbors(10, 10));
    }
}