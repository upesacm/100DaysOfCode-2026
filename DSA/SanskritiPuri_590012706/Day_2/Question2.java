class Solution {
    public int largestElement(int[] nums) {
        int max = nums[0];                  
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {            
                max = nums[i];             
            }
        }
        return max;                        
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {12, 35, 1, 10, 34, 1};
        System.out.println(sol.largestElement(arr1)); 

        int[] arr2 = {10, 5, 10};
        System.out.println(sol.largestElement(arr2)); 
    }
}
