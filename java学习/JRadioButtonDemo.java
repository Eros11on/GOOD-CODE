package ch10;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class JRadioButtonDemo extends JFrame{
	JPanel p;
	JRadioButton btnRed,btnGreen,btnBlue;
	public JRadioButtonDemo() {
		super("��ѡ��");
		p = new JPanel();
		btnRed = new JRadioButton("��ɫ");
		btnGreen = new JRadioButton("��ɫ");
		btnBlue = new JRadioButton("��ɫ");
		p.add(btnRed);
		p.add(btnGreen);
		p.add(btnBlue);
		//����һ����������
		ButtonListener b1 = new ButtonListener();
		//����ťע���������
		btnRed.addActionListener(b1);
		btnGreen.addActionListener(b1);
		btnBlue.addActionListener(b1);
		this.add(p);
		this.setSize(300,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				
	}
	//������չActionListener�ļ�����
	public class ButtonListener implements ActionListener{
		//��дActionListener�ӿ��е��¼�������actionPerformed()
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();//��ȡ�¼�Դ
			//�ж��¼�Դ��������Ӧ����
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

