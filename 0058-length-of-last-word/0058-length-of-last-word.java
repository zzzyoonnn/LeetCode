import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        String word = "";
        while (st.hasMoreTokens()) {
            word = st.nextToken();
        }
        
        return word.length();
    }
}