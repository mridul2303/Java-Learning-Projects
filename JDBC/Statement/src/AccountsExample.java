import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountsExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading of jdbc
             conn = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/mydatabase", "root", "9907012831");//establishing connection
            conn.setAutoCommit(false);
            Statement stm = conn.createStatement();//statement
            // First operation
            stm.executeUpdate("UPDATE accounts SET balance = balance - 1000 WHERE acno = 1");

            // Second operation
            stm.executeUpdate("UPDATE accounts SET balance = balance + 6000 WHERE acno=2");
            //yaha tak code execute hoga then we will commit changes otherwise rollback
            conn.commit();
            System.out.println("transaction completed");


        } catch (Exception e)
        {
            try {
                if (conn != null)
                    conn.rollback(); // Rollback if error
                System.out.println("Transaction rolled back due to error: " + e.getMessage());
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
 }}
}