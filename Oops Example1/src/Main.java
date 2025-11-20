import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Employee e1 = new Manager(2,"Mradul Jain",25000f,"Software Development");
        Employee e2 = new Developer(2,"Amitt Sharma",20000f,"JAVA");
        Employee e3 = new Employee(2,"Rahul Jain",200000f);
//new Manager(...) → creates a Manager object in memory.
//
//Employee e1 → the reference variable e1 is of Employee type.
//
//Even though the object is a Manager, the variable is treated as an Employee reference.
//
//This is called Polymorphism (Upcasting).
        /*Because:
A Manager IS-A Employee
A Developer IS-A Employee*/

        list.add(e1);//manager
        list.add(e2);//developer
        list.add(e3);//normal employee
        for (Employee emp : list) {
            emp.display();
            System.out.println();

        }

    }

}
