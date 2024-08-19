import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SupportTicketSystem {

    // Queue to store customer support tickets
    private Queue<String> ticketQueue;

    // Constructor to initialize the ticket queue
    public SupportTicketSystem() {
        ticketQueue = new LinkedList<>();
    }

    // Method to add a new ticket to the queue
    public void addTicket(String ticket) {
        ticketQueue.add(ticket);
        System.out.println("Ticket added: " + ticket);
    }

    // Method to process (remove) the next ticket in line
    public void processNextTicket() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets to process.");
        } else {
            String processedTicket = ticketQueue.poll();
            System.out.println("Processed ticket: " + processedTicket);
        }
    }

    // Method to display all pending tickets
    public void displayPendingTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Pending tickets:");
            for (String ticket : ticketQueue) {
                System.out.println("- " + ticket);
            }
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        SupportTicketSystem ticketSystem = new SupportTicketSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCustomer Support Ticket System:");
            System.out.println("1. Add Ticket");
            System.out.println("2. Process Next Ticket");
            System.out.println("3. Display Pending Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ticket description: ");
                    String ticket = scanner.nextLine();
                    ticketSystem.addTicket(ticket);
                    break;
                case 2:
                    ticketSystem.processNextTicket();
                    break;
                case 3:
                    ticketSystem.displayPendingTickets();
                    break;
                case 4:
                    System.out.println("Exiting Ticket System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}