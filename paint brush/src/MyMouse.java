import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyMouse {
    public static void main(String[] args) {
        new Mouse();
    }
}
class Mouse extends Frame implements MouseListener, MouseMotionListener{
    int x1,y1,x2,y2;
    ArrayList<Point> points = new ArrayList<>();

    Mouse(){
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(333,444);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        for (int i = 0; i < points.size()-1;  i++){
            Point p1 = points.get(i);
            Point p2 = points.get(i+1);
            if (p1!= null && p2!=null){
                g.drawLine(p1.x,p1.y,p2.x,p2.y);
            }
        }

    }

    public void mouseMoved(MouseEvent e){}
    public void mouseDragged(MouseEvent e){
        points.add(e.getPoint());
        repaint();
    }
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        points.add(e.getPoint());
    }
    public void mouseReleased(MouseEvent e) {
        points.add(null);
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent f) {}
}
