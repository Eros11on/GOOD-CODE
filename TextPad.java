package com.txt;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
public class TextPad extends JFrame implements ActionListener
{

    //����һ�����
    //JPanel jp =null;
    JTextArea jta =null;


    //����˵���
    JMenuBar jmb=null;
    //����˵�
    JMenu jm1 =null;
    //����˵�ѡ��
    JMenuItem jmi1=null;
    JMenuItem jmi2=null;
    JMenuItem jmi3=null;
    JMenuItem jmi4 =null;
    ArrayList<JMenuItem> arraylistOfItem=null;//Ϊ�˵���������б�
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        TextPad t =new TextPad();
    }
    //���캯��
    public TextPad()
    {
        //����һ�����
        //jp =new JPanel();
        //�������ı��е��ı���
        jta=new JTextArea();
        jta.setRows(20);
        jta.setColumns(20);
        jta.setText(null);
        jta.setFont( new Font(null,10, 22));
        JScrollPane scroll=new JScrollPane();
        scroll.setViewportView(jta);
       arraylistOfItem =new ArrayList<JMenuItem>();
        //����һ���˵���
        jmb =new JMenuBar();
        //����һ���˵�
        jm1 =new JMenu("�ļ�");
        jm1.setMnemonic('F');
        //���� �˵�ѡ��
        jmi1=new JMenuItem("��", new ImageIcon("images/open-sign-128.png"));
        jmi1.setMnemonic('O');
        jmi1.addActionListener(this);;
        jmi1.setActionCommand("��");
        arraylistOfItem.add(jmi1);

        jmi2=new JMenuItem("����");
        jmi2.setMnemonic('S');
        jmi2.addActionListener(this);
        jmi2.setActionCommand("����");
        arraylistOfItem.add(jmi2);
        jmi2.setIcon(new ImageIcon("images/128_save.png"));


        jmi3 =new JMenuItem("�˳�");
        jmi3.setMnemonic('X');
        jmi3.setIcon(new ImageIcon("images/128_exit.png"));
        arraylistOfItem.add(jmi3);
        jmi3.addActionListener(this);
        jmi3.setActionCommand("�˳�");

        //jp.setLayout(new BorderLayout());
        //jp.setBackground(Color.lightGray);

        //����ӽ�����������
        //jp.add(jta,BorderLayout.CENTER);


         //���ô��岼�ֹ����� 
        this.getContentPane().setLayout(new BorderLayout());


        //�����봰��������
        //this.add(jp,BorderLayout.CENTER);
        this.add(scroll, BorderLayout.CENTER);

        this.setJMenuBar(jmb);
        jmb.add(jm1 );
        for(int i=0; i<arraylistOfItem.size(); i++)
        {
            jm1.add(arraylistOfItem.get(i));
        }

        //���ô���Ĵ�С����
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(new Point(400,200));
        this.setResizable(false);




    }



    @Override
    public void actionPerformed(ActionEvent e) 
    {

        String actionCommand = e.getActionCommand();
        switch (actionCommand) 
        {
            case "��":
                this.openFileToTextArea();
                break;

            case "����" :
                this.saveFile(this.getCurFileName());
                break;

            case "�˳�" :
                this.saveFile(this.getCurFileName());
                System.exit(0);
                break;

            case "���Ϊ" :
                this.saveAs();
                break;

            default:
                break;
        }

    }
}


