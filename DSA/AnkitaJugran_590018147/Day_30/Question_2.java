import java.util.Stack;

public class PushElementAtBottom {

    public static void pushAtBottom( Stack<Integer> stack, int x ) {

            if(stack.isEmpty()){
                stack.push(x);
                return;
            }

            int top = stack.pop();
            pushAtBottom(stack, x);
            stack.push(top);
        }


    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int x = 5; //element to push at the bottom of the stack

        System.out.println("Stack Before: " + stack);
        pushAtBottom(stack, x);
        System.out.println("Stack After: " + stack);
    }
}
