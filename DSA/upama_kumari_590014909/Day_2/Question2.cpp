#include<iostream>
#include<vector>
using namespace std;
int LargestElement(vector<int>&nums){
    int largest = nums[0];

    for(int i=1;i<nums.size();i++){
        if(nums[i]>largest){
            largest=nums[i];
        }
    }
    return largest;
}
int main(){
    vector<int>nums={10,5,10};
    cout<<LargestElement(nums);
    return 0;

}
