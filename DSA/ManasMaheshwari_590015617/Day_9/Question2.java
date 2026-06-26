// Question: Remove all spaces from the given string using an optimized approach.
// Time Complexity: O(N)
// Space Complexity: O(N)

class Question2 {
    public static void main(String args[]) {
        String s = "C od ing";
        int count = s.length();
        
        String result = "";
        
        for (int i = 0; i < count; i++) {
            if (s.charAt(i) != ' ') {
                result += s.charAt(i);
            }
        }
        
        System.out.println(result);
    }
}
