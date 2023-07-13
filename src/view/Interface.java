package view;

import java.util.List;
import java.util.Scanner;

import model.Todo;
import repository.TodoCRUD;

public class Interface {
    private static Scanner scanner = new Scanner(System.in);

    public static void launchApp() {
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
                    getAllTodos();
                    break;
                case 2:
                    findTodo();
                    break;
                case 3:
                    updateTodo();
                    break;
                case 4:
                    addTodo();
                    break;
                case 5:
                    deleteTodo();
                    break;
                case 6:
                    // Quit
                    choix = 6;
                    System.out.println("Bye !!!");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
                    break;
            }
        }
        scanner.close();
    }

    // Get all tasks
    private static void getAllTodos() {
        System.out.println("All todos --");
        
        List<Todo> allTodo = TodoCRUD.findAllTasks();
        for (Todo task : allTodo) {
            System.out.println(task.getId() + ". Title: " + task.getTitle() + "\n\tDescription: "
                    + task.getDescription() + "\n\tDeadline: " + task.getDeadline().toString().replace("T", " ") + "\n\tPriority: "
                    + task.getPriority() + "\n\tDone: " + task.isDone());
        }
    }

    // For find a task
    private static void findTodo() {
        System.out.println("Find a task -- \n" 
            + "Search : ");
        String search = scanner.next();

        List<Todo> allTasks = TodoCRUD.findAllTasks();
        for (Todo task : allTasks) {
            if (task.getTitle().toUpperCase().contains(search.toUpperCase()) || task.getDescription().toUpperCase().contains(search.toUpperCase())) {
                System.out.println(task.getId() + ". Title: " + task.getTitle() + "\n\tDescription: "
                    + task.getDescription() + "\n\tDeadline: " + task.getDeadline().toString().replace("T", " ") + "\n\tPriority: "
                    + task.getPriority() + "\n\tDone: " + task.isDone());
            }
        }
    }

    // Update a task
    private static void updateTodo() {
        System.out.println("Update task --\n"
            + "Enter number of to do : ");
        int _id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter new title : ");
        String newTitle = scanner.nextLine();
        
        System.out.println("Enter new description : ");
        String newDescription = scanner.nextLine();
        
        System.out.println("Enter new deadline : ");
        String newDeadline = scanner.nextLine();
        
        System.out.println("Enter new priority : ");
        int newPriority = scanner.nextLine();
        
        System.out.println("Enter new done : ");
        int newDone = scanner.nextInt();
        
        Todo taskU = TodoCRUD.findTaskById(_id);
        TodoCRUD.updateTaskById(_id, newTitle, newDescription, newDeadline, newPriority, newDone);
        System.out.println("Task with id : " + taskU.getId() + " is updated successfuly.");
    }

    // Add new task
    private static void addTodo() {
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

        TodoCRUD.addTask(newTitle, newDescription, newDeadline, newPriority);
    }

    // Delete a task
    private static void deleteTodo() {
        System.out.println("Delete a task -- \n"
            + "Enter number of task you want to delete : ");
        int _id = scanner.nextInt();

        Todo taskD = TodoCRUD.findTaskById(_id);
        TodoCRUD.deleteTaskById(_id);
        System.out.println("Delete : " + taskD.getTitle());
    }
}
