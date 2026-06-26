package Day_11;

import java.util.*;
public class Question2 {
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the string:");
        String s = scan.next();
        StringBuilder result = new StringBuilder();
        for (char ch : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) == -1) {
                result.append(".").append(ch);
            }
        }
        System.out.println(result); 
        scan.close();
}
}
