import java.util.Stack;

public class CopyStack {

    public static void main(String[] args) {

        Stack<Integer> original = new Stack<>();

        original.push(1);
        original.push(2);
        original.push(3);
        original.push(4);

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        //Move elements from original stack to temp stack
        while (!original.isEmpty()) {
            temp.push(original.pop());
        }

        // Now the order is reversed in temp stack. Restore original and create copy stack
        while (!temp.isEmpty()) {

            int element = temp.pop();

            original.push(element);
            copy.push(element);
        }

        System.out.println("Original Stack: " + original);
        System.out.println("Copied Stack: " + copy);
    }
}