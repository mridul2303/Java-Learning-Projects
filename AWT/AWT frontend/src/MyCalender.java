import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class MyCalender {
    public static void main(String[] args) {
        new Calender();

    }

}
class Calender extends Frame implements ActionListener {


    Label l1 = new Label("day");
    Label l2 = new Label("time");

    Button b1 = new Button("Status");


    TextField t1 = new TextField(20);//day
    TextField t2 = new TextField(20);//time
    TextField t3 = new TextField(20);//on\off


    Calender() {
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        setSize(300, 400);

        add(l1);
        add(l2);
        add(b1);
        add(t1);
        add(t2);
        add(t3);

        b1.addActionListener(this);

        //to close the window we are using this
        addWindowListener(new WindowAdapter() {
            public void
            windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
        public void actionPerformed (ActionEvent e){

            String day = t1.getText().toLowerCase();   // get text from t1 (day field)
            String time = t2.getText();               // get text from t2 (time field)

            boolean Weekend = day.equals("saturday") || day.equals("sunday");
            boolean ValidTime = time.equals("18:00") || time.equals("12:00");

            if (Weekend && ValidTime) {
                t3.setText("on");
            } else {
                t3.setText("off");

            }

        }
    }
