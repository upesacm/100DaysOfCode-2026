package DSA.VridhiJain_590014870.Day_9;
import java.util.*;
public class Question2.java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                result += s.charAt(i);
            }
        }
        System.out.println(result);
    }
}
