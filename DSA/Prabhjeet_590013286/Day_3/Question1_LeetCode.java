class Solution {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) { // Increment if digit is less than 9

                digits[i]++;
                return digits;
            }

            digits[i] = 0; // Carry generated
        }

        int[] result = new int[digits.length + 1];

        result[0] = 1; // Case like 999 -> 1000

        return result;
    }
}

//logic: start from the last digit.
//If digit is less than 9, increment it and return.
//If digit is 9, make it 0 and carry forward.
//If all digits become 0, create a new array with leading!! :)