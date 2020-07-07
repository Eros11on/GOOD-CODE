import java.awt.Dimension;
  import java.awt.FileDialog;
  import java.awt.TextArea;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;   
  import java.io.BufferedReader;
  import java.io.BufferedWriter;
  import java.io.File;
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.FileReader;
  import java.io.FileWriter;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import javax.swing.JFrame;
  import javax.swing.JMenu;
  import javax.swing.JMenuBar;
  import javax.swing.JMenuItem; 
 public class JMenuDemo extends JFrame implements ActionListener{
  
    JMenu menu1, menu2, menu3, menu4;//�˵�
     JMenuItem mt1, mt2, mt3, mt4, mt31; //�Ӳ˵�
     FileDialog save, open; //���桢�򿪵Ĵ���
     TextArea textArea; //�ı���
      FileWriter fw;
    BufferedWriter bw;
      FileReader fr;
      BufferedReader br;
     String oldFile;
      String oldFolder;
     /**
     * ������ں���
       * @param args
      */
      public static void main(String[] args) {
          new TestText();
      }
      
      public void JMenuDemo() {
          super("���±�");
        
          /**
           * �˵���
           */
          JMenuBar menuBar = new JMenuBar();
          menu1 = new JMenu("�ļ�(F)",true);
          menu1.setMnemonic('F');
       mt1 = new JMenuItem("�½�(N)",'N');
         mt1.setMnemonic('N');
          mt2 = new JMenuItem("��(O)",'O');
          mt2.addActionListener(this);
          mt2.setMnemonic('O');
          mt3 = new JMenuItem("����(S)",'S');
          mt3.addActionListener(this);
          mt3.setMnemonic('S');
          mt31 = new JMenuItem("���Ϊ...");
          mt31.addActionListener(this);
          mt4 = new JMenuItem("�˳�(X)",'X');
          mt4.addActionListener(this);
          mt4.setMnemonic('X');
          
          menu2 = new JMenu("�༭(E)",true);
          
          
          this.setJMenuBar(menuBar);
         menuBar.add(menu1);
          menuBar.add(menu2);
          menu1.add(mt1);
          menu1.add(mt2);
       menu1.add(mt3);
          menu1.add(mt31);
          menu1.addSeparator();
          menu1.add(mt4);
          
          /**
           * �ı���
           */
          textArea = new TextArea("", 10, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
        save = new FileDialog(this, "�����ļ��Ի���", FileDialog.SAVE);
          open = new FileDialog(this, "���ļ��Ի���", FileDialog.LOAD);
          
         add(textArea);
         
         Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
          this.setSize(600, 600);
         this.setLocation(screenSize.width/2-this.getWidth()/2,screenSize.height/2-this.getHeight()/2);
         this.setVisible(true);
      }
 
     public void actionPerformed(ActionEvent e) {
         /**
          * ���ļ�
          */
         if (e.getSource().equals(mt2)) {
            open();
        }
         /**
          * �����ļ�          */
         if (e.getSource().equals(mt3)) {
           save();         
}
       /**
          * �ļ����Ϊ
          */
         if (e.getSource().equals(mt31)) {
            saveTo();
        }
        /**
          * �˳�
          */
         if (e.getSource().equals(mt4)) {
            exit();
         }
     }
 
     /**
      * �˳����±�
      */
     private void exit() {
         System.exit(0);
     }
 
     /**
      * ���ļ��Ի���
      */
     private void open() {
         String s;
      open.setVisible(true);
         /**
          * ���ļ�
       */
      if (open.getFile() != null) {
             oldFile = open.getFile();
             oldFolder = open.getDirectory();
             File file = new File(open.getDirectory(), open.getFile());
            try {
                 fr = new FileReader(file);
                 String encoding = fr.getEncoding();                 InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),encoding);
                 br = new BufferedReader(inputStreamReader);
                 textArea.setText("");
                while ((s = br.readLine())!= null) {
                     textArea.append(s + "\r\n");
               }
                fr.close();
                inputStreamReader.close();
                br.close();
            } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();             }
         }
     }
     /**
      * �ļ����Ϊ
     * @throws IOException 
    */
     private void saveTo(){
         save.setVisible(true);
         /**
          * �����ļ�
       */
        try {
            if (save.getFile() != null) {
               File file = new File(save.getDirectory(),save.getFile());
               fw = new FileWriter(file);
                 bw = new BufferedWriter(fw);
                bw.write(textArea.getText(), 0, (textArea.getText()).length());
                bw.flush();
               bw.close();
                fw.close();
             }
         } catch (Exception e) {
             e.printStackTrace();
        }
     }

     /**
     * �����ļ�
      */
     private void save() {
        String oldFile = this.oldFile;
        String oldFolder = this.oldFolder;
      if (oldFile != null && oldFolder != null) {
            File file = new File(oldFolder,oldFile);
             if (file.exists()) {
                try {
                    file.createNewFile();
                    fw = new FileWriter(file);
                   bw = new BufferedWriter(fw);
                    bw.write(textArea.getText(), 0, (textArea.getText()).length());
                     bw.flush();
                    bw.close();
                     fw.close();
                } catch (IOException e) {
                  e.printStackTrace();
                }
           }
         } else {
             saveTo();
       }
       
    }
 }