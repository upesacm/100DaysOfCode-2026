// Question: Reverse the given string and print the reversed result.
// Time Complexity: O(N)
// Space Complexity: O(N)

class Question2 {
    public static void main(String args[]) {
        String text = "Computer";
        int count = text.length();
        
        char text_array[] = text.toCharArray();
        
        for (int i = 0; i < count / 2; i++) {
            char temp = text_array[i];
            text_array[i] = text_array[count - 1 - i];
            text_array[count - 1 - i] = temp;
        }
        
        String reversed = new String(text_array);
        System.out.println(reversed);
    }
}
