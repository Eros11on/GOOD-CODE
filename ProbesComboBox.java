

import javax.swing.*;
/**
 * Title      :ProbesComboBox.java
 * Description:Create a combo box for users to choose the number of probes.
 * @author Dunmin Yu
 * @version 1.0
 */
/**
 * Set the combo box to select the number of probes.
 */
public class ProbesComboBox extends JComboBox {

    private static ProbesComboBox instance;
    /**
     * Use singleton variables to ensure that the class has only one object.
     * @return
     */
  
    public static synchronized ProbesComboBox getInstance() {
        if (instance == null) {
            instance = new ProbesComboBox();
            instance.init();
        }
        return instance;
    }

    /**
     * Initialize the combo box.��
     */
    private void init() {
        // Sets the number of probes that can be selected.
        String[] listData = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String str : listData) {
            this.addItem(str);//Add the number to the combo box.
        }
        // Set the location of the combo box.
        this.setBounds(170, 70, 40, 25);
    }

}
