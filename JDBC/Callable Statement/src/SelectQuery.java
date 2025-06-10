import java.math.BigDecimal;
import java.sql.*;

public class SelectQuery {
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
            String sql = "{call GetInsertEmployeeByDeptID(?, ?, ?, ?)}";
            cstmt = conn.prepareCall(sql);

            // Set procedure parameters
            cstmt.setInt(4, 2);                    // DeptID

            //get procedure
            cstmt.registerOutParameter(1, Types.VARCHAR);     // EmpName
            cstmt.registerOutParameter(2,Types.INTEGER);                  // EmpAge
            BigDecimal EmpSalary = new BigDecimal("55000.75");
            cstmt.registerOutParameter(3,Types.DECIMAL);

            // Execute procedure
            cstmt.execute();


            String name = cstmt.getString(1);
            int age = cstmt.getInt(2);
            double salary = cstmt.getDouble(3);


            System.out.println("Employee Details:");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Salary: " + salary);

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