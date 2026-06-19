package DSA.MeghnaDhakad_590013960.Day_2;
class Question1_Leetcode{
    public static void main(String[] args){
    int[] nums = {0,1,2,2,3,0,4,2}; // Input array
    int val = 2; // Value to remove

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        System.out.println(count);
    }
}