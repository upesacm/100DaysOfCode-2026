import java.util.*;
public class Question2 {
    static void bottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int top = stack.pop();
        bottom(stack, x);
        stack.push(top);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        int x = sc.nextInt();
        bottom(stack, x);
        System.out.println(stack);
    }
}