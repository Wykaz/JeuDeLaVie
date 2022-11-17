package fr.sdv.thomasb.automates;

/**
 * Classe représentant une cellule
 */
public class Cell {

    /**
     * État de la cellule
     */
    private boolean alive;

    /**
     * Constructeur par défaut
     */
    public Cell() {
        this(false);
    }

    /**
     * Constructeur
     *
     * @param alive État de la cellule
     */
    public Cell(boolean alive) {
        this.alive = alive;
    }

    /**
     * Retourne l'état de la cellule
     *
     * @return État de la cellule
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Définit l'état de la cellule
     *
     * @param alive État de la cellule
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Définit l'état de la cellule en fonction du nombre de voisins vivants
     *
     * @param numberNeighbors Nombre de voisins vivants
     */
    public void nextGeneration(int numberNeighbors) {
        if (numberNeighbors < 2 || numberNeighbors > 3) {
            alive = false;
        } else if (numberNeighbors == 3) {
            alive = true;
        }
    }

    /**
     * Retourne la représentation textuelle de la cellule
     *
     * @return la représentation textuelle de la cellule
     */
    @Override
    public String toString() {
        return alive ? "X" : " ";
    }
}
