package Day_12;
import java.util.*;
public class d12question2_technical {
    public static int commonArray(String S) {
        boolean[] seen = new boolean[256];
        int distinctElementCount =0;

        for (int i = 0; i < S.length(); i++) {
            int a = (int) S.charAt(i); 
            if (seen[a]==false) {seen[a] = true;distinctElementCount++;}}

        return distinctElementCount;}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(commonArray(sc.nextLine()));
    }
}