package view;

import java.util.List;
import java.util.Scanner;

import model.Todo;
import repository.TodoCRUD;

public class Interface {

    public static void launchApp() {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 6) {
            System.out.println("=== TODO Menu ===");
            System.out.println("1 : Show all todo");
            System.out.println("2 : Find a todo");
            System.out.println("3 : Change todo");
            System.out.println("4 : Insert todo");
            System.out.println("5 : Delete Todo");
            System.out.println("6 : Quit");

            System.out.print("What's your choice: ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                // Ajoutez votre logique pour l'option 1 ici
                System.out.println("All todos --");
                    List<Todo> allTodo = TodoCRUD.findAllTasks();
                    for (Todo task : allTodo) {
                        System.out.println(task.getId() + ". Title: " + task.getTitle() + "\n\tDescription: "
                                + task.getDescription() + "\n\tDeadline: " + task.getDeadline().toString().replace("T", " ") + "\n\tPriority: "
                                + task.getPriority() + "\n\tDone: " + task.isDone());
                    }
                    break;

                case 2:
                    // For find a task by id
                    System.out.println("Find a task -- ");
                    break;
                case 3:
                    // Update a task
                    System.out.println("Update task -- ");
                    break;

                case 4:
                    // Add new task
                    System.out.println("Add new task -- \n"
                        +"new Title : ");
                    String newTitle = scanner.next();
                    scanner.nextLine();
                    
                    System.out.println("new Description : ");
                    String newDescription = scanner.nextLine();
                    
                    System.out.println("new Deadline (yyyy-MM-dd HH:mm:ss) : ");
                    String newDeadline = scanner.nextLine();
                    
                    System.out.println("new Priority (Number) : ");
                    int newPriority = scanner.nextInt();

                    System.out.println(newTitle +" "+ newDescription +" "+ newDeadline +" "+ newPriority);

                    TodoCRUD.addTask(newTitle, newDescription, newDeadline, newPriority);
                    break;

                case 5:
                    // Delete a task
                    System.out.println("Delete a task -- \n"
                        + "Enter number of task you want to delete : ");
                    int _id = scanner.nextInt();

                    Todo taskD = TodoCRUD.findTaskById(_id);
                    TodoCRUD.deleteTaskById(_id);
                    System.out.println("Delete : " + taskD.getTitle());
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
