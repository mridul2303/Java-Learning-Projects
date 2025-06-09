import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertEmployeeExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "9907012831";

        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection(jdbcURL, username, password);

            // Prepare call to stored procedure with 4 parameters
            String sql = "{call InsertEmployee(?, ?, ?, ?)}";
            cstmt = conn.prepareCall(sql);

            // Set procedure parameters
            cstmt.setString(1, "Ravi Sharma");     // EmpName
            cstmt.setInt(2, 30);                   // EmpAge
            BigDecimal EmpSalary = new BigDecimal("55000.75");
            cstmt.setBigDecimal(3, EmpSalary);
            cstmt.setInt(4, 2);                    // DeptID

            // Execute procedure
            cstmt.execute();

            System.out.println("Employee inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}