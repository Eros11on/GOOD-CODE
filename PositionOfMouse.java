import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PositionOfMouse extends JFrame{
    private JLabel label;
    public PositionOfMouse(){
        super("���Գ���");//�����´���
        this.setSize(400,300);//���ô���Ŀ�͸�
        this.setVisible(true);//���ô���ɼ�
        this.setLayout(new FlowLayout(FlowLayout.CENTER));//����������Ҿ��ж���
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���õ���رհ�ťʱ��Ĭ�ϲ���
        JLabel label = new JLabel("�˴���ʾ����Ҽ����������");
        this.add(label); // ����ǩ���봰��

        this.addMouseListener(new MouseAdapter(){  //�����ڲ��࣬����¼�
            public void mouseClicked(MouseEvent e){   //�����ɵ���¼�
                if(e.getButton() == MouseEvent.BUTTON3){ //e.getButton�ͻ᷵�ص������Ǹ�������������ҽ���3�����Ҽ�
                    int x = e.getX();  //�õ����x����
                    int y = e.getY();  //�õ����y����
                    String banner = "��굱ǰ���λ�õ�������" + x + "," + y;
                    label.setText(banner);  //�޸ı�ǩ����
                }
            }
        });
    }
    public static void main(String[] args) {
        // TODO �Զ����ɵķ������
        new PositionOfMouse();
    }

}
