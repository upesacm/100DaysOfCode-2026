import java.util.Stack;

public class Question2 {

    public static void insertBottom(Stack<Integer> st,int x){

        if(st.isEmpty()){
            st.push(x);
            return;
        }

        int top=st.pop();

        insertBottom(st,x);

        st.push(top);
    }

    public static void main(String[] args){

        Stack<Integer> st=new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        insertBottom(st,5);

        System.out.println(st);
    }
}