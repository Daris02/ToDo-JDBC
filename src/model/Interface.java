package model;

import java.util.Scanner;

public class Interface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        while (choix != 6){
        System.out.println("=====TODO Menu=====");
        System.out.println("1 : Show all todo");
        System.out.println("2 : ??");
        System.out.println("3 : Change todo");
        System.out.println("4 : Insert todo");
        System.out.println("5 : Delete Todo");
        System.out.println("6 : Quit");

            System.out.println("What's your choice: ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    //System.out.println("Option 1 sélectionnée");
                    // Ajoutez votre logique pour l'option 1 ici
                    Todo first = Fonctionnement.findTodoByid(1);
                    System.out.println("Our todo are: \n" + first);
                    break;
                case 2:
                    System.out.println("Option 2 sélectionnée");
                    // Ajoutez votre logique pour l'option 2 ici
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    break;
                case 4:
                    Todo inserer = Fonctionnement.Inseretion(Insert);
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }
}
