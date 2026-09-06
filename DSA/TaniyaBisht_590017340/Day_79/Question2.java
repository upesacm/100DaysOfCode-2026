
class MP{
    public static int findSingle(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2, 4, 7};
        int answer = findSingle(nums);
        System.out.println("Single element:" + answer);
    }
}