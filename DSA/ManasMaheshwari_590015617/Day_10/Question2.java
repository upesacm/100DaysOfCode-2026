// Question: Determine the correct output based on the number of distinct characters in the username.
// Time Complexity: O(N)
// Space Complexity: O(1)

class Question2 {
    public static void main(String args[]) {
        String username = "sevenkplus";
        int count = username.length();
        
        int distinct_count = 0;
        int seen[] = new int[26];
        
        for (int i = 0; i < count; i++) {
            int char_index = username.charAt(i) - 'a';
            
            if (seen[char_index] == 0) {
                seen[char_index] = 1;
                distinct_count++;
            }
        }
        
        if (distinct_count % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
