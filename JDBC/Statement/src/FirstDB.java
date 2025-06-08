
import java.sql.*;
import java.util.Scanner;


public class FirstDB {
    public static void main(String[] args) {
        String name;
        int id;
        int salary;
        Scanner inp = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading of jdbc
            Connection conn = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/mydatabase", "root", "9907012831");//establishing connection
            Statement  stm=  conn.createStatement();//statement

            //System.out.println("enter name , id , salary");
            System.out.println("enter salary, id");
            //name = inp.nextLine();
            //id = inp.nextInt();
            //salary = inp.nextInt();
            //String insert = ("INSERT INTO Employee VALUES(" + id + ",'"+name+"',"+salary+")");
            salary = inp.nextInt();
            id = inp.nextInt();
            String update = "UPDATE EMPLOYEE SET Salary = " + salary + " WHERE employeeID = " + id;
            System.out.println(update);
            stm.executeUpdate(update);//inserting query
            System.out.print("3");
            conn.close();//closing of connection



        }
        catch (ClassNotFoundException e1){
            System.out.println(e1);
        }
        catch (SQLException e2){
            System.out.println(e2);
        }

    }
}
