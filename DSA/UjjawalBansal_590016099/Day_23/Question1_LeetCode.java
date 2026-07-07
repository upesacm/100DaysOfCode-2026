import java.util.Arrays;

public class Question1_LeetCode {
    public int findContentChildren(int[] g, int[] s) {
        int len1 = g.length;
        int len2 = s.length;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0, j = 0;
        while (i<len1 && j<len2) {
            if (g[i]<=s[j]) {
                i++;
                j++;
            }
            else j++;
        }
        return i;
    }
}
