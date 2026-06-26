import java.util.HashMap;
import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        boolean flag = true;

        if (s.length() != t.length()) {
            flag = false;
        } else {

            HashMap<Character, Character> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {

                char a = s.charAt(i);
                char b = t.charAt(i);

                if (map.containsKey(a)) {

                    if (map.get(a) != b) {
                        flag = false;
                        break;
                }

                } else {

                    if (map.containsValue(b)) {
                        flag = false;
                        break;
                    }

                    map.put(a, b);
        }
        }
        }

        System.out.println(flag);

        sc.close();
    }
}