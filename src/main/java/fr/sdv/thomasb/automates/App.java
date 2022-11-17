package fr.sdv.thomasb.automates;

public class App {

    public static void main(String[] args) {
        Menu menu = new Menu();
        do {
            Figure figureGame = menu.getFigure();
            int numberGeneration = menu.getNumberGeneration();
            int pause = menu.getPause();

            JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(figureGame.getFigure());
            System.out.println("Generation 0 (debut)");
            jeuDeLaVie.print();
            jeuDeLaVie.play(numberGeneration, pause);
        } while (menu.isReplay());
    }
}
