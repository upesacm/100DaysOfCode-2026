#include <iostream>
#include<vector>
using namespace std;

vector<int>result(vector<int>nums){
    int n=nums.size()-1;
    int first=0;
    int second=0;
    int flag=0;

    int i=n;
    int j=0;
    while(j<=i){
        if(nums[i]>nums[j]){
            if(flag){
                second=second+nums[i];
                flag=0;
                i--;
            }
            else{
                first=first+nums[i];
                flag=1;
                i--;
            }
        }
        else{
            if(flag){
                second=second+nums[j];
                flag=0;
                j++;
            }
            else{
                first=first+nums[j];
                flag=1;
                j++;
            }
        }
    }

    return {first,second};

}

int main(){
    int n;
    cout<<"Enter the number of elements: ";
    cin>>n;

    cout<<"Enter the elements: ";
    vector<int>nums(n);
    for(int i=0; i<n; i++){
        cin>>nums[i];
    }

    vector<int> ans = result(nums);
    cout << ans[0] << " " << ans[1];


    return 0;
}