class Question1_leetcode {
    public String addBinary(String a, String b) {
        // StringBuilder lets us build the result efficiently
        // (Strings in Java are immutable, so repeated concatenation is slow)
        StringBuilder result = new StringBuilder();

        // Start pointers at the last character of each string (rightmost bit)
        int i = a.length() - 1;
        int j = b.length() - 1;

        // 'carry' holds the carry-over value (0 or 1) from the previous column,
        // just like when you carry a "1" in normal decimal addition
        int carry = 0;

        // Keep looping as long as there are digits left in EITHER string,
        // or there's still a carry to process
        while (i >= 0 || j >= 0 || carry != 0) {

            // Get the current bit from 'a', or 0 if we've run out of digits
            int bitA = (i >= 0) ? (a.charAt(i) - '0') : 0;

            // Get the current bit from 'b', or 0 if we've run out of digits
            int bitB = (j >= 0) ? (b.charAt(j) - '0') : 0;

            // Add the two bits plus any carry from the previous step
            int sum = bitA + bitB + carry;

            // The digit we write down is sum % 2 (0 or 1)
            // Example: 1 + 1 = 2 -> binary digit is 0, carry becomes 1
            //          1 + 1 + 1 = 3 -> binary digit is 1, carry becomes 1
            result.append(sum % 2);

            // The new carry is 1 if sum was 2 or 3, otherwise 0
            carry = sum / 2;

            // Move both pointers one position to the left
            i--;
            j--;
        }

        // We built the result backwards (right to left), so reverse it
        // to get the correct left-to-right binary string
        return result.reverse().toString();
    
        
    }
}