
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Title      :ProcessActionListener.java
 * Description:When the user press the button,the reply will 
 *             appear on the output area, and a histogram will be created.
 * @author Dunmin Yu
 * @version 1.0
 */
public class ProcessActionListener implements ActionListener {
    /**
     * This method will execute after the user press the button,the reply will 
     * appear on the output area, and a histogram will be created.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = "cmd /c chcp 437&& ping -n " + ProbesComboBox.getInstance().getSelectedItem() + " " + UrlTextField.getInstance().getText();
        String data = execute(cmd);
        // Send the text to the output area.
        EditorTextArea.getInstance().setText(data);
        
        // Draw the histogram.
        System.out.println("data:" + TextUtils.getRTT(data));
        
        Histogram2.getInstance().print(TextUtils.getRTT(data));
    }

    /**
     * This method call the ping command,and read the string from the input stream.
     * @param cmd A string I created before, use it to call the ping command.
     * @return
     */
    // Execute DOS 
    private String execute(String cmd) {
        String str = "";
        try {
            Process process = Runtime.getRuntime().exec(cmd);//Call the ping command.
            process.waitFor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
            //Read the string from the input stream.
            while ((line = bufferedReader.readLine()) != null) {
                line += "\n";
                str += line;
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }

}
