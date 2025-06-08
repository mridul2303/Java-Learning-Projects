import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import java.nio.file.Files;
import java.util.Base64;

public class EmployrrForm {
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
    JLabel l4 = new JLabel();
    File selectedFile = null;
    Connection con;
    Statement stm;

    Employee() {
        // JDBC Setup
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "root", "9907012831");
            stm = con.createStatement();
        } catch (Exception e1) {
            System.out.println("Connection Error: " + e1);
        }

        // GUI Layout
        setLayout(new GridLayout(5, 2, 10, 10));
        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);add(new Label("Selected Photo:"));add(l4);
        add(b1); add(b2); add(b3);add(b4);add(b5);

        // Window properties
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
                    // Read image file bytes and encode as Base64
                    byte[] imageBytes = Files.readAllBytes(selectedFile.toPath());
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    String insert = "INSERT INTO Employee (employeeID, name, Salary, photo) VALUES (" +
                            empId + ", '" + name + "', " + salary + ", FROM_BASE64('" + base64Image + "'))";
                    stm.executeUpdate(insert);
                    System.out.println("Record saved with photo");
                } else {
                    // No image selected, insert without photo
                    String insert = "INSERT INTO Employee (employeeID, name, Salary) VALUES (" +
                            empId + ", '" + name + "', " + salary + ")";
                    stm.executeUpdate(insert);
                    System.out.println("Record saved without photo");
                }
            } else if (source == b2) {
                String delete = "DELETE FROM Employee WHERE employeeID = " + empId;
                stm.executeUpdate(delete);
                System.out.println("Record deleted");
            }
           else if (source == b3) {
                String update;

                if (selectedFile != null) {
                    // Read image bytes and convert to base64
                    byte[] imageBytes = Files.readAllBytes(selectedFile.toPath());
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    update = "UPDATE Employee SET name = '" + t2.getText() +
                            "', Salary = " + t3.getText() +
                            ", photo = FROM_BASE64('" + base64Image + "') " +
                            "WHERE employeeID = " + t1.getText();
                } else {
                    // No new photo selected, update only name and salary
                    update = "UPDATE Employee SET name = '" + t2.getText() +
                            "', Salary = " + t3.getText() +
                            " WHERE employeeID = " + t1.getText();
                }

                stm.executeUpdate(update);
                System.out.println("Record updated");
            }
            else if (source == b4) {
                String find = "select * from employee where employeeid =" + t1.getText();
                rs = stm.executeQuery(find);
                b = rs.next();
                if (b){
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("salary"));
                    // Get photo bytes
                    byte[] imgBytes = rs.getBytes("photo");
                    if (imgBytes != null) {
                        ImageIcon icon = new ImageIcon(imgBytes);
                        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        l4.setIcon(new ImageIcon(img));
                    } else {
                        l4.setIcon(null); // No photo found
                    }
                }
                else {
                    System.out.println("there is no record");

                }

                }
            else if (source == b5){
                chooser = new JFileChooser(); // it opens a file chooser dialog box and used to browse, select and open file
                //returns int values based on event done by user
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    // JFileChooser.APPROVE_OPTION is a constant which states user selected a file
                    selectedFile = chooser.getSelectedFile();//storing this selected file in File object

                    // Set image on photoLabel
                    ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    //Returns the Image object from the ImageIcon and Scales the image to 100 pixels wide and 100 pixels tall.
                    l4.setIcon(new ImageIcon(img));

                }

            }

        } catch (Exception ex) {
            System.out.println("Database Error: " + ex);
        }
    }
}


