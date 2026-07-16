import java.util.*;
class Question2 {
    public int compress(char[] chars) {
        int i = 0, write = 0;
        while (i < chars.length) {
            char ch = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }
            chars[write++] = ch;
            if (count > 1)
                for (char c : (count + "").toCharArray())
                    chars[write++] = c;
        }
        return write;
    }

    public static void main(String[] args) {
        Question1_leetcode s = new Question1_leetcode();
        char[] chars = {'a','a','b','b','c','c','c'};
        int len = s.compress(chars);
        for (int i = 0; i < len; i++)
            System.out.print(chars[i] + " ");
    }
}