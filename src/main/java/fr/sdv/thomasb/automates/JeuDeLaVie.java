package fr.sdv.thomasb.automates;

/**
 * La classe JeuDeLaVie permet de gérer un jeu de la vie
 */
public class JeuDeLaVie {

    /**
     * La grille de jeu
     */
    private final Cell[][] grid;

    /**
     * Constructeur de la classe
     *
     * @param grid la grille de jeu
     */
    public JeuDeLaVie(boolean[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("La grille ne peut pas être null");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("La grille ne peut pas être vide");
        }

        this.grid = new Cell[grid.length][grid[0].length];

        // On initialise la grille
        for (int y = 0; y < grid.length; y++) { // Parcours des lignes
            for (int x = 0; x < grid[0].length; x++) { // Parcours des colonnes
                this.grid[y][x] = new Cell(grid[y][x]);
            }
        }
    }

    /**
     * Constructeur de la classe
     *
     * @param sizeX taille de la grille en X.
     * @param sizeY taille de la grille en Y.
     */
    public JeuDeLaVie(int sizeX, int sizeY) {
        if (sizeX <= 0) {
            throw new IllegalArgumentException("La taille X doit être supérieure à 0");
        }
        if (sizeY <= 0) {
            throw new IllegalArgumentException("La taille Y doit être supérieure à 0");
        }

        // On initialise la grille
        this.grid = initGrid(sizeX, sizeY);
    }

    /**
     * Set la cellule à l'index donné
     */
    public void setCell(int x, int y, boolean alive) {
        if (x < 0 || x >= grid.length) {
            throw new IllegalArgumentException("L'index X est incorrect");
        }
        if (y < 0 || y >= grid[0].length) {
            throw new IllegalArgumentException("L'index Y est incorrect");
        }
        if (grid[y][x] == null) {
            grid[y][x] = new Cell(alive);
        } else {
            grid[y][x].setAlive(alive);
        }
    }

    /**
     * Initialise la grille
     *
     * @param sizeX taille de la grille en X.
     * @param sizeY taille de la grille en Y.
     * @return la grille initialisée
     */
    private Cell[][] initGrid(int sizeX, int sizeY) {
        Cell[][] cell = new Cell[sizeY][sizeX];
        for (int y = 0; y < cell.length; y++) { // Parcours des lignes
            for (int x = 0; x < cell[0].length; x++) { // Parcours des colonnes
                cell[y][x] = new Cell();
            }
        }
        return cell;
    }

    /**
     * Crée une nouvelle grille de jeu de la vie
     */
    public void nextGeneration() {
        Cell[][] newGrid = initGrid(grid.length, grid[0].length);

        for (int y = 0; y < grid.length; y++) { // lignes
            for (int x = 0; x < grid[y].length; x++) { // colonnes
                final int numberNeighbors = numberNeighbors(x, y);
                Cell cell = new Cell(grid[y][x].isAlive());
                cell.nextGeneration(numberNeighbors);
                newGrid[y][x] = cell;
            }
        }

        // On remplace la grille par la nouvelle grille
        for (int y = 0; y < grid.length; y++) { // lignes
            for (int x = 0; x < grid[y].length; x++) { // colonnes
                grid[y][x] = newGrid[y][x];
            }
        }
    }

    /**
     * Retourne le nombre de voisins vivants d'une cellule
     *
     * @param x la position x de la cellule
     * @param y la position y de la cellule
     */
    public int numberNeighbors(int x, int y) {
        int numberNeighbors = 0; // le nombre de voisins vivants
        for (int k = y - 1; k <= y + 1; k++) { // parcours des lignes
            for (int l = x - 1; l <= x + 1; l++) { // parcours des colonnes
                if (k >= 0 && k < grid.length && l >= 0 && l < grid[k].length && // dans la grille et
                        !(k == y && l == x) && // pas la cellule et
                        grid[k][l].isAlive()) { // est vivant
                    numberNeighbors++;
                }
            }
        }
        return numberNeighbors;
    }

    /**
     * Affiche l'état de la grille dans la console
     */
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof JeuDeLaVie jeuDeLaVie)) { // si obj n'est pas une instance de JeuDeLaVie
            return false;
        }
        if (jeuDeLaVie.grid.length != grid.length) { // si le nombre de lignes est différent
            return false;
        }
        for (int y = 0; y < grid.length; y++) { // parcours des lignes
            if (jeuDeLaVie.grid[y].length != grid[y].length) { // si le nombre de colonnes est différent
                return false;
            }
            for (int x = 0; x < grid[y].length; x++) { // parcours des colonnes
                if (jeuDeLaVie.grid[y][x] == null || grid[y][x] == null ||// si une cellule est null
                        jeuDeLaVie.grid[y][x].isAlive() != grid[y][x].isAlive()) { // si les cellules sont différentes
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Cell[] y : grid) { // parcours des lignes
            for (Cell x : y) { // parcours des colonnes
                stringBuilder.append("|").append(x.toString());
            }
            stringBuilder.append("|").append("\n");
        }
        return stringBuilder.toString();
    }

    public void play(int numberGeneration, int delay) {
        for (int i = 0; i < numberGeneration; i++) {
            nextGeneration();
            System.out.println("Generation " + (i + 1));
            print();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
