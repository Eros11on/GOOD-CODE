package com.xiets.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JCheckBoxDemo {

    public static void main(String[] args) {
        JFrame jf = new JFrame("��ѡ��");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
         //���һ����ǩ
        JLabel label=new JLabel("��ע��۲�����ı仯")

        // ������ѡ��
        JCheckBox checkBox01 = new JCheckBox("����");
        JCheckBox checkBox02 = new JCheckBox("б��");
       
        // ��ӵ�һ����ѡ���״̬���ı�ļ�����������ѡ�������Ҫ����״̬�ı䣬��ɰ��˷�����Ӽ�����
        checkBox01.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // ��ȡ�¼�Դ������ѡ����
              if (e.getStateChange()==ChangeEvent.SELECTED);{
               
               label.setFont(new Font("����",1,12));
            }
        });

        // ����Ĭ�ϵ�һ����ѡ��ѡ��
        checkBox01.setSelected(true);

        panel.add(checkBox01);
        panel.add(checkBox02);
        
        jf.setContentPane(panel);
        jf.setVisible(true);
    }

}
