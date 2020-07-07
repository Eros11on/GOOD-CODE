 
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.text.Document;
import javax.swing.JTextArea;
import javax.swing.text.PlainDocument;
 
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import javax.swing.undo.*;
 
 
 
 
public class MainFrame extends JFrame{
    //设置组件
 
    private JMenuBar menuBar; 	//菜单条
    private JMenu fileMenu;		//文件菜单
    private JMenu editMenu;		//编辑菜单
    private JMenu helpMenu;		//帮助菜单
 
 
    private JTextArea jTextArea;	//文本区域
    private JScrollPane jScrollPane;		//滚动条
    //文件菜单内san项
    private JMenuItem openItem, closeItem, saveItem,aboutItem;
    private JMenuItem newItem, savetoItem;		//新建项目，另存为项目
    //编辑菜单中的所有项目
    private JMenuItem editUndo, editCut, editCopy, editPaste;
 
    private FileDialog open,save;		//定义一个打开文件和保存文件
    private File file;  	//定义一个文件
 
    String fileName,copy,paste,cut;
 
//	public UndoManager undoMgr = new UndoManager();
 
 
 
    class UndoHandler implements UndoableEditListener
    { public void undoableEditHappened(UndoableEditEvent uee)
    { undo.addEdit(uee.getEdit());
    }
    }
    public void removeUpdate(DocumentEvent e)
    { editUndo.setEnabled(true);
    }
    public void insertUpdate(DocumentEvent e)
    { editUndo.setEnabled(true);
    }
    public void changedUpdate(DocumentEvent e)
    { editUndo.setEnabled(true);
    }//DocumentListener结束
 
    //系统剪切板调用
    Toolkit toolkit=Toolkit.getDefaultToolkit();
    Clipboard clipBoard=toolkit.getSystemClipboard();
    //创建撤销操作管理器(与撤销操作有关)
    protected UndoManager undo=new UndoManager();
    protected UndoableEditListener undoHandler=new UndoHandler();
 
    protected Component statusLabel;
//	jTextArea.addUndoableEditListener(undo);
 
 
    MainFrame() {
        Init();
    }
 
    //初始化
    public void Init(){
        JFrame frame = new JFrame("菜单栏");		//建立一个名为记事本·伪的窗口
        frame.setBounds(300, 300, 700, 450);		//窗口位置在300，300，窗口大小为700*450
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);		//
 
        menuBar = new JMenuBar();		//初始化菜单栏
        fileMenu = new JMenu("文件");		//初始化名为文件的文件菜单
        editMenu = new JMenu("编辑");		//初始化编辑菜单
        helpMenu = new JMenu("帮助");		//初始话名为帮助的帮助菜单
 
//		Document doc = jTextArea.getDocument();
 
        jTextArea = new JTextArea(10, 40);		//10行40列
        Font x = new Font("Monospaced",1,20);	//定义字体大小以及一些属性
 
        jTextArea.setFont(x);		//只能使用x这种字体
        jTextArea.setLineWrap(true);//到达指定宽度则换行
        //应当首先利用构造函数指定JScrollPane的控制对象，此处为JTextArea，然后再讲JScrollPane
 
        jScrollPane = new JScrollPane(jTextArea);	//将滚动条添加进面板
        //设置滚动条自动出现
        jScrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //水平
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //竖直
        jScrollPane.setViewportView(jTextArea);
 
        jTextArea.getDocument().addUndoableEditListener(undo);
 
        //定义文件菜单内部的功能菜单
        newItem = new JMenuItem("新建");
        openItem = new JMenuItem("打开（O）");
        saveItem = new JMenuItem("保存（S）");
        savetoItem = new JMenuItem("另存为");
        closeItem = new JMenuItem("退出（X）");
        //定义编辑菜单内部项目
        editUndo = new JMenuItem("撤销");
        editCut = new JMenuItem("剪切");
        editCopy = new JMenuItem("复制");
        editPaste = new JMenuItem("粘贴");
        //帮助菜单
        aboutItem = new JMenuItem("关于记事本（A）");
 
        //添加两个选项卡到JMenu
        //添加子菜单项到菜单项
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
 
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(savetoItem);
        fileMenu.add(closeItem);
        editMenu.add(editUndo);
        editMenu.add(editCut);
        editMenu.add(editCopy);
        editMenu.add(editPaste);
        helpMenu.add(aboutItem);
        //放置菜单项及输入框
 
        frame.add(menuBar, BorderLayout.NORTH);
        frame.add(jScrollPane, BorderLayout.CENTER);
 
        statusLabel=new JLabel("　按F1获取帮助");
        frame.add(statusLabel,BorderLayout.SOUTH);//向窗口添加状态栏标签
        statusLabel.setVisible(false);
 
        //FileDialog 类显示一个对话框窗口，用户可以从中选择文件。
        //由于它是一个模式对话框，当应用程序调用其 show 方法来显示对话框时，它将阻塞其余应用程序，直到用户选择一个文件。
        open = new FileDialog(frame,"打开文档",FileDialog.LOAD);	//打开文档时候的界面
        save = new FileDialog(frame,"保存文档",FileDialog.SAVE); 	//保存文档时候的界面
 
