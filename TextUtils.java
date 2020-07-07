

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title      :TextUtils.java
 * Description:A text tool to get the values of RTT.
 * @author Dunmin Yu
 * @version 1.0
 */
public class TextUtils {

    /**
     * Get the values of RTT.
     *
     * @param text The string we need to match and obtain the RTT from it.
     * @return
     */
    public static List<Integer> getRTT(String text) {
        Pattern pattern = Pattern.compile("time=(.*)ms");//Compiles the given regular expression.
        Matcher m = pattern.matcher(text);//Matches the text to the expression.
        List<Integer> list = new ArrayList<Integer>();//Create a list to store the RTT.
        while (m.find()) {
        	//Add the content in the first parenthesis to the list.
            list.add(Integer.valueOf(m.group(1)));
        }
        return list;
    }

}
