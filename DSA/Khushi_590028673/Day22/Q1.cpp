#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

void moveZeros(vector<int>&nums){
    int n=nums.size();
    int i=0; 

    for(int j=0; j<n; j++){
        if(nums[j]!=0){
            swap(nums[i],nums[j]);
            i++;
        }
    }
}

int main(){
    int n;
    cout<<"Enter the number of elements: ";
    cin>>n;

    vector<int>nums(n);

    cout<<"Enter the elements: ";
    for(int i=0; i<n; i++){
        cin>>nums[i];
    }

    moveZeros(nums);

    cout<<"Array after moving zeros: ";
    for(int x:nums){
        cout<<x<<" ";
    }
    cout<<endl;

    return 0;
}