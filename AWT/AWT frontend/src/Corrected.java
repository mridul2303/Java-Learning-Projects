import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Corrected {
    public static void main(String[] args) {
        new check11();
    }

}

class check11 extends Frame implements ActionListener {
    static int m1 = 0, a1 = 0, tc1 = 0, tic1 = 0;

    Label l1 = new Label("Q1 cos(0)");
    CheckboxGroup cgp1 = new CheckboxGroup();
    Checkbox c1 = new Checkbox("1", false, cgp1);
    Checkbox c2 = new Checkbox("0", false, cgp1);
    Checkbox c3 = new Checkbox("0.5", false, cgp1);
    Checkbox c4 = new Checkbox("0.25", false, cgp1);
    Button b2 = new Button("next");

    check11() {
        setLayout(new FlowLayout());
        add(l1); add(c1); add(c2); add(c3); add(c4); add(b2);
        b2.addActionListener(this);
        setSize(333, 444); setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (c1.getState()) { m1 = 3; a1 = 1; tc1 = 1; tic1 = 0; }
        else if (c2.getState() || c3.getState() || c4.getState()) {
            m1 = -1; a1 = 1; tc1 = 0; tic1 = 1;
        }

        if (e.getSource() == b2) {
            setVisible(false);
            new check22();
        }
    }
}

class check22 extends Frame implements ActionListener {
    static int m2 = 0, a2 = 0, tc2 = 0, tic2 = 0;

    Label l2 = new Label("Q2 sin(0)");
    CheckboxGroup cgp1 = new CheckboxGroup();
    Checkbox c5 = new Checkbox("0", false, cgp1);
    Checkbox c6 = new Checkbox("1", false, cgp1);
    Checkbox c7 = new Checkbox("2", false, cgp1);
    Checkbox c8 = new Checkbox("3", false, cgp1);
    Button b2 = new Button("next");
    Button b3 = new Button("previous");

    check22() {
        setLayout(new FlowLayout());
        add(l2); add(c5); add(c6); add(c7); add(c8);
        add(b2); add(b3);
        b2.addActionListener(this); b3.addActionListener(this);
        setSize(333, 444); setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (c5.getState()) { m2 = 3; a2 = 1; tc2 = 1; tic2 = 0; }
        else if (c6.getState() || c7.getState() || c8.getState()) {
            m2 = -1; a2 = 1; tc2 = 0; tic2 = 1;
        }

        if (e.getSource() == b2) {
            setVisible(false);
            new check33();
        } else if (e.getSource() == b3) {
            setVisible(false);
            new check11();
        }
    }
}

class check33 extends Frame implements ActionListener {
    static int m3 = 0, a3 = 0, tc3 = 0, tic3 = 0;

    Label l3 = new Label("Q3 tan(45)");
    CheckboxGroup cgp1 = new CheckboxGroup();
    Checkbox c9 = new Checkbox("1", false, cgp1);
    Checkbox c10 = new Checkbox("0.25", false, cgp1);
    Checkbox c11 = new Checkbox("0.75", false, cgp1);
    Checkbox c12 = new Checkbox("0", false, cgp1);
    Button b1 = new Button("Submit");
    Button b3 = new Button("Previous");

    check33() {
        setLayout(new FlowLayout());
        add(l3); add(c9); add(c10); add(c11); add(c12);
        add(b1); add(b3);
        b1.addActionListener(this); b3.addActionListener(this);
        setSize(333, 444); setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (c9.getState()) { m3 = 3; a3 = 1; tc3 = 1; tic3 = 0; }
        else if (c10.getState() || c11.getState() || c12.getState()) {
            m3 = -1; a3 = 1; tc3 = 0; tic3 = 1;
        }

        if (e.getSource() == b1) {
            setVisible(false);
            new check44();
        } else if (e.getSource() == b3) {
            setVisible(false);
            new check22();
        }
    }
}

class check44 extends Frame {
    int totalmarks = check1.m1 + check2.m2 + check3.m3;
    int totalattempt = check1.a1 + check2.a2 + check3.a3;
    int unattempt = 3 - totalattempt;
    int totalcorrect = check1.tc1 + check2.tc2 + check3.tc3;
    int totalincorrect = check1.tic1 + check2.tic2 + check3.tic3;

    TextField t1 = new TextField(20); // total marks
    TextField t2 = new TextField(20); // total attempt
    TextField t3 = new TextField(20); // unattempt
    TextField t4 = new TextField(20); // correct
    TextField t5 = new TextField(20); // incorrect

    check44() {
        setLayout(new FlowLayout());
        add(t1); add(t2); add(t3); add(t4); add(t5);

        t1.setText("Total Marks = " + totalmarks);
        t2.setText("Total Attempt = " + totalattempt);
        t3.setText("Unattempt = " + unattempt);
        t4.setText("Total Correct = " + totalcorrect);
        t5.setText("Total Incorrect = " + totalincorrect);

        setSize(333, 444); setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
