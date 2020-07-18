package com.xiets.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JCheckBoxDemo {

    public static void main(String[] args) {
        JFrame jf = new JFrame("复选框");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
         //添加一个标签
        JLabel label=new JLabel("请注意观察宋体的变化")

        // 创建复选框
        JCheckBox checkBox01 = new JCheckBox("粗体");
        JCheckBox checkBox02 = new JCheckBox("斜体");
       
        // 添加第一个复选框的状态被改变的监听（其他复选框如果需要监听状态改变，则可按此方法添加监听）
        checkBox01.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // 获取事件源（即复选框本身）
              if (e.getStateChange()==ChangeEvent.SELECTED);{
               
               label.setFont(new Font("宋体",1,12));
            }
        });

        // 设置默认第一个复选框选中
        checkBox01.setSelected(true);

        panel.add(checkBox01);
        panel.add(checkBox02);
        
        jf.setContentPane(panel);
        jf.setVisible(true);
    }

}
