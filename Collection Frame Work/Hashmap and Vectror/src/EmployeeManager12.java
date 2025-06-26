import java.util.*;

// Employee class
class Employee {
    int id;
    String name;
    double salary;

    // Constructor
    public Employee(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public void display()
    {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary:" + salary);
    }
}

public class EmployeeManager12 {
    public static void main(String[] args) {
        //Vector to store all employees (ordered, index-based)
        Vector<Employee> employeeList = new Vector<>();
        // HashMap to search employee by ID (fast lookup)
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        // Adding employees
        Employee e1 = new Employee(101, "Kank", 50000);
        Employee e2 = new Employee(102, "Nancy", 60000);
        Employee e3 = new Employee(103, "Rahul", 55000);

        // Add to Vector
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        // Add to HashMap
        employeeMap.put(e1.id, e1);
        employeeMap.put(e2.id, e2);
        employeeMap.put(e3.id, e3);

        // 1Vector output (ordered)
        System.out.println(" All Employees (from Vector):");
        for (Employee emp : employeeList) {
            emp.display();
        }

        // 2HashMap output (search by ID)
        System.out.println("\n Search Employee by ID using HashMap:");
        int searchId = 102;
        if (employeeMap.containsKey(searchId)) {
            System.out.print("Employee Found: ");
            employeeMap.get(searchId).display();
        } else {
            System.out.println("Employee ID " + searchId + " not found.");
        }

        // Update salary using HashMap (key-based update)
        System.out.println("\n Updating Salary of Employee ID 103...");
        Employee empToUpdate = employeeMap.get(103);
        if (empToUpdate != null) {
            empToUpdate.salary = 58000;
        }

        // Re-print all employees to confirm update
        System.out.println("\nUpdated Employees (from Vector):");
        for (Employee emp : employeeList) {
            emp.display(); // Updated data reflects here too!
        }
    }
}

