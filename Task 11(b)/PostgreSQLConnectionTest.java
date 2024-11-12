import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnectionTest {

    public static void main(String[] args) {
        // Database URL, username, and password
        String jdbcURL = "jdbc:postgresql://localhost:5432/test"; // Database URL for PostgreSQL
        String username = "your_username"; // PostgreSQL username
        String password = "your_password"; // PostgreSQL password

        try {
            // Attempt to connect to the PostgreSQL database
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            
            // If the connection is successful
            System.out.println("Connected to the database");
            
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            // Handle invalid credentials
            if (e.getSQLState().equals("28P01")) {
                System.out.println("Invalid username or password");
            } else {
                // Handle other SQL exceptions
                e.printStackTrace();
            }
        }
    }
}
