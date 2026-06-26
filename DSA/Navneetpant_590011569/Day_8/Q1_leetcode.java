class Solution{ 
    public boolean isPalindrome ( String s ) {
    String k = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
    String reversed = new StringBuilder(k).reverse().toString();
    return k.equals(reversed);
}
}


public class Q1_leetcode {
    public static void main (String [] args) {
    String example = "A man, a plan, a canal: Panama ";
    Solution demo = new Solution();
    boolean result = demo.isPalindrome(example);
    System.out.println(result);
    String example2 = "race a car";
    boolean result2 = demo.isPalindrome(example2);
    System.out.println(result2);

}
}