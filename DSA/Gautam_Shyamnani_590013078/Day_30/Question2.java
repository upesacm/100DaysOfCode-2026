import java.util.Stack;

public class Question2 {
    public static void insertAtBottom(Stack<Integer> st,int x){
        Stack<Integer> temp = new Stack<>();
        
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        st.push(x);

        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
    }
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        
        int x = 5;
        insertAtBottom(st,x);
        System.out.println(st);
    }
}
