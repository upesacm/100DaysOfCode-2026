package Day_29;

import java.util.*;

public class d29question2_technical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();          // size of the input array
        Stack <Character> stack = new Stack<>();
        for (char a: n.toCharArray()) {
            stack.push(a);}
        int stackLength= stack.size();
        for (int i=0; i<stackLength;i++) {
            System.out.print(stack.pop());}
        sc.close();
    }
}
