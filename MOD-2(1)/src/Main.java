import java.util.*;

class Employee implements Comparable<Employee>, Cloneable, Iterable<Employee> {
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
    
    // Comparable interface: Natural ordering by id
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    // Cloneable interface: Deep copy of Employee
    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
    
    // Iterable interface: Allows iteration over a single Employee (not common but for demonstration)
    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Employee next() {
                if (hasNext) {
                    hasNext = false;
                    return Employee.this;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    // toString for easy printing
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }

    // Static Comparator for sorting by name
    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    // Static Comparator for sorting by salary
    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.getSalary(), e2.getSalary());
        }
    };
}

// Example usage
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "Alice", 70000));
        employees.add(new Employee(1, "Bob", 50000));
        employees.add(new Employee(2, "Charlie", 60000));

        // Natural ordering by id
        Collections.sort(employees);
        System.out.println("Sorted by ID: " + employees);

        // Sorting by name using Comparator
        Collections.sort(employees, Employee.NameComparator);
        System.out.println("Sorted by Name: " + employees);

        // Sorting by salary using Comparator
        Collections.sort(employees, Employee.SalaryComparator);
        System.out.println("Sorted by Salary: " + employees);

        // Cloning an employee
        Employee clonedEmployee = employees.get(0).clone();
        System.out.println("Cloned Employee: " + clonedEmployee);

        // Iterating over employees
        for (Employee employee : employees) {
            System.out.println("Iterating: " + employee);
        }
    }
}