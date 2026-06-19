class Question1_leetcode {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse the array backwards (from least significant digit to most)
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, just add 1 and we are done!
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit was 9, it becomes 0, and the loop continues to carry the 1
            digits[i] = 0;
        }
        
        // If we exit the loop, it means ALL digits were 9 (e.g., [9, 9, 9])
        // We need a new array of size n + 1 (e.g., [1, 0, 0, 0])
        int[] newnum = new int[n + 1];
        newnum[0] = 1; // The rest of the elements default to 0 in Java
        
        return newnum;
    }
}