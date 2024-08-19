import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Employee implements Comparable<Employee>, Cloneable {

    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Method to display employee details
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }

    // Overriding compareTo method for sorting by ID
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    // Overriding clone method to ensure cloneability
    @Override
    protected Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported for Employee", e);
        }
    }

    // Main method to demonstrate sorting and cloneability
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "John", 55000));
        employees.add(new Employee(1, "Alice", 75000));
        employees.add(new Employee(2, "Bob", 65000));

        // Sorting by ID using Comparable
        System.out.println("Sorting by ID (using Comparable):");
        Collections.sort(employees);
        displayEmployees(employees);

        // Sorting by Name using Comparator
        System.out.println("\nSorting by Name (using Comparator):");
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });
        displayEmployees(employees);

        // Sorting by Salary using Comparator
        System.out.println("\nSorting by Salary (using Comparator):");
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        displayEmployees(employees);

        // Cloning an Employee
        System.out.println("\nCloning the first Employee:");
        Employee clonedEmployee = employees.get(0).clone();
        System.out.println("Original: " + employees.get(0));
        System.out.println("Cloned: " + clonedEmployee);

        // Iterating over employees using enhanced for loop
        System.out.println("\nIterating over employees using enhanced for loop:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Iterating over employees using an iterator
        System.out.println("\nIterating over employees using an iterator:");
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Utility method to display the list of employees
    public static void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}