
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Result {
    public static void main(String[] args) {
        new Form();
    }
}

class Form extends Frame implements ActionListener{

    String physics,maths,chemistry;
    int no1,no2,no3;
    float per ;
    Label l1 = new Label("physics");
    Label l2 = new Label("chemistry");
    Label l3 = new Label("maths");

    //textbox
    TextField t1 = new TextField(20);//physics
    TextField t2 = new TextField(20);//chem
    TextField t3 = new TextField(20);//maths
    TextField t4 = new TextField(20);//percentage
    TextField t5 = new TextField(20);//grade
    TextField t6 = new TextField(20);//pass\fail

    //button
    Button b1 = new Button("result");


    Form(){
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        setSize(300,400);

        add(l1); add(l2); add(l3);
        add(t1); add(t2); add(t3); add(t4); add(t5); add(t6);
        add(b1);

        b1.addActionListener(this);

        //to close the window we are using this
        addWindowListener(new WindowAdapter() {
            public void
            windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent e){
        // no need to do like if(o==b1) because
        //You only have one component (b1) that is wired with an ActionListener.
        //So, when actionPerformed is triggered, it's always coming from b1.
            physics = t1.getText();
            chemistry = t2.getText();
            maths = t3.getText();

            no1 = Integer.parseInt(physics);
                no2 = Integer.parseInt(chemistry);
                no3 = Integer.parseInt(maths);

            per = ((no1 + no2 + no3) / 300.0f) * 100;

        if (no1 >= 33 && no2 >= 33 && no3 >= 33) {
            t5.setText(String.format("%.2f%%", per)); // show percentage

            if (per >= 60) {
                t4.setText("Grade A");
                t6.setText("Pass");
                t5.setText(String.valueOf(per));
            } else if (per >= 50) {
                t4.setText("Grade B");
                t6.setText("Pass");
                t5.setText(String.valueOf(per));
            } else {
                t4.setText("Grade C");
                t6.setText("Pass");
                t5.setText(String.valueOf(per));
            }
        } else {
            t6.setText("Fail");
            t4.setText(" ");
            t5.setText(" ");

        }

        }
    }
