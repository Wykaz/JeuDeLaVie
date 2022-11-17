package fr.sdv.thomasb.automates;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe Menu
 */
public class Menu {

    /**
     * Retourne la figure choisie par l'utilisateur
     *
     * @return Figure choisie par l'utilisateur
     */
    public Figure getFigure() {
        Figure figureGame = null;
        do {
            System.out.println("Choisissez une figure : ");
            for (Figure figure : Figure.values()) {
                System.out.println(figure.ordinal() + " - " + figure.getName());
            }
            try {
                int figureIndex = new Scanner(System.in).nextInt();

                if (figureIndex >= 0 && figureIndex < Figure.values().length) {
                    figureGame = Figure.values()[figureIndex];
                    continue;
                }
            } catch (InputMismatchException ignored) {
            }
            System.out.println("Choix incorrect\n");
        } while (figureGame == null);
        return figureGame;
    }

    /**
     * Retourne le nombre de générations saisies par l'utilisateur
     *
     * @return Nombre de générations
     */
    public int getNumberGeneration() {
        int numberGeneration = 0;
        do {
            System.out.println("Choisissez un nombre de generation : ");
            try {

                int tempNumberGeneration = new Scanner(System.in).nextInt();
                if (tempNumberGeneration > 0) {
                    numberGeneration = tempNumberGeneration;
                    continue;
                }
            } catch (InputMismatchException ignored) {
            }
            System.out.println("Nombre de generation incorrect (doit être supérieur à 0)\n");
        } while (numberGeneration == 0);
        return numberGeneration;
    }

    /**
     * Retourne le temps de pause saisie par l'utilisateur
     *
     * @return Temps de pause
     */
    public int getPause() {
        int pause = 0;
        do {
            System.out.println("Choisissez un temps de pause en milliseconde entre chaque génération : ");
            try {
                int tempPause = new Scanner(System.in).nextInt();
                if (tempPause > 0) {
                    pause = tempPause;
                    continue;
                }
            } catch (InputMismatchException ignored) {
            }
            System.out.println("Temps de pause incorrect (doit être supérieur à 0)\n");
        } while (pause == 0);
        return pause;
    }

    /**
     * Retourne si l'utilisateur veut rejouer
     *
     * @return true si l'utilisateur veut rejouer, false sinon
     */
    public boolean isReplay() {
        Boolean replay = null; // Object de type Boolean pour avoir la valeur null
        do {
            System.out.println("Voulez-vous rejouer ? (O/N)");
            try {
                String replayInput = new Scanner(System.in).nextLine();
                if (replayInput.equalsIgnoreCase("O")) {
                    replay = true;
                } else if (replayInput.equalsIgnoreCase("N")) {
                    replay = false;
                }
            } catch (InputMismatchException ignored) {
            }
        } while (replay == null);
        return replay;
    }
}
