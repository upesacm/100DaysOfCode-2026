package DSA.VridhiJain_590014870.Day_2;
class Question2 {
    public int largest(int[] nums) {
        int largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }
        return largest;
    }
}