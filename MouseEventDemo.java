import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class GUIExample extends JFrame implements ActionListener {
	private JPanel jp=new JPanel();
	private JCheckBox[] jcbArray={new JCheckBox("��������/����"),
			                      new JCheckBox("����/����/����"),
			                      new JCheckBox("����/����"),
			                      new JCheckBox("����/�ȼ�"),
			                      new JCheckBox("ʱ�з�װ/��ױƷ")};
	private JRadioButton[]jrbArray={new JRadioButton("5~15��"),
			                        new JRadioButton("16~25��",true),
			                        new JRadioButton("26~35��"),
			                        new JRadioButton("36~45��"),
			                        new JRadioButton("46~55��")};
	private JButton[] jbArray={new JButton("�ύ"),new JButton("���")};
	private JLabel[] jlArray={new JLabel("����Σ�"),new JLabel("��Ȥ���ã�"),new JLabel("����Ľ��Ϊ��")};
    private JTextField jtf=new JTextField();
	private ButtonGroup bg=new ButtonGroup();
	public GUIExample(){
		jp.setLayout(null);
		for (int i=0;i<5;i++){
			jrbArray[i].setBounds(40 + i * 100, 40, 80, 30);
			jcbArray[i].setBounds(40 + i * 120, 100, 120, 30);
			jp.add(jrbArray[i]);
			jp.add(jcbArray[i]);
			jrbArray[i].addActionListener(this);
			jcbArray[i].addActionListener(this);
			bg.add(jrbArray[i]);
			if(i>1)
				continue;
			jlArray[i].setBounds(20, 20 + i * 50, 80, 30);
			jbArray[i].setBounds(400 + i * 120, 200, 80, 26);
			jp.add(jlArray[i]);
			jp.add(jbArray[i]);
			jbArray[i].addActionListener(this);
		}
			jlArray[2].setBounds(20, 150, 120, 30);
			jp.add(jlArray[2]);
			jtf.setBounds(120, 150, 500, 26);
			jp.add(jtf);
			jtf.setEditable(false);
			this.add(jp);
			this.setTitle("������Ϣ����");
			this.setBounds(100, 100, 700, 280);
			this.setVisible(true);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==jbArray[1]){
				for (int i=0;i<jcbArray.length;i++)
					jcbArray[i].setSelected(false);
				jtf.setText("");		
			} else{
				StringBuffer temp1=new StringBuffer("����һ��");
				StringBuffer temp2=new StringBuffer();
				for(int i=0;i<5;i++){
					if(jrbArray[i].isSelected()){
						temp1.append(jrbArray[i].getText());
					}
					if(jcbArray[i].isSelected()){
						temp2.append(jcbArray[i].getText()+",");
				}
			}
			if(temp2.length()==0){
					jtf.setText("����δѡ����Ȥ����");
			} else{
				temp1.append("���ˣ���Ƚ�ϲ��");
				temp1.append(temp2.substring(0, temp2.length()-1));
				jtf.setText(temp1.append("��").toString());
			}
	    }
    }
	public static void main(String[] args) {
		new GUIExample();
	}
}
