import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class EmployeeForm extends Frame implements ActionListener{

    //to store the data we are using array
    String[] name = new String[100];
    String[] age = new String[100];
    String[] Salary = new String[100];

    int count = 0; //total no. of record
    int current = -1; //jo hum dekhna chahte hein

    // these are labels where message will shown
    Label L1 = new Label("name");
    Label L2 = new Label("age");
    Label L3 = new Label("Salary");


    Button B1 = new Button("save");
    Button B2 = new Button("Find");
    Button B3 = new Button("Next");
    Button B4 = new Button("Prev");
    Button B5 = new Button("Last");
    Button B6 = new Button("First");
    Button B7 = new Button("Update");
    Button B8 = new Button("Delete");

    // these are textfields where we enter name,age,salary
    TextField T1 = new TextField(20);
    TextField T3 = new TextField(20);
    TextField T2 = new TextField(20);

    EmployeeForm(){
        System.out.println("initialized");

        setLayout(new FlowLayout()); // to initialize page
        setSize(300,400); // size of page

        add(L1); add(L2); add(L3);
        add(T1); add(T2); add(T3);

        add(B1); add(B2); add(B3); add(B4);
        add(B5); add(B6); add(B7); add(B8);

        setVisible(true); // TO visible window
        setBackground(Color.LIGHT_GRAY); // backgroung colour of window

        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
        B7.addActionListener(this);
        B8.addActionListener(this);

        //to close the window we are using this
        addWindowListener(new WindowAdapter() {
            public void
            windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    // actionPerformed(ActionEvent e) is a method that is called
    // when a user performs an action
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();

        // if we press save
        if (o==B1){
            name[count] = T1.getText();
            age[count] = T2.getText();
            Salary[count] = T3.getText();
            count++;
            current = count-1;

            // to clear text
            T1.setText("");
            T2.setText("");
            T3.setText("");

        }
        //next
        else if (o==B3){
            if (current < count-1){
                current++;
                showData(current);
            }
        }
        //prev
        else if (o==B4){
            if (current > 0){
                current--;
                showData(current);
            }

        }
        //first
       else if (o==B6){
           if (count>0){
               current=0;
               showData(current);
           }

        }
        //update
       else if (o==B7){

            name[current] = T1.getText();
            age[current] = T2.getText();
            Salary[current] = T3.getText();
            current = count-1;

            // to clear text
            T1.setText("");
            T2.setText("");
            T3.setText("");

        }
       //delete
       else if (o==B8){
           for (int i = current ; i<count-1; i++){
               name[i] = name[i+1];
               age[i] = age[i+1];
               Salary[i] = Salary[i+1];
           }
           count--;
           showData(current);

        }
       //find
       else if (o==B2) {
           String Search = T1.getText();
           boolean find = false;

           for (int m = 0 ; m < count ; m++){
               if (Search.equals(name[m]) ){
                   showData(m);
                   find = true ;
                   break;
               }
           }
            if (!find) {
                T1.setText("");
                T2.setText("");
                T3.setText("");
                System.out.println("Name not found!");
            }

        }
       
       //last
        else if (o==B5) {
            if (count > 0){
                current = count - 1;
                showData(count-1);
            }
            
        }

    }
    private void showData(int I){
        T1.setText(name[I]);
        T2.setText(age[I]);
        T3.setText(Salary[I]);
    }
}

class Page{
    public static void main(String[] args) {
        System.out.println("start");
        new EmployeeForm();
    }
}
