import java.util.HashSet;

class Q2 {
    public void checkDistinctCharacters(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        
        if (uniqueChars.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        
        System.out.print("Input: abc. Output: ");
        obj.checkDistinctCharacters("abc"); 
        
        System.out.print("Input: abcd. Output: ");
        obj.checkDistinctCharacters("abcd"); 
    }
}

/*class Solution {
    public void checkDistinctCharacters(String s) {
        boolean[] seen = new boolean[256];
        int distinctCount = 0;
        
        for (char c : s.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                distinctCount++;
            }
        }
        
        if (distinctCount % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        
        System.out.print("Input: abc. Output: ");
        obj.checkDistinctCharacters("abc"); 
        
        System.out.print("Input: abcd. Output: ");
        obj.checkDistinctCharacters("abcd"); 
    }
}*/
