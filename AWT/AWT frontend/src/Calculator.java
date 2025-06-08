import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator {
    public static void main(String[] args) {

        new Calc();
    }
}
class Calc extends Frame implements ActionListener {
    String no1, no2;
    int a, b, c;
    String operator;
    TextField t1 = new TextField(20);

    Button b1 = new Button("1");
    Button b2 = new Button("2");
    Button b3 = new Button("3");
    Button b4 = new Button("4");
    Button b5 = new Button("5");
    Button b6 = new Button("6");
    Button b7 = new Button("7");
    Button b8 = new Button("8");
    Button b9 = new Button("9");
    Button b0 = new Button("0");
    Button b11 = new Button("+");
    Button b12 = new Button("-");
    Button b13 = new Button("=");
    Button b14 = new Button("*");
    Button b15 = new Button("/");
    Button b16 = new Button("clear");

    Calc() {
        add(b1);add(b2);add(b3);add(b4);
        add(b5);add(b6);add(b7);add(b8);add(b9);add(b0);add(b14);add(b15);
        add(b13);add(b12);add(b11);add(t1);add(b5);add(b16);

        b1.addActionListener(this);
        b5.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);

        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        setSize(300, 400);

        //to close the window we are using this
        addWindowListener(new WindowAdapter() {
            public void
            windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == b1) {
            t1.setText(t1.getText() + "1");
        } else if (s == b2) {
            t1.setText(t1.getText() + "2");
        } else if (s == b3) {
            t1.setText(t1.getText() + "3");
        } else if (s == b4) {
            t1.setText(t1.getText() + "4");
        } else if (s == b5) {
            t1.setText(t1.getText() + "5");
        }else if (s == b6) {
            t1.setText(t1.getText() + "6");
        }else if (s == b7) {
            t1.setText(t1.getText() + "7");
        }else if (s == b8) {
            t1.setText(t1.getText() + "8");
        }else if (s == b9) {
            t1.setText(t1.getText() + "9");
        }else if (s == b0) {
            t1.setText(t1.getText() + "0");
        }else if (s == b16) {
            t1.setText("0");
        }


        // Addition operator
        else if (s == b11) {
            no1 = t1.getText();
            operator = "+";
            t1.setText("");
            // subtractor
        } else if (s == b12) {
            no1 = t1.getText();
            operator = "-";
            t1.setText("");

        }//multiplication
        else if (s == b14) {
            no1 = t1.getText();
            operator = "*";
            t1.setText("");
        }
        //division
        else if (s == b15) {
            no1 = t1.getText();
            operator = "/";
            t1.setText("");

        }


        // Equals
        else if (s == b13) {
            no2 = t1.getText();
            a = Integer.parseInt(no1);
            b = Integer.parseInt(no2);

            switch (operator) {
                case "+" -> c = a + b;
                case "-" -> c = a - b;
                case "*" -> c = a * b;
                case "/" -> c = a / b;
            }

            t1.setText("" + c);
        }
    }
}



