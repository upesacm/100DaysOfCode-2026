import java.util.Scanner;

class Solution {
    public boolean isPalindrome(String s) {
        String str = "";

        for(int i = 0; i<s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            if(Character.isLetterOrDigit(ch)) {
                str += ch;
            }
        }

        String rev = "";

        for(int i = str.length()-1; i>=0; i--) {
            rev += str.charAt(i);
        }

        return str.equals(rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Solution obj = new Solution();

        System.out.println(obj.isPalindrome(s));
    }
}
