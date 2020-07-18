import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class FocusKeyEventDemo implements FocusListener,ActionListener{
	String o,p,q;
	JFrame jframe=new JFrame("输入序列号");
	JPanel jpanel=new JPanel();
	JTextField jtf1,jtf2,jtf3;
	JButton jb=new JButton("确定");
	JLabel jlb=new JLabel("序列号:                  ");
	public  FocusKeyEventDemo(){
		jtf1=new JTextField(9);
		jtf2=new JTextField(9);
		jtf3=new JTextField(9);
		jpanel.setLayout(new FlowLayout());
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		jframe.setBounds(0,0,450,150);
		jframe.setVisible(true);
		jtf1.addFocusListener(this);
		jtf2.addFocusListener(this);
		jtf3.addFocusListener(this);
		jframe.add(jpanel);
		jpanel.add(jtf1);
		jpanel.add(jtf2);
		jpanel.add(jtf3);
		jpanel.add(jb);
		jpanel.add(jlb);
		jb.addActionListener(this);
	}
	public static void main(String[] args) {
		 FocusKeyEventDemo a=new  FocusKeyEventDemo();		 
	}
	@Override
	public void focusGained(FocusEvent e) {	
	}
	@Override
	public void focusLost(FocusEvent e) {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			o=jtf1.getText();
			p=jtf2.getText();
			q=jtf3.getText();
			jlb.setText("输入的序列号为:"+o+p+q);
		}
	}
}
