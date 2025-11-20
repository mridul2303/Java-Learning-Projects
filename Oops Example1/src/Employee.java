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
         System.out.println("Employee Name = " + name);
         System.out.println("Employee ID = " + id);
         System.out.println("Employee Salary = " + salary);
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
        System.out.println("Employee Department = " + department);
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
        System.out.println("Employee Programming Language = " + ProgrammingLanguage);
    }
}