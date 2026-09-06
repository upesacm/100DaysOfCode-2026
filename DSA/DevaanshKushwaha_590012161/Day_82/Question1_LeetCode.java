class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;      // even → divide by 2
            } else {
                num -= 1;       // odd → subtract 1
            }
            steps++;
        }
        return steps;
    }
}
