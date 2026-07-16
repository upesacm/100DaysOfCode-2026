void copyStack(Stack<Integer> st, Stack<Integer> copy) {
    Stack<Integer> temp = new Stack<>();

    while (!st.isEmpty())
        temp.push(st.pop());

    while (!temp.isEmpty()) {
        int x = temp.pop();
        st.push(x);
        copy.push(x);
    }
}