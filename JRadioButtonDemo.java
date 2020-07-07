package ch10;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class JRadioButtonDemo extends JFrame{
	JPanel p;
	JRadioButton btnRed,btnGreen,btnBlue;
	public JRadioButtonDemo() {
		super("单选框");
		p = new JPanel();
		btnRed = new JRadioButton("红色");
		btnGreen = new JRadioButton("绿色");
		btnBlue = new JRadioButton("蓝色");
		p.add(btnRed);
		p.add(btnGreen);
		p.add(btnBlue);
		//创建一个监听对象
		ButtonListener b1 = new ButtonListener();
		//给按钮注册监听对象
		btnRed.addActionListener(b1);
		btnGreen.addActionListener(b1);
		btnBlue.addActionListener(b1);
		this.add(p);
		this.setSize(300,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				
	}
	//创建扩展ActionListener的监听类
	public class ButtonListener implements ActionListener{
		//重写ActionListener接口中的事件处理方法actionPerformed()
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();//获取事件源
			//判断事件源，进行相应处理
			if(source==btnRed) {
				p.setBackground(Color.red);
			}else if(source==btnGreen) {
				p.setBackground(Color.green);
			}else {
				p.setBackground(Color.blue);
			}
		}
	}
	public static void main(String[] args) {
		JRadioButtonDemo cf = new JRadioButtonDemo();
		cf.setVisible(true);
	}

}

