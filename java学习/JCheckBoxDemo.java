import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
public class MouseEventDemo implements MouseListener{
Frame frame = new Frame("鼠标事件");
TextField tField = new TextField(30);
public MouseEventDemo (){
frame.add(tField, "South");
frame.setBackground(new Color(0,255,0));
frame.addMouseListener(this);
frame.setSize(500, 400);
frame.setLocation(400, 300);
frame.setVisible(true);

}
public static void main(String[] args) {
new MouseEventDemo ();
}
public void mousePressed(MouseEvent e) {
System.out.println("鼠标按下");
}
public void mouseReleased(MouseEvent e) {
System.out.println("鼠标松开");
String string = "鼠标左键单击，坐标：（" + e.getX() + "，" + e.getY() +"）";
tField.setText(string);
}
public void mouseEntered(MouseEvent e) {
tField.setText("鼠标进入窗体");
}
public void mouseExited(MouseEvent e) {
tField.setText("鼠标离开窗体");
}
public void mouseMoved(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {

}
