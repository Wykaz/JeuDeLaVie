package fr.sdv.thomasb.automates;

public enum Figure {

    BLINKER("Clignotant", 2, new boolean[][]{
            {false, false, false},
            {true, true, true},
            {false, false, false}
    }),
    SINGLE_OSCILLATOR("Oscillateur seul", 3, new boolean[][]{
        {false, false, false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, true, false, false, false, false, false, false},
        {false, false, false, false, false, true, true, true, false, false, false, false, false},
        {false, false, false, true, true, true, false, true, true, true, false, false, false},
        {false, false, false, true, false, false, false, false, false, true, false, false, false},
        {false, false, true, true, false, false, false, false, false, true, true, false, false},
        {false, true, true, false, false, false, false, false, false, false, true, true, false},
        {false, false, true, true, false, false, false, false, false, true, true, false, false},
        {false, false, false, true, false, false, false, false, false, true, false, false, false},
        {false, false, false, true, true, true, false, true, true, true, false, false, false},
        {false, false, false, false, false, true, true, true, false, false, false, false, false},
        {false, false, false, false, false, false, true, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false, false, false},
    }),
    OSCILLATOR_LOWER_LEFT_BLOCK("Oscillateur avec un bloc en bas à gauche", 3, new boolean[][]{
            {false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, true, false, false, false, false, false, false},
            {false, false, false, false, false, true, true, true, false, false, false, false, false},
            {false, false, false, true, true, true, false, true, true, true, false, false, false},
            {false, false, false, true, false, false, false, false, false, true, false, false, false},
            {false, false, true, true, false, false, false, false, false, true, true, false, false},
            {false, true, true, false, false, false, false, false, false, false, true, true, false},
            {false, false, true, true, false, false, false, false, false, true, true, false, false},
            {false, false, false, true, false, false, false, false, false, true, false, false, false},
            {false, false, false, true, true, true, false, true, true, true, false, false, false},
            {false, true, true, false, false, true, true, true, false, false, false, false, false},
            {false, true, true, false, false, false, true, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false},
    }),
    OSCILLATOR_FOUR_BLOCK("Oscillateur entouré de quatre blocs", 3, new boolean[][]{
            {false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, true, true, false, false, false, true, false, false, false, true, true, false},
            {false, true, true, false, false, true, true, true, false, false, true, true, false},
            {false, false, false, true, true, true, false, true, true, true, false, false, false},
            {false, false, false, true, false, false, false, false, false, true, false, false, false},
            {false, false, true, true, false, false, false, false, false, true, true, false, false},
            {false, true, true, false, false, false, false, false, false, false, true, true, false},
            {false, false, true, true, false, false, false, false, false, true, true, false, false},
            {false, false, false, true, false, false, false, false, false, true, false, false, false},
            {false, false, false, true, true, true, false, true, true, true, false, false, false},
            {false, true, true, false, false, true, true, true, false, false, true, true, false},
            {false, true, true, false, false, false, true, false, false, false, true, true, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false},
    }),
    CROSS("Une croix", 3, new boolean[][]{
            {false, false, false, false, false, false, false, false, false, false},
            {false, false, false, true, true, true, true, false, false, false},
            {false, false, false, true, false, false, true, false, false, false},
            {false, true, true, true, false, false, true, true, true, false},
            {false, true, false, false, false, false, false, false, true, false},
            {false, true, false, false, false, false, false, false, true, false},
            {false, true, true, true, false, false, true, true, true, false},
            {false, false, false, true, false, false, true, false, false, false},
            {false, false, false, true, true, true, true, false, false, false},
            {false, false, false, false, false, false, false, false, false, false},
    }),
    DIAGONAL("Une diagonale", 3, new boolean[][]{
            {false, false, false, false, false, false, false, true, true},
            {false, false, false, false, false, false, false, true, false},
            {false, false, false, false, false, false, false, true, false},
            {false, false, false, false, true, true, false, true, false},
            {false, false, false, true, false, false, true, false, false},
            {false, false, false, true, true, false, false, false, false},
            {false, false, false, false, true, true, false, false, false},
            {false, false, true, false, false, true, false, false, false},
            {false, true, false, true, true, false, false, false, false},
            {false, true, false, false, false, false, false, false, false},
            {true, true, false, false, false, false, false, false, false},
    })
    ;

    /**
     * Nom de la figure
     */
    private final String name;

    /**
     * La période d'oscillation de la figure
     */
    private final int oscillationPeriod;

    /**
     * La figure
     */
    private final boolean[][] figure;

    /**
     * Constructeur pour les figures
     * @param name Nom de la figure
     * @param oscillationPeriod Période d'oscillation de la figure
     * @param figure La figure
     */
    Figure(String name, int oscillationPeriod, boolean[][] figure) {
        this.name = name;
        this.oscillationPeriod = oscillationPeriod;
        this.figure = figure;
    }

    /**
     * Retourne le nom de la figure.
     * @return le nom de la figure.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retourne la période d'oscillation de la figure.
     * @return la période d'oscillation de la figure.
     */
    public int getOscillationPeriod() {
        return this.oscillationPeriod;
    }

    /**
     * Retourne la figure.
     * @return la figure.
     */
    public boolean[][] getFigure() {
        return figure;
    }
}
