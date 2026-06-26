// Question: Modify a string by removing all vowels, converting consonants to lowercase, and adding a dot before each.
// Time Complexity: O(N)
// Space Complexity: O(N)

class Question2 {
    public static void main(String args[]) {
        String text = "Hello";
        int count = text.length();
        
        String result = "";
        
        for (int i = 0; i < count; i++) {
            char c = text.charAt(i);
            char lower = Character.toLowerCase(c);
            
            if (lower != 'a' && lower != 'e' && lower != 'i' && lower != 'o' && lower != 'u' && lower != 'y') {
                result += "." + lower;
            }
        }
        
        System.out.println(result);
    }
}
