import java.util.Stack;
class Question2 {
    static Stack<Integer> copy(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>(), c = new Stack<>();
        while (!a.isEmpty()) c.push(a.pop());
        while (!c.isEmpty()) {
            int x = c.pop();
            a.push(x); b.push(x);
        } return b;
    }
}