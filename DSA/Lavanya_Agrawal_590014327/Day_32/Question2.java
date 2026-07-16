import java.util.Scanner;
import java.util.Stack;

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

        for (int i = 0; i < n; i++) {
            original.push(sc.nextInt());
        }

        Stack<Integer> copy = new Stack<>();

        copyStack(original, copy);

        System.out.println(copy);

        sc.close();
    }
}
