
import java.util.Stack;
class BS{
    public static void insertBottom(Stack<Integer> stack, int x){
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int top = stack.pop();
        insertBottom(stack, x);
        stack.push(top);
    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int x = 5;
        insertBottom(stack, x);
        System.out.println(stack);
    }
}