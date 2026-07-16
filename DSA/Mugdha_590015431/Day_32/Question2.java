package DSA.Mugdha_590015431.Day_32;

import java.util.*;

public class Question2 {

    public static void copyStack(Stack<Integer> original, Stack<Integer> copy) {
        if (original.isEmpty()) {
            return;
        }

        int top = original.pop();

        copyStack(original, copy);

        original.push(top);
        copy.push(top);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> original = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        for (int i = 0; i < n; i++) {
            original.push(sc.nextInt());
        }

        copyStack(original, copy);

        System.out.println(copy);

        sc.close();
    }
}