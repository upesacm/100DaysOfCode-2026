/*Move Zeroes
Explanation
Move all zeroes to the end of the array while keeping the relative order of non-zero elements unchanged.*/

void moveZeroes(int* nums, int numsSize) {
    int i, j = 0;  
    for(i = 0; i < numsSize; i++){
        if(nums[i] != 0){
            nums[j] = nums[i];
            j++;
        }
    }
    
    for(i = j; i < numsSize; i++){
        nums[i] = 0;
    }
}

