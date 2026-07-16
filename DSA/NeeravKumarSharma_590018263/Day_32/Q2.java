import java.util.Stack;

public class Q2 {

    public static Stack<Integer> copy(Stack<Integer> original) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        
        while (!original.isEmpty()) {
            temp.push(original.pop());
        }
        
        while (!temp.isEmpty()) {
            int currentItem = temp.pop();
            
            destination.push(currentItem);
            
            original.push(currentItem);
        }
        
        return destination;
    }
    
    public static void main(String[] args) {
        Stack<Integer> original = new Stack<>();
        
        original.push(1);
        original.push(2);
        original.push(3);
        original.push(4);
        
        Stack<Integer> copied = copy(original);
        
        System.out.println("Output: " + copied); 
    }

}