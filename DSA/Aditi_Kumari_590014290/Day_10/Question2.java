package Day_10;
import java.util.*;
public class Question2 {
    public static void main(String[]args){
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the string");
        String s= scan.nextLine();
        HashSet <Character> set= new HashSet<>();
        for (int i =0; i<s.length(); i++){
            set.add(s.charAt(i));
        }
        if (set.size() %2 ==0){
            System.out.println("CHAT WITH HER!");
        }
        else{
            System.out.println("IGNORE HIM!");
        }
        scan.close();
    }
}
