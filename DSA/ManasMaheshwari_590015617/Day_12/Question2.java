// Question: Find the length of the smallest valid substring containing all distinct characters.
// Time Complexity: O(N^2)
// Space Complexity: O(1)

class Question2 {
    public static void main(String args[]) {
        String text = "zzxyzz";
        int count = text.length();
        
        int distinct = 0;
        int seen[] = new int[256];
        for (int i = 0; i < count; i++) {
            if (seen[text.charAt(i)] == 0) {
                distinct++;
                seen[text.charAt(i)] = 1;
            }
        }
        
        int min = count;
        
        for (int i = 0; i < count; i++) {
            int current = 0;
            int window[] = new int[256];
            
            for (int j = i; j < count; j++) {
                if (window[text.charAt(j)] == 0) {
                    current++;
                    window[text.charAt(j)] = 1;
                }
                
                if (current == distinct) {
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                    }
                    break;
                }
            }
        }
        
        System.out.println(min);
    }
}
