import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Practise {
    public static void main(String[] args) {
        new Mydata();
    }
}
class Mydata extends Frame implements ActionListener {
    TextArea t = new TextArea(5,50);
    List l = new List(2,true);
    Button b1 = new Button("Click");

    Mydata(){
        setLayout(null);
        setSize(300,600);
        add(t);add(l);l.add("Windows");l.add("Linux");l.add("Mac");l.add("android");
        add(b1);
        b1.addActionListener(this);
        t.setBounds(350,100,100,100);
        b1.setBounds(250,100,50,50);
        l.setBounds(100,100,100,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if (o==b1){
            t.setText(Arrays.toString(l.getSelectedItems()));
        }
    }
}
