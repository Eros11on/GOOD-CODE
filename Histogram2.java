
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Title      :Histogram2.java
 * Description:Use the value of RTT to create a histogram.
 * @author Dunmin Yu
 * @version 1.0
 */
public class Histogram2 extends JPanel {

    private int x = 1;

    private int y = 1;

    public static final int BINS = 3;

    private static Histogram2 instance;
    //Use singleton variables to ensure that the class has only one object.
    public static synchronized Histogram2 getInstance() {
        if (instance == null) {
            instance = new Histogram2();
            instance.init();
        }
        return instance;
    }

    private void init() {
        
    }
    
    /**
     * This method generate a list, which contains 
     * the maximum and the minimum of the RTT's interval. 
     * @param min   int number as the minimum of the interval.
     * @param max   int number as the maximum of the interval.
     * @param rang  int number as the range of the interval.
     * @return A list.
     */
    private List<List<Integer>> getInterval(int min, int max, int rang) {
        // Save the generated interval.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int temStart = min, b1, b2;
        // Generate interval value.
        for (int i = 0; i < BINS; i++) {
            b1 = temStart; 
            b2 = rang;
            System.out.println("min:" + Arrays.asList(b1, b1 + b2));
            result.add(Arrays.asList(b1, b1 + b2)); //Add the minimum to the list.
            temStart = b1 + b2;
        }
        if (temStart < max) {
            System.out.println("max:" + Arrays.asList(temStart, max));
            result.add(Arrays.asList(temStart, max));// Add the maximum to the list.
        }
        return result;
    }

    
    
    /**
     * This method create the histogram of RTT.
     * @param data  A List which contains integer values as minimum and maximum of an interval.
     */
    public void print(List<Integer> data) {
        // Redraw
        this.removeAll(); 
        x = 0;
        y = 0;
        Map<String, Integer> his = new HashMap<String, Integer>(); //Create a hash map instance.

        // The sorting.
        Collections.sort(data);
        // Take the minimum and the maximum.
        int min = data.get(0); //Get the minimum of the interval.
        int max = data.get(data.size() - 1);//Get the maximum of the interval.
        //Calculate bins.
        int rang = (max - min) / BINS == 0 ? 1 : (max - min) / BINS;
        System.out.println("min:" + min + ", max:" + max + ", rang:" + rang);

        //System.out.println(result);
        List<List<Integer>> result = this.getInterval(min, max, rang);
        // Traverse the interval and draw the labels on histogram.
        List<List<Object>> hisDate = new ArrayList<List<Object>>();//Create an array list.
        for (List<Integer> list : result) {
            Integer start = list.get(0), end = list.get(1);//Get the first and second value of list as minimum and maximum of the interval.
            for (Integer key : list) {
                if (result.indexOf(list) == result.size() - 1) {
                    if (start <= key && key < end) {// If key is in the interval.
                        List<Object> map = new ArrayList<>();
                        // Gets the number of times the data appears in the interval.
                        int num = count(false, start, end, data);
                        if (num > y) {
                            y = num;
                        }
                        map.add(start + "<=RTT<=" + end);//Add this string which represent the interval to map.
                        map.add(num);
                        hisDate.add(map);
                    }
                } else {
                    if (start <= key && key < end) {
                        List<Object> map = new ArrayList<>();//Create an array list.
                        // Gets the number of times the data appears in the interval.
                        int num = count(true, start, end, data);
                        if (num > y) {
                            y = num;
                        }
                        map.add(start + "<=RTT<" + end);
                        map.add(num);
                        hisDate.add(map);
                    }
                }
            }
        }
        System.out.println(hisDate);
        // Draw the histogram.
        x = hisDate.size();
        y = y + 1;
        System.out.println("x:" + x + ", y??" + y);
        this.setLayout(new GridLayout(x, y));//Create new layout.
        for (List<Object> map : hisDate) {   
            JLabel lb = new JLabel((String) map.get(0));
            this.add(lb); //Add the label to the panel.
            for (int i = 0; i < (int) map.get(1); i++) {
                JLabel lbd = new JLabel("*");//Create and add this "*" to the panel.
                this.add(lbd);
            }
            int e = (y - 1) - (int) map.get(1);
            for (int i = 0; i < e; i++) {
                JLabel lbd = new JLabel("");//Add a space to the panel.
                this.add(lbd);
            }
        }

        this.repaint();
    }

    /**
     * This method gets the number of times the data appears in the interval.
     *
     * @param fl Boolean value which means whether the index 
     *        of list equals to the size of list "result".
     * @param start int number means the minimum of the interval.
     * @param end   int number means the maximum of the interval.
     * @param data  A List which contains integer values as minimum and maximum of an interval.
     * @return  The number of times the data appears in the interval.
     */
    public int count(boolean fl, int start, int end, List<Integer> data) {
        int count = 0;
        for (Integer d : data) {
            if (fl) {
                if (start <= d && d < end) {//d is in the interval.
                    count++;
                }
            } else {
                if (start <= d && d <= end) {
                    count++;
                }
            }
        }
        return count;
    }

}
