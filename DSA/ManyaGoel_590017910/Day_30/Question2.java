import java.util.*;
public class Question2 {
    public static void insert(Stack <Integer> stack,int x){
        if(stack.isEmpty()){
            stack.push(x);
            return ;
        }
        int top=stack.pop();
        insert(stack,x);
        stack.push(top);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter stack elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        System.out.println("Original Stack:" + stack);
        System.out.print("Enter element to insert at bottom: ");
        int x = sc.nextInt();
        insert(stack, x);
        System.out.println("Stack after insertion: " + stack);
        sc.close();
    }
}