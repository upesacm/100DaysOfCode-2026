import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        System.out.print(s.chars().distinct().count() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
    }
}