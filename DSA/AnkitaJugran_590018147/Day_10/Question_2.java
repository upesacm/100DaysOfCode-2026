import java.util.HashSet;

public class Distinct_char {
    public static void main(String[] args) {
        String str = "hello";
        HashSet<Character> set = new HashSet<>();
        for ( char c : str.toCharArray() ) {
            set.add(c);
        }
        if ( set.size() % 2 == 0 ){
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
