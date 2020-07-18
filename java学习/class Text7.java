package day01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Text7 {
    public static class cannian extends JFrame {
        JTextField ac;
        JLabel a1, a2, a3;
        JCheckBox b1, b2;
        JRadioButton c1, c2, c3, c4;
        JComboBox d;
        JPanel ad;
        ButtonGroup e;
        static int count = 1;

        public cannian() {
            super("字体特效");
            ac = new JTextField("中文字体");
            ac.setEditable(false);
            a1 = new JLabel("字体样式");
            a2 = new JLabel("字体");
            a3 = new JLabel("字号");
            b1 = new JCheckBox("粗体");
            b2 = new JCheckBox("斜体");
            e = new ButtonGroup();
            c1 = new JRadioButton("宋体");
            c2 = new JRadioButton("黑体");
            c3 = new JRadioButton("隶书");
            c4 = new JRadioButton("楷体_GB2312");
            ad = new JPanel();
            ad.add(c1);
            ad.add(c2);
            ad.add(c3);
            ad.add(c4);
            e.add(c1);
            e.add(c2);
            e.add(c3);
            e.add(c4);
            d = new JComboBox();
            d.addItem("80");
            d.addItem("70");
            d.addItem("60");
            d.addItem("50");
            d.addItem("40");
            d.addItem("30");
            d.addItem("20");
            d.addItem("10");
            this.setLayout(null);
            ac.setBounds(1, 1, 300, 100);
            a1.setBounds(30, 110, 70, 30);
            a2.setBounds(130, 110, 70, 30);
            a3.setBounds(230, 110, 70, 30);
            b1.setBounds(40, 130, 60, 20);
            b2.setBounds(40, 160, 60, 20);
            c1.setBounds(130, 130, 60, 20);
            c2.setBounds(130, 150, 60, 20);
            c3.setBounds(130, 170, 60, 20);
            c4.setBounds(130, 190, 60, 20);
            d.setBounds(220, 130, 50, 25);
            this.add(ac);
            this.add(a1);
            this.add(a2);
            this.add(a3);
            this.add(b1);
            this.add(b2);
            this.add(c1);
            this.add(c2);
            this.add(c3);
            this.add(c4);
            this.add(d);
            ItemEvent a = new ItemEvent();
            b1.addActionListener(a);
            b2.addActionListener(a);
            c1.addActionListener(a);
            c2.addActionListener(a);
            c3.addActionListener(a);
            d.addActionListener(a);
            this.setSize(300, 300);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        public class ItemEvent implements ActionListener {
            //重写ActionListener接口中的事件处理方法actionPerformed()
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                Object b0 = null;
                if (source == b1) {
                    ac.setFont(new Font("", Font.BOLD, 20));
                } else if (source == b2) {
                    ac.setFont(new Font("", Font.ITALIC, 20));
                }
                if (source == c1) {
                    ac.setFont(new Font("宋体", Font.PLAIN, 20));
                }
                if (source == c2) {
                    ac.setFont(new Font("黑体", Font.PLAIN, 20));
                }
                if (source == c3) {
                    ac.setFont(new Font("隶书", Font.PLAIN, 20));
                }
                if (source == c4) {
                    ac.setFont(new Font("楷体_GB2312", Font.PLAIN, 20));
                }
                if (source == d) {
                    switch (d.getSelectedIndex()) {
                        case 1:
                            ac.setFont(new Font("", Font.PLAIN, 80));
                        case 2:
                            ac.setFont(new Font("", Font.PLAIN, 70));
                        case 3:
                            ac.setFont(new Font("", Font.PLAIN, 60));
                        case 4:
                            ac.setFont(new Font("", Font.PLAIN, 50));
                        case 5:
                            ac.setFont(new Font("", Font.PLAIN, 40));
                        case 6:
                            ac.setFont(new Font("", Font.PLAIN, 30));
                        case 7:
                            ac.setFont(new Font("", Font.PLAIN, 20));
                        case 8:
                            ac.setFont(new Font("", Font.PLAIN, 10));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        cannian a = new cannian();
        a.setVisible(true);
    }
}
