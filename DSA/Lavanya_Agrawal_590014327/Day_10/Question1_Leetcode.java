import java.util.*;

public class Question1_Leetcode {

    public static int strStr(String haystack, String needle) {
        
        int n = haystack.length();
        int m = needle.length();
        
        for (int i = 0; i <= n - m; i++) {
            
            if (haystack.charAt(i) == needle.charAt(0)) {
                
                int j = 0;
                
                while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                
                if (j == m) return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String haystack = sc.nextLine();
        String needle = sc.nextLine();

        System.out.println(strStr(haystack, needle));

        sc.close();
    }
}