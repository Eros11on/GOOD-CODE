import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
public class DrawOval extends JFrame implements ActionListener{
    Ovalcanvas canvas;
    JTextField in_R,in_X,in_Y;
    JButton btn;
    public static void main(String[] args){
        DrawOval DrawOval=new DrawOval();
    }
    public DrawOval(){
        setTitle("画布上绘制圆");
        setSize(600,300);
        setVisible(true);
        canvas=new Ovalcanvas();
        in_R=new JTextField(6);
        in_X=new JTextField(6);
        in_Y=new JTextField(6);
        setLayout(new FlowLayout());
        add(new JLabel("输入圆的位置坐标:"));
        add(in_X);
        add(in_Y);
        add(new JLabel("输入圆的半径:"));
        add(in_R);
        btn=new JButton("确定");
        btn.addActionListener(this);
        add(btn);
        add(canvas);
        validate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    class Ovalcanvas extends Canvas{
        int x,y,r;
        void Ovalcanvas(){
            setSize(200,200);
            setBackground(Color.cyan);
        }
        public void setOval(int x,int y,int r){
            this.x=x;
            this.y=y;
            this.r=r;
        }
        public void paint(Graphics g){
            g.drawOval(x,y,2*r,2*r);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e){

        int x,y,r;
        try{
            x=Integer.parseInt(in_X.getText());
            y=Integer.parseInt(in_Y.getText());
            r=Integer.parseInt(in_R.getText());
            Graphics g = this.getGraphics();
            g.drawOval(x, y, r, r);

        }
        catch (NumberFormatException ee){
            x=0;y=0;r=0;
        }
    }
} 
