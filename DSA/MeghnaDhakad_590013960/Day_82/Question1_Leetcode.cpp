class Solution {
public:
    int numberOfSteps(int num) {
        int steps = 0;
        
        while (num > 0) {
            if (num & 1) {
                // Number is odd, subtract 1
                num--;
            } else {
                // Number is even, divide by 2
                num >>= 1;
            }
            steps++;
        }
        
        return steps;
    }
};