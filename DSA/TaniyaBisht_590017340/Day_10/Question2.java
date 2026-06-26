
import java.util.*;
class DG{
    public static void main(String[] args) {
        String str ="WTH";
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<str.length(); i++) {
            set.add(str.charAt(i));
        }
        if(set.size()%2 == 0) {
            System.out.println("CHAT WITH HER!");
        } 
        else{
            System.out.println("IGNORE HIM!");
        }
    }
}