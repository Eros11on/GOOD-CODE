import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
public class MouseEventDemo implements MouseListener{
Frame frame = new Frame("����¼�");
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
System.out.println("��갴��");
}
public void mouseReleased(MouseEvent e) {
System.out.println("����ɿ�");
String string = "���������������꣺��" + e.getX() + "��" + e.getY() +"��";
tField.setText(string);
}
public void mouseEntered(MouseEvent e) {
tField.setText("�����봰��");
}
public void mouseExited(MouseEvent e) {
tField.setText("����뿪����");
}
public void mouseMoved(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {

}
