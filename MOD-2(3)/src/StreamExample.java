import java.util.*;
import java.util.stream.*;

class Employee {
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

    // toString for easy printing
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

public class StreamExample {
    public static void main(String[] args) {
        // Create a list of 10 employees
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 70000),
            new Employee(2, "Bob", 50000),
            new Employee(3, "Charlie", 60000),
            new Employee(4, "David", 120000),
            new Employee(5, "Eve", 80000),
            new Employee(6, "Frank", 95000),
            new Employee(7, "Grace", 45000),
            new Employee(8, "Hannah", 110000),
            new Employee(9, "Ivy", 75000),
            new Employee(10, "Jack", 85000)
        );

        // 1. Filtering employees with salary greater than 75000
        System.out.println("Employees with salary > 75000:");
        List<Employee> highEarners = employees.stream()
            .filter(e -> e.getSalary() > 75000)
            .collect(Collectors.toList());
        highEarners.forEach(System.out::println);

        // 2. Sorting employees by salary
        System.out.println("\nEmployees sorted by salary:");
        List<Employee> sortedBySalary = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary))
            .collect(Collectors.toList());
        sortedBySalary.forEach(System.out::println);

        // 3. Finding the employee with the highest salary
        System.out.println("\nEmployee with the highest salary:");
        employees.stream()
            .max(Comparator.comparingDouble(Employee::getSalary))
            .ifPresent(System.out::println);

        // 4. Calculating the average salary
        System.out.println("\nAverage salary of employees:");
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);
        System.out.println("Average Salary: " + averageSalary);
    }
}