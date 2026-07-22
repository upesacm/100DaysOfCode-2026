class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int zero = 0;
        int one = 0;

        // Count student preferences
        for (int s : students) {
            if (s == 0)
                zero++;
            else
                one++;
        }

        // Process sandwiches
        for (int sandwich : sandwiches) {

            if (sandwich == 0) {
                if (zero == 0)
                    return one;
                zero--;
            } else {
                if (one == 0)
                    return zero;
                one--;
            }
        }

        return 0;
    }
}