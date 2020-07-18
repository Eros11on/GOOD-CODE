

import javax.swing.*;
/**
 * Title      :UrlTextField.java
 * Description:Create and set the URL text field for users to input.
 * @author Dunmin Yu
 * @version 1.0
 */

public class UrlTextField extends JTextField {
     
    private static UrlTextField instance;
    /**
     * Use singleton variables to ensure that the class has only one object.
     * @return
     */
    
    public static synchronized UrlTextField getInstance() {
        if (instance == null) {
            instance = new UrlTextField();

            // Initializes the input box.??
            instance.setColumns(20);
            instance.setBounds(65, 35, 245, 25);
        }
        return instance;
    }

}
