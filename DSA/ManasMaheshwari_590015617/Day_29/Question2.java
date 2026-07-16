class Question2 {
    public static void main(String[] args) {
        String s = "hello"; // Sample test case
        
        System.out.println(reverseString(s));
    }
    
    public static String reverseString(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int top = -1;
        
        for (int i = 0; i < n; i++) {
            top++;
            stack[top] = s.charAt(i);
        }
        
        char[] reversed = new char[n];
        int index = 0;
        
        while (top >= 0) {
            reversed[index] = stack[top];
            top--;
            index++;
        }
        
        return new String(reversed);
    }
}
