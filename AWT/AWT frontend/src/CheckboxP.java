
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckboxP {
    public static void main(String[] args) {
        new check();//first class where we enter username and pass
    }
}
//class1
class check extends Frame implements ActionListener{
    Label l1 = new Label("Enter username");
    Label l2 = new Label("enter password");
    TextField t1 = new TextField(20);//for username
    TextField t2 = new TextField(20);//for password
    TextField t3 = new TextField(20);
    Button b1 = new Button("next");

    check(){
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(333,444);
        add(l1);add(l2);add(t1);add(t2);add(b1);add(t3);
        b1.addActionListener(this);
        //to close the window we are using this
        addWindowListener(new WindowAdapter() {
            public void
            windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        //if we press next button
        if (o==b1){
            //checking wheather our username and pass is correct or not
            if (t1.getText().equals("mradul") && t2.getText().equals("12345")){
                setVisible(false);
                new check1();//here we are calling next class by pressing next button
            }
            else {
                t3.setText("User name or password is incorrect");
                // we are showing message on textfield 3 if any of our username or pass is incorrect

            }
        }
    }
}


//next class which is called in above class
class check1 extends Frame implements ActionListener {
    // m = marks , a = attempt , tc = totalcorrect , tic = total incorrect
    // we are declaring variables as o initially
    static int m1 = 0;
    static int a1 = 0;
    static int tc1 = 0;
    static  int tic1 = 0;
    Label l1 = new Label("Q1 cos(0)");
CheckboxGroup cgp1 = new CheckboxGroup();
    Checkbox c1 = new Checkbox("1",false,cgp1);
    Checkbox c2 = new Checkbox("0",false,cgp1);
    Checkbox c3 = new Checkbox("0.5",false,cgp1);
    Checkbox c4 = new Checkbox("0.25",false,cgp1);

    Button b2 = new Button("next");

    check1() {
        setLayout(new FlowLayout());
        add(l1);
        add(c1);
        add(c2);
        add(c3);
        add(c4);

        add(b2);
        b2.addActionListener(this);
        setSize(333, 444);
        setVisible(true);
        //to close the window we are using this
        addWindowListener(new WindowAdapter() {
            public void
            windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (c1.getState()){//if someone press 1 radiobutton which is correct then marks = 3 attempt = 1 etc
            m1 = 3;
            a1 = 1;
            tc1 = 1;
            tic1 = 0;
        }
        if (c2.getState()){//if someone press 2 radiobutton which is incorrect then marks = -1 etc
            m1 = -1;
            a1 = 1;
            tc1 = 0;
            tic1 = 1;
        }
        if (c3.getState()){
            m1 = -1;
            a1 = 1;
            tc1 = 0;
            tic1 = 1;
        }
        if (c4.getState()){
            m1 = -1;
            a1 = 1;
            tc1 = 0;
            tic1 = 1;
        }
//if we press next button
        if (o == b2) {
            setVisible(false);
            new check2();//we are calling next class by pressing next button
        }
    }
}
//next class is called
    class check2 extends Frame implements ActionListener {
    //again declaring variables but with different name
    static int m2 = 0;
static int a2 = 0;
static  int tc2 = 0;
static  int tic2 = 0;
        Label l2 = new Label("Q2 sin(0)");

        CheckboxGroup cgp1 = new CheckboxGroup();
        Checkbox c5 = new Checkbox("0",false,cgp1);
        Checkbox c6 = new Checkbox("1",false,cgp1);
        Checkbox c7 = new Checkbox("2",false,cgp1);
        Checkbox c8 = new Checkbox("3",false,cgp1);

        Button b2 = new Button("next");
        Button b3 = new Button("previous");


        check2() {
            setLayout(new FlowLayout());
            add(l2);
            add(c5);
            add(c6);
            add(c7);
            add(c8);

            add(b2);
            add(b3);

            b2.addActionListener(this);
            b3.addActionListener(this);
            setSize(333, 444);
            setVisible(true);
            //to close the window we are using this
            addWindowListener(new WindowAdapter() {
                public void
                windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });

        }

        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            //we are doing same as we did in above class
            if (c5.getState()){
                m2 = 3;
                a2 = 1;
                tc2 = 1;
                tic2 = 0;
            }
            if (c6.getState()){
                m2 = -1;
                a2 = 1;
                tc2 = 0;
                tic2 = 1;
            }
            if (c7.getState()){
                m2=-1;
                a2 = 1;
                tc2 = 0;
                tic2 = 1;
            }
            if (c8.getState()){
                m2=-1;
                a2 = 1;
                tc2 = 0;
                tic2 = 1;
            }
            //to press next button
            if (o == b2) {
                setVisible(false);
                new check3();//calling next class by pressing next button
            }
            //to press previous button
            if (o==b3){
                setVisible(false);
                new check1();//we are calling previous class by previous button
            }

        }
    }
//next class is called
    class check3 extends Frame implements ActionListener {
    static int m3 = 0;
   static int a3 = 0;
   static int tc3 = 0;
   static  int tic3 = 0;

        Label l3 = new Label("Q3 tan(45)");

        CheckboxGroup cgp1 = new CheckboxGroup();
        Checkbox c9 = new Checkbox("1",false,cgp1);
        Checkbox c10 = new Checkbox("0.25",false,cgp1);
        Checkbox c11 = new Checkbox("0.75",false,cgp1);
        Checkbox c12 = new Checkbox("0",false,cgp1);


        Button b1 = new Button("Submit");
        Button b3 = new Button("Previous");

        check3() {
            setLayout(new FlowLayout());
            add(l3);
            add(c9);
            add(c10);
            add(c11);
            add(c12);
            add(b1);
            add(b3);

            b1.addActionListener(this);
            b3.addActionListener(this);
            setSize(333, 444);
            setVisible(true);
            //to close the window we are using this
            addWindowListener(new WindowAdapter() {
                public void
                windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });

        }

        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            if (c9.getState()){
                m3 = 3;
                a3 = 1;
                tc3 = 1;
                tic3 = 0;

            }
            if (c10.getState()){
                m3 = -1;
                a3 = 1;
                tc3 = 0;
             tic3 = 1;
            }
            if (c11.getState()){
                m3=-1;
                a3 = 1;
                tc3 = 0;
                tic3 = 1;
            }
            if (c12.getState()){
                m3=-1;
                a3 = 1;
                tc3 = 0;
                tic3 = 1;

            }//by pressing next button
            if (o == b1)//submit
                 {
                setVisible(false);
                new check4();//we are calling next class
            }
            //by pressing previous button
            if (o == b3)
                {
                setVisible(false);
                new check2();//calling previous class
            }

        }

    }

    class check4 extends Frame implements ActionListener {
    // we used static because we need to use that m1 m2 m3 here to calculate total marks
    int totalmarks = check1.m1 + check2.m2 + check3.m3;//we declared variable totalmarks by adding values stored in m1 m2 m3
    int totalattempt = check1.a1 + check2.a2 + check3.a3;//similar
    int unattempt = 3 - totalattempt;//similar
    int totalcorrect = check1.tc1 + check2.tc2 + check3.tc3;//similar
    int totalincorrect = check1.tic1 + check2.tic2 + check3.tic3;
        int percent = (int)(((double) totalmarks / 9) * 100);

        TextField t1 = new TextField(20);//total marks
        TextField t2 = new TextField(20);//total attempt
        TextField t3 = new TextField(20);//correct
        TextField t4 = new TextField(20);//incorrect
        TextField t5 = new TextField(20);
        TextField t6 = new TextField(20);

        check4() {
            setLayout(new FlowLayout());

            add(t1);
            add(t2);
            add(t3);
            add(t4);
            add(t5);
            add(t6);

            setSize(333, 444);
            setVisible(true);
            //to close the window we are using this
            addWindowListener(new WindowAdapter() {
                public void
                windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });
            //here are displaying totalmarks and all in textfields
            t1.setText("total marks =" + totalmarks);
            t2.setText("total attmept =" + totalattempt);
            t3.setText("unattempt =" + unattempt );
            t4.setText("total correct ="+ totalcorrect);
            t5.setText("total incorrect ="+ totalincorrect);
            t6.setText("percentage is =" + percent);

        }
        public void actionPerformed(ActionEvent e){
        }
    }


