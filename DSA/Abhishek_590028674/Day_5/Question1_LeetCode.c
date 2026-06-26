bool canJump(int* nums, int numsSize) {
    int i=0;
    int minJump = 0;
    for(i=numsSize-2; i>=0;i--){
        minJump++;
        if(nums[i]>=minJump) minJump=0; 
    }
    return !minJump;
}