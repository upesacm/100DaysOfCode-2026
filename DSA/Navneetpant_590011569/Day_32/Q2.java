class Solution {
    public Stack<Integer> cloneStack(Stack<Integer> st) {
           if (st.isEmpty()) {
               return new Stack<>();
               
               
           }
        
           int temp = st.pop();
           
           Stack <Integer> clone = cloneStack(st);
           clone.push(temp);
           st.push(temp);
           
           
            
        
        return clone;
    }
}