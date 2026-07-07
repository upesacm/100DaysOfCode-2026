public class Question1_Leetcode {
    //Function to move all zeroes to the end of the array while maintaining the relative order of the non-zero elements

    public void moveZeroes(int[] nums) {
        int index=0; // Initialize index to keep track of the position to place non-zero elements

        //Traverse the array and move non-zero elements to the front
        for(int i=0;i<nums.length;i++){
            // If the current element is not zero, place it at the current index and increment the index
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        // After all non-zero elements have been moved to the front, fill the remaining positions in the array with zeroes
        for(int i=index;i<nums.length;i++){
            nums[i]=0;
        }  
    }
}