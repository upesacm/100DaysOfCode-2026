package Day_27;

import java.util.*;
public class d27question1_leetcode {
    public static int compress(char[] chars) {
        int write = 0;  
        int read = 0;   

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {
                String num = Integer.toString(count);
                for (char c : num.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // size of the input array
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().charAt(0);     // elements of the array
        }
        int result = compress(a);
        System.out.println(result);
        sc.close();
    }}

