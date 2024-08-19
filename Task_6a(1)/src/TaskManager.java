import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    // List to store tasks
    private ArrayList<String> tasks;

    // Constructor to initialize the task list
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Method to add a task
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to update a task at a given index
    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
            System.out.println("Task updated at position " + index + ": " + newTask);
        } else {
            System.out.println("Invalid task position.");
        }
    }

    // Method to remove a task at a given index
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task position.");
        }
    }

    // Method to display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Manager:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    taskManager.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter task position to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    System.out.print("Enter new task description: ");
                    String newTask = scanner.nextLine();
                    taskManager.updateTask(updateIndex - 1, newTask);  // Convert to zero-based index
                    break;
                case 3:
                    System.out.print("Enter task position to remove: ");
                    int removeIndex = scanner.nextInt();
                    taskManager.removeTask(removeIndex - 1);  // Convert to zero-based index
                    break;
                case 4:
                    taskManager.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting Task Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}