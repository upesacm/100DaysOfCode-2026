package DSA.Sudhanshu_Ranjan_590018435.Day_8;

class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}

// this is the same question from leetcode - 344. Reverse String.