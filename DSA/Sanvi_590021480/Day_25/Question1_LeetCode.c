int cmp(const void *a, const void *b){
    return (*(int *)a - *(int *)b);
}

bool valid(int x, int y, int z){
    if(x+y>z && y+z>x && z+x>y) return 1;
    else return 0;
}

int triangleNumber(int* nums, int numsSize) {
    qsort(nums, numsSize, sizeof(int), cmp);
    int count=0;
    for(int k=numsSize-1;k>=2;k--){
        int l=0,r=k-1;
        while(l<r){
            if (valid(nums[k],nums[l],nums[r])){
                count+=(r-l);
                r--;
            }
            else l++;
        }
    }
    return count;
}
