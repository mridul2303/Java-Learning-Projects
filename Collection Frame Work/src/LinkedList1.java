import java.util.*;

class Student {
    int id;
    String name;
    double salary;

    Student(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Student(id=" + id + ", name=" + name + ", salary=" + salary + ")";
    }
}
public class LinkedList1 {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();

        students.add(new Student(1, "Ramesh", 50000));
        students.add(new Student(2, "Suresh", 60000));
        students.add(new Student(3, "Kamlesh", 40000));

        Scanner sc = new Scanner(System.in);

        // Search by name
        System.out.print("Enter student name to search: ");
        String searchName = sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(searchName)) {
                System.out.println("Student found: " + s);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }

        // Sort by salary using Comparator
        students.sort(Comparator.comparingDouble(s -> s.salary));
        System.out.println("Students sorted by salary:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

