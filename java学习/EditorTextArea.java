

import javax.swing.*;
/**
 * Title      :EditorTextArea.java
 * Description:Create the output display area.
 * @author Dunmin Yu
 * @version 1.0
 */


public class EditorTextArea extends JTextArea {

    private static EditorTextArea instance;

    /**
     * Gets the singleton object in the output display area.
     *
     * @return
     */
    public static synchronized EditorTextArea getInstance() {
        if (instance == null) {
            instance = new EditorTextArea();
            instance.init();
        }
        return instance;
    }

    /**
     * Initializes the output display area.
     */
    private void init() {
    	this.setText("Your output will appear here..");
        this.setBounds(330, 0, 350, 300);//Set the location of the text.
    }

}
