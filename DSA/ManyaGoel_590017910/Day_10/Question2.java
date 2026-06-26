import java.util.*;
public class Question2{
    public static void Gender (String s){
        Set <Character> set = new HashSet<>();
        for (char c:s.toCharArray()){
            set.add(c);
        }
        if(set.size()%2==0) System.out.println("CHAT WITH HER!");
        else System.out.println("IGNORE HIM!");
    }
public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string: ");
    String str = sc.nextLine();
    Gender(str);
    sc.close();
}
}