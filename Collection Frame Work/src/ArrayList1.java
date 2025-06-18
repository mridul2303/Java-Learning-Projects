import java.util.ArrayList;
import java.util.Comparator;

class Employee {
    int id;
    String name;
    double Salary;

    Employee(int id, String name, double Salary) {
        this.id = id;
this.name = name;
this.Salary = Salary;
    }
    public String toString() {
        return "Employee(id=" + id + "name=" + name + "Salary =" + Salary+")";
    }
}
class ArrayList1{
    public static void main(String[] args) {
        ArrayList<Employee> employee = new ArrayList<>();
        employee.add(new Employee(1,"ramesh",50000));
        employee.add(new Employee(2,"suresh",60000));
        employee.add(new Employee(3,"kamlesh",40000));
        employee.sort(Comparator.comparingDouble(e -> e.Salary));
        //to print employee data
        for (Employee e : employee) {
            System.out.println(e);}
    }
}

