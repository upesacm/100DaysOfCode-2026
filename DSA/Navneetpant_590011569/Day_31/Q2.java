class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack <Integer> stack = new Stack <> ();
        ArrayList <Integer> al = new ArrayList <> ();
        
        int [] result = new int [arr.length];
        Arrays.fill(result,-1);
        
        for (int i = 0 ; i< arr.length; i++ ) {
            while (!stack.isEmpty() && arr[i]>arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = arr[i]; 
                
            }
            stack.push(i);
        }
        for (int val : result ) {
            al.add(val);
        }
        return al;
       
        
    }
}
