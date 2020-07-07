 
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
    //�������
 
    private JMenuBar menuBar; 	//�˵���
    private JMenu fileMenu;		//�ļ��˵�
    private JMenu editMenu;		//�༭�˵�
    private JMenu helpMenu;		//�����˵�
 
 
    private JTextArea jTextArea;	//�ı�����
    private JScrollPane jScrollPane;		//������
    //�ļ��˵���san��
    private JMenuItem openItem, closeItem, saveItem,aboutItem;
    private JMenuItem newItem, savetoItem;		//�½���Ŀ�����Ϊ��Ŀ
    //�༭�˵��е�������Ŀ
    private JMenuItem editUndo, editCut, editCopy, editPaste;
 
    private FileDialog open,save;		//����һ�����ļ��ͱ����ļ�
    private File file;  	//����һ���ļ�
 
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
    }//DocumentListener����
 
    //ϵͳ���а����
    Toolkit toolkit=Toolkit.getDefaultToolkit();
    Clipboard clipBoard=toolkit.getSystemClipboard();
    //������������������(�볷�������й�)
    protected UndoManager undo=new UndoManager();
    protected UndoableEditListener undoHandler=new UndoHandler();
 
    protected Component statusLabel;
//	jTextArea.addUndoableEditListener(undo);
 
 
    MainFrame() {
        Init();
    }
 
    //��ʼ��
    public void Init(){
        JFrame frame = new JFrame("�˵���");		//����һ����Ϊ���±���α�Ĵ���
        frame.setBounds(300, 300, 700, 450);		//����λ����300��300�����ڴ�СΪ700*450
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);		//
 
        menuBar = new JMenuBar();		//��ʼ���˵���
        fileMenu = new JMenu("�ļ�");		//��ʼ����Ϊ�ļ����ļ��˵�
        editMenu = new JMenu("�༭");		//��ʼ���༭�˵�
        helpMenu = new JMenu("����");		//��ʼ����Ϊ�����İ����˵�
 
//		Document doc = jTextArea.getDocument();
 
        jTextArea = new JTextArea(10, 40);		//10��40��
        Font x = new Font("Monospaced",1,20);	//���������С�Լ�һЩ����
 
        jTextArea.setFont(x);		//ֻ��ʹ��x��������
        jTextArea.setLineWrap(true);//����ָ���������
        //Ӧ���������ù��캯��ָ��JScrollPane�Ŀ��ƶ��󣬴˴�ΪJTextArea��Ȼ���ٽ�JScrollPane
 
        jScrollPane = new JScrollPane(jTextArea);	//����������ӽ����
        //���ù������Զ�����
        jScrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //ˮƽ
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //��ֱ
        jScrollPane.setViewportView(jTextArea);
 
        jTextArea.getDocument().addUndoableEditListener(undo);
 
        //�����ļ��˵��ڲ��Ĺ��ܲ˵�
        newItem = new JMenuItem("�½�");
        openItem = new JMenuItem("�򿪣�O��");
        saveItem = new JMenuItem("���棨S��");
        savetoItem = new JMenuItem("���Ϊ");
        closeItem = new JMenuItem("�˳���X��");
        //����༭�˵��ڲ���Ŀ
        editUndo = new JMenuItem("����");
        editCut = new JMenuItem("����");
        editCopy = new JMenuItem("����");
        editPaste = new JMenuItem("ճ��");
        //�����˵�
        aboutItem = new JMenuItem("���ڼ��±���A��");
 
        //�������ѡ���JMenu
        //����Ӳ˵���˵���
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
        //���ò˵�������
 
        frame.add(menuBar, BorderLayout.NORTH);
        frame.add(jScrollPane, BorderLayout.CENTER);
 
        statusLabel=new JLabel("����F1��ȡ����");
        frame.add(statusLabel,BorderLayout.SOUTH);//�򴰿����״̬����ǩ
        statusLabel.setVisible(false);
 
        //FileDialog ����ʾһ���Ի��򴰿ڣ��û����Դ���ѡ���ļ���
        //��������һ��ģʽ�Ի��򣬵�Ӧ�ó�������� show ��������ʾ�Ի���ʱ��������������Ӧ�ó���ֱ���û�ѡ��һ���ļ���
        open = new FileDialog(frame,"���ĵ�",FileDialog.LOAD);	//���ĵ�ʱ��Ľ���
        save = new FileDialog(frame,"�����ĵ�",FileDialog.SAVE); 	//�����ĵ�ʱ��Ľ���
 
        Event();												//�ĸ���ť�ļ���
        frame.setVisible(true);									//��ʾ����
 
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
     * �������¼�����
     */
    public void Event() {
       final MainFrame mf = this;
        //����Ϊ�ļ��˵�
        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == newItem) {
                        if (!(getTa().getText()).equals("")) {
                            Object[] options = { "ȷ��", "ȡ��" };
                            int response = JOptionPane.showOptionDialog(null,
                                    "���Ƿ񱣴�", "��ʾ", JOptionPane.YES_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    options, options[0]);
                            if (response == 0) {
                                FileDialog d = new FileDialog(mf, "�����ļ�",
                                        FileDialog.SAVE);
                                d.setVisible(true);
                                fileName = d.getDirectory() + d.getFile();
                                FileOutputStream fout = new FileOutputStream(
                                        fileName + ".txt");
 
                                byte[] bb = getTa().getText()
                                        .getBytes();
 
                                fout.write(bb);
                                // �ر�
                                fout.close();
                                JOptionPane.showMessageDialog(null, "�ѱ���");
                                getTa().setText("");
                            }
                            if (response == 1) {
                                JOptionPane.showMessageDialog(null, "��ѡ����ȡ��");
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
                JOptionPane.showMessageDialog(null, "windows���±�\n"
                        + "���@SnoWalker\n" + "����ʵ��");
            }
        });
 
        openItem.addActionListener(new ActionListener()//�˵���Ŀ��������
        {
            public void actionPerformed(ActionEvent e)
            {
                open.setVisible(true);
                String dirPath = open.getDirectory();	//��ȡ�Ի���Ŀ¼��FileDialog��ķ���
                String fileName= open.getFile();    	//��ȡ�Ի���ѡ���ļ�
                if(dirPath==null || fileName==null) 	//��ȡ��
                    return;
 
                jTextArea.setText("");//���ļ�֮ǰ����ı�����
 
                file = new File(dirPath,fileName);
                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(file));//���뻺�������Ч��
                    String line = null;		//����һ������
                    while ((line=br.readLine()) !=null)
                    {
                        //�������ı�׷�ӵ��ĵ���β�����ģ��Ϊ null �����ַ���Ϊ null ��գ���ִ���κβ�����
                        //��Ȼ����� Swing ���������̰߳�ȫ�ģ����˷������̰߳�ȫ�ġ�
                        jTextArea.append(line+"\r\n");
                    }
                }
                catch (IOException ie){
                    throw new RuntimeException("��ȡʧ�ܣ�");
                }
            }
        });
 
        saveItem.addActionListener(new ActionListener()//�˵���Ŀ����������
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
                        FileDialog d = new FileDialog(mf, "���Ϊ", FileDialog.SAVE);
                        d.setVisible(true);
                        fileName = d.getDirectory() + d.getFile();
                        FileOutputStream fout = new FileOutputStream(fileName + ".txt");
                        byte[] bb = getTa().getText().getBytes();
 
                        fout.write(bb);
                        // �ر�
                        fout.close();
                    } catch (Exception e4) {
                        System.out.println(e4.getMessage());
                    }
                }
            }
        });
 
 
 
 
        //����Ϊ�༭�˵�
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