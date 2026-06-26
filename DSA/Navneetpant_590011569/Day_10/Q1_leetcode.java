class Solution {
    public int strStr(String haystack, String needle) {
        int p1 = 0;
        int p2 = needle.length();

        if (needle.length()>haystack.length()){
            return -1;
        }
        for (int i = 0 ; i < haystack.length() ; i ++ ) {
            if (haystack.substring(p1,p2).equals(needle)){
                return p1;

            }
            else{
                if (p2==haystack.length()){
                    return -1;
                }
                p1++;
                p2++;
            }

        }

       return -1;

        
    }
}
public class Q1_leetcode{
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";
        Solution temp = new Solution();
        System.out.println(temp.strStr(haystack, needle));


    }
}