bool canJump(int* nums, int numsSize){
    int reach=0;
    for(int i=0;i<numsSize;i++){
        if(i>reach) 
            return false;
        if(i+nums[i]>reach) 
            reach=i+nums[i];
    }
    return true;
}
