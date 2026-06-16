int removeElement(int* nums, int numsSize, int val) {
    int a=0;
    for(int i=0;i<numsSize;i++){
        if(nums[i]!=val){
            nums[a]=nums[i];
            a++;
        }
    }
    return a;
}
