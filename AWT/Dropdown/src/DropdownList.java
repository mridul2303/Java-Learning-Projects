import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownList {
    public static void main(String[] args) {
        new Mylist();
    }
}
class Mylist extends Frame implements ActionListener{
    Choice C = new Choice();
    Button ad = new Button("add");
    Button delete = new Button("Delete");
    Button insert = new Button("Insert");
    Button count = new Button("Count");
    TextField t1 = new TextField(20);
    TextField t2 = new TextField(20);

    Mylist(){
        setSize(333,444);
        setVisible(true);
        setLayout(new FlowLayout());
        add(C);add(delete);add(insert);add(count);add(t1);add(t2);
        add(ad);C.add("windows");C.add("Linux");
        ad.addActionListener(this);
        delete.addActionListener(this);
        insert.addActionListener(this);
        count.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if (o == ad) {
            C.add(t1.getText());
        }
        if (o == delete) {
            C.remove(t1.getText());
        }
        if (o == insert) {
            C.insert(t1.getText(),Integer.parseInt(t2.getText()));
        }
        if (o == count) {
            t1.setText(String.valueOf(C.getItemCount()));
        }

    }

}
