package DSA.Mugdha_590015431.Day_11;
import java.util.*;
public class Question2 {
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(processString(s));

        sc.close();
    }

    public static String processString(String s) {
        StringBuilder result = new StringBuilder();

        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch != 'a' && ch != 'e' && ch != 'i' &&
               ch != 'o' && ch != 'u' && ch != 'y') {

                result.append('.');
                result.append(ch);
            }
        }

        return result.toString();
    }
}
