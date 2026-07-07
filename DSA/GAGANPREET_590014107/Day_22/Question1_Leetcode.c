void moveZeroes(int* nums, int numsSize) {
    int k=0;
    for(int i=0;i<numsSize;i++){
        if(nums[i]!=0){
            nums[k]=nums[i];
            k++;
        }  
    }
    while(k<numsSize){
        nums[k]=0;
        k++;
    }

}
