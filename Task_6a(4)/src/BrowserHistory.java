import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {

    // Deque to store history for back and forward navigation
    private Deque<String> backStack;
    private Deque<String> forwardStack;
    private String currentPage;

    // Constructor to initialize the browser history
    public BrowserHistory() {
        backStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
        currentPage = null;
    }

    // Method to add a new page to the history
    public void visit(String page) {
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        currentPage = page;
        forwardStack.clear();  // Clear forward history on new visit
        System.out.println("Visited: " + page);
    }

    // Method to go back to the previous page
    public void goBack() {
        if (backStack.isEmpty()) {
            System.out.println("No pages in the back history.");
        } else {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            System.out.println("Went back to: " + currentPage);
        }
    }

    // Method to go forward to the next page
    public void goForward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No pages in the forward history.");
        } else {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            System.out.println("Went forward to: " + currentPage);
        }
    }

    // Method to display the current page
    public void displayCurrentPage() {
        if (currentPage == null) {
            System.out.println("No current page.");
        } else {
            System.out.println("Current page: " + currentPage);
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBrowser History:");
            System.out.println("1. Visit New Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Display Current Page");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter page URL: ");
                    String page = scanner.nextLine();
                    browserHistory.visit(page);
                    break;
                case 2:
                    browserHistory.goBack();
                    break;
                case 3:
                    browserHistory.goForward();
                    break;
                case 4:
                    browserHistory.displayCurrentPage();
                    break;
                case 5:
                    System.out.println("Exiting Browser History.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}