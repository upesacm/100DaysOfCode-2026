import java.lang.String;

public class Solution {
    public int strStr(String haystack, String needle) {
        int indx = 0;

        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);

        }

        return -1;
    }

}
