int missingNumber(int* nums, int numsSize) {
    int Sum=0,s=0,result;
    for(int i=0;i<=numsSize;i++){
        Sum += i;
    }
    for(int j=0;j<numsSize;j++){
        s+=nums[j];
    }
    result =Sum-s;
    return result;
}