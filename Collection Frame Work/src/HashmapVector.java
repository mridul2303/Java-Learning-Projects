import java.util.HashMap;
import java.util.Vector;

public class HashmapVector {
    public static void main(String[] args) {
        Vector<Employeelist>employeelist = new Vector<>();

        HashMap<Integer,Employeelist>employeelistMap = new Hashmap<>();

        Employeelist e1 = new Employeelist(1,"kanak",50000);

        Employeelist e2 = new Employeelist(2,"naincy",550000);

        Employeelist e3 = new Employeelist(3,"rahul",60000);

        //adding in vector
        employeelistList.add(e1);
        employeelistList.add(e2);
        employeelistList.add(e3);

        //adding in hashmap
        employeelistMap.put(e1,id,e1);
        employeelistMap.put(e2,id,e2);
        employeelistMap.put(e3,id,e3);
        System.out.println("all employeelist (from Vector):");
        for (Employeelist emp: employeelist){
            emp.Display();
        }
    }
}
class HMV {
    int id;
    String name;
    double salary;

    HMV(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String Display() {
        return "Student(id=" + id + ", name=" + name + ", salary=" + salary + ")";
    }
}