        Event();												//四个按钮的监听
        frame.setVisible(true);									//显示界面
 
    }
    public JTextArea getTa() {
        return jTextArea;
    }
    public void checkMenuItemEnabled()
    { String selectText=jTextArea.getSelectedText();
        if(selectText==null)
        { editCut.setEnabled(true);
//	popupCut.setEnabled(false);
            editCopy.setEnabled(true);
//	popupCopy.setEnabled(false);
           
        }
        else
        { editCut.setEnabled(true);
//	popupMenu_Cut.setEnabled(true);
            editCopy.setEnabled(true);
//	popupMenu_Copy.setEnabled(true);
           
        }
    }
 
   
 
    /*
     * 组件添加事件，，
     */
    public void Event() {
       final MainFrame mf = this;
        //以下为文件菜单
        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == newItem) {
                        if (!(getTa().getText()).equals("")) {
                            Object[] options = { "确定", "取消" };
                            int response = JOptionPane.showOptionDialog(null,
                                    "你是否保存", "提示", JOptionPane.YES_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    options, options[0]);
                            if (response == 0) {
                                FileDialog d = new FileDialog(mf, "保存文件",
                                        FileDialog.SAVE);
                                d.setVisible(true);
                                fileName = d.getDirectory() + d.getFile();
                                FileOutputStream fout = new FileOutputStream(
                                        fileName + ".txt");
 
                                byte[] bb = getTa().getText()
                                        .getBytes();
 
                                fout.write(bb);
                                // 关闭
                                fout.close();
                                JOptionPane.showMessageDialog(null, "已保存");
                                getTa().setText("");
                            }
                            if (response == 1) {
                                JOptionPane.showMessageDialog(null, "你选择了取消");
                                getTa().setText("");
                            }
                        }
                    }
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
        });
 
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
 
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "windows记事本\n"
                        + "借鉴@SnoWalker\n" + "用于实现");
            }
        });
 
        openItem.addActionListener(new ActionListener()//菜单条目监听：打开
        {
            public void actionPerformed(ActionEvent e)
            {
                open.setVisible(true);
                String dirPath = open.getDirectory();	//获取对话框目录；FileDialog类的方法
                String fileName= open.getFile();    	//获取对话框选定文件
                if(dirPath==null || fileName==null) 	//点取消
                    return;
 
                jTextArea.setText("");//打开文件之前清空文本区域
 
                file = new File(dirPath,fileName);
                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(file));//放入缓存器提高效率
                    String line = null;		//定义一个空行
                    while ((line=br.readLine()) !=null)
                    {
                        //将给定文本追加到文档结尾。如果模型为 null 或者字符串为 null 或空，则不执行任何操作。
                        //虽然大多数 Swing 方法不是线程安全的，但此方法是线程安全的。
                        jTextArea.append(line+"\r\n");
                    }
                }
                catch (IOException ie){
                    throw new RuntimeException("读取失败！");
                }
            }
        });
 
        saveItem.addActionListener(new ActionListener()//菜单条目监听：保存
        {
            public void actionPerformed(ActionEvent e)
            {
                if(file==null)
                {
                    save.setVisible(true);
                    String dirPath = save.getDirectory();
                    String fileName= save.getFile();
                    if(dirPath==null || fileName==null)
                        return;
                    file = new File(dirPath,fileName);
                }
                try
                {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    String text = jTextArea.getText();
                    bw.write(text);
                    bw.close();
                }
                catch (IOException ex)
                {
                    throw new RuntimeException();
                }
            }
        });
 
        savetoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == savetoItem) {
                    try {
                        FileDialog d = new FileDialog(mf, "另存为", FileDialog.SAVE);
                        d.setVisible(true);
                        fileName = d.getDirectory() + d.getFile();
                        FileOutputStream fout = new FileOutputStream(fileName + ".txt");
                        byte[] bb = getTa().getText().getBytes();
 
                        fout.write(bb);
                        // 关闭
                        fout.close();
                    } catch (Exception e4) {
                        System.out.println(e4.getMessage());
                    }
                }
            }
        });
 
 
 
 
        //以下为编辑菜单
        editUndo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextArea.requestFocus();
                if(undo.canUndo())
                { try
                { undo.undo();
                }
                catch (CannotUndoException ex)
                { System.out.println("Unable to undo:" + ex);
                    //ex.printStackTrace();
                }
                }
                if(!undo.canUndo())
                { editUndo.setEnabled(false);
                }
            }
        });
        editCut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == editCut) {
                    jTextArea.requestFocus();
                    String text=jTextArea.getSelectedText();
                    StringSelection selection=new StringSelection(text);
                    clipBoard.setContents(selection,null);
                    jTextArea.replaceRange("",jTextArea.getSelectionStart(),jTextArea.getSelectionEnd());
                    checkMenuItemEnabled();
 
                }
            }
        });
        editCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == editCopy) {
                    jTextArea.requestFocus();
                    String text=jTextArea.getSelectedText();
                    StringSelection selection=new StringSelection(text);
                    clipBoard.setContents(selection,null);
                    checkMenuItemEnabled();
                }
            }
        });
        editPaste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == editPaste) {
                    jTextArea.requestFocus();
                    Transferable contents=clipBoard.getContents(this);
                    if(contents==null)return;
                    String text="";
                    try
                    { text=(String)contents.getTransferData(DataFlavor.stringFlavor);
                    }
                    catch (Exception exception)
                    {
                    }
                    jTextArea.replaceRange(text,jTextArea.getSelectionStart(),jTextArea.getSelectionEnd());
                    checkMenuItemEnabled();
                }
            }
        });
  
    }
 
    public static void main(String[] args){
        new MainFrame();
    }
}