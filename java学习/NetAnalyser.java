

import javax.swing.*;
import java.awt.*;
/**
 * Title      :NetAnalyser.java
 * Description:A graphical user interface application to execute 
 *             the fundamental network diagnostic tool ping
 *             and display its raw output together with a histogram of Round Trip Time (RTT) values.
 * @author Dunmin Yu
 * @version 1.0
 */
public class NetAnalyser {

    /**
     * This class create and display the GUI.
     */
    private void createAndShowGUI() {
        // Create and display the frame.
        JFrame frame = new JFrame("NetAnalyser V1.0");
        frame.setSize(1200, 280);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the Layout as BorderLayout.
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel west = new JPanel();
        
        west.setLayout(new GridLayout(5, 1));
       //Create and set the label.
        JLabel titleLabel = new JLabel("Enter Test URL & no. of probes and click on Process");
        west.add(titleLabel);

        JPanel inputGroup = new JPanel();
        JLabel inputLabel = new JLabel("Test URL");
        inputGroup.add(inputLabel);
        inputGroup.add(UrlTextField.getInstance());
        west.add(inputGroup);

        JPanel selectGroup = new JPanel();
        JLabel selectLabel = new JLabel(" No. of probes");
        selectGroup.add(selectLabel);
        selectGroup.add(ProbesComboBox.getInstance());
        west.add(selectGroup);

        JPanel buttonGroup = new JPanel();
        JButton processButton = new JButton("Process");
        processButton.addActionListener(new ProcessActionListener());
        buttonGroup.add(processButton);
        west.add(buttonGroup);

        frame.getContentPane().add(west, BorderLayout.WEST);

        JPanel center = new JPanel();
        //center.setBackground(Color.RED);
        center.add(EditorTextArea.getInstance());

        frame.getContentPane().add(center, BorderLayout.CENTER);

        JPanel east = new JPanel();
        //east.setBackground(Color.blue);
        east.setLayout(new GridLayout(2, 1));
        JLabel histogram = new JLabel("Histogram                     ");
        east.add(histogram);
        east.add(Histogram2.getInstance());
        frame.getContentPane().add(east, BorderLayout.EAST);

        // Make the frame visible.
        frame.setVisible(true);
    }

    /**
     * This method initialize the panel component.
     *
     * @param panel JPanel of the frame.
     */
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Set the title.
        JLabel titleLabel = new JLabel("Enter Test URL & no. of probes and click on Process");
        titleLabel.setBounds(10, 0, 300, 25);
        panel.add(titleLabel);

        // Set the input field title.
        JLabel inputLabel = new JLabel("Test URL");
        inputLabel.setBounds(10, 37, 55, 25);
        panel.add(inputLabel);

        //Add the URL field.
        panel.add(UrlTextField.getInstance());

        JLabel selectLabel = new JLabel(" No. of probes");
        selectLabel.setBounds(90, 70, 80, 25);
        panel.add(selectLabel);

        // Add a combobox for the number of probes.
        panel.add(ProbesComboBox.getInstance());

        // Set the button.
        JButton processButton = new JButton("Process");
        processButton.setBounds(100, 105, 100, 25);
        processButton.addActionListener(new ProcessActionListener());
        panel.add(processButton);

        // Add the output area.
        panel.add(EditorTextArea.getInstance());

        // The label of the histogram.
        JLabel histogram = new JLabel("Histogram");
        histogram.setBounds(700, 20, 300, 25);
        panel.add(histogram);

        // Add the histogram to the panel.
        panel.add(Histogram2.getInstance());
    }

    public static void main(String[] args) {
        // Display and apply GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NetAnalyser().createAndShowGUI();
            }
        });
    }
}
