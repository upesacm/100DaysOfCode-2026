public class Question1_Leetcode {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;   
            } else {
                num--;        
            }
            steps++;
        }
        return steps;
    }
}