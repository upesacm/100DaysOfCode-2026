class Solution {
    public int numberOfSteps(int num) {

        int steps = 0;
        while( num > 0) {
            //bitwise checking whether a number is even or not
            if( (num & 1) == 0 ){
                //bitwise divide by 2
                num = num >> 1;
                
            }
            else{
                num -= 1;
            }
            steps++;
        }
        return steps;
    }
}