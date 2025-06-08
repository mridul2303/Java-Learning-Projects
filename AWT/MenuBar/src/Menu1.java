import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.lang.System.exit;

public class Menu1 {
    public static void main(String[] args) {
        new Mymenu();
    }
}
class Mymenu extends Frame implements ActionListener{
    MenuBar mb = new MenuBar();
    Menu file = new Menu("FILE");
    Menu color = new Menu("COLOR");
    Menu blue = new Menu("BLUE");
    MenuItem lb = new MenuItem("LB");
    MenuItem db = new MenuItem("DB");
    MenuItem exit = new MenuItem("EXIT");
    MenuItem red = new MenuItem("RED");
    MenuItem Cal = new MenuItem("CAL");

    Mymenu(){
        setMenuBar(mb);
        setSize(333,444);
        setVisible(true);
        mb.add(file);mb.add(color);color.add(blue);
        blue.add(lb);blue.add(db);file.add(exit);
        color.add(red); file.add(Cal);
        exit.addActionListener(this);
        red.addActionListener(this);
        lb.addActionListener(this);
        db.addActionListener(this);
        Cal.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if (o==exit){
            exit(0);
        }
        if (o==red){
            setBackground(Color.RED);
        }
        if (o==lb){
            setBackground(Color.BLUE);
        }
        if (o==db){
            setBackground(Color.GREEN);
        }
        if (o==Cal){
            new Calculator();
        }
    }
}
class Calculator extends Frame implements ActionListener {
    String Operator;
    double no1 , no2 , ans;
    double m = 0;
    TextField t = new TextField(40);
    Panel p = new Panel();
    Button B1 = new Button("AC");
    Button B2 = new Button("+");
    Button B3 = new Button("-");
    Button B4 = new Button("*");
    Button B5 = new Button("/");
    Button B6 = new Button("=");
    Button B7 = new Button("M+");
    Button B8= new Button("M-");
    Button B9 = new Button("Mr");
    Button B10 = new Button("C");
    Button B11 = new Button(".");

    Calculator() {
        setVisible(true);
        setSize(333, 444);
        setLayout(new BorderLayout());
        add(t, BorderLayout.NORTH);
        p.setLayout(new GridLayout(6, 4));
        p.add(B1);
        p.add(B2);
        p.add(B3);
        p.add(B4);
        p.add(B5);
        p.add(B6);p.add(B7);p.add(B8);p.add(B9);p.add(B10);p.add(B11);
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
        B6.addActionListener(this);
        B7.addActionListener(this);
        B8.addActionListener(this);
        B9.addActionListener(this);
        B10.addActionListener(this);
        B11.addActionListener(this);

        t.setFont(new Font("Arial", Font.BOLD, 28));

        for (int i = 0; i <= 9; i++) {
            Button B = new Button(String.valueOf(i));
            B.addActionListener(this);
            p.add(B);
        }
        add(p, BorderLayout.CENTER);
        // Close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        String command = e.getActionCommand();
        if (command.matches("[0-9]")) {
            t.setText(t.getText() + command);
        }
        if (o == B1) {
            t.setText("0");

        }
        if (o == B2) {//+
            if (t.getText().isEmpty()){
                no1 = 0;
            }
            else {
                no1 = Double.parseDouble(t.getText());
                t.setText("");
                Operator = "+";
            }
        }
        if (o == B3) {//-
            if (t.getText().isEmpty()){
                no1 = 0;
            }
            else {
                no1 = Double.parseDouble(t.getText());
                t.setText("");
                Operator = "-";
            }
        }
        if (o == B4) {//*
            if (t.getText().isEmpty()){
                no1 = 0;
            }
            else {
                no1 = Double.parseDouble(t.getText());
                t.setText("");
                Operator = "*";
            }
        }
        if (o == B5) {// /
            if (t.getText().isEmpty()){
                no1 = 0;
            }
            else {
                no1 = Double.parseDouble(t.getText());
                t.setText("");
                Operator = "/";
            }
        }
        if (o == B6) {
            no2 = Double.parseDouble(t.getText());
            t.setText("");
            if (Operator.equals("+")){
                ans = no1+no2;
            }
            if (Operator.equals("-")){
                ans = no1-no2;
            }
            if (Operator.equals("*")){
                ans = no1*no2;
            }
            if (Operator.equals("/")){
                if (no2==0){
                    t.setText("tends to infinity");
                }
                ans = no1/no2;
            }
            t.setText(String.valueOf(ans));
        }
        if (o==B7){//M+
            m = m + Double.parseDouble(t.getText());
        }
        if (o==B8){//M-
            m = m - Double.parseDouble(t.getText());
        }
        if (o==B9){//Mr
            t.setText(String.valueOf(m));
        }
        if (o==B10){
            t.setText(t.getText().substring(0,t.getText().length()-1));
        }
        if (o==B11){
            if (t.getText().contains(".")){
                t.setText(t.getText()+"");
            }
            else {
                t.setText(t.getText() + ".");
            }
        }
    }
}
