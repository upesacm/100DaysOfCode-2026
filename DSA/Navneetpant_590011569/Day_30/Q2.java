class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        ArrayList <Integer> al = new ArrayList<>();
        while (!st.isEmpty()) {
            al.add(st.pop());
            
        }
        Collections.reverse(al);
        st.push(x);
        for (int i = 0 ; i < al.size(); i++ ) {
            st.push(al.get(i));
        }
        return st;
    }
}