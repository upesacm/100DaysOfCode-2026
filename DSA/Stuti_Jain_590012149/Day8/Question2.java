import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        ArrayList<Character> list = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        Collections.reverse(list);

        for(char ch : list) {
            System.out.print(ch);
        }
    }
}
