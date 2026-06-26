#include<iostream>
#include<vector>
using namespace std;
int countNum(vector<int>&nums,int target){
    int count=0;
    for(int i=0;i<nums.size();i++){
        if(target==nums[i]){
            count++;
        }
    }
    return count;
}
int main(){
    vector<int>nums={1,1,2,2,2,2,3};
    cout<<countNum(nums,2);
}