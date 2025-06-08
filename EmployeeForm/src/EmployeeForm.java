import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeForm {
    public static void main(String[] args) {
new EmployeeList();
    }
}
class EmployeeList {
    ArrayList<Employee> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    EmployeeList() {
        while (true)
        System.out.println("press 1 to add");
        System.out.println("press 2 to view");
        System.out.println("press 3 to delete");
        System.out.println("press 4 to update");
        System.out.println("press 5 to find");
        System.out.println("press 6 to exit");
        int a = scanner.nextInt();
        scanner.nextLine(); //counsume new line
        switch (a) {
            case 1 -> add();
            case 2 -> view();
            case 3 -> delete();
            case 4 -> update();
            case 5 -> find();
            case 6 -> exit();
            default -> System.out.println("Invalid option.");
        }
    }

    private void add() {
        System.out.println("enter id");
        int id = scanner.nextInt();

        System.out.println("enter name");
        String name = scanner.nextLine();

        System.out.println("enter department");
        String department = scanner.nextLine();

        System.out.println("enter skills");
        String skills = scanner.nextLine();

        list.add(new Employee(id,name,department,skills));
        System.out.println("Employee added successfully");
    }

    private void view() {
        if (list.isEmpty()) {
            System.out.println("nothing to display");
            return;
        }
            System.out.println("\n--- Employee List ---");
        //This loop goes through each Employee object stored in that list
        ////Employee e is a temporary variable that represents each individual Employee object during each loop cycle.
            for (Employee e : list) {
                System.out.println(e);
            }
    }

    private void delete() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = list.removeIf(e -> e.getId() == id);
        //lambda expression: for each employee e, check if their ID matches the given id.
        //f any element is removed, removeIf returns true; otherwise, it returns false.
        if (removed) {
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }

    }

    private void update() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee e : list) {
            if (e.getId() == id) {
                System.out.print("Enter new Name: ");
                e.setName(scanner.nextLine());

                System.out.print("Enter new Department: ");
                e.setDepartment(scanner.nextLine());

                System.out.print("Enter new Skills: ");
                e.setSkills(scanner.nextLine());

                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    private void find() {
        System.out.print("Enter ID to find: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee e : list){
            if (e.getId() == id){
                System.out.println("employee found");
                System.out.println(e);
            }
        }

    }
    private void exit(){
        System.out.println("Exiting the program.");
        System.exit(0);

    }
}
class Employee {
    private int id;
    private String name;
    private String department;
    private String skills;

    public Employee(int id, String name, String department, String skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Skills: " + skills;
    }
}
