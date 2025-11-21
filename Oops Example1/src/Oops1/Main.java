package Oops1;

import java.util.ArrayList;

class Employee {
    int id;
    String name;
    Float salary;

    Employee(int id, String name, Float salary){
      this.id = id;
      this.name = name;
      this.salary = salary;
    }
     // Method to display info
     void display() {
         System.out.println("Oops1.Employee Name = " + name);
         System.out.println("Oops1.Employee ID = " + id);
         System.out.println("Oops1.Employee Salary = " + salary);
     }
}
class Manager extends Employee{
    String department;
    Manager(int id, String name, Float salary, String dep){
      super(id, name, salary);
        department = dep;
    }
    void display(){
        super.display();
        System.out.println("Oops1.Employee Department = " + department);
    }

}
class Developer extends Employee{
    String ProgrammingLanguage;
    Developer(int id, String name, Float salary, String pl){
        super(id, name, salary);
        ProgrammingLanguage = pl;
    }
    void display(){
        super.display();
        System.out.println("Oops1.Employee Programming Language = " + ProgrammingLanguage);
    }
}


public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Employee e1 = new Manager(2,"Mradul Jain",25000f,"Software Development");
        Employee e2 = new Developer(2,"Amitt Sharma",20000f,"JAVA");
        Employee e3 = new Employee(2,"Rahul Jain",200000f);
//new Oops1.Manager(...) → creates a Oops1.Manager object in memory.
//
//Oops1.Employee e1 → the reference variable e1 is of Oops1.Employee type.
//
//Even though the object is a Oops1.Manager, the variable is treated as an Oops1.Employee reference.
//
//This is called Polymorphism (Upcasting).
        /*Because:
A Oops1.Manager IS-A Oops1.Employee
A Oops1.Developer IS-A Oops1.Employee*/

        list.add(e1);//manager
        list.add(e2);//developer
        list.add(e3);//normal employee
        for (Employee emp : list) {
            emp.display();
            System.out.println();

        }

    }

}