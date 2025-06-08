import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import java.nio.file.Files;
import java.util.Base64;
public class Preparedstmt {
    public static void main(String[] args) {
        new Employee();
    }
}
class Employee extends Frame implements ActionListener {
    ResultSet rs;
    Boolean b;
    Label l1 = new Label("Employee ID:");
    Label l2 = new Label("Employee Name:");
    Label l3 = new Label("Employee Salary:");
    TextField t1 = new TextField(20);
    TextField t2 = new TextField(20);
    TextField t3 = new TextField(20);
    Button b1 = new Button("Save");
    Button b2 = new Button("Delete");
    Button b3 = new Button("Update");
    Button b4 = new Button("Find");
    Button b5 = new Button("Choose Photo");

    Button first = new Button("first");
    Button last = new Button("last");
    Button next = new Button("next");
    Button prev = new Button("prev");
    JLabel l4 = new JLabel();
    File selectedFile = null;
    Connection con;

    Employee() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "root", "9907012831");
        } catch (Exception e1) {
            System.out.println("Connection Error: " + e1);
        }

        setLayout(new GridLayout(5, 2, 10, 10));
        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3); add(new Label("Selected Photo:")); add(l4);
        add(b1); add(b2); add(b3); add(b4); add(b5);
        add(first);add(last);add(next);add(prev);

        setTitle("Employee Form");
        setSize(400, 300);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        first.addActionListener(this);
        last.addActionListener(this);
        next.addActionListener(this);
        prev.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        Object source = e.getSource();
        String empId = t1.getText().trim();
        String name = t2.getText().trim();
        String salary = t3.getText().trim();

        try {
            if (source == b1) {
                if (selectedFile != null) {
                    byte[] imageBytes = Files.readAllBytes(selectedFile.toPath());
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    String insert = "INSERT INTO Employee (employeeID, name, Salary, photo) VALUES (?, ?, ?, FROM_BASE64(?))";
                    try (PreparedStatement pstmt = con.prepareStatement(insert)) {
                        pstmt.setInt(1, Integer.parseInt(empId));
                        pstmt.setString(2, name);
                        pstmt.setDouble(3, Double.parseDouble(salary));
                        pstmt.setString(4, base64Image);
                        pstmt.executeUpdate();
                    }
                    System.out.println("Record saved with photo");
                } else {
                    String insert = "INSERT INTO Employee (employeeID, name, Salary) VALUES (?, ?, ?)";
                    try (PreparedStatement pstmt = con.prepareStatement(insert)) {
                        pstmt.setInt(1, Integer.parseInt(empId));
                        pstmt.setString(2, name);
                        pstmt.setDouble(3, Double.parseDouble(salary));
                        pstmt.executeUpdate();
                    }
                    System.out.println("Record saved without photo");
                }
            } else if (source == b2) {
                String delete = "DELETE FROM Employee WHERE employeeID = ?";
                try (PreparedStatement pstmt = con.prepareStatement(delete)) {
                    pstmt.setInt(1, Integer.parseInt(empId));
                    pstmt.executeUpdate();
                }
                System.out.println("Record deleted");
            } else if (source == b3) {
                if (selectedFile != null) {
                    byte[] imageBytes = Files.readAllBytes(selectedFile.toPath());
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    String update = "UPDATE Employee SET name = ?, Salary = ?, photo = FROM_BASE64(?) WHERE employeeID = ?";
                    try (PreparedStatement pstmt = con.prepareStatement(update)) {
                        pstmt.setString(1, name);
                        pstmt.setDouble(2, Double.parseDouble(salary));
                        pstmt.setString(3, base64Image);
                        pstmt.setInt(4, Integer.parseInt(empId));
                        pstmt.executeUpdate();
                    }
                } else {
                    String update = "UPDATE Employee SET name = ?, Salary = ? WHERE employeeID = ?";
                     PreparedStatement pstmt = con.prepareStatement(update) ;
                        pstmt.setString(1, name);
                        pstmt.setDouble(2, Double.parseDouble(salary));
                        pstmt.setInt(3, Integer.parseInt(empId));
                        pstmt.executeUpdate();

                }
                System.out.println("Record updated");
            } else if (source == b4) {
                String find = "SELECT * FROM Employee WHERE employeeID = ?";
                try (PreparedStatement pstmt = con.prepareStatement(find)) {
                    pstmt.setInt(1, Integer.parseInt(empId));
                    rs = pstmt.executeQuery();
                    b = rs.next();
                    if (b) {
                        t2.setText(rs.getString("name"));
                        t3.setText(rs.getString("salary"));
                        byte[] imgBytes = rs.getBytes("photo");
                        if (imgBytes != null) {
                            ImageIcon icon = new ImageIcon(imgBytes);
                            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            l4.setIcon(new ImageIcon(img));
                        } else {
                            l4.setIcon(null);
                        }
                    } else {
                        System.out.println("There is no record");
                    }
                }
            } else if (source == b5) {
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    l4.setIcon(new ImageIcon(img));
                }
            }
            else if (source == first) {
                String sql = "SELECT * FROM Employee";
                PreparedStatement pstmt = con.prepareStatement(sql,  ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                rs = pstmt.executeQuery();
                if (rs.first()) {
                    t1.setText(String.valueOf((rs.getInt("employeeID"))));
                    t2.setText(rs.getString("name"));
                    t3.setText(String.valueOf(rs.getDouble("salary")));
                    byte[] imgBytes = rs.getBytes("photo");
                    if (imgBytes != null) {
                        ImageIcon icon = new ImageIcon(imgBytes);
                        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        l4.setIcon(new ImageIcon(img));
                    } else {
                        l4.setIcon(null);
                    }
                }
            } else if (source == last) {
                String sql = "SELECT * FROM Employee";
                PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = pstmt.executeQuery();
                if (rs.last()) {
                    t1.setText(String.valueOf(rs.getInt("employeeID")));
                    t2.setText(rs.getString("name"));
                    t3.setText(String.valueOf(rs.getDouble("salary")));
                    byte[] imgBytes = rs.getBytes("photo");
                    if (imgBytes != null) {
                        ImageIcon icon = new ImageIcon(imgBytes);
                        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        l4.setIcon(new ImageIcon(img));
                    } else {
                        l4.setIcon(null);
                    }
                }
            } else if (source == next) {
                if (rs != null && !rs.isLast()) {
                    if (rs.next()) {
                        t1.setText(String.valueOf(rs.getInt("employeeID")));
                        t2.setText(rs.getString("name"));
                        t3.setText(String.valueOf(rs.getDouble("salary")));
                        byte[] imgBytes = rs.getBytes("photo");
                        if (imgBytes != null) {
                            ImageIcon icon = new ImageIcon(imgBytes);
                            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            l4.setIcon(new ImageIcon(img));
                        } else {
                            l4.setIcon(null);
                        }
                    }
                } else {
                    System.out.println("Already at last record or no data");
                }
            } else if (source == prev) {
                if (rs != null && !rs.isFirst()) {
                    if (rs.previous()) {
                        t1.setText(String.valueOf(rs.getInt("employeeID")));
                        t2.setText(rs.getString("name"));
                        t3.setText(String.valueOf(rs.getDouble("salary")));
                        byte[] imgBytes = rs.getBytes("photo");
                        if (imgBytes != null) {
                            ImageIcon icon = new ImageIcon(imgBytes);
                            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            l4.setIcon(new ImageIcon(img));
                        } else {
                            l4.setIcon(null);
                        }
                    }
                } else {
                    System.out.println("Already at first record or no data");
                }
            }


            } catch (Exception ex) {
            System.out.println("Database Error: " + ex);
        }
    }
}