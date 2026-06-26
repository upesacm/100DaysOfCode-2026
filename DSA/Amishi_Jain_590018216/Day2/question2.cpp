#include<iostream>
#include<vector>
using namespace std;

    int funct1(vector<int>&nums){
        int max = -1;
        for(int i = 0;i<nums.size();i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    
    }


    int main(){
        vector<int>nums = {1,2,3,4,5};
        cout<<funct1(nums);
        return 0;
    }