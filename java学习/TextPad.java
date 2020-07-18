package com.txt;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
public class TextPad extends JFrame implements ActionListener
{

    //定义一个面板
    //JPanel jp =null;
    JTextArea jta =null;


    //定义菜单条
    JMenuBar jmb=null;
    //定义菜单
    JMenu jm1 =null;
    //定义菜单选项
    JMenuItem jmi1=null;
    JMenuItem jmi2=null;
    JMenuItem jmi3=null;
    JMenuItem jmi4 =null;
    ArrayList<JMenuItem> arraylistOfItem=null;//为菜单项创建集合列表
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        TextPad t =new TextPad();
    }
    //构造函数
    public TextPad()
    {
        //创建一个面板
        //jp =new JPanel();
        //创建多文本行的文本域
        jta=new JTextArea();
        jta.setRows(20);
        jta.setColumns(20);
        jta.setText(null);
        jta.setFont( new Font(null,10, 22));
        JScrollPane scroll=new JScrollPane();
        scroll.setViewportView(jta);
       arraylistOfItem =new ArrayList<JMenuItem>();
        //创建一个菜单条
        jmb =new JMenuBar();
        //创建一个菜单
        jm1 =new JMenu("文件");
        jm1.setMnemonic('F');
        //创建 菜单选项
        jmi1=new JMenuItem("打开", new ImageIcon("images/open-sign-128.png"));
        jmi1.setMnemonic('O');
        jmi1.addActionListener(this);;
        jmi1.setActionCommand("打开");
        arraylistOfItem.add(jmi1);

        jmi2=new JMenuItem("保存");
        jmi2.setMnemonic('S');
        jmi2.addActionListener(this);
        jmi2.setActionCommand("保存");
        arraylistOfItem.add(jmi2);
        jmi2.setIcon(new ImageIcon("images/128_save.png"));


        jmi3 =new JMenuItem("退出");
        jmi3.setMnemonic('X');
        jmi3.setIcon(new ImageIcon("images/128_exit.png"));
        arraylistOfItem.add(jmi3);
        jmi3.addActionListener(this);
        jmi3.setActionCommand("退出");

        //jp.setLayout(new BorderLayout());
        //jp.setBackground(Color.lightGray);

        //组件加进面板组件里面
        //jp.add(jta,BorderLayout.CENTER);


         //设置窗体布局管理器 
        this.getContentPane().setLayout(new BorderLayout());


        //面板加入窗体容器，
        //this.add(jp,BorderLayout.CENTER);
        this.add(scroll, BorderLayout.CENTER);

        this.setJMenuBar(jmb);
        jmb.add(jm1 );
        for(int i=0; i<arraylistOfItem.size(); i++)
        {
            jm1.add(arraylistOfItem.get(i));
        }

        //设置窗体的大小属性
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
            case "打开":
                this.openFileToTextArea();
                break;

            case "保存" :
                this.saveFile(this.getCurFileName());
                break;

            case "退出" :
                this.saveFile(this.getCurFileName());
                System.exit(0);
                break;

            case "另存为" :
                this.saveAs();
                break;

            default:
                break;
        }

    }
}


