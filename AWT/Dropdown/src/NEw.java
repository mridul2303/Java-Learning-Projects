import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NEw {
    public static void main(String[] args) {
        new Dropbox();
    }
}
class Dropbox extends Frame implements ActionListener{
    Choice ch1 = new Choice();
    Choice ch2 = new Choice();
    //TextField t1 = new TextField(20);
    //TextField t2 = new TextField(20);
    Button B1 = new Button("<<");

    Dropbox(){
        setSize(333,444);
        setVisible(true);
        setLayout(new FlowLayout());
        add(ch1);
        add(ch2);
        //add(t1);add(t2);
        add(B1);
        ch1.add("windows");ch1.add("linux");
        B1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent m){
        Object oo = m.getSource();
        if (oo==B1){
            String Selected = ch1.getSelectedItem();
            ch2.add(Selected);
            ch1.remove(Selected);

        }

    }
}
