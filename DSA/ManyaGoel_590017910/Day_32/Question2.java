import java.util.*;
public class Question2 {
    static Stack <Integer> copiedStack = new Stack<>();
    public static void copyStack(Stack <Integer> st){
        if(st.isEmpty())
            return;

        int x = st.pop();
        copyStack(st);
        st.push(x);
        copiedStack.push(x);
}
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size: ");
    int n = sc.nextInt();
    Stack<Integer> st = new Stack<>();
    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
        st.push(sc.nextInt());
    }
    copyStack(st);
    System.out.println("Original Stack: " + st);
    System.out.println("Copied Stack: " + copiedStack);
    sc.close();
}
}